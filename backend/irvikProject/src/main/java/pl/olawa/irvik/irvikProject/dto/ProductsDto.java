package pl.olawa.irvik.irvikProject.dto;

import pl.olawa.irvik.irvikProject.domain.Images;

import javax.persistence.Column;
import java.util.List;

public class ProductsDto {

    private String titleEn;
    private String titlePl;
    private String titleUk;
    private String descriptionEn;
    private String descriptionPl;
    private String descriptionUk;
    private String materialUk;
    private String materialPl;
    private String materialEn;
    private  String category;
    private int discount;
    private int totalPrice;
    private boolean isAvailable;
    private List<Images>images;
    private int width;
    private int length;
    private  int height;

    public ProductsDto() {
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getTitlePl() {
        return titlePl;
    }

    public void setTitlePl(String titlePl) {
        this.titlePl = titlePl;
    }

    public String getTitleUk() {
        return titleUk;
    }

    public void setTitleUk(String titleUk) {
        this.titleUk = titleUk;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public String getDescriptionPl() {
        return descriptionPl;
    }

    public void setDescriptionPl(String descriptionPl) {
        this.descriptionPl = descriptionPl;
    }

    public String getDescriptionUk() {
        return descriptionUk;
    }

    public void setDescriptionUk(String descriptionUk) {
        this.descriptionUk = descriptionUk;
    }

    public String getMaterialUk() {
        return materialUk;
    }

    public void setMaterialUk(String materialUk) {
        this.materialUk = materialUk;
    }

    public String getMaterialPl() {
        return materialPl;
    }

    public void setMaterialPl(String materialPl) {
        this.materialPl = materialPl;
    }

    public String getMaterialEn() {
        return materialEn;
    }

    public void setMaterialEn(String materialEn) {
        this.materialEn = materialEn;
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

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
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
