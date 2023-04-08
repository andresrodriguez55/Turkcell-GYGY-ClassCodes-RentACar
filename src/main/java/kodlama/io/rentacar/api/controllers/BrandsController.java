package kodlama.io.rentacar.api.controllers;

import kodlama.io.rentacar.business.abstracts.BrandService;
import kodlama.io.rentacar.business.dto.requests.create.CreateBrandRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateBrandRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateBrandResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllBrandsResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetBrandResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController
{
    private final BrandService service;

    @GetMapping
    public List<GetAllBrandsResponse> getAll()
    {
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public GetBrandResponse getById(@PathVariable("id") Integer id)
    {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateBrandResponse add(@RequestBody CreateBrandRequest brand)
    {
        return service.add(brand);
    }

    @PutMapping(path = "/{id}")
    public UpdateBrandResponse update(@PathVariable("id") int id, @RequestBody UpdateBrandRequest brand)
    {
        return service.update(id, brand);
    }

    @DeleteMapping(path="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable("id") Integer id)
    {
        service.delete(id);
    }
}
