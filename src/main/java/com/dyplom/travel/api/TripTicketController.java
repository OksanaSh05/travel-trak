package com.dyplom.travel.api;

import com.dyplom.travel.models.TripTicket;
import com.dyplom.travel.services.TripTicketService;
import com.dyplom.travel.services.models.CreateTripRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping(value = "/secured/trips")
@RestController
public class TripTicketController {

    private final TripTicketService service;

    @PostMapping
    public void save(@RequestBody @Valid CreateTripRequest request) {
        service.save(request);
    }

    @GetMapping
    public List<TripTicket> getAllUserTrips(@RequestParam long userId) {
        return service.getAllById(userId);
    }

    @GetMapping(value = "/{id}")
    public TripTicket getTrip(@PathVariable long id) {
        return service.getExistent(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTrip(@PathVariable long id) {
        service.delete(id);
    }
}
