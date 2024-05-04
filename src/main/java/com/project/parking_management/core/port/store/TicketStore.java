package com.project.parking_management.core.port.store;

import com.project.parking_management.core.domain.entity.Ticket;

public interface TicketStore {
    Ticket getTicket(Long ticketId);
}
