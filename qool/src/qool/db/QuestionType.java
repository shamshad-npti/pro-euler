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

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Shamshad Alam
 */
@Entity(name = "question_type")
public class QuestionType extends DbObject {

    @Column(name = "title", nullable = false, unique = true)
    private String type;

    public QuestionType() {
    }

    public QuestionType(String type, long id) {
        super(id);
        this.type = type;
    }

    public QuestionType(long id) {
        super(id);
    }

    public QuestionType(String type) {
        this.type = type;
    }

    @Override
    public String displayString() {
        return type;
    }

    @Override
    public String toString() {
        return "{id=" + getId() + ", type=" + type + '}';
    }

}
