package com.notyflow.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CommandeProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String TOPIC = "notiflow.command.created";

    public CommandeProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void envoyerCommande(CommandeCreatedEvent event) {
        try {
            String json = objectMapper.writeValueAsString(event);
            kafkaTemplate.send(TOPIC, event.commandeId(), json);
            System.out.println(" Événement envoyé au topic " + TOPIC + " : " + json);
        } catch (Exception e) {
            System.err.println(" Erreur lors de la sérialisation : " + e.getMessage());
        }
    }
}