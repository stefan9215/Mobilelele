package mobilelele.mobilelele.model.service;

import java.math.BigDecimal;

public class OfferAddServiceModel {

    private String brand;
    private String model;
    private BigDecimal price;
    private String engine;
    private String transmission;
    private int year;
    private int mileage;
    private String description;
    private String imageUrl;

    public String getBrand() {
        return brand;
    }

    public OfferAddServiceModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferAddServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public OfferAddServiceModel setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public String getTransmission() {
        return transmission;
    }

    public OfferAddServiceModel setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferAddServiceModel setYear(int year) {
        this.year = year;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferAddServiceModel setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferAddServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferAddServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferAddServiceModel setModel(String model) {
        this.model = model;
        return this;
    }
}
