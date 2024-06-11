package com.dyplom.travel.services;

import com.dyplom.travel.models.TripTicket;
import com.dyplom.travel.models.hotel.Hotel;
import com.dyplom.travel.repositories.HotelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.dyplom.travel.services.HotelConstants.*;

@RequiredArgsConstructor
@Service
public class HotelService extends BasePersistenceService<Hotel> {

    private final HotelRepository repository;

    public List<Hotel> getListByCountry(String country) {
        return repository.findAllByCountry(country);
    }

    @Transactional
    public void updateHotelBedrooms(Hotel hotel, Map<String, Integer> selectedRooms, TripTicket tripTicket) {
        selectedRooms.forEach((room, count) -> {
            if (ONE_BEDROOMS.equals(room)) {
                if (hotel.getFreeOneBedrooms() - count >= 0) {
                    tripTicket.setOneBedroomCount(count);
                    hotel.setFreeOneBedrooms(hotel.getFreeOneBedrooms() - count);
                } else {
                    throw new IllegalStateException(String.format("Not enough %s rooms", room));
                }
            } else if (TWO_BEDROOMS.equals(room)) {
                if (hotel.getFreeTwoBedrooms() - count >= 0) {
                    tripTicket.setTwoBedroomCount(count);
                    hotel.setFreeOneBedrooms(hotel.getFreeTwoBedrooms() - count);
                } else {
                    throw new IllegalStateException(String.format("Not enough %s rooms", room));
                }
            } else if (THREE_BEDROOMS.equals(room)) {
                if (hotel.getFreeThreeBedrooms() - count >= 0) {
                    tripTicket.setThreeBedroomCount(count);
                    hotel.setFreeOneBedrooms(hotel.getFreeThreeBedrooms() - count);
                } else {
                    throw new IllegalStateException(String.format("Not enough %s rooms", room));
                }
            } else {
                throw new IllegalStateException(String.format("Not implemented for %s", room));
            }
        });
        update(hotel);
    }
    @Override
    protected JpaRepository<Hotel, Long> getRepository() {
        return repository;
    }
}
