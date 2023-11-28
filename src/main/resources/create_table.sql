
create table Points(
                       id uuid primary key ,
                       x float default 0,
                       y float default 0,
                       z float default 0
);

create table Couple_Points(
                        id uuid primary key ,
                        pointA_id uuid,
                        pointB_id uuid,
                        foreign key (pointA_id) references Points (id) ON DELETE CASCADE,
                        foreign key (pointB_id) references Points (id) ON DELETE CASCADE
);

create table Launch(
                       id uuid primary key ,
                       time_of_begin timestamp unique not null ,
                       time_of_end timestamp unique not null
);

create table Calculation(
                        id uuid primary key ,
                        method varchar not null
);

create table Logger(
                       id uuid primary key ,
                       launch_id uuid,
                       couple_point_id uuid,
                       calculation_id uuid,
                       foreign key (launch_id) references Launch (id) ON DELETE CASCADE,
                       foreign key (couple_point_id) references Couple_Points (id) ON DELETE CASCADE,
                       foreign key (calculation_id) references Calculation (id) ON DELETE CASCADE
);