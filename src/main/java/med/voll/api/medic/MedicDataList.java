package med.voll.api.medic;

import med.voll.api.model.Medic;

public record MedicDataList(String nome, String email, String crm, Specialization specialization) {

    public MedicDataList(Medic medic) {
        this(medic.getName(), medic.getEmail(), medic.getCrm(), medic.getSpecialization());
    }

}