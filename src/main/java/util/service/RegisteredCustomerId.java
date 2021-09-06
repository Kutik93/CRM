package util.service;

import java.io.Serializable;
import java.util.UUID;

import static java.util.Objects.hash;
import static java.util.Objects.requireNonNull;

public class RegisteredCustomerId implements Serializable {

    private UUID id;

    public RegisteredCustomerId(UUID id) {
        this.id = requireNonNull(id);
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisteredCustomerId that = (RegisteredCustomerId) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return hash(id);
    }
}
