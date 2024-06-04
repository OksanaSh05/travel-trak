package com.dyplom.travel.models;

import com.dyplom.travel.models.hotel.Hotel;
import com.dyplom.travel.models.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "trips")
public class Trip extends BaseEntity {
    @Basic
    private String location;
    @Basic
    private LocalDate start;
    @Basic
    private LocalDate end;
    @Basic
    private BigDecimal price;
    @Basic
    private String airportName;
    @Basic
    private String city;
    @Basic
    private int passengerCount;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;
    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;
}
