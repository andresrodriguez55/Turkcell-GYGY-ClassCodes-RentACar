package kodlama.io.rentacar.repository;

import jakarta.transaction.Transactional;
import kodlama.io.rentacar.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer>
{
    //@Transactional //undo if error comes
    //void deleteByRentalId(int rentalId);
}
