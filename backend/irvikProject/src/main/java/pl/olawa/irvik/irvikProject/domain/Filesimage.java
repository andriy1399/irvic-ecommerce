package pl.olawa.irvik.irvikProject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "filesimage")
public class String {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;
    @JsonProperty("Bucket")
    @Column
    private java.lang.String imageBucket;
    @JsonProperty("Key")
    @Column
    private java.lang.String imageKey;
    @JsonProperty("Location")
    @Column
    private java.lang.String imageLocation;

    @JsonProperty("key")
    @Column
    private java.lang.String imageKeyTwo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "products_id")
    @JsonIgnore
    private Products products;

    public String(java.lang.String imageBucket, java.lang.String imageKey, java.lang.String imageLocation, java.lang.String imageKeyTwo, Products products) {
        this.imageBucket = imageBucket;
        this.imageKey = imageKey;
        this.imageLocation = imageLocation;
        this.imageKeyTwo = imageKeyTwo;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public java.lang.String getImageBucket() {
        return imageBucket;
    }

    public void setImageBucket(java.lang.String imageBucket) {
        this.imageBucket = imageBucket;
    }

    public java.lang.String getImageKey() {
        return imageKey;
    }

    public void setImageKey(java.lang.String imageKey) {
        this.imageKey = imageKey;
    }

    public java.lang.String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(java.lang.String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public java.lang.String getImageKeyTwo() {
        return imageKeyTwo;
    }

    public void setImageKeyTwo(java.lang.String imageKeyTwo) {
        this.imageKeyTwo = imageKeyTwo;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
