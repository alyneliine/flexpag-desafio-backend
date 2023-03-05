package com.flexpag.paymentscheduler;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PaymentSchedulerController {

    PaymentSchedulerRepository repository;

    @GetMapping("/PaymentScheduler/status/{id}")
    public String consultarStatusAgendamentoPorId(@PathVariable Long id){
        return repository.findById(id).get().getStatus();

    }

    @GetMapping("/PaymentScheduler")
    public List <PaymentScheduler> mostrarTodosAgendamentos(){
        return repository.findAll();
    }

    @PostMapping("/PaymentScheduler")
    public String criarAgendamento(@RequestBody PaymentScheduler paymentSheduler){ 

        paymentSheduler.dataCriacao = ZonedDateTime.now();
        
        paymentSheduler.status = "Pending";

        return "ID: " + repository.save(paymentSheduler).id;
        
    }

    @PutMapping("/PaymentScheduler/{id}")
    public PaymentScheduler editarAgendamento(@PathVariable Long id, @RequestBody PaymentScheduler dataAgendamentoPagamento){
       
        PaymentScheduler paymentSheduler = repository.findById(id).get();

        paymentSheduler.dataModificacao = ZonedDateTime.now();
        paymentSheduler.dataAgendamentoPagamento = dataAgendamentoPagamento.dataAgendamentoPagamento;
        return repository.save(paymentSheduler);
    }

    @PutMapping("/PaymentScheduler/pagar/{id}")
    public PaymentScheduler efetuarPagamento(@PathVariable Long id){

        PaymentScheduler paymentSheduler = repository.findById(id).get();

        paymentSheduler.dataModificacao = ZonedDateTime.now();
        paymentSheduler.dataPagamento = ZonedDateTime.now();
        paymentSheduler.status = "Paid";
        return repository.save(paymentSheduler);

    }

    @DeleteMapping("/PaymentScheduler/{id}")
    public String excluirAgendamento(@PathVariable Long id){
        repository.deleteById(id);
        return "Excluído com sucesso";
    }

   
}
