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
package qool.db;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Shamshad Alam
 */
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "question")
public abstract class Question extends DbObject {

    @ManyToOne
    @JoinColumn(name = "question_type_id", referencedColumnName = "id", nullable = false)
    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "quiz_id", referencedColumnName = "id", nullable = false)
    private Quiz quiz;

    public Question(QuestionType questionType) {
        this.questionType = questionType;
    }

    public Question() {
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    protected void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    @Override
    public String displayString() {
        return "";
    }

}
