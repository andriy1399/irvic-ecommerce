package pl.olawa.irvik.irvikProject.domain;

import javax.persistence.*;

@Entity
@Table
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
