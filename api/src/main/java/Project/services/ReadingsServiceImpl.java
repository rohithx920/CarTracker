package Project.services;

import Project.entity.Readings;
import Project.entity.Vehicles;
import Project.exception.ResorceNotFoundException;
import Project.repository.ReadingsRepository;
import Project.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rohith on 6/28/2017.
 */
@Service
public class ReadingsServiceImpl implements ReadingsService{
    @Autowired
    ReadingsRepository readingsRepository;

    public List<Readings> findAll() {
        return readingsRepository.findAll();
    }

    public Readings findOne(String vin) {
        Readings readings=readingsRepository.findOne(vin);
        if(readings == null){
            //exception handling 404 not found
            throw new ResorceNotFoundException("Emp with id"+vin+"doesn't exists");
        }
        return readings;
    }

    @Transactional
    public Readings create(Readings readings) {
        //Readings reading=readingsRepository.findOne(readings.getVin());
        //System.out.println("***"+vehicle );
//        if(vehicle !=null){
//            return update(vehicles.getVin(),vehicles);
//        }
//        else {
            // System.out.println("***");

        //System.out.println(readings.);
            return readingsRepository.create(readings);
        //}
    }
    @Transactional
    public Readings update(String vin, Readings readings) {
        Readings reading=readingsRepository.findOne(readings.getVin());

        if(reading == null){
            throw new ResorceNotFoundException("Emp with id"+vin+"doesn't exists");
        }
        return readingsRepository.update(reading);

    }
    @Transactional
    public void delete(String vin) {
        Readings reading=readingsRepository.findOne(vin);

        if(reading == null){
            throw new ResorceNotFoundException("Emp with id"+vin+"doesn't exists");
        }
        readingsRepository.delete(reading);

    }
}


