import java.util.ArrayList;
import java.util.Scanner;

public class Management {
    private double totalRevenue;
    private double totalProfit;
    private double totalCost;
    private final double TAX_RATE = 0.13;


    ArrayList<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void display() {
        for (Product i : products) {
            System.out.println("+-------------------------------+");
            System.out.println(i.toString());
            System.out.println("+-------------------------------+");

        }
    }

    public void editProduct() {
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        String option;
        for (Product i : products) {
            if (productName.equalsIgnoreCase(i.getProductName())) {
                do {
                    System.out.println("+--------------------------------+");
                    System.out.println("|           Edit menu            |");
                    System.out.println("| 1: Name of the product         |");
                    System.out.println("| 2: Import price of the product |");
                    System.out.println("| 3: Sell price of the product   |");
                    System.out.println("| 4: Quantity of the product     |");
                    System.out.println("| 5. Exit                        |");
                    System.out.println("+--------------------------------+");
                    option = scanner.nextLine();

                    switch (option) {
                        case "1":
                            System.out.print("Edit product name: ");
                            String newName = scanner.nextLine();
                            i.setProductName(newName);
                            break;
                        case "2":
                            System.out.print("Edit product import price: ");
                            double newImportPrice = scanner.nextDouble();
                            scanner.nextLine();
                            i.setImportPrice(newImportPrice);
                            break;
                        case "3":
                            System.out.print("Edit product sell price: ");
                            double newSellPrice = scanner.nextDouble();
                            scanner.nextLine();
                            i.setSellPrice(newSellPrice);
                            break;
                        case "4":
                            System.out.print("Edit product quantity: ");
                            int newQuantity = scanner.nextInt();
                            scanner.nextLine();
                            i.setQuantity(newQuantity);
                            break;
                        case "5":
                            System.out.print("Exit...");
                            break;
                        default:
                            System.out.println("Invalid option");

                    }
                } while (!option.equals("5"));
            } else {
                System.out.println("Invalid product name.");
            }

        }

    }

    public void addProduct() {

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
    public void removeProduct() {
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        for (int i = 0; i < products.size(); i++) {
            if (productName.equalsIgnoreCase(products.get(i).getProductName())) {
                products.remove(i);
            } else {
                System.out.println("Invalid product name.");
                break;
            }
        }
    }
    public void checkProduct() {
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        for(Product i : products) {
            if (productName.equalsIgnoreCase(i.getProductName())) {
                System.out.println("+-------------------------------+");
                System.out.println(i.toString());
                System.out.println("+-------------------------------+");
            }
        }
    }




    public void sellProduct() {
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        for(Product i : products){
            if(productName.equalsIgnoreCase(i.getProductName())) {
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                i.setQuantity(i.getQuantity() - quantity);
                double subtotal = quantity * i.getSellPrice();
                System.out.println("Subtotal: " + subtotal );
                System.out.println("Tax: " + subtotal * TAX_RATE );
                System.out.println("Total: " + (subtotal + subtotal * TAX_RATE));
            }
        }
    }


    public void calcRevenue() {

    }

    public void calcProfit() {

    }

    public void calcCost() {

    }

}
