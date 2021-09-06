package util.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.entity.Company;
import util.exception.CompanyAlreadyExistsException;
import util.exception.CustomerAlreadyExistsException;
import static java.util.Objects.requireNonNull;

public class CompanyCustomerRegistration {

    private final SessionFactory sessionFactory;

    public CompanyCustomerRegistration(SessionFactory sessionFactory) {
        this.sessionFactory = requireNonNull(sessionFactory);
    }

    public RegisteredCustomerId registerCompany(RegistrationCompanyForm form) {
        final var session = sessionFactory.openSession();
        final var tx = session.beginTransaction();
        // 1. walidacja
        if (companyExists(form, session)) {
            throw new CompanyAlreadyExistsException("company exists" + form);
        }

        // 2. zamiana form w encji Company
        final var company = Company.from(form);

        // 3. zapisanie Person do DB
        session.save(company);

        // 4. commit & zwrócenie id
        tx.commit();
        session.close();
        return new RegisteredCustomerId(company.getId());
    }

    private Boolean companyExists(RegistrationCompanyForm form, Session session) {
        return session.createQuery("select count(p) > 0 from Company p where p.companyName =?1" + "and p.nipNumber.nip = ?2", Boolean.class)
                .setParameter(1, form.getCompanyName()).setParameter(2, form.getNip()).getSingleResult();
    }
}
