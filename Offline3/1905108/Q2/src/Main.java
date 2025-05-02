import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Decorator
public class Main {
    public static void main(String[] args) {
        CoffeerTongCoffee c;
        List<CoffeerTongCoffee> coffees=new ArrayList<>();
        Serving s=new Serving();
        Scanner scn= new Scanner(System.in);
        String str;
        double totalCost=0;

        System.out.println("Coffee'r Tong");
        System.out.println("----------------------------");
        System.out.println("----------------------------");
        while (true) {
            while (true) {
                System.out.println("Choose a option");
                System.out.println("1. Americano");
                System.out.println("2. Espresso");
                System.out.println("3. Cappuccino");
                System.out.println("4. Mocha");
                System.out.println("5. Exit");
                System.out.print("Enter: ");
                str = scn.nextLine();
                System.out.println();
                if (str.equalsIgnoreCase("5")) {
                    for (CoffeerTongCoffee a : coffees) {
                        a.print();
                    }
                    System.out.println("Total cost:\t" + totalCost);
                    coffees.clear();
                    totalCost=0;
                    break;
                }
                c = s.getCoffee(str);
                totalCost += c.cost();
                coffees.add(c);
            }
            System.out.print("\nAnother Order?(Y/N)\nEnter: ");
            str=scn.nextLine();
            System.out.println();
            if(str.equalsIgnoreCase("N"))
                break;
            else {
                System.out.println("----------------------------");
                System.out.println("----------------------------");
            }
        }
    }
}