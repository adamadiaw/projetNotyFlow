package com.notyflow.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CommandeProducerService {

    private final KafkaTemplate<String, CommandeCreatedEvent> kafkaTemplate;
    private static final String TOPIC = "notiflow.commandes.created";

    public CommandeProducerService(KafkaTemplate<String, CommandeCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void envoyerCommande(CommandeCreatedEvent event) {
        kafkaTemplate.send(TOPIC, event.commandeId().toString(), event);
        System.out.println("✅ Événement envoyé au topic " + TOPIC + " : " + event);
    }
}