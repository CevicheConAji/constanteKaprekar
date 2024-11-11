import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iteraciones = sc.nextInt();

        for (int i = 0; i < iteraciones; i++) {
            int cont = 0;
            Integer[] a = {0, 0, 0, 0};
            preguntar(a, sc);

            int n1 = a[0];
            int n2 = a[1];
            int n3 = a[2];
            int n4 = a[3];

            if (n1 == n2 && n2 == n3 && n3 == n4) {
                System.out.println(8);
                continue;
            }
            if (n1 == 6 && n2 == 1 && n3 == 7 && n4 == 4) {
                System.out.println(0);
                continue;
            }

            boolean flag = true;
            while (flag) {
                int menor = reverseMenor(a);
                int mayor = reverseMayor(a);

                int resultado = mayor - menor;
                cont++;

                if (resultado == 6174) {
                    System.out.println(cont);
                    break;
                }

                a = ceros(resultado, a);
            }
        }
        sc.close();
    }

    public static int reverseMenor(Integer[] a) {
        Collections.sort(Arrays.asList(a));
        StringBuilder n = new StringBuilder();
        for (int i : a) {
            n.append(i);
        }
        return Integer.parseInt(n.toString());
    }

    public static int reverseMayor(Integer[] a) {
        Arrays.sort(a, Collections.reverseOrder());
        StringBuilder n = new StringBuilder();
        for (int i : a) {
            n.append(i);
        }
        return Integer.parseInt(n.toString());
    }

    public static void preguntar(Integer[] a, Scanner sc) {
        int num = sc.nextInt();
        ceros(num, a);
    }

    public static Integer[] ceros(int num, Integer[] a) {
        String numString = String.format("%04d", num);
        for (int i = 0; i < a.length; i++) {
            a[i] = Character.getNumericValue(numString.charAt(i));
        }
        return a;
    }
}
