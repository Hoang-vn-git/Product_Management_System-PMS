import java.util.ArrayList;
import java.util.Scanner;
public class Management {
    private double totalRevenue;
    private double totalProfit;
    private double totalCost;


    ArrayList<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void display(){
        for (Product i:products){
            System.out.println("+-------------------------------+");
            System.out.println("|                               |");
            System.out.println("|   " + i.toString());
            System.out.println("|                               |");
            System.out.println("+-------------------------------+");

        }
    }
    public void editProduct(){
        for (Product i:products){
            System.out.println(i.getProductName());

        }

    }
    public void addProduct(){

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product import price: ");
        double importPrice = scanner.nextDouble();

        System.out.print("Enter product sell price: ");
        double sellPrice = scanner.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Product product = new Product(name, importPrice, sellPrice, quantity);
        products.add(product);


    }
    public void sellProduct(){

    }


    public void calcRevenue(){

    }

    public void calcProfit(){

    }
    public void calcCost(){

    }

}
