package com.dyplom.travel.services;

import com.dyplom.travel.models.TripTicket;
import com.dyplom.travel.models.hotel.Hotel;
import com.dyplom.travel.repositories.TripTicketRepository;
import com.dyplom.travel.services.models.CreateTripRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.dyplom.travel.services.HotelConstants.*;

@RequiredArgsConstructor
@Service
public class TripTicketService extends BasePersistenceService<TripTicket> {

    private final TripTicketRepository repository;
    private final HotelService hotelService;
    private final UserService userService;
    private final TravelService travelService;

    @Transactional
    public void save(CreateTripRequest request) {
        TripTicket tripTicket = new TripTicket();
        Hotel hotel = hotelService.getExistent(request.getHotelId());
        tripTicket.setHotel(hotel);
        tripTicket.setPassengerCount(request.getPassengerCount());
        tripTicket.setOwner(userService.getExistent(request.getUserId()));
        tripTicket.setTravel(travelService.getExistent(request.getTravelId()));
        hotelService.updateHotelBedrooms(hotel, request.getSelectedRooms(), tripTicket);
        save(tripTicket);
    }

    @Transactional
    @Override
    public void delete(long id) {
        TripTicket existent = getExistent(id);
        Map<String, Integer> roomToFree = new HashMap<>();
        roomToFree.put(ONE_BEDROOMS, -existent.getOneBedroomCount());
        roomToFree.put(TWO_BEDROOMS, -existent.getTwoBedroomCount());
        roomToFree.put(THREE_BEDROOMS, -existent.getThreeBedroomCount());
        hotelService.updateHotelBedrooms(existent.getHotel(), roomToFree, existent);
        delete(existent);
    }

    public List<TripTicket> getAllById(long ownerId) {
        return repository.findAllByOwnerId(ownerId);
    }

    @Override
    protected JpaRepository<TripTicket, Long> getRepository() {
        return repository;
    }
}
