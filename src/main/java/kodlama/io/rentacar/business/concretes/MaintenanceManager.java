package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.CarService;
import kodlama.io.rentacar.business.abstracts.MaintenanceService;
import kodlama.io.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateMaintenanceRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateMaintenanceResponse;
import kodlama.io.rentacar.entities.Maintenance;
import kodlama.io.rentacar.entities.enums.State;
import kodlama.io.rentacar.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MaintenanceManager implements MaintenanceService
{
    private final MaintenanceRepository repository;
    private final CarService carService;
    private final ModelMapper mapper;

    @Override
    public List<GetAllMaintenanceResponse> getAll()
    {
        List<Maintenance> maintenances = repository.findAll();

        List<GetAllMaintenanceResponse> response =
                maintenances.stream().map(maintenance -> mapper.map(maintenance, GetAllMaintenanceResponse.class)).toList();
        return response;
    }

    @Override
    public GetMaintenanceResponse getById(int id)
    {
        checkIfMaintenanceExists(id);

        Maintenance maintenance = repository.findById(id).get();

        GetMaintenanceResponse response = mapper.map(maintenance, GetMaintenanceResponse.class);
        return response;
    }

    @Override
    public GetMaintenanceResponse returnCarFromMaintenance(int carId)
    {
        checkIfCarIsNotUnderMaintenance(carId);

        Maintenance maintenance = repository.findByCarIdAndIsCompletedIsFalse(carId);
        maintenance.setCompleted(true);
        maintenance.setEndDate(LocalDateTime.now());
        carService.changeState(carId, State.AVAILABLE);
        repository.save(maintenance);

        GetMaintenanceResponse response = mapper.map(maintenance, GetMaintenanceResponse.class);
        return response;
    }

    @Override
    public CreateMaintenanceResponse add(CreateMaintenanceRequest request)
    {
        checkIfCarIsUnderMaintenance(request.getCarId());
        checkCarAvailabilityForMaintenance(request);

        Maintenance maintenance = mapper.map(request, Maintenance.class);
        maintenance.setId(0);
        maintenance.setCompleted(false);
        maintenance.setStartDate(LocalDateTime.now());
        maintenance.setEndDate(null);
        repository.save(maintenance);
        carService.changeState(request.getCarId(), State.MAINTENANCE);

        CreateMaintenanceResponse response = mapper.map(maintenance, CreateMaintenanceResponse.class);
        return response;
    }

    @Override
    public UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest request)
    {
        checkIfMaintenanceExists(id);

        Maintenance maintenance = mapper.map(request, Maintenance.class);
        maintenance.setId(id);
        repository.save(maintenance);

        UpdateMaintenanceResponse response = mapper.map(maintenance, UpdateMaintenanceResponse.class);
        return response;
    }

    @Override
    public void delete(Integer id)
    {
        checkIfMaintenanceExists(id);
        Maintenance maintenance = repository.findById(id).get();
        repository.delete(maintenance);
    }

    private void checkIfMaintenanceExists(int id)
    {
        if(!repository.existsById(id))
        {
            throw new IllegalArgumentException("ID does not exist..");
        }
    }

    private void checkIfCarIsNotUnderMaintenance(int carId)
    {
        if(!repository.existsByCarIdAndIsCompletedIsFalse(carId))
            throw new RuntimeException("The car is not in maintenance!");
    }

    private void checkIfCarIsUnderMaintenance(int carId)
    {
        if(repository.existsByCarIdAndIsCompletedIsFalse(carId))
            throw new RuntimeException("The car is in maintenance!");
    }

    private void checkCarAvailabilityForMaintenance(CreateMaintenanceRequest request)
    {
        if(carService.getById(request.getCarId()).getState().equals(State.RENTED))
        {
            throw new RuntimeException("Car is rented, it can be take it to maintenance!");
        }
    }
}
