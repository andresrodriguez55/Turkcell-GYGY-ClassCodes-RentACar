package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.PaymentService;
import kodlama.io.rentacar.business.abstracts.PostService;
import kodlama.io.rentacar.business.dto.requests.create.CreatePaymentRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdatePaymentRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreatePaymentResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllPaymentsResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetPaymentResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdatePaymentResponse;
import kodlama.io.rentacar.core.dto.CreateRentalPaymentRequest;
import kodlama.io.rentacar.entities.Payment;
import kodlama.io.rentacar.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService
{
    private final PaymentRepository repository;
    private final ModelMapper mapper;
    private final PostService postService;

    @Override
    public List<GetAllPaymentsResponse> getAll()
    {
        List<Payment> payments = repository.findAll();
        List<GetAllPaymentsResponse> response =
                payments.stream().map(payment -> mapper.map(payment, GetAllPaymentsResponse.class)).toList();
        return response;
    }

    @Override
    public GetPaymentResponse getById(int id)
    {
        Payment payment = repository.findById(id).orElseThrow();
        GetPaymentResponse response = mapper.map(payment, GetPaymentResponse.class);
        return response;
    }

    @Override
    public CreatePaymentResponse add(CreatePaymentRequest request)
    {
        checkIfCardExistsByCardNumber(request);

        Payment payment = mapper.map(request, Payment.class);
        payment.setId(0);
        repository.save(payment);
        CreatePaymentResponse response = mapper.map(payment, CreatePaymentResponse.class);
        return response;
    }

    @Override
    public UpdatePaymentResponse update(int id, UpdatePaymentRequest request)
    {
        checkIfPaymentExists(id);
        Payment payment = mapper.map(request, Payment.class);
        payment.setId(id);
        repository.save(payment);
        UpdatePaymentResponse response = mapper.map(payment, UpdatePaymentResponse.class);
        return response;
    }

    @Override
    public void delete(int id)
    {
        checkIfPaymentExists(id);
        repository.deleteById(id);
    }

    private void checkIfPaymentExists(int id)
    {
        if(!repository.existsById(id))
        {
            throw new RuntimeException("Payment does not exists...");
        }
    }

    private void checkIfCardExistsByCardNumber(CreatePaymentRequest request)
    {
        if(repository.existsByCardNumber(request.getCardNumber()))
        {
            throw new RuntimeException("Card already exists...");
        }
    }

    @Override
    public void processRentalPayment(CreateRentalPaymentRequest request)
    {
        checkIfPaymentIsValid(request);
        Payment payment = repository.findByCardNumber(request.getCardNumber());
        checkIfBalanceIsEnough(request.getPrice(), payment.getBalance());

        //FAKE POS SERVICE
        postService.pay();

        payment.setBalance(payment.getBalance() - request.getPrice());
        repository.save(payment);
    }

    private void checkIfPaymentIsValid(CreateRentalPaymentRequest request)
    {
        if(repository.existsByCardNumberAndCardHolderAndCardExpirationYearAndCardExpirationMonthAndCardCvv(
                request.getCardNumber(),
                request.getCardHolder(),
                request.getCardExpirationYear(),
                request.getCardExpirationMonth(),
                request.getCardCvv()
        ))
        {
            throw new RuntimeException("Invalid card information...");
        }
    }

    private void checkIfBalanceIsEnough(double price, double balance)
    {
        if(balance < price)
        {
            throw new RuntimeException("Insufficient balance...");
        }
    }
}
