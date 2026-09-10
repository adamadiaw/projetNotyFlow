package com.notyflow.consumer_stock;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stocks")
public class Stock {

    @Id
    private String produit;

    private int quantiteDisponible;

    // Constructeur par défaut (obligatoire pour JPA)
    public Stock() {
    }

    public Stock(String produit, int quantiteDisponible) {
        this.produit = produit;
        this.quantiteDisponible = quantiteDisponible;
    }

    // Getters et Setters
    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public int getQuantiteDisponible() {
        return quantiteDisponible;
    }

    public void setQuantiteDisponible(int quantiteDisponible) {
        this.quantiteDisponible = quantiteDisponible;
    }
}