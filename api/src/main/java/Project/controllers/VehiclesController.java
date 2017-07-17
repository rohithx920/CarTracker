package Project.controllers;

import Project.entity.Vehicles;
import Project.services.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Rohith on 6/28/2017.
 */

@RestController
@CrossOrigin(origins = "*")
public class VehiclesController {

    @Autowired
    VehiclesService vehiclesService;
    @RequestMapping(method= RequestMethod.GET , value = "/vehicles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicles> findAll(){
        System.out.println("hi");
        return vehiclesService.findAll();
    }
    @RequestMapping(method= RequestMethod.GET , value = "/vehicles/{vin}")
    public Vehicles findOne(@PathVariable("vin") String vin) {
        return vehiclesService.findOne(vin);
    }
    @RequestMapping(method= RequestMethod.PUT , value = "/vehicles")
    public List<Vehicles> create(@RequestBody List<Vehicles> vehicles) {
        //System.out.println(vehicles);
        for(Vehicles vehicle:vehicles){
            System.out.println(vehicle.getVin());
            Vehicles v=findOne(vehicle.getVin());
            System.out.println(v);
             if(v !=null){
                System.out.println("update:"+v.getVin());
                vehiclesService.update(v.getVin(),v);
            }
            else{
                System.out.println("creating");
                vehiclesService.create(vehicle);
            }
        }
        //System.out.println(vehicles);
        //return vehiclesService.create(vehicles);
        return vehicles;
    }

//    @RequestMapping(method= RequestMethod.PUT , value = "/vehicles/{vin}")
//    public Vehicles update(@PathVariable("vin") String vin, @RequestBody Vehicles vehicles) {
//        return vehiclesService.update(vin,vehicles);
//    }
    @RequestMapping(method= RequestMethod.DELETE, value="/vehicles/{vin}")
    public void delete(@PathVariable("vin") String vin) {
         vehiclesService.delete(vin);
    }

}
