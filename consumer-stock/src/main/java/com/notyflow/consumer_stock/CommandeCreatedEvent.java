package com.notyflow.consumer_stock;

public record CommandeCreatedEvent(
    String commandeId,
    String clientEmail,
    String clientNom,
    String produit,
    int quantite,
    double montant,
    String dateCreation
) {
}