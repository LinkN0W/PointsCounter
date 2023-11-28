package org.example.points.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.enums.MethodCalculation;

import java.util.Objects;

@Entity
@DiscriminatorValue("Points3D")
@NoArgsConstructor
@Getter
public class Points3D extends Points{

    @Column(name = "x")
    private float x = 0;

    @Column(name = "y")
    private float y = 0;

    @Column(name = "z")
    private float z = 0;


    @Transient
    private final MethodCalculation methodCalculation = MethodCalculation.DISTANCE3D;

    public Points3D(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString() {
        return "("+ x +" ,"+ y +", "+ z + ")";
    }


}
