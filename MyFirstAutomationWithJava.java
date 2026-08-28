Java

import java.util.Scanner;

public class AgeCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = input.nextInt();

        if (age > 10) {
            System.out.println("OK");
        } else {
            System.out.println("Not OK");
        }

        input.close();
    }
}