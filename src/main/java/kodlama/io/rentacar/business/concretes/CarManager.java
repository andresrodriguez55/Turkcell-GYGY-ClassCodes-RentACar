package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.CarService;
import kodlama.io.rentacar.business.dto.requests.create.CreateCarRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateCarRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateCarResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllCarsResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetCarResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateCarResponse;
import kodlama.io.rentacar.entities.Car;
import kodlama.io.rentacar.entities.enums.State;
import kodlama.io.rentacar.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //once time of creation?
@AllArgsConstructor
public class CarManager implements CarService
{
    private final CarRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<GetAllCarsResponse> getAll(boolean includeCarsThatAreInMaintenance)
    {
        List<Car> cars = filterCarsByMaintenanceState(includeCarsThatAreInMaintenance);
        List<GetAllCarsResponse> response = cars.stream().map(car -> mapper.map(car, GetAllCarsResponse.class)).toList();
        return response;
    }

    @Override
    public GetCarResponse getById(int id)
    {
        checkIfCarExists(id);
        Car car = repository.findById(id).get();
        GetCarResponse response = mapper.map(car, GetCarResponse.class);
        return response;
    }

    @Override
    public CreateCarResponse add(CreateCarRequest request)
    {
        Car car = mapper.map(request, Car.class);
        car.setId(0); // doğru kullanım, mapper birden fazla id attributeleri karıştırabildiği için her önleme karşı..
        car.setState(State.AVAILABLE);
        repository.save(car);
        CreateCarResponse response = mapper.map(car, CreateCarResponse.class);
        return response;
    }

    @Override
    public UpdateCarResponse update(int id, UpdateCarRequest request)
    {
        checkIfCarExists(id);
        Car car = mapper.map(request, Car.class);
        car.setId(id);
        repository.save(car);
        UpdateCarResponse response = mapper.map(car, UpdateCarResponse.class);
        return response;
    }

    @Override
    public void delete(Integer id)
    {
        checkIfCarExists(id);

        Car car = repository.findById(id).get();
        repository.deleteById(id);
    }

    @Override
    public void changeState(int id, State state)
    {
        Car car = repository.findById(id).get();
        car.setState(state);
        repository.save(car);
    }

    private void checkIfCarExists(int id)
    {
        if(!repository.existsById(id))
        {
            throw new IllegalArgumentException("ID does not exist..");
        }
    }

    private List<Car> filterCarsByMaintenanceState(boolean includeCarsThatAreInMaintenance)
    {
        if(includeCarsThatAreInMaintenance)
        {
            return repository.findAll();
        }

        return repository.findAllByStateIsNot(State.MAINTENANCE);
    }
}
