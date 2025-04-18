import java.util.ArrayList;
import java.util.Scanner;

public class Management {
    private double totalRevenue;
    private double totalProfit;
    private double totalCost;
    private String productName;
    private double importPrice;
    private double sellPrice;
    private int quantity;
    private final double TAX_RATE;

    {
        TAX_RATE = 0.13;
    }


    ArrayList<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void display() {
        if (products.isEmpty()) {
            System.out.println("+--------------------------------+");
            System.out.println("|            Empty               |");
            System.out.println("+--------------------------------+");
        } else {
            for (Product i : products) {
                System.out.println("+----------------------------------------+");
                System.out.println(i.toString());
            }
        }
    }

    public void editProduct() {
        String option;
        Product isFound = null;
        do {
            System.out.print("Enter product name: ");
            productName = scanner.nextLine();

            for (Product i : products) {
                if (productName.equalsIgnoreCase(i.getProductName())) {
                    isFound = i;
                    do {
                        System.out.println("+--------------------------------+");
                        System.out.println("|           Edit menu            |");
                        System.out.println("| 1: Name of the product         |");
                        System.out.println("| 2: Import price of the product |");
                        System.out.println("| 3: Sell price of the product   |");
                        System.out.println("| 4: Quantity of the product     |");
                        System.out.println("| 5. Save                        |");
                        System.out.println("+--------------------------------+");
                        System.out.print("| Enter option: ");
                        option = scanner.nextLine();

                        switch (option) {
                            case "1":
                                boolean isExist;
                                do {
                                    isExist = false;
                                    System.out.print("Edit product name: ");
                                    productName = scanner.nextLine();
                                    for (Product p : products) {
                                        if (productName.equalsIgnoreCase(p.getProductName())) {
                                            System.out.println("Product name already exists");
                                            isExist = true;
                                            break;
                                        }
                                    }

                                } while (isExist);
                                i.setProductName(productName);
                                break;
                            case "2":
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
                                i.setImportPrice(importPrice);
                                break;
                            case "3":
                                System.out.print("Edit product sell price: ");
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
                                i.setSellPrice(sellPrice);
                                break;
                            case "4":
                                System.out.print("Enter product quantity: ");
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
                                i.setQuantity(quantity);
                                break;
                            case "5":

                                break;
                            default:
                                System.out.println("+--------------------------------+");
                                System.out.println("|          Invalid input         |");
                                System.out.println("+--------------------------------+");

                        }
                    } while (!option.equals("5"));
                    break;
                }

            }
            if (isFound == null) {
                System.out.println("+--------------------------------+");
                System.out.println("|       Product not found        |");
                System.out.println("+--------------------------------+");
            }
            isFound = null;
            System.out.print("Press Y to continue or N to exit: ");
            option = scanner.nextLine();
        } while (!option.equalsIgnoreCase("N"));
        System.out.println("+--------------------------------+");
        System.out.println("|          Exiting...            |");
        System.out.println("+--------------------------------+");


    }

