package kodlama.io.rentacar.business.dto.responses.get;

import kodlama.io.rentacar.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetCarResponse
{
    private int id;
    private int modelYear;
    private String plate;
    private State state;
    private double dailyPrice;
    private int modelId;
}
