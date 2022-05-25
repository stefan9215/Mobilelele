package mobilelele.mobilelele.model.entity;

import mobilelele.mobilelele.model.entity.enums.Category;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class Model extends BaseEntity{

    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;
    @Column(nullable = false,name = "image_url")
    private String imageUrl;
    @Column(name = "start_year")
    private int startYear;
    @Column(name = "end_year")
    private int endYear;
    @ManyToOne
    private Brand brand;

    public String getName() {
        return name;
    }

    public Model setName(String name) {
        this.name = name;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Model setCategory(Category category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Model setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getStartYear() {
        return startYear;
    }

    public Model setStartYear(int startYear) {
        this.startYear = startYear;
        return this;
    }

    public int getEndYear() {
        return endYear;
    }

    public Model setEndYear(int endYear) {
        this.endYear = endYear;
        return this;
    }

    public Brand getBrand() {
        return brand;
    }

    public Model setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }
}
