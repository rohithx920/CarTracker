package Project.repository;

import Project.entity.Readings;

import java.util.List;

/**
 * Created by Rohith on 6/28/2017.
 */
public interface ReadingsRepository {
    List<Readings> findAll();
    Readings findOne(String vin);
    Readings create(Readings readings);
    Readings update(Readings readings);
    void delete(Readings readings);

}
