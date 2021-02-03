package kz.iitu.spring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner L = new Scanner(System.in);
        Account[] accs = {
                new Account("Person1", "correctly", 4000),
                new Account("Alex", "1230", 5000),
                new Account("Bob", "5555", 600),
                new Account("Razor", "7117", 7000),
                new Account("John", "1111", 9000)
        };

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Bank bank = context.getBean("bankBean", Bank.class);
        BankService bankService = context.getBean("serviceBean", BankService.class);
        for (Account acc: accs) {
            bank.accounts.add(acc);
        }
        System.out.println("Pin:");
        String pin = L.next();
        if (bankService.checkPin(pin)){
            String name = "";
            for (int i = 0; i < bank.accounts.size(); i++) {
                if (bank.accounts.get(i).pin.equals(pin)){
                    name = bank.accounts.get(i).name;
                }
            }
            int choice = -1;
            while (choice != 0){
                System.out.println("=====================================================================");
                System.out.println("1.Check balance");
                System.out.println("2.Withdraw");
                System.out.println("3.Up to");
                System.out.println("4.Change Pin");
                System.out.println("0.Exit");
                System.out.println("=====================================================================");
                choice = L.nextInt();
                switch (choice){
                    case 1:
                        bankService.checkBalance(name, pin);
                        break;
                    case  2:
                        System.out.println("How much money:");
                        int withdraw = L.nextInt();
                        bankService.withdraw(name, pin, withdraw);
                        break;
                    case  3:
                        System.out.println("How much money:");
                        int upTo = L.nextInt();
                        bankService.upToBalance(name, pin, upTo);
                        break;
                    case 4:
                        System.out.println("Old PIN:");
                        String oldPin = L.next();
                        if (!oldPin.equals(pin)){
                            System.out.println("Error");
                            break;
                        }
                        System.out.println("New PIN:");
                        String newPin = L.next();
                        bankService.changePin(oldPin, newPin);
                        pin = newPin;
                        break;
                }
            }
        }

    }
}
