package az.dev.ticketingservice.repository;

import az.dev.ticketingservice.entity.BookingSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingSeatRepository extends JpaRepository<BookingSeat, UUID> {
}
