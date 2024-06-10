package com.dyplom.travel.models;

import com.dyplom.travel.models.hotel.Hotel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "travels")
public class Travel extends BaseEntity {
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
    private String country;
    @Basic
    private String name;
    @Basic
    private String description;
    @Column(name = "country_photo")
    private String countryPhoto;

    @OneToMany(mappedBy = "travel", cascade = CascadeType.REMOVE)
    private List<TripTicket> tripTickets;

    @Transient
    private List<Hotel> hotels;
}
