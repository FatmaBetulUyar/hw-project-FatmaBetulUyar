package com.patika.paycore.Project.messaging.producer;

import com.patika.paycore.Project.config.RabbitMQConfig;
import com.patika.paycore.Project.model.entity.Transaction;
import com.patika.paycore.Project.service.TransactionService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messaging/publish")
public class TransactionProducer {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private TransactionService transactionService;
//
//    @PostMapping("/{message}")
//    public String publishMessage(@PathVariable String message) {
//        template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, message);
//        return "Success";
  //  }

//    @PostMapping("/transaction/{id}")
//    public String publishTransaction(@PathVariable Integer id) {
//        Transaction transaction = transactionService.getTransaction(id);
//        template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, transaction);
//        return "Success";
//    }
}