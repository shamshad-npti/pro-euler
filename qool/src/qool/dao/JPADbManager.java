/*
 * Copyright (C) 2015 Shamshad Alam
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package qool.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import qool.db.DbObject;
import qool.db.Question;
import qool.db.Quiz;
import qool.db.User;

/**
 *
 * @author shame
 */
public class JPADbManager implements DbManager {
    final private EntityManager em;
    private User currentUser;
    private static JPADbManager dbm;
    private JPADbManager(String pu) {
        em = Persistence.createEntityManagerFactory(pu).createEntityManager();
    }

    public static DbManager getDbManager() {
        if (dbm == null) {
            dbm = new JPADbManager("qool");
        }
        return dbm;
    }

    @Override
    public LoginResult Login(User user) throws DbException {
        User dbu = getUserById(user.getUserId());
        if (dbu != null) {
            this.currentUser = dbu;
            return LoginResult.SUCCESS;
        } else {
            return LoginResult.USER_NOT_EXISTS;
        }
    }

    @Override
    public List<? extends Question> getQuestionByQuiz(Quiz quiz) throws DbException {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Question> cq = cb.createQuery(Question.class);
        Root<Question> question = cq.from(Question.class);
        cq.select(question).where(cb.equal(question.get("quiz"), quiz));
        TypedQuery<Question> q = em.createQuery(cq);
        q.setMaxResults(200);
        return q.getResultList();
    }

    @Override
    public Quiz getQuiz(long id) throws DbException {
        return findById(id, Quiz.class);
    }

    @Override
    public Question getQuestion(long id) throws DbException {
        return findById(id, Question.class);
    }

    @Override
    public User getUserById(String userId) throws DbException {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> user = cq.from(User.class);
        cq.select(user).where(cb.equal(user.get("user_id"), userId));
        TypedQuery<User> q = em.createQuery(cq);
        q.setMaxResults(1);
        List<User> usr = q.getResultList();
        if (usr.isEmpty()) {
            return null;
        } else {
            return usr.get(0);
        }
    }

    @Override
    public void saveQuiz(Quiz quiz) throws DbException {
        save(quiz);
    }

    @Override
    public void saveAllQuestions(Quiz quiz, List<Question> questions) throws DbException {
        saveOrUpdate(quiz);
        questions.stream().forEach((ques) -> {
            ques.setQuiz(quiz);
        });
        saveAll(questions);
    }

    @Override
    public void saveQuestion(Question question) throws DbException {
        save(question);
    }

    @Override
    public void saveAll(List<? extends DbObject> dbos) throws DbException {
        try {
            em.getTransaction().begin();
            dbos.stream().forEach((dbo) -> {
                prepareForCreate(dbo);
                em.persist(dbo);
            });
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new DbException(ex);
        }
    }

    @Override
    public void save(DbObject dbo) throws DbException {
        try {
            this.prepareForCreate(dbo);
            this.em.getTransaction().begin();
            this.em.persist(dbo);
            this.em.getTransaction().commit();
        } catch (Exception ex) {
            throw new DbException(ex);
        }
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public void saveOrUpdate(DbObject dbo) throws DbException {
        try {
            if (exists(dbo)) {
                prepareForUpdate(dbo);
                em.getTransaction().begin();
                em.merge(dbo);
                em.getTransaction().commit();
            } else {
                save(dbo);
            }
        } catch (Exception ex) {
            throw new DbException(ex);
        }
    }

    @Override
    public void updateAll(List<? extends DbObject> dbos) throws DbException {
        try {
            em.getTransaction().begin();
            dbos.stream().forEach((dbo) -> {
                prepareForUpdate(dbo);
                em.merge(dbo);
            });
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new DbException(ex);
        }
    }

    @Override
    public <T extends DbObject> boolean exists(T dbo) {
        Class<T> clazz = (Class<T>) dbo.getClass();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        Root<T> root = cq.from(clazz);
        cq.select(root.alias("id")).where(cb.equal(root.get("id"), dbo.getId()));
        TypedQuery<T> q = em.createQuery(cq);
        q.setMaxResults(1);
        return q.getResultList().isEmpty();
    }

    @Override
    public <T extends DbObject> List<T> findAll(Class<T> clazz) {
        CriteriaQuery<T> q = em.getCriteriaBuilder().createQuery(clazz);
        q.from(clazz);
        return em.createQuery(q).getResultList();
    }

    @Override
    public <T extends DbObject> T findById(long id, Class<T> clazz) {
        return em.find(clazz, id);
    }

    @Override
    public <T extends DbObject> List<T> findRange(Class<T> clazz, int start, int lenth) {
        CriteriaQuery<T> q = em.getCriteriaBuilder().createQuery(clazz);
        q.from(clazz);
        Query qr = em.createQuery(q);
        qr.setFirstResult(start);
        qr.setMaxResults(lenth);
        return qr.getResultList();
    }

    private void prepareForCreate(DbObject dbo) {
        dbo.setCreated(now());
        dbo.setCreator(getCurrentUser());
    }

    private void prepareForUpdate(DbObject dbo) {
        dbo.setModified(now());
        dbo.setModifier(getCurrentUser());
    }

    private Date now() {
        return Calendar.getInstance().getTime();
    }
}
