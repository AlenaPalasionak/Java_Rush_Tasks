package com.javarush.task.task25.task2513;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
public class Solution {

    private static final Random RANDOM = new Random();

    public static synchronized void moveMoney(Account from, Account to, int amount) {
        int transactionNumber = RANDOM.nextInt(5000);// генерируется рандомный транзакционный номер

        System.out.printf("Транзакция №%d: списание $%d со счета №%d. Баланс: %d.%n", transactionNumber, amount, from.getNumber(), from.getBalance());
        from.setBalance(from.getBalance() - amount);

        System.out.printf("Транзакция №%d: зачисление $%d на счет №%d. Баланс: %d.%n", transactionNumber, amount, to.getNumber(), to.getBalance());
        to.setBalance(to.getBalance() + amount);
        Thread.yield();
    }

    static class Account {
        private int number;
        private int balance;
        private boolean balanceChanged;

        public Account(int number, int balance) {
            this.number = number;
            this.balance = balance;
        }

        public int getNumber() {
            return number;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
            this.balanceChanged = true;
        }

        public void checkBalance() {
            System.out.println(this.number + ": проверка...");
            this.balanceChanged = false;
        }
    }

    public static void main(String[] args) {
        Account a1 = new Account(44444444, 3000);
        Account a2 = new Account(77777, 10);
        Account a3 = new Account(111, 0);

        Set<Account> accounts = new HashSet<>();
        Collections.addAll(accounts, a1, a2, a3);// добавляем в коллекцию сразу все аккаунты

        Thread operationThread = new Thread(() -> {// анон класс- объект
            for (int i = 1; i <= 1000; i *= 10) {
                moveMoney(a1, a2, i);//

            }
        });

        Thread controlThread = new Thread(() -> {
            while (operationThread.isAlive()) {
                accounts.stream().filter(a -> a.balanceChanged).forEach(Account::checkBalance);
            }
        });
// получается две нити идет паралельно кому повезет, нужно воспользоваться yield(), чтобы  дать возможность вывести балланс, работа по очреди
        controlThread.start();
        operationThread.start();
    }
}
//Запусти 10 раз и посмотри в какие моменты происходит "проверка".
//Попробуй добиться выполнения "проверки" после каждого изменения баланса, для этого в moveMoney() вызови Thread.yield().