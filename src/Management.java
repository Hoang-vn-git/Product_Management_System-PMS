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
            System.out.println("    " + i.toString());
            System.out.println("|                               |");
            System.out.println("+-------------------------------+");

        }
    }
    public void editProduct(){
            System.out.print("Enter product name: ");
            String productName = scanner.nextLine();
        for (Product i:products){
            if(productName.equalsIgnoreCase(i.getProductName())){
                System.out.print("Edit product name: ");
                String newName = scanner.nextLine();

                System.out.print("Edit product import price: ");
                double newImportPrice = scanner.nextDouble();

                System.out.print("Edit product sell price: ");
                double newSellPrice = scanner.nextDouble();

                System.out.print("Edit quantity: ");
                int newQuantity = scanner.nextInt();
                scanner.nextLine();

                i.setProductName(newName);
                i.setImportPrice(newImportPrice);
                i.setSellPrice(newSellPrice);
                i.setQuantity(newQuantity);
            } else {
                System.out.println("Invalid product name.");
            }

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
