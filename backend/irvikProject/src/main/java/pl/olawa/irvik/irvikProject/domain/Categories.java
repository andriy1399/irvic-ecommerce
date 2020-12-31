package pl.olawa.irvik.irvikProject.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class Categories {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO,generator = "pg-uuid")
    @GenericGenerator(name = "pg-uuid",strategy = "uuid2")
    private UUID id;
    @Column
    private String categoryEn;
    @Column
    private String categoryUk;
    @Column
    private String categoryPl;

    public Categories() {
    }

    public Categories(String categoryEn, String categoryUk, String categoryPl) {
        this.categoryEn = categoryEn;
        this.categoryUk = categoryUk;
        this.categoryPl = categoryPl;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getCategoryEn() {
        return categoryEn;
    }

    public void setCategoryEn(String categoryEn) {
        this.categoryEn = categoryEn;
    }

    public String getCategoryUk() {
        return categoryUk;
    }

    public void setCategoryUk(String categoryUk) {
        this.categoryUk = categoryUk;
    }

    public String getCategoryPl() {
        return categoryPl;
    }

    public void setCategoryPl(String categoryPl) {
        this.categoryPl = categoryPl;
    }
}
