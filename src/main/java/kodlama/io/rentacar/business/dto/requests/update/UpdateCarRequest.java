package kodlama.io.rentacar.business.dto.requests.update;

import kodlama.io.rentacar.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCarRequest
{
    private int modelId;
    private int modelYear;
    private String plate;
    private State state;
    private double dailyPrice;
}
