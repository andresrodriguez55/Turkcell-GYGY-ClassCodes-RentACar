package kodlama.io.rentacar.business.dto.responses.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCarResponse
{
    private int id;
    private int modelYear;
    private String plate;
    private int state; //1 - available, 2 - rented, 3 - maintance
    private double dailyPrice;
    private int modelId;
}
