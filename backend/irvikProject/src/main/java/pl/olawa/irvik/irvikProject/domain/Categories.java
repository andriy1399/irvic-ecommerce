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
    private String name;

    public Categories(String name) {
        this.name = name;
    }

    public Categories() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
