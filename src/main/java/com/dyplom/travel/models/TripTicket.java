package com.dyplom.travel.models;

import com.dyplom.travel.models.hotel.Hotel;
import com.dyplom.travel.models.user.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "trip_tickets")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TripTicket extends BaseEntity {
    @Basic
    private int passengerCount;

    @Column(name = "one_bedrooms_count")
    private int oneBedroomCount;

    @Column(name = "two_bedrooms_count")
    private int twoBedroomCount;

    @Column(name = "three_bedrooms_count")
    private int threeBedroomCount;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;

    @ManyToOne
    @JoinColumn(name = "travel_id", referencedColumnName = "id")
    private Travel travel;

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;
}
