package com.notyflow.consumer_log;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LogConsumer {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(
        topics = "notiflow.command.created",
        groupId = "notiflow.log"
    )
    public void consommerCommande(String message) {
        try {
            CommandeCreatedEvent event = objectMapper.readValue(message, CommandeCreatedEvent.class);
            System.out.println("LOG ENREGISTRÉ pour la commande " + event.commandeId());
            System.out.println("   Client : " + event.clientNom() + " (" + event.clientEmail() + ")");
            System.out.println("   Produit : " + event.produit() + " x " + event.quantite());
            System.out.println("   Montant : " + event.montant() + " FCFA");
            System.out.println("   Date : " + event.dateCreation());
        } catch (Exception e) {
            System.err.println("Erreur lors de la désérialisation : " + e.getMessage());
        }
    }
}