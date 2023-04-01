package kodlama.io.rentacar.repository;

import kodlama.io.rentacar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //jpa ya de por si es un repositorio, no hace falta la anotacion
public interface BrandRepository extends JpaRepository<Brand, Integer>
{
    //custom queries
    boolean existsBrandByNameIgnoreCase(String name);
}
