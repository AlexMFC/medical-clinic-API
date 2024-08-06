package med.voll.api.medic;

import med.voll.api.model.Medic;

public record MedicDataList(Long id, String name, String email, String crm, Specialization specialization) {

    public MedicDataList(Medic medic) {
        this(medic.getId(), medic.getName(), medic.getEmail(), medic.getCrm(), medic.getSpecialization());
    }

}