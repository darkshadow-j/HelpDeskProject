package pl.plenczewski.backjwttest.models.stats;

import javax.persistence.*;
import java.util.List;

@Entity
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameStatistic;

    @OneToMany(cascade = CascadeType.ALL)
    List<SubCategoryWithColor> subCategoryWithColor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameStatistic() {
        return nameStatistic;
    }

    public void setNameStatistic(String nameStatistic) {
        this.nameStatistic = nameStatistic;
    }

    public List<SubCategoryWithColor> getSubCategoryWithColor() {
        return subCategoryWithColor;
    }

    public void setSubCategoryWithColor(List<SubCategoryWithColor> subCategoryWithColor) {
        this.subCategoryWithColor = subCategoryWithColor;
    }
}
