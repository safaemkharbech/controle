package org.sid.billingservice.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "fullbilling",types = Bill.class)
public interface BillingProjection {
    Long getId();
    Date getBillDate();
    Long getCustomerID();

}
