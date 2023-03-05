package com.flexpag.paymentscheduler;

import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PaymentScheduler {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String status;
    double valorPagamento;
    ZonedDateTime dataCriacao;
    ZonedDateTime dataPagamento;
    Date dataAgendamentoPagamento;
    ZonedDateTime dataModificacao;

}
