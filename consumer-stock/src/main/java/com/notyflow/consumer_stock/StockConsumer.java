package com.notyflow.consumer_stock;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StockConsumer {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final StockRepository stockRepository;

    public StockConsumer(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @KafkaListener(
        topics = "notiflow.command.created",
        groupId = "notiflow.stock"
    )
    public void consommerCommande(String message) {
        try {
            CommandeCreatedEvent event = objectMapper.readValue(message, CommandeCreatedEvent.class);
            
            // Récupérer le stock actuel du produit
            Stock stock = stockRepository.findById(event.produit())
                    .orElse(new Stock(event.produit(), 100)); // Stock initial de 100 si nouveau produit
            
            // Décrémenter le stock
            int nouvelleQuantite = stock.getQuantiteDisponible() - event.quantite();
            stock.setQuantiteDisponible(nouvelleQuantite);
            
            // Sauvegarder en base
            stockRepository.save(stock);
            
            System.out.println("📦 STOCK MIS À JOUR pour " + event.produit());
            System.out.println("   Quantité commandée : " + event.quantite());
            System.out.println("   Nouveau stock : " + nouvelleQuantite);
            
        } catch (Exception e) {
            System.err.println("❌ Erreur lors du traitement : " + e.getMessage());
            e.printStackTrace();
        }
    }
}