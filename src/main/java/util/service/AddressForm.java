package util.service;

import java.util.Objects;

public class AddressForm {
    private final String street;
    private final String city;
    private final String country;
    private final String zipCode;

    public AddressForm(String street, String city, String country, String zipCode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressForm that = (AddressForm) o;
        return Objects.equals(street, that.street) && Objects.equals(city, that.city) && Objects.equals(country, that.country) && Objects.equals(zipCode, that.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, country, zipCode);
    }

    @Override
    public String toString() {
        return "AddressForm{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
