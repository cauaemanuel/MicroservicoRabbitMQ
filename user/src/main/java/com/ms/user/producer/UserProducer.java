package com.ms.user.producer;

import com.ms.user.DTO.EmailDTO;
import com.ms.user.model.Usuario;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(Usuario user) {
        var emailDto = new EmailDTO();
        emailDto.setUserId(user.getUserID());
        emailDto.setEmailTo(user.getEmail());
        emailDto.setSubject("Cadastro Realizado Com Sucesso");
        emailDto.setText(user.getName() + ", seja bem vindo(a)! \nAgradecemos o seu cadastro, aproveite todos os recursos da nossa plataforma");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}
