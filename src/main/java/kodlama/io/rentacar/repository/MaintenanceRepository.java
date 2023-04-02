package kodlama.io.rentacar.repository;

import kodlama.io.rentacar.entities.Car;
import kodlama.io.rentacar.entities.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer>
{
}
