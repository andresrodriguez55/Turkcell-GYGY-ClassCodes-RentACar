package kodlama.io.rentacar.business.abstracts;

import kodlama.io.rentacar.business.dto.requests.create.CreateCarRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateCarRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateCarResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllCarsResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetCarResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateCarResponse;
import kodlama.io.rentacar.entities.enums.State;

import java.util.List;

public interface CarService
{
    List<GetAllCarsResponse> getAll(boolean includeCarsThatAreInMaintenance);
    GetCarResponse getById(int id);
    CreateCarResponse create(CreateCarRequest request);
    UpdateCarResponse update(int id, UpdateCarRequest request);
    void changeState(int id, State state);
    void delete(Integer id);
}
