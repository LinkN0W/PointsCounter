package org.example.logger.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.calculation.entities.Calculation;
import org.example.launch.entities.Launch;
import org.example.points.entities.CouplePoints;
import org.example.points.entities.Points;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "logger")
@Getter
@Setter

public class Logger {

    @Id
    @GeneratedValue
    private UUID id;


    @Column(name = "session_id")
    private UUID sessionId;


    @OneToOne
    @JoinColumn(name = "launch_id", referencedColumnName = "id")
    private Launch launch;

    @OneToOne
    @JoinColumn(name = "couple_points_id", referencedColumnName = "id")
    private CouplePoints couplePoints;

    @OneToOne
    @JoinColumn(name = "calculation_id", referencedColumnName = "id")
    private Calculation calculation;


    @Override
    public String toString() {
        return "Logger{" +
                "id=" + id +
                ", launch=" + launch +
                ", couplePoints=" + couplePoints +
                ", calculation=" + calculation +
                '}';
    }
}
