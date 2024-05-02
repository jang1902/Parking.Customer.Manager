package com.project.parking_management.infrastructure.store.repository;

import com.project.parking_management.core.domain.entity.Ticket;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends BaseRepository<Ticket, Long> {

}
