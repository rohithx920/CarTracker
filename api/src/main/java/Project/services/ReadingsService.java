package Project.services;

import Project.entity.Readings;

import java.util.List;

/**
 * Created by Rohith on 6/28/2017.
 */
public interface ReadingsService {
    List<Readings> findAll();
    Readings findOne(String vin);
    Readings create(Readings readings);
    Readings update(String vin, Readings readings);
    void delete(String vin);

}
