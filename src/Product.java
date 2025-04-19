public class Product {
    private String id;
    private String productName;
    private double importPrice;
    private double sellPrice;
    private int quantity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product(String id, String productName, double importPrice, double sellPrice, int quantity) {
        this.id = id;
        this.productName = productName;
        this.importPrice = importPrice;
        this.sellPrice = sellPrice;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format(
                """
                        | Product name: %-24s |
                        | Import price: %-24.2f |
                        | Price:        %-24.2f |
                        | Quantity:     %-24d |""",
                getProductName(), getImportPrice(), getSellPrice(), getQuantity()
        );
    }
}