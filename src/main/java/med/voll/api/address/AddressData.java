package med.voll.api.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AddressData(
        @NotBlank
        String logr,
        @NotBlank
        String neighbourhood,
        @NotBlank @Pattern(regexp = "\\d{8}")
        String zipCode,
        @NotBlank
        String state,
        @NotBlank
        String city,

        String complement,
        String number) {


}
