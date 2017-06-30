package Project.entity;

import org.springframework.context.annotation.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by Rohith on 6/28/2017.
 */

@Entity
public class Tires {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;
    private float frontLeft;
    private float frontRight;
    private float rearLeft;
    private float rearRight;

    public Tires(){
        this.id= UUID.randomUUID().toString();
    }

    public Tires(float frontLeft, float frontRight, float rearLeft, float rearRight) {
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.rearLeft = rearLeft;
        this.rearRight = rearRight;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public String getVin() {
//        return vin;
//    }
//
//    public void setVin(String vin) {
//        this.vin = vin;
//    }

    public float getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(float frontLeft) {
        this.frontLeft = frontLeft;
    }

    public float getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(float frontRight) {
        this.frontRight = frontRight;
    }

    public float getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(float rearLeft) {
        this.rearLeft = rearLeft;
    }

    public float getRearRight() {
        return rearRight;
    }

    public void setRearRight(float rearRight) {
        this.rearRight = rearRight;
    }

    @Override
    public String toString() {
        return "Tires{" +
                "frontLeft=" + frontLeft +
                ", frontRight=" + frontRight +
                ", rearLeft=" + rearLeft +
                ", rearRight=" + rearRight +
                '}';
    }
}
