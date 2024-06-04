package com.dyplom.travel.services;

import com.dyplom.travel.models.hotel.Hotel;
import com.dyplom.travel.repositories.HotelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HotelService extends BasePersistenceService<Hotel> {

    private final HotelRepository repository;

    @Transactional
    public void updateHotelBedrooms(Hotel hotel) {
//        switch (existent.getPassengerCount()) {
//            case 1:
//                hotel.setFreeOneBedrooms(hotel.getFreeOneBedrooms() + 1);
//            case 2:
//                hotel.setFreeTwoBedrooms(hotel.getFreeTwoBedrooms() + 1);
//            case 3:
//                hotel.setFreeThreeBedrooms(hotel.getFreeThreeBedrooms() + 1);
//        }
        update(hotel);
    }
    @Override
    protected JpaRepository<Hotel, Long> getRepository() {
        return repository;
    }
}
