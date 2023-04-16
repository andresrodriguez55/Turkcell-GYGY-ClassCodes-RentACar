package kodlama.io.rentacar.adapters;

import kodlama.io.rentacar.business.abstracts.PostService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FakePosServiceAdapter implements PostService
{
    @Override
    public void pay()
    {
        boolean isPaymentSuccessfull = true; //new Random().nextBoolean();
        if(!isPaymentSuccessfull)
        {
            throw new RuntimeException("Payment invalid...");
        }
    }
}
