package med.voll.api.model;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.address.Address;
import med.voll.api.medic.MedicRecord;
import med.voll.api.medic.MedicUpdateRecord;
import med.voll.api.medic.Specialization;

import java.io.Serializable;
@Table(name="medics")
@Entity
@Getter
@Setter
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

    private Boolean active;

    public Medic(MedicRecord medic) {
        this.name = medic.name();
        this.email = medic.email();
        this.crm = medic.crm();
        this.phone = medic.phone();
        this.specialization = medic.specialization();
        this.address = new Address(medic.address());
        this.active = true;
    }

    public void updateData(MedicUpdateRecord medic) {
        if(medic.name() != null) this.name = medic.name();
        if(medic.phone() != null) this.phone = medic.phone();
        if(medic.address() != null) this.address.updateAddress(medic.address());
    }

    public void logicDelete() {
        this.active = false;
    }
}
