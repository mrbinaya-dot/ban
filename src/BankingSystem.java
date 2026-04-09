

    public class BankingSystem {
        public static void main(String[ ] args) {
            Account myaccount = new Account("1001", "jhon baba", 4000);

            Runnable task1 = () -> {
                try {
                    myaccount.withdraw(3000);

                } catch (InsufficientFundException e) {
                    System.out.println(e.getMessage());
                }
            };

            Runnable task2 = () -> {
                try {

                    myaccount.withdraw(2000);
                } catch (InsufficientFundException e) {
                    System.out.println(e.getMessage());
                }

            };

            Thread atm1 = new Thread(task1,"ATM1");
            Thread atm2 = new Thread(task2,"ATM2");
            atm1.start();
            atm2.start();
            try{
                atm1.join();
                atm2.join();

            }catch (Exception e){
                e.printStackTrace();
            }
            myaccount.showHistory();



        }
    }


