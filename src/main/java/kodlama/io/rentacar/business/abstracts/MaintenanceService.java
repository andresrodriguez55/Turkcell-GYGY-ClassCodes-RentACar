package kodlama.io.rentacar.business.abstracts;

import kodlama.io.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateMaintenanceRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateMaintenanceResponse;

import java.util.List;

public interface MaintenanceService
{
    List<GetAllMaintenanceResponse> getAll();
    GetMaintenanceResponse getById(int id);
    GetMaintenanceResponse returnCarFromMaintenance(int carId);
    CreateMaintenanceResponse add(CreateMaintenanceRequest request);
    UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest request);
    void delete(Integer id);
}
