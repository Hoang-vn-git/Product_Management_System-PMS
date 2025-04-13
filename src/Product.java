public class Product {
    private String productName;
    private double importPrice;
    private double sellPrice;
    private int quantity;

    public Product(String productName, double importPrice, double sellPrice, int quantity) {
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
        return "| Product name: " + getProductName() +"          |"+ " \n| Price: " + getSellPrice() + "                   |"+  " \n| Quantity: " + getQuantity() + "                  |" ;
    }
}