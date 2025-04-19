
import java.util.List;

public class Order {

    private String id ;
    private final double  TAX_RATE;
    private List<Product> items;

    public double getTAX_RATE() {
        return TAX_RATE;
    }

    public Order(String id,  List<Product> items , double TAX_RATE) {
        this.id = id;
        this.items = items;
        this. TAX_RATE =  TAX_RATE;
    }

}