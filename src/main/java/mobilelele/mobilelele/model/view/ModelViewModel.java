package mobilelele.mobilelele.model.view;

import mobilelele.mobilelele.model.entity.enums.Category;

public class ModelViewModel {

    private Long id;
    private String name;
    private Category category;
    private int startYear;
    private int endYear;
    private String imageUrl;

    public Long getId() {
        return id;
    }

    public ModelViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ModelViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public ModelViewModel setCategory(Category category) {
        this.category = category;
        return this;
    }

    public int getStartYear() {
        return startYear;
    }

    public ModelViewModel setStartYear(int startYear) {
        this.startYear = startYear;
        return this;
    }

    public int getEndYear() {
        return endYear;
    }

    public ModelViewModel setEndYear(int endYear) {
        this.endYear = endYear;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
