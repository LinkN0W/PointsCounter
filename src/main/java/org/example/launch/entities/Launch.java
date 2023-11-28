package org.example.launch.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "launch")
@Getter
@Setter
public class Launch {

    @Id
    @GeneratedValue
    private UUID id;

    @NonNull
    @Column(name = "time_of_begin")
    private LocalDateTime timeOfBegin;

    @NonNull
    @Column(name = "time_of_end")
    private LocalDateTime timeOfEnd;


}
