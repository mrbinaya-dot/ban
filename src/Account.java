

import java.util.ArrayList;
import java.util.List;

    public class Account {
        private final String accountNumber;
        private final  String accountHolder;
        private double balance;
        private final List<String> transactionHistory;

        public Account(String accountNumber,String accountHolder,double initialDeposit){
            this.accountNumber=accountNumber;
            this.accountHolder= accountHolder;
            this.balance=initialDeposit;
            this.transactionHistory=new ArrayList<>();
            addTransaction("Account opened with: Rs" + initialDeposit);
        }

        public synchronized void withdraw(double amount) throws InsufficientFundException{
            if (amount>balance){
                throw new InsufficientFundException("Withdrawl failed! Insufficient balance for Account"+ accountNumber);

            } balance -= amount;
            addTransaction("Withdrawn : Rs"+amount);
            System.out.println("Sucessfully withdrawn amount: Rs"+ amount);

        }

        private void addTransaction(String message){
            transactionHistory.add(message);
        }
        public void showHistory(){
            System.out.println("\n----History---of----"+accountHolder+ "----");
            for (String record : transactionHistory){
                System.out.println(record);
            }
        }
        public double getBalance(){
            return balance;
        }
        public String getAccountNumber(){
            return accountNumber;
        }
    }


