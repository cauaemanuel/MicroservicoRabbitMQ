package com.ms.email.consumer;

import com.ms.email.dto.EmailDTO;
import com.ms.email.model.EmailEntity;
import com.ms.email.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    private EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailDTO emailDTO){
        var emailEntity = new EmailEntity();
        BeanUtils.copyProperties(emailDTO, emailEntity);
        emailService.sendEmail(emailEntity);
    }
}
