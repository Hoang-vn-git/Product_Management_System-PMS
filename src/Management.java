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
            System.out.println("+----------------------------------------+");
            System.out.println(i.toString());

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
        for (Product i : products) {
            if (productName.equalsIgnoreCase(i.getProductName())) {
                System.out.println("+-------------------------------+");
                System.out.println(i.toString());
                System.out.println("+-------------------------------+");
            }
        }
    }


    public void sellProduct() {
        ArrayList<Product> sellProducts = new ArrayList<>();
        double subtotal = 0;
        int sellQuantity;
        int avalQuantity;
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        do {
            for (Product i : products) {
                if (productName.equalsIgnoreCase(i.getProductName())) {
                    System.out.print("Enter quantity: ");
                    sellQuantity = scanner.nextInt();
                    scanner.nextLine();
                    avalQuantity = i.getQuantity();
                    i.setQuantity(sellQuantity);
                    subtotal += sellQuantity * i.getSellPrice();
                    Product product = new Product(i.getProductName(), i.getImportPrice(),i.getSellPrice() , i.getQuantity());
                    sellProducts.add(product);
                    i.setQuantity(avalQuantity - sellQuantity);
                    System.out.print("Enter product name or press Y to checkout: ");
                    productName = scanner.nextLine();
                }
            }
        } while (!productName.equalsIgnoreCase("Y"));


        System.out.println("Subtotal: " + subtotal);
        System.out.println("Tax: " + subtotal * TAX_RATE);
        System.out.println("Total: " + (subtotal + subtotal * TAX_RATE));


        System.out.print("Print a recipt?[Y/N]");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("Y")) {
            System.out.println("========== RECEIPT ==========");
            for(Product i : sellProducts) {
                System.out.printf("%-15s x%-2d %6.2f\n",
                        i.getProductName(), i.getQuantity(),i.getSellPrice());
            }
            System.out.println("-----------------------------");
            System.out.printf("Subtotal:%18.2f\n", subtotal);
            System.out.printf("Tax (%.0f%%):%16.2f\n", TAX_RATE * 100, subtotal * TAX_RATE);
            System.out.printf("Total:%21.2f\n", (subtotal + subtotal * TAX_RATE));
            System.out.println("=============================");

        } else {
            System.out.println("Exit...");
        }
    }


    public void calcRevenue() {

    }

    public void calcProfit() {

    }

    public void calcCost() {

    }

}
