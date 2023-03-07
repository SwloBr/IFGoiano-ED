import java.util.Scanner;

public class Ex351 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int L, num;
        String[] nomes = new String[5];
        for (L = 0; L <= 4; L++) {
            System.out.println("nome " + (L + 1) + ": ");
            nomes[L] = scanner.nextLine();

        }
        System.out.println("Digite o numero da pessoa: ");
        num = scanner.nextInt();
        while (num < 1 || num > 5) {
            System.out.println("Numero fora do intervalo");
            System.out.println("Digite o numero da pessoa");
            num = scanner.nextInt();
        }
        System.out.println(nomes[num - 1]);

    }
}
