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
                            System.out.println("+--------------------------------+");
                            System.out.println("|          Exiting...            |");
                            System.out.println("+--------------------------------+");
                            break;
                        default:
                            System.out.println("Invalid option");

                    }
                } while (!option.equals("5"));
            } else {
                System.out.println("+--------------------------------+");
                System.out.println("|      Invalid product name      |");
                System.out.println("+--------------------------------+");
            }

        }

    }

    public void addProduct() {
        String productName;
        double importPrice;
        double sellPrice;
        int quantity;

        System.out.print("Enter product name: ");
        productName = scanner.nextLine();


        do {
            System.out.print("Enter product import price: ");
            do {
                try {
                    importPrice = scanner.nextDouble();
                    scanner.nextLine();
                    if (importPrice < 0) {
                        System.out.println("+--------------------------------+");
                        System.out.println("|         Invalid input          |");
                        System.out.println("+--------------------------------+");
                        System.out.print("Enter product import price: ");
                        continue;
                    }
                    break;
                } catch (Exception E) {
                    System.out.println("+--------------------------------+");
                    System.out.println("|         Invalid input          |");
                    System.out.println("+--------------------------------+");
                    scanner.nextLine();
                }
                System.out.print("Enter product import price: ");
            } while (true);

            System.out.print("Enter product sell price: ");
            do {
                try {
                    sellPrice = scanner.nextDouble();
                    scanner.nextLine();
                    if (sellPrice < 0) {
                        System.out.println("+--------------------------------+");
                        System.out.println("|         Invalid input          |");
                        System.out.println("+--------------------------------+");
                        System.out.print("Enter product sell price: ");
                        continue;
                    }
                    break;
                } catch (Exception E) {
                    System.out.println("+--------------------------------+");
                    System.out.println("|         Invalid input          |");
                    System.out.println("+--------------------------------+");
                    scanner.nextLine();
                }
                System.out.print("Enter product sell price: ");
            } while (true);

            System.out.print("Enter quantity: ");
            do {
                try {
                    quantity = scanner.nextInt();
                    scanner.nextLine();
                    if (quantity < 0) {
                        System.out.println("+--------------------------------+");
                        System.out.println("|         Invalid input          |");
                        System.out.println("+--------------------------------+");
                        System.out.print("Enter quantity: ");
                        continue;
                    }
                    break;
                } catch (Exception E) {
                    System.out.println("+--------------------------------+");
                    System.out.println("|         Invalid input          |");
                    System.out.println("+--------------------------------+");
                    scanner.nextLine();
                }
                System.out.print("Enter quantity: ");
            } while (true);

            Product product = new Product(productName, importPrice, sellPrice, quantity);
            products.add(product);
            System.out.print("Enter product name to continue or press Y to exit: ");
            productName = scanner.nextLine();
        } while (!productName.equalsIgnoreCase("Y"));


    }

    public void removeProduct() {
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        do {
            for (int i = 0; i < products.size(); i++) {
                if (productName.equalsIgnoreCase(products.get(i).getProductName())) {
                    products.remove(i);
                    System.out.print("Enter product name to continue or press N to exit.");
                    productName = scanner.nextLine();
                } else {
                    System.out.println("+--------------------------------+");
                    System.out.println("|      Invalid product name      |");
                    System.out.println("+--------------------------------+");
                    break;
                }
            }
        } while (!productName.equalsIgnoreCase("N"));
        System.out.println("+--------------------------------+");
        System.out.println("|          Exiting...            |");
        System.out.println("+--------------------------------+");

    }

    public void checkProduct() {
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        do {
            for (Product i : products) {
                if (productName.equalsIgnoreCase(i.getProductName())) {
                    System.out.println("+-------------------------------+");
                    System.out.println(i);
                    System.out.println("+-------------------------------+");
                    System.out.println("Enter product name to continue or press N to exit.");
                    productName = scanner.nextLine();
                } else {
                    System.out.println("+--------------------------------+");
                    System.out.println("|      Invalid product name      |");
                    System.out.println("+--------------------------------+");
                }
            }
        } while (productName.equalsIgnoreCase("N"));
        System.out.println("+--------------------------------+");
        System.out.println("|          Exiting...            |");
        System.out.println("+--------------------------------+");
    }


    public void sellProduct() {
        ArrayList<Product> sellProducts = new ArrayList<>();
        double subtotal = 0;
        int sellQuantity;
        Product isFounded = null;
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        do {
                for (Product i : products) {
                    if (productName.equalsIgnoreCase(i.getProductName())) {
                        isFounded = i;
                        break;
                    }
                }
                    if (isFounded == null){
                        System.out.println("+--------------------------------+");
                        System.out.println("|       Product not found        |");
                        System.out.println("+--------------------------------+");
                        System.out.print("Enter again: ");
                        productName = scanner.nextLine();
                        continue;
                    }



            try {
                System.out.print("Enter quantity: ");
                sellQuantity = scanner.nextInt();
                scanner.nextLine();
                do {
                    if (sellQuantity > isFounded.getQuantity() || sellQuantity <= 0) {
                        System.out.printf("Enter quantity match with available quantity (x%d).\n", isFounded.getQuantity());
                        System.out.print("Enter quantity: ");
                        sellQuantity = scanner.nextInt();
                        scanner.nextLine();
                    }
                } while (!(sellQuantity <= isFounded.getQuantity() && sellQuantity > 0));
                subtotal += sellQuantity * isFounded.getSellPrice();
                Product product = new Product(isFounded.getProductName(), isFounded.getImportPrice(), isFounded.getSellPrice(), sellQuantity);
                sellProducts.add(product);
                isFounded.setQuantity(isFounded.getQuantity() - sellQuantity);

            } catch (Exception E) {
                System.out.println("+--------------------------------+");
                System.out.println("|         Invalid input          |");
                System.out.println("+--------------------------------+");
                scanner.nextLine();
                continue;
            }

            System.out.print("Enter product name to continue or press Y to checkout: ");
            productName = scanner.nextLine();
            isFounded = null;

        } while (!productName.equalsIgnoreCase("Y"));
        System.out.println("+--------------------------------+");
        System.out.println("|          Checking out...       |");
        System.out.println("+--------------------------------+");
        System.out.println("=============================");
        System.out.printf("Subtotal: %.2f\n", subtotal);
        System.out.printf("Tax: %.2f\n", subtotal * TAX_RATE);
        System.out.printf("Total: %.2f\n", (subtotal + subtotal * TAX_RATE));
        System.out.println("=============================");


        System.out.print("Print a receipt?[Y/N]");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("Y")) {
            System.out.println("+--------------------------------+");
            System.out.println("|          Printing...           |");
            System.out.println("+--------------------------------+");
            System.out.println("========== RECEIPT ==========");
            for (Product i : sellProducts) {
                System.out.printf("%-15s x%-2d %6.2f\n", i.getProductName(), i.getQuantity(), i.getSellPrice());
            }
            System.out.println("-----------------------------");
            System.out.printf("Subtotal:%18.2f\n", subtotal);
            System.out.printf("Tax (%.0f%%):%17.2f\n", TAX_RATE * 100, subtotal * TAX_RATE);
            System.out.printf("Total:%21.2f\n", (subtotal + subtotal * TAX_RATE));
            System.out.println("======= END OF RECEIPT ======");

        } else {
            System.out.println("+--------------------------------+");
            System.out.println("|          Exiting...            |");
            System.out.println("+--------------------------------+");
        }
    }


    public void calcRevenue() {

    }

    public void calcProfit() {

    }

    public void calcCost() {

    }

}
