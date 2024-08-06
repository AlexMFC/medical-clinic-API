package med.voll.api.medic;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.address.AddressData;

public record MedicRecord(
        @NotBlank String name,
        @NotBlank @Email String email,
        @NotBlank @Pattern(regexp = "\\d{4,6}") String crm,
        @NotBlank @Pattern(regexp ="\\d{2,3}" + "\\d{8,9}") String phone,
        @NotNull Specialization specialization,
        @NotNull @Valid AddressData address) {
}
