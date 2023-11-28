package org.example.points.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.enums.MethodCalculation;

@Entity
@DiscriminatorValue("Points2D")
@NoArgsConstructor
@Getter
public class Points2D extends Points {

    @Column(name = "x")
    private float x = 0;

    @Column(name = "y")
    private float y = 0;

    @Transient
    private final MethodCalculation methodCalculation = MethodCalculation.DISTANCE2D;

    public Points2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "("+ x +" ,"+ y +")";
    }


}
