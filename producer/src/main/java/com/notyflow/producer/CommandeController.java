package com.notyflow.producer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    private final CommandeProducerService producerService;

    public CommandeController(CommandeProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping
    public ResponseEntity<CommandeCreatedEvent> creerCommande(@RequestBody CommandeCreatedEvent commande) {
        // On force la génération de l'ID et la date si elles ne sont pas fournies
        CommandeCreatedEvent event = new CommandeCreatedEvent(
                commande.commandeId() != null ? commande.commandeId() : UUID.randomUUID(),
                commande.clientEmail(),
                commande.clientNom(),
                commande.produit(),
                commande.quantite(),
                commande.montant(),
                commande.dateCreation() != null ? commande.dateCreation() : LocalDateTime.now()
        );

        producerService.envoyerCommande(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(event);
    }
}