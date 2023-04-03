package kodlama.io.rentacar.business.dto.requests.update;

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
    private String information;
    private int carId;
    private boolean isCompleted;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
