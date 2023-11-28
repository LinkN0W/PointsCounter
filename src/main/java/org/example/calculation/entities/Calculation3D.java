package org.example.calculation.entities;


import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.MethodCalculation;

@Entity
@DiscriminatorValue("DISTANCE3D")
@Getter
@Setter
public class Calculation3D extends Calculation{



    private MethodCalculation methodCalculation = MethodCalculation.DISTANCE3D;
}
