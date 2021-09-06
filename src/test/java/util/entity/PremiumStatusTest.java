package util.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.HibernateUtil;

import static org.junit.jupiter.api.Assertions.*;

class PremiumStatusTest {

    private final SessionFactory factory = HibernateUtil.getSessionFactory();

    private Session session;
    private Transaction tx;

    @BeforeEach
    void before() {
        session = factory.openSession();
        tx = session.beginTransaction();
    }

    @AfterEach
    void after() {
        tx.rollback();
        session.close();
    }

    @Test
    void shouldSavePremiumStatus() {
        //given
        final var customer = new Person("Jan", "Kowalski", new Pesel("12345678913"));
        final var status = new PremiumStatus(Status.GOLD);
        customer.markPremium(status);
        //when
        saveAndFlush(customer);
        //then
        final var customerRead = session.get(Customer.class, customer.getId());
        assertEquals(status, customerRead.getStatus());
    }
    private void saveAndFlush(Customer status) {
        session.save(status);
        session.flush();
//        tx.commit();
        session.clear();
    }
}