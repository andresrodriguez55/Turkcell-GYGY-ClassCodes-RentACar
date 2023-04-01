package kodlama.io.rentacar.business.dto.requests.create;

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
    private int modelYear;
    private String plate;
    private int state; //1 - available, 2 - rented, 3 - maintance
    private double dailyPrice;
    private int modelId;
}
