import java.util.Scanner;

public class Ex483 {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int L,c, au;
        int[] num = new int[4];
        int[] num1 = new int[4];
        for (L = 0;  L< 4 ; L++) {
            System.out.println("digite 1 numero " + (L+1) + ": " );
            num[L] = scanner.nextInt();
        }
        for (L = 0;  L< 4 ; L++) {
            System.out.println("digite 2 numero " + (L+1) + ": " );
            num1[L] = scanner.nextInt();
        }
        c = produtointerno(num, num1, 4);
        System.out.println("VETOR A\tVETORB\n");
        for (L = 0; L <4 ; L++) {
            System.out.println(num[L] + "\t" + num1[L]);
            System.out.println("produto interno");

        }
    }
    public static int produtointerno(int[] vet1, int[] vet2, int quant) {
        int prod, i;
        prod = 0;
        for (i = 0; i < quant; i++) {
            prod = prod + (vet1[i] * vet2[i]);

        }
        return prod;
    }
}
