package org.example.points.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.calculation.entities.Calculation;
import org.example.logger.entities.Logger;

import java.util.UUID;

@Entity
@Table(name = "Couple_Points")
@Getter
@Setter
public class CouplePoints {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne
    @JoinColumn(name = "pointA_id", referencedColumnName = "id")
    private Points pointA;

    @OneToOne
    @JoinColumn(name = "pointB_id", referencedColumnName = "id")
    private Points pointB;




    @Override
    public String toString() {
        return "CouplePoints{" +
                "pointA=" + pointA +
                ", pointB=" + pointB +
                '}';
    }
}
