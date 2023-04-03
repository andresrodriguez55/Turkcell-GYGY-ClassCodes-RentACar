package kodlama.io.rentacar.business.dto.responses.update;

import kodlama.io.rentacar.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCarResponse
{
    private int id;
    private int modelYear;
    private String plate;
    private State state;
    private double dailyPrice;
    private int modelId;
}
