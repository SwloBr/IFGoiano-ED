import java.util.Scanner;

public class Ex25 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int data, dia, mes, ano;
        System.out.print("\nDigite data no formato ddmmaa: ");
        data = scanner.nextInt();
        dia = data / 10000;
        mes = (data % 10000) / 100;
        ano = data % 100;
        System.out.print("\nDIA: " + dia);
        System.out.print("\nMES: " + mes);
        System.out.print("\nANO: " + ano);
        System.out.print("\n");
    }
}
