package pl.olawa.irvik.irvikProject.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table
public class Products {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO,generator = "pg-uuid")
    @GenericGenerator(name = "pg-uuid",strategy = "uuid2")
    private UUID uu_id;
    @Column
    private String titleEn;
    @Column
    private String titlePl;
    @Column
    private String titleUk;
    @Column
    private String descriptionEn;
    @Column
    private String descriptionPl;
    @Column
    private String descriptionUk;

    @Column
    private int price;
    @Column
    private String materialUk;
    @Column
    private String materialPl;
    @Column
    private String materialEn;
    @Column
    private  String category;
    @Column
    private int discount;
    @Column
    private int totalPrice;
    @Column
    private boolean isAvailable;

    @ElementCollection
    private List<String>images;
    @Column
    private Date dateOfEdition;
    @Column
    private int width;
    @Column
    private int length;
    @Column
    private  int height;

    public Products() {
    }

    public Products(String titleEn, String titlePl, String titleUk, String descriptionEn, String descriptionPl, String descriptionUk, int price, String materialUk, String materialPl, String materialEn, String category, int discount, int totalPrice, boolean isAvailable, List<String> images, Date dateOfEdition, int width, int length, int height) {
        this.titleEn = titleEn;
        this.titlePl = titlePl;
        this.titleUk = titleUk;
        this.descriptionEn = descriptionEn;
        this.descriptionPl = descriptionPl;
        this.descriptionUk = descriptionUk;
        this.price = price;
        this.materialUk = materialUk;
        this.materialPl = materialPl;
        this.materialEn = materialEn;
        this.category = category;
        this.discount = discount;
        this.totalPrice = totalPrice;
        this.isAvailable = isAvailable;
        this.images = images;
        this.dateOfEdition = dateOfEdition;
        this.width = width;
        this.length = length;
        this.height = height;
    }


    public UUID getUu_id() {
        return uu_id;
    }

    public void setUu_id(UUID uu_id) {
        this.uu_id = uu_id;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Date getDateOfEdition() {
        return dateOfEdition;
    }

    public void setDateOfEdition(Date dateOfEdition) {
        this.dateOfEdition = dateOfEdition;
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
