package com.dyplom.travel.services.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class CreateTripRequest {
    @NotNull
    private Integer passengerCount;
    @NotEmpty
    private Map<String, Integer> selectedRooms;
    @NotNull
    private Integer hotelId;
    @NotNull
    private Integer userId;
    @NotNull
    private Integer travelId;
}
