package kz.iitu.spring1;

public class BankService implements IBankService {
    Bank bank;

    public BankService(Bank bank) {
        this.bank = bank;
    }

    public boolean checkPin(String pin){
        if (pin.equals("correctly"))
            return true;
        return false;
    }
    public void changePin(String oldPin, String newPin){
        for (int i = 0; i < bank.accounts.size(); i++) {
            if (bank.accounts.get(i).pin.equals(oldPin)){
                bank.accounts.get(i).pin = newPin;
                System.out.println("Pin updated");
            }
        }
    }

    @Override
    public void checkBalance(String name, String pin) {
        for (int i = 0; i < bank.accounts.size(); i++) {
            if (bank.accounts.get(i).pin.equals(pin) && bank.accounts.get(i).name.equals(name) ){
                System.out.println("Name: " + bank.accounts.get(i).name);
                System.out.println("Balance: " + bank.accounts.get(i).cash);
            }
        }
    }

    @Override
    public void withdraw(String name, String pin, int money) {
        for (int i = 0; i < bank.accounts.size(); i++) {
            if (bank.accounts.get(i).pin.equals(pin) && bank.accounts.get(i).name.equals(name)) {
                bank.accounts.get(i).cash -= money;
                System.out.println("Name: " + bank.accounts.get(i).name);
                System.out.println("Withdrawn money: " + money);
                System.out.println("Cash: " + bank.accounts.get(i).cash);
            }
        }
    }

    @Override
    public void upToBalance(String name, String pin, int money) {
        for (int i = 0; i < bank.accounts.size(); i++) {
            if (bank.accounts.get(i).pin.equals(pin) && bank.accounts.get(i).name.equals(name)) {
                bank.accounts.get(i).cash += money;
                System.out.println("Name: " + bank.accounts.get(i).name);
                System.out.println("Replenished money: " + money);
                System.out.println("Cash: " + bank.accounts.get(i).cash);
            }
        }
    }
}
