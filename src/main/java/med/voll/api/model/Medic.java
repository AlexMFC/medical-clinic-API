package med.voll.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.address.Address;
import med.voll.api.medic.MedicRecord;
import med.voll.api.medic.Specialization;

import java.io.Serializable;
@Table(name="medics")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String crm;
    @Enumerated(EnumType.ORDINAL)
    private Specialization specialization;
    @Embedded
    private Address address;

    public Medic(MedicRecord medic) {
        this.name = medic.name();
        this.email = medic.email();
        this.crm = medic.crm();
        this.phone = medic.phone();
        this.specialization = medic.specialization();
        this.address = new Address(medic.address());
    }
}
