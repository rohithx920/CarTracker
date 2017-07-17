package Project.controllers;

import Project.entity.Alerts;
import Project.entity.Readings;
import Project.entity.Tires;
import Project.entity.Vehicles;
import Project.services.ReadingsService;
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
public class ReadingsController {
    @Autowired
    ReadingsService readingsService;
    @Autowired
    VehiclesService vehiclesService;
    @Autowired
    AlertsController alertsController;
    @RequestMapping(method= RequestMethod.GET , value = "/readings", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Readings> findAll(){
        System.out.println("hi");
        return readingsService.findAll();
    }
    @RequestMapping(method= RequestMethod.GET , value = "/readings/{vin}")
    public Readings findOne(@PathVariable("vin") String vin) {
        return readingsService.findOne(vin);
    }

    @RequestMapping(method= RequestMethod.POST , value = "/readings")
    public Readings create(@RequestBody Readings readings) {
//        System.out.println(readings);
//        Readings readings1=new Readings();
//        Tires tires=new Tires();
//        tires=readings.getTires();
//        //tires.getFrontLeft(tires);
//        System.out.println(tires);
        Vehicles vehicles=vehiclesService.findOne(readings.getVin());
        if(readings.getEngineRpm()>vehicles.getRedlineRpm()){
            Alerts alert=new Alerts();
            alert.setType("HIGH");
            alert.setVin(readings.getVin());
            alert.setInfo("readings.getEngineRpm() vehicles.getRedlineRpm()");
            alertsController.create(alert);
        }
        else if(readings.getFuelVolume()<vehicles.getMaxFuelVolume()){
            Alerts alert=new Alerts();
            alert.setType("MEDIUM");
            alert.setVin(readings.getVin());
            alert.setInfo("readings.getEngineRpm()>vehicles.getRedlineRpm()");
            alertsController.create(alert);
        }
        else if(readings.getTires().getFrontLeft()< 32 ||  readings.getTires().getFrontLeft()>36){
            Alerts alert=new Alerts();
            alert.setType("LOW");
            alert.setVin(readings.getVin());
            alert.setInfo("readings.getEngineRpm()>vehicles.getRedlineRpm()");
            alertsController.create(alert);
        }
        else if(readings.getTires().getFrontRight()< 32 ||  readings.getTires().getFrontRight()>36){
            Alerts alert=new Alerts();
            alert.setType("LOW");
            alert.setVin(readings.getVin());
            alert.setInfo("readings.getTires().getFrontRight()< 32 ||  readings.getTires().getFrontRight()>36");
            alertsController.create(alert);
        }
        else if(readings.getTires().getRearLeft()< 32 ||  readings.getTires().getRearLeft()>36){
            Alerts alert=new Alerts();
            alert.setType("LOW");
            alert.setVin(readings.getVin());
            alert.setInfo("readings.getTires().getRearLeft()< 32 ||  readings.getTires().getRearLeft()>36");
            alertsController.create(alert);
        }
        else if(readings.getTires().getRearRight()< 32 ||  readings.getTires().getRearRight()>36){
            Alerts alert=new Alerts();
            alert.setType("LOW");
            alert.setVin(readings.getVin());
            alert.setInfo("readings.getTires().getRearRight()< 32 ||  readings.getTires().getRearRight()>36");
            alertsController.create(alert);
        }
        else if(readings.isEngineCoolantLow()==true || readings.isCheckEngineLightOn()==true){
            Alerts alert=new Alerts();
            alert.setType("LOW");
            alert.setVin(readings.getVin());
            alert.setInfo("readings.isEngineCoolantLow()==true || readings.isCheckEngineLightOn()==true");
            alertsController.create(alert);
        }
        Readings reading=readingsService.create(readings);


        return reading;
    }
    @RequestMapping(method= RequestMethod.PUT , value = "/readings/{vin}")
    public Readings update(@PathVariable("vin") String vin, @RequestBody Readings readings) {
        return readingsService.update(vin,readings);
    }
    @RequestMapping(method= RequestMethod.DELETE, value="/readings/{vin}")
    public void delete(@PathVariable("vin") String vin) {
        readingsService.delete(vin);
    }
}
