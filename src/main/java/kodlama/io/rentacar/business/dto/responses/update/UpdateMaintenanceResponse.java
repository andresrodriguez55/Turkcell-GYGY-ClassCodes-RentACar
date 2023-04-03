package kodlama.io.rentacar.business.dto.responses.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateMaintenanceResponse
{
    private int id;
    private String information;
    private int carId;
    private boolean isCompleted;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
