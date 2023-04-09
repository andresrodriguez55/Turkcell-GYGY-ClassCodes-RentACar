package kodlama.io.rentacar.repository;

import kodlama.io.rentacar.business.dto.requests.create.CreatePaymentRequest;
import kodlama.io.rentacar.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>
{
    Payment findByCardNumber(String cardNumber);
    boolean existsByCardNumber(String cardNumber);
    boolean existsByCardNumberAndCardHolderAndCardExpirationYearAndCardExpirationMonthAndCardCvv(
            String cardNumber, String cardHolder, int expirationYear, int expirationMonth, String cardCvv
    );

    //SPeL -> Spring expression language
    //    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END " +
    //            "FROM Payment AS p WHERE p.cardNumber = :#{paymentRequest.cardNumber} AND "+
    //            "AND p.cardHolder = :#{paymentRequest.cardHolder} AND "+
    //            "p.cardExpirationYear = :#{paymentRequest.cardExpirationYear} AND "+
    //            "p.cardExpirationMonth = :#{paymentRequest.cardExpirationMonth} AND "+
    //            "p.cardCvv = :#{paymentRequest.cardCvv}")
    //    boolean existsByCardNumberAndCardHolderAndCardExpirationYearAndCardExpirationMonthAndCardCvv(
    //            @Param("paymentRequest") CreatePaymentRequest paymentRequest
    //            );

}
