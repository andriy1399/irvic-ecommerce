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

    @Column
    private String name;
    @Column
    private String type;
    @Column
    private byte[] data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "products_id", nullable = false)
    private Products products;


    public Images() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
