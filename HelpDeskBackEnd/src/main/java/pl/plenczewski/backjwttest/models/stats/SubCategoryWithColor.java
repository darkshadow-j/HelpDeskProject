package pl.plenczewski.backjwttest.models.stats;

import pl.plenczewski.backjwttest.models.ticket.Subcategory;
import javax.persistence.*;

@Entity
public class SubCategoryWithColor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Subcategory subCategoryList;

    private String color;

    private Integer value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Subcategory getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(Subcategory subCategoryList) {
        this.subCategoryList = subCategoryList;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
