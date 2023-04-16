package kodlama.io.rentacar.business.rules;

import kodlama.io.rentacar.common.constants.Messages;
import kodlama.io.rentacar.core.exceptions.BusinessException;
import kodlama.io.rentacar.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules
{
    private final BrandRepository repository;

    public void checkIfBrandExists(int id)
    {
        if(!repository.existsById(id))
        {
            throw new BusinessException(Messages.Brand.NotExists);
        }
    }

    public void checkIfBrandExistByNameIgnoreCase(String name)
    {
        if(repository.existsBrandByNameIgnoreCase(name))
        {
            throw new BusinessException(Messages.Brand.Exists);
        }
    }
}
