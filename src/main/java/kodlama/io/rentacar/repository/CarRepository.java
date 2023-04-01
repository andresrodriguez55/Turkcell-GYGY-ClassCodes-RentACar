package kodlama.io.rentacar.repository;

import kodlama.io.rentacar.entities.Brand;
import kodlama.io.rentacar.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer>
{
}
