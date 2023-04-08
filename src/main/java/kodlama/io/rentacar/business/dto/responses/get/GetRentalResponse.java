package kodlama.io.rentacar.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetRentalResponse
{
    private int id;
    private int carId;
    private double dailyPrice;
    private int rentedForDays;
    private double totalPrice;
    private LocalDateTime startDate;
}
