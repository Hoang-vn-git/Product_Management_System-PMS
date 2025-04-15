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
        boolean isExist = false;

        do {
            System.out.print("Enter product name: ");
            productName = scanner.nextLine();
            isExist = false;
            for (Product i : products) {
                if (productName.equalsIgnoreCase(i.getProductName())) {
                    System.out.println("+--------------------------------+");
                    System.out.println("|      Product already exists    |");
                    System.out.println("+--------------------------------+");
                    isExist = true;
                    break;
                }

            }
        } while (isExist);


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


    public void checkoutProduct() {
        ArrayList<Product> sellProducts = new ArrayList<>();
        double subtotal = 0;
        int sellQuantity;
        Product isFounded = null;
        boolean isSoldOut = false;
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        do {
            for (Product i : products) {
                if (productName.equalsIgnoreCase(i.getProductName())) {
                    isFounded = i;
                    if (isFounded.getQuantity() == 0) {
                        isSoldOut = true;
                        System.out.println("+--------------------------------+");
                        System.out.println("|           Sold out             |");
                        System.out.println("+--------------------------------+");
                    }
                    break;
                }
            }
            if (isFounded == null) {
                System.out.println("+--------------------------------+");
                System.out.println("|       Product not found        |");
                System.out.println("+--------------------------------+");
                System.out.print("Enter again: ");
                productName = scanner.nextLine();
                continue;
            }


            if (!isSoldOut) {
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
            }

            System.out.print("Enter product name to continue or press Y to checkout: ");
            productName = scanner.nextLine();
            isFounded = null;
            isSoldOut = false;

        } while (!productName.equalsIgnoreCase("Y"));
        System.out.println("+--------------------------------+");
        System.out.println("|          Checking out...       |");
        System.out.println("+--------------------------------+");
        System.out.println("=============================");
        System.out.printf("Subtotal: %.2f\n", subtotal);
        System.out.printf("Tax (%.0f%%): %.2f\n", TAX_RATE * 100, subtotal * TAX_RATE);
        System.out.printf("Total: %.2f\n", (subtotal + subtotal * TAX_RATE));
        System.out.println("=============================");


        System.out.print("Print a receipt?[Y/N]");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("Y")) {
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


    public void calcRevenue() {

    }

    public void calcProfit() {

    }

    public void calcCost() {

    }

}
