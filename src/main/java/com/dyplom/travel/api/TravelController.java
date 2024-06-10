package com.dyplom.travel.api;

import com.dyplom.travel.models.Travel;
import com.dyplom.travel.services.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/public/travels")
public class TravelController {

    private final TravelService service;

    @GetMapping
    public List<Travel> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/available")
    public List<Travel> getAvailable() {
        return service.getAvailable();
    }

    @GetMapping(value = "/{id}")
    public Travel getById(@PathVariable Long id) {
        return service.getExistent(id);
    }
}
