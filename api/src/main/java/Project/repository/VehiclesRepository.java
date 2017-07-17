package Project.repository;

import Project.entity.Vehicles;

import java.util.List;

/**
 * Created by Rohith on 6/28/2017.
 */
public interface VehiclesRepository {
    List<Vehicles> findAll();
    Vehicles findOne(String vin);
    Vehicles create(Vehicles vehicles);
    Vehicles update( Vehicles vehicles);
    void delete(Vehicles vehicles);
}
