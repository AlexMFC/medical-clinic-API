package med.voll.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String logr;
    private String neighbourhood;
    private String zipCode;
    private String number;
    private String complement;
    private String city;
    private String state;

    public Address(AddressData address) {
        this.logr = address.logr();
        this.neighbourhood = address.neighbourhood();
        this.zipCode = address.zipCode();
        this.number = address.number();
        this.complement = address.complement();
        this.city = address.city();
        this.state = address.state();
    }

    public void updateAddress(Address address) {
        if (address.logr != null)  this.logr = address.logr;
        if (address.neighbourhood  != null)  this.neighbourhood  = address.neighbourhood ;
        if (address.zipCode != null)  this.zipCode = address.zipCode;
        if (address.number != null)  this.number = address.number;
        if (address.complement != null)  this.complement = address.complement;
        if (address.state != null)  this.state = address.state;
        if (address.city != null)  this.city = address.city;
    }
}
