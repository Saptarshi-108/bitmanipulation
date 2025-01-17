import java.util.Scanner;
import java.lang.StringBuilder;

public class BitConvertor {

    public static String reverseBinary(String binary) {
        StringBuilder sb = new StringBuilder(binary);
        return sb.reverse().toString();
    }
    
    public static StringBuilder Dec2Bin(int num) {
        if (num == 0) {
            return new StringBuilder("0");
        }
        if (num < 0) {
            System.out.println("Error: Decimal number cannot be negative.");
            return null;
        }

        StringBuilder binary = new StringBuilder();
        while (num > 0) {
            if (num % 2 == 0) {
                binary = binary.append("0");
            } else {
                binary = binary.append("1");
            }
            num = num / 2;
        }
        binary.reverse();
        return binary;
    }

    public static int Bin2Dec(String binary) {
        binary=reverseBinary(binary);
        if (binary == null || binary.isEmpty()) {
            System.out.println("Error: Binary string cannot be empty or null.");
            return -1;
        }

        for (char c : binary.toCharArray()) {
            if (c != '0' && c != '1') {
                System.out.println("Error: Binary string can only contain '0' and '1'.");
                return -1;
            }
        }

        int decimal = 0;
        for (int pow = 0; pow < binary.length(); pow++) {
            if (binary.charAt(pow) == '1') {
                decimal += (int) Math.pow(2, pow);
            }
        }
        return decimal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to convert:");
        System.out.println("1. Binary to Decimal");
        System.out.println("2. Decimal to Binary");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("Enter the binary number:");
            String binary = sc.next();
            int decimal = Bin2Dec(binary);
            if (decimal != -1) {
                System.out.println("The decimal equivalent is: " + decimal);
            }
        } else if (choice == 2) {
            System.out.println("Enter the decimal number:");
            int decimal = sc.nextInt();
            StringBuilder binary = Dec2Bin(decimal);
            if (binary != null) {
                System.out.println("The binary equivalent is: " + binary);
            }
        } else {
            System.out.println("Error: Invalid choice.");
        }
        sc.close();
    }
}