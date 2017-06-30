package Project.services;

import Project.entity.Vehicles;

import java.util.List;

/**
 * Created by Rohith on 6/28/2017.
 */
public interface VehiclesService {
    List<Vehicles> findAll();
    Vehicles findOne(String vin);
    Vehicles create(Vehicles vehicles);
    Vehicles update(String vin, Vehicles vehicles);
    void delete(String vin);

}
