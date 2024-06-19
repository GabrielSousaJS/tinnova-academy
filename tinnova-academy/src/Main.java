import entities.Account;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Seja bem-vindo ao banco Tinnova!");
        System.out.println("-----------------------------------");
        System.out.println("Para prosseguir abra uma conta.");

        System.out.print("Deseja abrir uma conta [S/N]: ");
        String response = sc.nextLine().toUpperCase();

        if (response.equals("N")) {
            System.out.println("Obrigado por nos visitar!");
            System.exit(0);
        } else if (!response.equals("S")) {
            System.out.println("Opção inválida!");
            System.exit(0);
        }

        Account account = new Account();
        Account destination = new Account();

        operations(account, destination, sc);
    }

    private static void operations(Account account, Account destination, Scanner sc) {
        System.out.println("Escolha uma das operações seguintes para prosseguir:");
        System.out.println("1 - Depositar");
        System.out.println("2 - Sacar");
        System.out.println("3 - Transferir");
        System.out.println("4 - Saldo");
        System.out.println("5 - Sair");
        System.out.print("Opção: ");

        int option = 0;

        try {
            option = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Opção inválida!");
            System.exit(0);
        }

        switch (option) {
            case 1:
                System.out.print("Digite o valor a ser depositado: ");
                double amount = writeAmount(sc);

                if (account.deposit(amount))
                    System.out.println("Depósito realizado com sucesso!");
                else
                    System.out.println("Depósito não realizado!");
                break;
            case 2:
                System.out.print("Digite o valor a ser sacado: ");
                amount = writeAmount(sc);

                if (account.withdraw(amount))
                    System.out.println("Saque realizado com sucesso!");
                else
                    System.out.println("Saque não realizado!");
                break;
            case 3:
                System.out.print("Digite o valor a ser transferido: ");
                amount = writeAmount(sc);

                if (account.transfer(destination, amount))
                    System.out.println("Transferência realizada com sucesso!");
                else
                    System.out.println("Transferência não realizada!");
                break;
            case 4:
                System.out.println("Saldo atual na conta: R$ " + account.getBalance() +
                        " e valor total de transferências: R$ " + account.getTotalAmountTransferred());
                break;
            case 5:
                System.out.println("Obrigado por nos visitar!");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        String response;

        System.out.println("Deseja fazer mais operações [S/N]: ");
        sc.nextLine();
        response = sc.nextLine().toUpperCase();

        if (response.equals("N")) {
            System.out.println("Obrigado por usar Tinnova!");
            System.exit(0);
        } else if (!response.equals("S")) {
            System.out.println("Opção inválida!");
            System.exit(0);
        }
        else {
            operations(account, destination, sc);
        }
    }

    private static double writeAmount(Scanner sc) {
        try {
            return sc.nextDouble();
        } catch (Exception e) {
            return 0.0;
        }
    }
}