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

import java.util.List;
import qool.db.DbObject;
import qool.db.Question;
import qool.db.Quiz;
import qool.db.User;

/**
 *
 * @author shame
 */
public interface DbManager {
    public LoginResult Login(User user) throws DbException;
    public List<? extends Question> getQuestionByQuiz(Quiz quiz) throws DbException;
    public Quiz getQuiz(long id) throws DbException;
    public Question getQuestion(long id) throws DbException;
    public User getUserById(String userId) throws DbException;
    public User getCurrentUser();
    public void saveQuiz(Quiz quiz) throws DbException;
    public void saveAllQuestions(Quiz quiz, List<Question> questions) throws DbException;
    public void saveQuestion(Question question) throws DbException;
    public void save(DbObject object) throws DbException;
    public void saveAll(List<? extends DbObject> object) throws DbException;
    public void updateAll(List<? extends DbObject> object) throws DbException;
    public void saveOrUpdate(DbObject object) throws DbException;
    public <T extends DbObject> boolean exists(T dbo);
    public <T extends DbObject> T findById(long id, Class<T> clazz);
    public <T extends DbObject> List<T> findAll(Class<T> clazz);
    public <T extends DbObject> List<T> findRange(Class<T> clazz, int start, int lenth);

    public static enum LoginResult {
        SUCCESS,
        INTERRUPTED,
        NOT_CONNECTED,
        USER_NOT_EXISTS,
        PASSWORD_MISMATCH,
        FAILED;
    }
}
