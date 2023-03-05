package com.flexpag.paymentscheduler;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentSchedulerRepository extends JpaRepository <PaymentScheduler, Long>  {
    
}
