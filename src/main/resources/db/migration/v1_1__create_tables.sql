create table users(
    id int primary key auto_increment,
    username varchar(32) not null,
    password text,
    phone varchar(16),
    role varchar(16)
);
create table hotels(
    id int primary key auto_increment,
    name varchar(255),
    price_per_night decimal(10, 2),
    star_rate int,
    hotel_photo text,
    free_one_bedrooms int,
    free_two_bedrooms int,
    country varchar(30),
    free_three_bedrooms int
);
create table travels(
    id int primary key auto_increment,
    country varchar(255) not null,
    country_photo text,
    start date not null,
    end date not null,
    price decimal(10, 2) not null,
    airport_name varchar(64),
    name varchar(255),
    description text,
    city varchar(64)
);
create table trip_tickets(
    id int primary key auto_increment,
    passenger_count int not null,
    one_bedrooms_count int,
    two_bedrooms_count int,
    three_bedrooms_count int,
    owner_id int references users(id),
    travel_id int references travels(id),
    hotel_id int references hotels(id)
);