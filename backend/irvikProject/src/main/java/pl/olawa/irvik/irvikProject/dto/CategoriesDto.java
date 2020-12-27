package pl.olawa.irvik.irvikProject.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.Column;

public class CategoriesDto {

    private String nameUA;

    private String nameEU;

    private String namePL;

    public String getNameUA() {
        return nameUA;
    }

    public void setNameUA(String nameUA) {
        this.nameUA = nameUA;
    }

    public String getNameEU() {
        return nameEU;
    }

    public void setNameEU(String nameEU) {
        this.nameEU = nameEU;
    }

    public String getNamePL() {
        return namePL;
    }

    public void setNamePL(String namePL) {
        this.namePL = namePL;
    }
}
