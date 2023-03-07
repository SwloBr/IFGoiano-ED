import java.util.Scanner;

public class Ex348 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int L;
        String[] nomes = new String[5];
        Double[] pr1 = new Double[5];
        Double[] pr2 = new Double[5];
        Double[] media = new Double[5];

        for (L = 0; L <= 4 ; L++) {
            System.out.println("digite " + (L + 1) + "nome: ");
            nomes[L] = scanner.nextLine();
            System.out.println("digite 1 nota: ");
            pr1[L] = scanner.nextDouble();
            System.out.println("digite 2 nota: ");
            pr2[L] = scanner.nextDouble();
            media[L] = (pr1[L] + pr2[L])/2;
        }
        System.out.println("\n\n\n\nRELAÇÃO FINAL\n");
        for (L = 0; L <= 4; L++) {
            System.out.println((L+1) + "- " + nomes[L]);
            System.out.println((pr1[L]) + "\n" + pr2[L] + "\n" + media[L]);
        }

    }
}
