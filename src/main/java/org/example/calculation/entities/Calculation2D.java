package org.example.calculation.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.MethodCalculation;

@Entity
@DiscriminatorValue("DISTANCE2D")
@Getter
@Setter
public class Calculation2D extends Calculation {


    @Column (insertable = false, name = "method")
    private MethodCalculation methodCalculation = MethodCalculation.DISTANCE2D;
}
