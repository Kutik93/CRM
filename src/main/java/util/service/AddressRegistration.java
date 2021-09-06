package util.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.entity.Address;
import util.entity.Company;
import util.exception.CompanyAlreadyExistsException;

import static java.util.Objects.requireNonNull;

public class AddressRegistration {

    private final SessionFactory sessionFactory;

    public AddressRegistration(SessionFactory sessionFactory) {
        this.sessionFactory = requireNonNull(sessionFactory);
    }

    public AddressRegistrationId addressRegistration(AddressForm form) {

        final var session = sessionFactory.openSession();
        final var tx = session.beginTransaction();

        final var address = Address.from(form);

        // 3. zapisanie Person do DB
        session.save(address);

        // 4. commit & zwrócenie id
        tx.commit();
        session.close();
        return new AddressRegistrationId(address.getId());
    }
}
