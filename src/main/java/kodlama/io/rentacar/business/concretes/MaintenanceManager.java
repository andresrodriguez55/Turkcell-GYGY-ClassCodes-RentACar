package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.MaintenanceService;
import kodlama.io.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateMaintenanceRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllCarsResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateMaintenanceResponse;
import kodlama.io.rentacar.entities.Maintenance;
import kodlama.io.rentacar.repository.CarRepository;
import kodlama.io.rentacar.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MaintenanceManager implements MaintenanceService
{
    private final MaintenanceRepository repository;
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
    public CreateMaintenanceResponse create(CreateMaintenanceRequest request)
    {
        Maintenance maintenance = mapper.map(request, Maintenance.class);
        maintenance.setId(0);
        repository.save(maintenance);
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
}
