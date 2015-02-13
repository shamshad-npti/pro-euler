package qool.db;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 *
 * @author shame
 */
@MappedSuperclass
public abstract class DbObject implements Serializable, Comparable<DbObject> {

    @Id
    @Column(name = "id", insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Version
    @Column(name = "version")
    private long version;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;
    @ManyToOne
    @JoinColumn(name = "creator", referencedColumnName = "id")
    private User creator;
    @ManyToOne
    @JoinColumn(name = "", referencedColumnName = "id")
    private User modifier;

    public DbObject() {
    }

    public DbObject(long id) {
        this.id = id;
    }

    public abstract String displayString();

    public long getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getModifier() {
        return modifier;
    }

    public void setModifier(User modifier) {
        this.modifier = modifier;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DbObject other = (DbObject) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    @Override
    public String toString() {
        return "{id=" + id + ";" + super.toString() + "}";
    }

    @Override
    public int compareTo(DbObject o) {
        return (int) (this.id - o.id);
    }

}
