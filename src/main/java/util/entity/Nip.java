package util.entity;

import javax.persistence.Column;
import java.util.Objects;
import static util.util.ArgumentValidator.validate;

public class Nip {
    @Column(name = "Nip")
    private String nip;

    public Nip() {
    }

    public Nip(String nip) {
        validate(nip != null && nip.matches("\\d{10}"), "nip is invalid: " + nip);
        this.nip = nip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nip nip1 = (Nip) o;
        return nip.equals(nip1.nip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nip);
    }

    public String getNip() {
        return nip;
    }
}
