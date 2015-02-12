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

import javax.persistence.Embedded;
import javax.persistence.Entity;

/**
 *
 * @author shame
 */
@Entity(name = "true_false_question")
public class TrueFalseQuestion extends Question {

    @Embedded
    private Option trueOption;
    @Embedded
    private Option falseOption;

    public TrueFalseQuestion() {
        super(QuestionType.TRUE_FALSE_QUESTION);
    }

    public Option getTrueOption() {
        return trueOption;
    }

    public Option getFalseOption() {
        return falseOption;
    }

    public void setTrueOption(Option trueOption) {
        this.trueOption = trueOption;
    }

    public void setFalseOption(Option falseOption) {
        this.falseOption = falseOption;
    }

}
