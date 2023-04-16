package kodlama.io.rentacar.business.rules;

import kodlama.io.rentacar.business.dto.requests.create.CreatePaymentRequest;
import kodlama.io.rentacar.common.constants.Messages;
import kodlama.io.rentacar.common.dto.CreateRentalPaymentRequest;
import kodlama.io.rentacar.core.exceptions.BusinessException;
import kodlama.io.rentacar.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentBusinessRules
{
    private final PaymentRepository repository;

    public void checkIfPaymentExists(int id)
    {
        if(!repository.existsById(id))
        {
            throw new BusinessException(Messages.Payment.NotFound);
        }
    }

    public void checkIfCardExistsByCardNumber(CreatePaymentRequest request)
    {
        if(repository.existsByCardNumber(request.getCardNumber()))
        {
            throw new BusinessException(Messages.Payment.CardNumberAlreadyExists);
        }
    }
    public void checkIfPaymentIsValid(CreateRentalPaymentRequest request)
    {
        if(!repository.existsByCardNumberAndCardHolderAndCardExpirationYearAndCardExpirationMonthAndCardCvv(
                request.getCardNumber(),
                request.getCardHolder(),
                request.getCardExpirationYear(),
                request.getCardExpirationMonth(),
                request.getCardCvv()
        ))
        {
            throw new BusinessException(Messages.Payment.NotAValidPayment);
        }
    }

    public void checkIfBalanceIsEnough(double price, double balance)
    {
        if(balance < price)
        {
            throw new BusinessException(Messages.Payment.NotEnoughMoney);
        }
    }
}
