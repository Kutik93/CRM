package util.service;

import org.junit.jupiter.api.Test;
import util.HibernateUtil;

import static org.junit.jupiter.api.Assertions.*;

class PersonCustomerRegistrationTest {
    private final PersonCustomerRegistration registration =
            new PersonCustomerRegistration(HibernateUtil.getSessionFactory());

    //given
    @Test
    void shouldRegisterPersonCustomer() {
        final var form = new RegisterPersoForm("Jan", "Kowalski", "12345678912");

        //when
        final var registeredCustomerId = registration.registerPerson(form);

        //then
        assertNotNull((registeredCustomerId.getId()));
    }
    @Test
    void shouldNotRegisterPersonIfLastNameAndPeselAlreadyExists(){
        //given
        final var form = new RegisterPersoForm("Jan", "Kowalski", "12345678912");
        //when & then
        registration.registerPerson(form);

    }

}