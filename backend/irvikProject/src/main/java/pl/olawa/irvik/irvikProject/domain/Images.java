package pl.olawa.irvik.irvikProject.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "images")
public class Images {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO,generator = "pg-uuid")
    @GenericGenerator(name = "pg-uuid",strategy = "uuid2")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "products_id", nullable = false)
    private Products products;


    public Images() {
    }
    public Images( Products products) {
        this.products = products;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
