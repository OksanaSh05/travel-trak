package com.dyplom.travel.repositories;

import com.dyplom.travel.models.TripTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripTicketRepository extends JpaRepository<TripTicket, Long> {

    List<TripTicket> findAllByOwnerId(long id);
}
