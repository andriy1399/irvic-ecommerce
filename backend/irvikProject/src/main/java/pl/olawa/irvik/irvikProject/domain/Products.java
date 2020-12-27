package pl.olawa.irvik.irvikProject.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private int price;
    @Column
    private String material;
    @Column
    private  String category;
    @Column
    private int discount;
    @Column
    private int totalPrice;
    @Column
    private boolean isAvailable;

    @ElementCollection
//    @CollectionTable(name = "products_url_images",joinColumns = @JoinColumn(name = "products_id"))
//    @Column(name = "url_images")
    private List<String>url_images;

    @Column
    private int width;
    @Column
    private int length;
    @Column
    private  int height;


    public Products(String title, String description, int price, String material, String category, int discount, int totalPrice, boolean isAvailable, List<String> url_images, int width, int length, int height) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.material = material;
        this.category = category;
        this.discount = discount;
        this.totalPrice = totalPrice;
        this.isAvailable = isAvailable;
        this.url_images = url_images;
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public List<String> getUrl_images() {
        return url_images;
    }

    public void setUrl_images(List<String> url_images) {
        this.url_images = url_images;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
