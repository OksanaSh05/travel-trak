package com.dyplom.travel.models.hotel;

import com.dyplom.travel.models.BaseEntity;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "hotels")
@Entity
public class Hotel extends BaseEntity {
    @Basic
    private String name;

    @Column(name = "price_per_night")
    private BigDecimal pricePerNight;

    @Column(name = "star_rate")
    private int starRate;

    @Column(name = "free_one_bedrooms")
    private int freeOneBedrooms;

    @Column(name = "free_two_bedrooms")
    private int freeTwoBedrooms;

    @Column(name = "free_three_bedrooms")
    private int freeThreeBedrooms;

    @Column(name = "hotel_photo")
    private String hotelPhoto;

    @Basic
    private String country;
}
