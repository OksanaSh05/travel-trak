package com.dyplom.travel.services;

import com.dyplom.travel.models.Travel;
import com.dyplom.travel.repositories.TravelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TravelService extends BasePersistenceService<Travel> {

    private final TravelRepository repository;
    private final HotelService hotelService;

    @Override
    public Travel getExistent(long id) {
        Travel travel = super.getExistent(id);
        travel.setHotels(hotelService.getListByCountry(travel.getCountry()));
        return travel;
    }

    public List<Travel> getAvailable() {
        return repository.findAllByEndAfter(LocalDate.now());
    }

    @Override
    protected JpaRepository<Travel, Long> getRepository() {
        return repository;
    }
}
