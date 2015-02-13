/*
 * Copyright (C) 2015 shame
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

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author shame
 */
@Entity(name = "course")
public class Course extends DbObject {

    @Column(unique = true, name = "title")
    private String title;
    @OneToMany(mappedBy = "course")
    private List<Quiz> quizes;

    public Course(long id) {
        super(id);
    }

    public Course() {
    }

    public Course(String name, long id) {
        super(id);
        this.title = name;
    }

    public Course(String name) {
        this.title = name;
    }

    public List<Quiz> getQuizes() {
        return quizes;
    }

    public void setQuizes(List<Quiz> quizes) {
        this.quizes = quizes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String displayString() {
        return title;
    }

    @Override
    public String toString() {
        return "{id=" + getId() + ", title=" + title + '}';
    }

}
