package kodlama.io.rentacar.business.dto.requests.create;

import kodlama.io.rentacar.entities.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateRentalRequest
{
    private int carId;
    private double dailyPrice;
    private int rentedForDays;
}
