package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Credit;
import com.aurionpro.model.NetBanking;
import com.aurionpro.model.PaymentGateway;
import com.aurionpro.model.UPI;

public class Ecommercetest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double amount = 0;
        int type = 0;
        boolean wantsRefund = false;
        String input;
        while(true) {
        while (true) {
            try {
            	
                System.out.println("Enter your type of payment: 1. Credit  2. UPI  3. NetBanking");
                type = sc.nextInt();
              
               
                if (type >= 1 && type <= 3) {
                    break;
                } else {
                    System.out.println("Invalid type. Please enter 1, 2, or 3.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine();
            }
        }

       
        while (true) {
            try {
                System.out.println("Enter the amount:");
                amount = sc.nextDouble();
                if (amount > 0) {
                    break;
                } else {
                    System.out.println("Amount must be greater than 0.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine();
            }
        }

       // sc.nextLine(); 
//        while (true) {
//            System.out.println("Do you want a refund? (yes/no):");
//            String response = sc.nextLine().trim().toLowerCase();
//
//            if (response.equals("yes")) {
//                wantsRefund = true;
//                break;
//            } else if (response.equals("no")) {
//                wantsRefund = false;
//                break;
//            } else {
//                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
//            }
//        }

       
        PaymentGateway payment = null;
        if (type == 1) {
            payment = new Credit(amount);
        } else if (type == 2) {
            payment = new UPI(amount);
        } else {
            payment = new NetBanking(amount);
        }

       
        System.out.println("\n-------------------- Payment Information --------------------");
        payment.pay(amount);
        payment.refund(amount);
        sc.nextLine();
//        if (wantsRefund) {
//            payment.refund(amount);
//        } else {
//            System.out.println("No refund processed.");
//        }
        System.out.println("Do you want to perform another transaction? (yes/no):");
        String continueResponse = sc.nextLine().trim().toLowerCase();
        if (!continueResponse.equals("yes")) {
            System.out.println("Thank you! Exiting...");
            break;
        }
    }

  
}
}