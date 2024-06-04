package com.dyplom.travel.api;

import com.dyplom.travel.models.Trip;
import com.dyplom.travel.services.TripService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping(value = "/secured/trips")
@RestController
public class TripController {

    private final TripService service;

    @PostMapping
    public Trip save(@RequestBody @Valid Trip trip) {
        return service.save(trip);
    }

    @GetMapping(value = "/all")
    public List<Trip> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/all")
    public List<Trip> getAllUserTrips(@RequestParam long userId) {
        return null;
    }

    @GetMapping(value = "/{id}")
    public Trip getTrip(@PathVariable long id) {
        return service.getExistent(id);
    }

    @PutMapping
    public Trip updateTrip(@RequestBody @Valid Trip trip) {
        return service.update(trip);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTrip(@PathVariable long id) {
        service.delete(id);
    }
}
