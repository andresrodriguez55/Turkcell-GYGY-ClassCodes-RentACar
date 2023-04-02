package kodlama.io.rentacar.business.dto.requests.create;

import kodlama.io.rentacar.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateMaintenanceRequest
{
    private State state;
    private int carId;
}
