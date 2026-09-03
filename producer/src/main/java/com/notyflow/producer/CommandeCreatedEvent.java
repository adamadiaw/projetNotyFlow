package com.notyflow.producer;

import java.time.LocalDateTime;
import java.util.UUID;

public record CommandeCreatedEvent(
        UUID commandeId,
        String clientEmail,
        String clientNom,
        String produit,
        int quantite,
        double montant,
        LocalDateTime dateCreation
) {
    // Ce record est immuable, parfait pour un événement Kafka
}