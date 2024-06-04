package com.dyplom.travel.api;

import com.dyplom.travel.models.hotel.Hotel;
import com.dyplom.travel.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/secured/users")
@RestController
public class HotelController {

    private final HotelService service;

    @GetMapping(value = "/all")
    public List<Hotel> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}")
    public Hotel getById(@PathVariable int id) {
        return service.getExistent(id);
    }
}
