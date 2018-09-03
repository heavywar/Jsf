package nls;

import javax.persistence.*;

@Entity
@Table(name = "publisher", schema = "bydb", catalog = "")
public class PublisherEntity {
    private long id;
    private String name;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;

        PublisherEntity that = (PublisherEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals (that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode () : 0);
        return result;
    }
}
