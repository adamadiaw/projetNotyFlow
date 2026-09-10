package com.notyflow.consumer_email;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(
        topics = "notiflow.command.created",
        groupId = "notiflow.email"
    )
    public void consommerCommande(String message) {
        try {
            CommandeCreatedEvent event = objectMapper.readValue(message, CommandeCreatedEvent.class);
            System.out.println("📧 EMAIL ENVOYÉ à " + event.clientEmail() + " pour la commande " + event.commandeId());
            System.out.println("   Détails : " + event.clientNom() + " a commandé " + event.quantite() + " x " + event.produit() + " pour " + event.montant() + " €");
        } catch (Exception e) {
            System.err.println("❌ Erreur lors de la désérialisation : " + e.getMessage());
        }
    }
}