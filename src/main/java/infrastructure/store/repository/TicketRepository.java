package infrastructure.store.repository;

import core.domain.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends BaseRepository<Ticket, Long> {

}
