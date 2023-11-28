package org.example.calculation.entities;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.MethodCalculation;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "calculation")
@Getter
@Setter
@DiscriminatorColumn
        (
                name= "method",
                discriminatorType=DiscriminatorType.STRING
        )
public class Calculation {


    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "distance")
    private float distance = 0;


    @Enumerated(EnumType.STRING)
    @Column (insertable = false, updatable = false, name = "method" )
    private MethodCalculation methodCalculation;



}
