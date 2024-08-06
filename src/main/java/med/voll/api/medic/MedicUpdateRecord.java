package med.voll.api.medic;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.address.Address;

public record MedicUpdateRecord (@NotNull Long id,
                                 String name,
                                 String phone,
                                 Address address){

}
