package org.example.points.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.MethodCalculation;
import org.example.logger.entities.Logger;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "points")
@Getter
@Setter
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)

public class Points  {

    @Id
    @GeneratedValue
    private UUID id;




    @Transient
    private MethodCalculation methodCalculation;


}
