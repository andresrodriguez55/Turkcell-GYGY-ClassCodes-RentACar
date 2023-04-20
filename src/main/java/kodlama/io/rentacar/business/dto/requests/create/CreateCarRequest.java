package kodlama.io.rentacar.business.dto.requests.create;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import kodlama.io.rentacar.common.constants.Regex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCarRequest
{
    @Min(1996)
    @Max(2023)
    private int modelYear;
    @Pattern(regexp = Regex.Plate, message = "Plate number must match the pattern")
    private String plate;
    //private State state; //default
    @Min(1)
    @Max(10000000)
    private double dailyPrice;

    private int modelId;
}
