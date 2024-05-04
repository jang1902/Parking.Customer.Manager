package com.project.parking_management.core.port.store;


import com.project.parking_management.core.domain.entity.Invoice;

public interface InvoiceStore {
    void saveInvoice(Invoice invoice);
}
