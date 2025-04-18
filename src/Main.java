import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Management management = new Management();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n\n======= MANAGEMENT SYSTEM ========");
            System.out.println("| 1: Add product                 |");
            System.out.println("| 2: Checkout                    |");
            System.out.println("| 3: Display                     |");
            System.out.println("| 4: Edit product                |");
            System.out.println("| 5: Remove product              |");
            System.out.println("| 6: Check product               |");
            System.out.println("| 7: Exit                        |");
            System.out.println("==================================");
            System.out.print("Enter option: ");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    management.addProduct();
                    break;
                case 2:
                    management.checkoutProduct();
                    break;
                case 3:
                    management.display();
                    break;
                case 4:
                    management.editProduct();
                    break;
                case 5:
                    management.removeProduct();
                    break;
                case 6:
                    management.checkProduct();
                    break;
                default:
                    System.out.println("======== Exiting =======");
            }


        } while (!(option == 7));


    }
}