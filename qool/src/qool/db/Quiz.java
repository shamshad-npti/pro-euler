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

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author shame
 */
@Entity(name = "quiz")
public class Quiz extends DbObject {

    @Column(name = "access_code", updatable = false, unique = true)
    private String accessCode;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description")
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "scheduled_date")
    private Date scheduledDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "scheduled_result_date")
    private Date scheduledResultDate;
    @Column(name = "anonymous_entry")
    private boolean anonymousEntryAllowed;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY)
    private List<Question> questions;

    public Quiz(long id) {
        super(id);
    }

    public Quiz() {
        this(0);
    }

    public List<? extends Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public Date getScheduledResultDate() {
        return scheduledResultDate;
    }

    public void setScheduledResultDate(Date scheduledResultDate) {
        this.scheduledResultDate = scheduledResultDate;
    }

    public boolean isAnonymousEntryAllowed() {
        return anonymousEntryAllowed;
    }

    public void setAnonymousEntryAllowed(boolean anonymousEntryAllowed) {
        this.anonymousEntryAllowed = anonymousEntryAllowed;
    }

    @Override
    public String displayString() {
        return title;
    }

    @Override
    public String toString() {
        return "Quiz{id=" + getId() + ", accessCode=" + accessCode + ", title=" + title + ", description=" + description + ", scheduledDate=" + scheduledDate + ", scheduledResultDate=" + scheduledResultDate + ", anonymousEntryAllowed=" + anonymousEntryAllowed + '}';
    }

}
