package LeetCodeQuestions.CapitalOne;

import java.util.Arrays;

public class simpleBankSystem2043 {

    public static class Bank {

        long[] balance;

        public Bank(long[] balance) {

            this.balance = balance; 
        }
    
        public boolean transfer(int account1, int account2, long money) {

            account1--;
            account2--;

            if(account1 >= balance.length || account1 < 0 || account2 < 0 || account2 >= balance.length){

                return false;
            }

            if(money > balance[account1]){

                return false;
            }

            balance[account1] -= money;
            balance[account2] += money;

            return true;

        }
    
        public boolean deposit(int account, long money) {
            account--;

            if(account >= balance.length || account < 0){

                return false;
            }

            balance[account] += money;

            return true;
        }
    
        public boolean withdraw(int account, long money) {

            account--;

            if(account >= balance.length || account < 0){

                return false;
            }

            if(money > balance[account]){

                return false;
            }

            balance[account] -= money;

            return true;
        }

        public String toString(){
            
            return Arrays.toString(balance);  
        }
    }

    public static void main(String[] args) {

        Bank b1 = new Bank(new long[]{45_000, 150_000, 20_000});

        System.out.println(b1); //println is what calls .toString()

        b1.deposit(1, 15_000);

        System.out.println(b1);

        b1.withdraw(2, 5_000);

        System.out.println(b1);
        
        System.out.println(b1.withdraw(3, 25_000));

        System.out.println(b1.deposit(6, 5));

        b1.transfer(1, 3, 15_000);

        System.out.println(b1);

        b1.transfer(3, 1, 35_000);
        System.out.println(b1);

        System.out.println(b1.transfer(3, 1, 35_000));



    }
}
