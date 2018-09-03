package entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "book", schema = "bydb")
public class BookEntity {

    private long id;

    private String name;
    private byte[] content;
    private int pageCount;
    private String isbn;
    private int publishYear;
    private long publisherId;
    private byte[] image;
    private String descr;
    private boolean edit;
//    @ManyToOne(cascade = CascadeType.ALL)
//    private AuthorEntity author;
//    @ManyToOne(cascade = CascadeType.ALL)
//    private GenreEntity genre;
//    @ManyToOne(cascade = CascadeType.ALL)
//    private PublisherEntity publisher;

    public boolean isEdit() {
        return edit;
    }
//
//    @JoinColumn(name = "author_id")
//    public AuthorEntity getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(AuthorEntity author) {
//        this.author = author;
//    }
//    @JoinColumn(name = "genre_id")
//    public GenreEntity getGenre() {
//        return genre;
//    }
//
//    public void setGenre(GenreEntity genre) {
//        this.genre = genre;
//    }
//
//    @JoinColumn(name = "publisher_id")
//    public PublisherEntity getPublisher() {
//        return publisher;
//    }

//    public void setPublisher(PublisherEntity publisher) {
//        this.publisher = publisher;
//    }

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "content", nullable = false)
    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Basic
    @Column(name = "page_count", nullable = false)
    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Basic
    @Column(name = "isbn", nullable = false, length = 100)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "publish_year", nullable = false)
    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    @Basic
    @Column(name = "publisher_id", nullable = false)
    public long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(long publisherId) {
        this.publisherId = publisherId;
    }

    @Basic
    @Column(name = "image", nullable = true)
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Basic
    @Column(name = "descr", nullable = true, length = 1000)
    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity that = (BookEntity) o;

        if (id != that.id) return false;
        if (pageCount != that.pageCount) return false;
        if (publishYear != that.publishYear) return false;
        if (publisherId != that.publisherId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (!Arrays.equals(content, that.content)) return false;
        if (isbn != null ? !isbn.equals(that.isbn) : that.isbn != null) return false;
        if (!Arrays.equals(image, that.image)) return false;
        if (descr != null ? !descr.equals(that.descr) : that.descr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(content);
        result = 31 * result + pageCount;
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + publishYear;
        result = 31 * result + (int) (publisherId ^ (publisherId >>> 32));
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + (descr != null ? descr.hashCode() : 0);
        return result;
    }
    public void setEdit(boolean edit) {
        this.edit = edit;
    }
}
