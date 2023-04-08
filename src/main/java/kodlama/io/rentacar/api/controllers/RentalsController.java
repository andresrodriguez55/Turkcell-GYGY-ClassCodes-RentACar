package kodlama.io.rentacar.api.controllers;

import kodlama.io.rentacar.business.abstracts.RentalService;
import kodlama.io.rentacar.business.dto.requests.create.CreateRentalRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateRentalRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateRentalResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllRentalsResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetRentalResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
@AllArgsConstructor
public class RentalsController
{
    private final RentalService service;

    @GetMapping
    public List<GetAllRentalsResponse> getAll()
    {
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public GetRentalResponse getById(@PathVariable("id") Integer id)
    {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateRentalResponse add(@RequestBody CreateRentalRequest rental)
    {
        return service.add(rental);
    }

    @PutMapping(path = "/{id}")
    public UpdateRentalResponse update(@PathVariable("id") int id, @RequestBody UpdateRentalRequest brand)
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
