package Project.services;

import Project.entity.Vehicles;
import Project.exception.ResorceNotFoundException;
import Project.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rohith on 6/28/2017.
 */
@Service
public class VehiclesServiceImpl implements VehiclesService{

    @Autowired
    VehiclesRepository vehiclesRepository;

    public List<Vehicles> findAll() {
        //System.out.println("jell");
        return vehiclesRepository.findAll();
    }

    public Vehicles findOne(String vin) {
        Vehicles vehicles=vehiclesRepository.findOne(vin);
        if(vehicles == null){
            //exception handling 404 not found
            //throw new ResorceNotFoundException("Emp with id"+vin+"doesn't exists");
            return null;
        }
        return vehicles;
    }

    @Transactional
    public Vehicles create(Vehicles vehicles) {
        Vehicles vehicle=vehiclesRepository.findOne(vehicles.getVin());
        //System.out.println("***"+vehicle );
        if(vehicle !=null){
            return update(vehicles.getVin(),vehicles);
        }
        else {
           // System.out.println("***");
            return vehiclesRepository.create(vehicles);
        }
    }
    @Transactional
    public Vehicles update(String vin, Vehicles vehicles) {
        Vehicles vehicle=vehiclesRepository.findOne(vehicles.getVin());

        if(vehicle == null){
            throw new ResorceNotFoundException("Emp with id"+vin+"doesn't exists");
        }
            return vehiclesRepository.update(vehicles);

    }
    @Transactional
    public void delete(String vin) {
        Vehicles vehicle=vehiclesRepository.findOne(vin);

        if(vehicle == null){
            throw new ResorceNotFoundException("Emp with id"+vin+"doesn't exists");
        }
        vehiclesRepository.delete(vehicle);

    }
}
