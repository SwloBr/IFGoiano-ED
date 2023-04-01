import java.util.Scanner;

public class Ex485 {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int L,c;
        int[] num = new int[6];
        String[] num1 = new String[6];
        for (L = 0; L < 6; L++) {
            System.out.println("Digite numero : " + (L+1) + ": ");
            num[L] = scanner.nextInt();

        }
        for (L = 0; L < 6; L++) {
            System.out.println("Digite caractere : " + (L+1) + ": ");
            num1[L] = scanner.next();

        }
        System.out.println("");
        multivetor(num, num1);
    }

    private static void multivetor(int[] vet1, String[] vet2, int[] tam) {
        int i, w;
        for (i = 0; i < tam.length ; i++) {
            System.out.println("");
            for (w = 0; w < vet1.length; w++) {
                System.out.println(vet1[i]);
            }
        }

    }
}
