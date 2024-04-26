package infrastructure.store.adapter;

import core.domain.entity.Ticket;
import infrastructure.store.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TicketAdapter extends BaseJPAAdapter<Ticket, Long, TicketRepository>{

}
