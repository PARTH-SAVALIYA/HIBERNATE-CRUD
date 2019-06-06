
import POJO.Author;
import POJO.Book;
import POJO.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class testcalss {

    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session session = sf.openSession();
    Transaction tx = session.beginTransaction();

    void insert(String a_name, String b_name, float price) {
        try {
            Author author = new Author(a_name);
            Book book = new Book(author, b_name, price);
            session.save(book);
            session.save(author);
            tx.commit();
        } catch (Exception e) {
        }

    }

    void list() {

        List<Book> book = session.createQuery("FROM Book").list();

        for (Book b : book) {

            System.out.println("Titel = " + b.getTitle());
            System.out.println("author = " + b.getAuthor());
            System.out.println("Price = " + b.getPrice());
        }
    }

    void update(int b_id, String a_name, String title, float price) {
        Author author = new Author(a_name);
        Book book = new Book(b_id, author, title, price);
        session.save(author);
        session.update(book);
        tx.commit();
    }

    void delete(int b_id) {

        Book book = new Book(b_id);
        session.delete(book);
        tx.commit();

    }
    void author() {
        String hql = "FROM Book";
        Query query = session.createQuery(hql);
        List list = query.list();

        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            Book book = (Book) itr.next();
            Author a = book.getAuthor();
            System.out.println("Author  = " + a.getAName());
        }

    }

}
