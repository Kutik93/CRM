package util.service;

import java.util.Objects;

public class RegistrationCompanyForm {

    private final String companyName;
    private final String nip;

    public RegistrationCompanyForm(String companyName, String nip) {
        this.companyName = companyName;
        this.nip = nip;

    }

    public String getCompanyName() {
        return companyName;
    }

    public String getNip() {
        return nip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationCompanyForm that = (RegistrationCompanyForm) o;
        return companyName.equals(that.companyName) && nip.equals(that.nip);
    }

    @Override
    public String toString() {
        return "RegistrationCompanyForm{" +
                "companyName='" + companyName + '\'' +
                ", nip='" + nip + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, nip);


    }
}
