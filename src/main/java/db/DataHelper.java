package db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.security.auth.login.Configuration;

import entity.*;


public class DataHelper {

    private SessionFactory sessionFactory = null;
    private static DataHelper dataHelper;
    //CriteriaBuilder builder = sessionFactory.openSession().getCriteriaBuilder();
   // Session session = sessionFactory.openSession();
    //private CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();


    private DataHelper() {

      sessionFactory = getSessionHibernate.getSessionFactory ();
    }


    public static DataHelper getInstance() {
        return dataHelper == null ? new DataHelper() : dataHelper;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }



    public List<BookEntity> getAllBooks() {
//
       CriteriaQuery<BookEntity> criteria =sessionFactory.getCurrentSession().getCriteriaBuilder ().createQuery(BookEntity.class);
        Root<BookEntity> personRoot = criteria.from( BookEntity.class );
        criteria.select( personRoot );
       List<BookEntity> bookEntities1 = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();

       //return  sessionFactory.getCurrentSession ().createCriteria(BookEntity.class).list();
        //sessionFactory.close ();
      return bookEntities1;
   }

   public List<GenreEntity> getAllGenres() {

       CriteriaQuery<GenreEntity> criteria =sessionFactory.getCurrentSession().getCriteriaBuilder ().createQuery(GenreEntity.class);
       Root<GenreEntity> personRoot = criteria.from( GenreEntity.class );
       criteria.select( personRoot );
       List<GenreEntity> bookEntities1 = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
       return bookEntities1;
    }
    public List<AuthorEntity> getAllAuthors() {
        CriteriaQuery<AuthorEntity> criteria =sessionFactory.getCurrentSession().getCriteriaBuilder ().createQuery(AuthorEntity.class);
        Root<AuthorEntity> personRoot = criteria.from( AuthorEntity.class );
        criteria.select( personRoot );
        List<AuthorEntity> bookEntities1 = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        return bookEntities1;    }

    public List<BookEntity> getBooksByGenre(Long genreId) {
       // CriteriaQuery<BookEntity> criteria =sessionFactory.getCurrentSession().getCriteriaBuilder ().createQuery(BookEntity.class);
       // Root<BookEntity> personRoot = criteria.from( BookEntity.class );
        //criteria.select( personRoot );
        //List<BookEntity> bookEntities1 = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        //Predicate personRestriction = sessionFactory.getCurrentSession ().getCriteriaBuilder().and (sessionFactory.getCurrentSession ().getCriteriaBuilder().equal ())
       // return bookEntities1;

       return sessionFactory.getCurrentSession().createCriteria(BookEntity.class).add(Restrictions.eq("genre.id", genreId)).list();
    }

    public List<BookEntity> getBooksByLetter(Character letter) {
       return getBookList("name", letter.toString(), MatchMode.START);
    }

   public List<BookEntity> getBooksByAuthor(String authorName) {
       return getBookList("author", authorName, MatchMode.ANYWHERE);
   }

    public List<BookEntity> getBooksByName(String bookName) {
       return getBookList("name", bookName, MatchMode.ANYWHERE);
   }

    public byte[] getContent(Long id) {
        return (byte[]) getFieldValue("content", id);
    }

    public byte[] getImage(Long id) {
        return (byte[]) getFieldValue("image", id);
    }

    public AuthorEntity getAuthor(long id) {
        return (AuthorEntity) getSession().get(AuthorEntity.class, id);
    }

    private List<BookEntity> getBookList(String field, String value, MatchMode matchMode) {
        return getSession().createCriteria(BookEntity.class).add(Restrictions.ilike(field, value, matchMode)).list();
    }

    private Object getFieldValue(String field, Long id) {
        return getSession().createCriteria(BookEntity.class).setProjection(Projections.property(field)).add(Restrictions.eq("id", id)).uniqueResult();
    }
}