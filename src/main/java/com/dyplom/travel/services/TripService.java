package com.dyplom.travel.services;

import com.dyplom.travel.models.Trip;
import com.dyplom.travel.repositories.TripRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TripService extends BasePersistenceService<Trip> {

    private final TripRepository repository;
    private final HotelService hotelService;

    @Transactional
    @Override
    public Trip save(Trip trip) {
        Trip existent = getExistent(trip.getId());
        hotelService.updateHotelBedrooms(existent.getHotel());
        return null;
    }

    @Transactional
    @Override
    public Trip update(Trip trip) {
        Trip existent = getExistent(trip.getId());
        hotelService.updateHotelBedrooms(existent.getHotel());
        return null;
    }

    @Transactional
    @Override
    public void delete(long id) {
        Trip existent = getExistent(id);
        hotelService.updateHotelBedrooms(existent.getHotel());
    }

    @Override
    protected JpaRepository<Trip, Long> getRepository() {
        return repository;
    }
}
