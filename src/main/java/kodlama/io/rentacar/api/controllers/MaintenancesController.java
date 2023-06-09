package kodlama.io.rentacar.api.controllers;

import kodlama.io.rentacar.business.abstracts.MaintenanceService;
import kodlama.io.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateMaintenanceRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateMaintenanceResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
@AllArgsConstructor
public class MaintenancesController
{
    private final MaintenanceService service;

    @GetMapping
    public List<GetAllMaintenanceResponse> getAll()
    {
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public GetMaintenanceResponse getById(@PathVariable("id") Integer id)
    {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateMaintenanceResponse add(@RequestBody CreateMaintenanceRequest request)
    {
        return service.add(request);
    }

    @PutMapping(path = "/return")
    public GetMaintenanceResponse returnCarFromMaintenance(@RequestParam int carId)
    {
        return service.returnCarFromMaintenance(carId);
    }

    @PutMapping(path = "/{id}")
    public UpdateMaintenanceResponse update(@PathVariable("id") int id, @RequestBody UpdateMaintenanceRequest request)
    {
        return service.update(id, request);
    }

    @DeleteMapping(path="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable("id") Integer id)
    {
        service.delete(id);
    }
}
