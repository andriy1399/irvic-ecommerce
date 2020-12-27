package pl.olawa.irvik.irvikProject.dto;

import java.util.List;

public class ProductsDto {

    private String title;
    private String description;
    private String material;
    private  String category;
    private int discount;
    private int totalPrice;
    private boolean isAvailable;
    private List<String> url_images;
    private int width;
    private int length;
    private  int height;

    public String getTitle() {
        return title;
    }

    public List<String> getUrlImages() {
        return url_images;
    }

    public void setUrlImages(List<String> urlImages) {
        this.url_images = urlImages;
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
