package com.project.parking_management.infrastructure.store.adapter;

import com.project.parking_management.core.domain.entity.Invoice;
import com.project.parking_management.core.port.store.InvoiceStore;
import com.project.parking_management.infrastructure.store.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class InvoiceAdapter extends BaseJPAAdapter<Invoice, Long, InvoiceRepository> implements InvoiceStore {

}
