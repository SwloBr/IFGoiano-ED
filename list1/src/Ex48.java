import java.util.Scanner;

public class Ex48 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float sm, qtdade, preco, vp, vd;
        System.out.print("\nentre com o salário mínimo: ");
        sm = scanner.nextFloat();
        System.out.print("\nentre com a quantidade em quilowatt: ");
        qtdade = scanner.nextFloat();
        preco = sm/700;
        vp = preco * qtdade;
        vd = (float) (vp * 0.9);
        System.out.print("\npreço do quilowatt: " + preco + "\n valor a ser pago: " + vp + "\n valor com desconto: "+ vd);
        System.out.print("\n");

    }
}
