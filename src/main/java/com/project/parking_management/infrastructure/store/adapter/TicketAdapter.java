package com.project.parking_management.infrastructure.store.adapter;

import com.project.parking_management.core.domain.entity.Ticket;
import com.project.parking_management.core.port.store.TicketStore;
import com.project.parking_management.infrastructure.store.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TicketAdapter extends BaseJPAAdapter<Ticket, Long, TicketRepository> implements TicketStore {

}
