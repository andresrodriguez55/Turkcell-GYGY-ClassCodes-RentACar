package kodlama.io.rentacar.business.dto.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PaymentRequest
{
    @NotBlank(message = "Card number cant be empty...")
    @Length(min=16, max=16, message = "The card number must have a length of 16...")
    private String cardNumber;
    @NotBlank(message = "Card holder cant be empty...")
    @Length(min=5, message = "The card holder must have a minimum length of 5...")
    private String cardHolder;

    @NotNull(message = "Card expiration year cant be empty...")
    @Min(value = 2023, message = "Card's expiration year must be at least 2023...")
    private int cardExpirationYear;

    @NotNull
    @Max(value = 12)
    @Min(value = 1)
    private int cardExpirationMonth;

    @NotBlank
    @Length(min=3, max = 3, message = "The card CVV numbert must have a length of 3...")
    private String cardCvv;
}
