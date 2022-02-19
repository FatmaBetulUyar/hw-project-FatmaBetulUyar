package com.patika.paycore.Project.messaging.producer;


import com.patika.paycore.Project.config.RabbitMQConfig;
import com.patika.paycore.Project.model.entity.Transaction;
import com.patika.paycore.Project.model.entity.Transfer;
import com.patika.paycore.Project.service.TransferService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messaging/publish")
public class TransferProducer {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private TransferService transferService;

    @PostMapping("/transfer/{id}")
    public String publishTransaction(@PathVariable Integer id) {
        Transfer transfer = transferService.getTransfer(id);
        template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, transfer);
        return "Success";
    }
}
