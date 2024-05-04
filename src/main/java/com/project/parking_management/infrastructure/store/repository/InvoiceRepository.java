package com.project.parking_management.infrastructure.store.repository;

import com.project.parking_management.core.domain.entity.Invoice;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends BaseRepository<Invoice, Long>{
}
