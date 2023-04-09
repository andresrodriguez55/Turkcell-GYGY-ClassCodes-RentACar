package kodlama.io.rentacar.business.dto.requests.update;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import kodlama.io.rentacar.business.dto.requests.PaymentRequest;
import kodlama.io.rentacar.entities.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdatePaymentRequest extends PaymentRequest
{
    @NotNull
    @Min(value = 0)
    private double balance;
}
