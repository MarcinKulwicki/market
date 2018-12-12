package pl.marcinkulwicki.promotionmarket.Objects;

public class Product {

    private String id;
    private String name;
    private String priceBefore;
    private String priceAfter;
    private String isAvailable;

    public Product(){
    }

    public Product(String id, String name, String priceBefore, String priceAfter, String isAvailable) {
        this.id = id;
        this.name = name;
        this.priceBefore = priceBefore;
        this.priceAfter = priceAfter;
        this.isAvailable = isAvailable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriceBefore() {
        return priceBefore;
    }

    public void setPriceBefore(String priceBefore) {
        this.priceBefore = priceBefore;
    }

    public String getPriceAfter() {
        return priceAfter;
    }

    public void setPriceAfter(String priceAfter) {
        this.priceAfter = priceAfter;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