    public void addProduct() {
        boolean isExist;
        do {

            isExist = false;
            System.out.print("Enter product name: ");
            productName = scanner.nextLine();
            if (productName.trim().isEmpty()) {
                System.out.println("Invalid product name");
                continue;
            }
            for (Product i : products) {
                if (productName.equalsIgnoreCase(i.getProductName())) {
                    System.out.println("+--------------------------------+");
                    System.out.println("|      Product already exists    |");
                    System.out.println("+--------------------------------+");
                    isExist = true;
                    break;
                }

            }// condition check exist product


            if (!isExist) {
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
                        } // condition check valid input
                        break;
                    } catch (Exception E) {
                        System.out.println("+--------------------------------+");
                        System.out.println("|         Invalid input          |");
                        System.out.println("+--------------------------------+");
                        scanner.nextLine();
                    }
                    System.out.print("Enter product import price: ");
                } while (true);  // condition check valid input

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
                        }  // condition check valid input
                        break;
                    } catch (Exception E) {
                        System.out.println("+--------------------------------+");
                        System.out.println("|         Invalid input          |");
                        System.out.println("+--------------------------------+");
                        scanner.nextLine();
                    }
                    System.out.print("Enter product sell price: ");
                } while (true);  // condition check valid input

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
                        }  // condition check valid input
                        break;
                    } catch (Exception E) {
                        System.out.println("+--------------------------------+");
                        System.out.println("|         Invalid input          |");
                        System.out.println("+--------------------------------+");
                        scanner.nextLine();
                    }
                    System.out.print("Enter quantity: ");
                } while (true);  // condition check valid input

                Product product = new Product(productName.trim(), importPrice, sellPrice, quantity);
                products.add(product);
            }
            System.out.print("Press Y to continue or N to exit: ");
            productName = scanner.nextLine();
        } while (!productName.equalsIgnoreCase("N"));

    }


    public void checkoutProduct() {
        ArrayList<Product> sellProducts = new ArrayList<>(); // New array for selling product
        double subtotal = 0;
        int sellQuantity;
        Product isFounded = null;
        boolean isSoldOut = false;
        String productName;
        String option;
        do {
            System.out.print("Enter product name: ");
            productName = scanner.nextLine();
            if (productName.trim().isEmpty()) {
                System.out.println("Invalid product name");
                continue;
            }
            for (Product i : products) {
                if (productName.equalsIgnoreCase(i.getProductName())) {
                    isFounded = i;
                    if (isFounded.getQuantity() == 0) { // In case product sold out
                        isSoldOut = true;
                        System.out.println("+--------------------------------+");
                        System.out.println("|           Sold out             |");
                        System.out.println("+--------------------------------+");
                    }
                    break;
                }
            }
            if (isFounded == null) { // In case product not found
                System.out.println("+--------------------------------+");
                System.out.println("|       Product not found        |");
                System.out.println("+--------------------------------+");
                System.out.print("Press Y to continue or N to exit: ");
                option = scanner.nextLine();
                if (option.equalsIgnoreCase("Y")) {
                    continue;
                } else {
                    return;
                }
            }


            if (!isSoldOut) { // In case product not sold out
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
                    } while (!(sellQuantity <= isFounded.getQuantity() && sellQuantity > 0)); // condition check valid input
                    // calc subtotal
                    subtotal += sellQuantity * isFounded.getSellPrice();
                    // create a new object
                    Product product = new Product(isFounded.getProductName(), isFounded.getImportPrice(), isFounded.getSellPrice(), sellQuantity);
                    sellProducts.add(product);
                    // set a new quantity
                    isFounded.setQuantity(isFounded.getQuantity() - sellQuantity);

                } catch (Exception E) {
                    System.out.println("+--------------------------------+");
                    System.out.println("|         Invalid input          |");
                    System.out.println("+--------------------------------+");
                    scanner.nextLine();
                    continue;
                }
            }

            System.out.print("Press Y to continue or N to exit: ");
            productName = scanner.nextLine();
            isFounded = null;
            isSoldOut = false;

        } while (!productName.equalsIgnoreCase("N"));

        System.out.println("+--------------------------------+");
        System.out.println("|          Checking out...       |");
        System.out.println("+--------------------------------+");
        System.out.println("=============================");
        System.out.printf("Subtotal: %.2f\n", subtotal);
        System.out.printf("Tax (%.0f%%): %.2f\n", TAX_RATE * 100, subtotal * TAX_RATE);
        System.out.printf("Total: %.2f\n", (subtotal + subtotal * TAX_RATE));
        System.out.println("=============================");


        System.out.print("Print a receipt?[Y/N]");
        option = scanner.nextLine();
        if (option.equalsIgnoreCase("Y")) {
            System.out.println("+--------------------------------+");
            System.out.println("|          Printing...           |");
            System.out.println("+--------------------------------+");
            System.out.println("============ RECEIPT ============");
            for (Product i : sellProducts) {
                System.out.printf("%-15s x%-2d %6.2f %6.2f\n", i.getProductName(), i.getQuantity(), i.getSellPrice(), i.getSellPrice() * i.getQuantity());
            }
            System.out.println("---------------------------------");
            System.out.printf("Subtotal:%24.2f\n", subtotal);
            System.out.printf("Tax (%.0f%%):%23.2f\n", TAX_RATE * 100, subtotal * TAX_RATE);
            System.out.printf("Total:%27.2f\n", (subtotal + subtotal * TAX_RATE));
            System.out.println("========= END OF RECEIPT ========");

        } else {
            System.out.println("+--------------------------------+");
            System.out.println("|          Exiting...            |");
            System.out.println("+--------------------------------+");
        }
    }

    public void removeProduct() {
        Product isFound = null;
        String option = "";
        do {

            System.out.print("Enter product name: ");
            productName = scanner.nextLine();
            if (productName.trim().isEmpty()) {
                System.out.println("Invalid product name");
                continue;
            }
            for (Product i : products) {
                if (productName.equalsIgnoreCase(i.getProductName())) {
                    isFound = i;
                    System.out.println("Removed product: " + isFound.getProductName());
                    products.remove(isFound);
                    break;
                }
            }
            if (isFound == null) {
                System.out.println("+--------------------------------+");
                System.out.println("|       Product not found        |");
                System.out.println("+--------------------------------+");
            }
            isFound = null;
            System.out.print("Press Y to continue or N to exit: ");
            option = scanner.nextLine();
        } while (!option.equalsIgnoreCase("N"));
        System.out.println("+--------------------------------+");
        System.out.println("|          Exiting...            |");
        System.out.println("+--------------------------------+");

    }

    public void checkProduct() {
        String option = "";
        Product isFound = null;
        do {
            System.out.print("Enter product name: ");
            productName = scanner.nextLine();
            if (productName.trim().isEmpty()) {
                System.out.println("Invalid product name");
                continue;
            }
            for (Product i : products) {
                if (productName.equalsIgnoreCase(i.getProductName())) {
                    isFound = i;
                    System.out.println("+----------------------------------------+");
                    System.out.println(i.toString());
                }
            }
            if (isFound == null) {
                System.out.println("+--------------------------------+");
                System.out.println("|       Product not found        |");
                System.out.println("+--------------------------------+");
            }
            isFound = null;
            System.out.print("Press Y to continue or N to exit: ");
            option = scanner.nextLine();
        } while (!option.equalsIgnoreCase("N"));
        System.out.println("+--------------------------------+");
        System.out.println("|          Exiting...            |");
        System.out.println("+--------------------------------+");
    }

    public void calcRevenue() {

    }

    public void calcProfit() {

    }

    public void calcCost() {

    }

}
