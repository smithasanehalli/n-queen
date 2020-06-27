
import java.util.Random;

public class Eight_queens_genetic_alg {

    static int[][] queens = new int[50][8];
    static int[] fitness = new int[50];


    public static void main(String[] args) {
        int[] selected1 = new int[8];
        int[] selected2 = new int[8];
        Random rnd = new Random();
        int selected1_index = 0;
        int selected2_index = 0;
        int sayac = 0;
        for (; ; ) {
            sayac++;
            selected1_index = 0;
            selected2_index = 0;
            int first = 0;
            int second = 0;
            int random_max = 0;

            generate(queens);
            fitness = fitness_function(queens);

            for (int i = 0; i < fitness.length; i++) {
                random_max += fitness[i];
            }
            int rand = rnd.nextInt(random_max);

            for (int i = 0; i < fitness.length; i++) {
                first = second;
                second += fitness[i];
                if (first <= rand && rand < second) {

                    for (int j = 0; j < selected1.length; j++) {
                        selected1_index = i;

                    }

                }
            }

            int rand2 = rnd.nextInt(random_max);
            first = 0;
            second = 0;

            for (int i = 0; i < fitness.length; i++) {
                first = second;
                second += fitness[i];
                if (first <= rand2 && rand2 < second) {

                    for (int k = 0; k < selected1.length; k++) {
                        selected2_index = i;
                    }
                }
            }

            crossover(queens[selected1_index], queens[selected2_index]);

            fitness = fitness_function(queens);


            double probab_mutation = Math.random();

            if (probab_mutation < 0.01) {
                mutate(queens[selected1_index]);
                fitness = fitness_function(queens);
            }

            if (fitness[selected1_index] == 28) {
                break;
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((j + 1) == queens[selected1_index][i]) {
                    System.out.print("Q ");

                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println(sayac + "nd step");
    }

    public static void generate(int[][] a) {

        int ran;
        for (int i = 0; i < 50; i++) {

            for (int j = 0; j < 8; j++) {

                ran = 1 + (int) (Math.random() * (8));
                a[i][j] = ran;

            }
        }

    }

    public static int[] fitness_function(int[][] a) {

        int b[] = new int[50];
        for (int i = 0; i < a.length; i++) {
            int function = 28;
            for (int j = 0; j < a[0].length - 1; j++) {
                for (int k = j + 1; k < a[0].length; k++) {
                    if (a[i][j] == a[i][k]) {
                        function--;

                    }
                    if (Math.abs(k - j) == Math.abs(a[i][k] - a[i][j])) {
                        function--;
                    }

                }
                b[i] = function;

            }
        }
        return b;
    }

    public static void crossover(int[] a, int[] b) {


        int r1 = (int) (Math.random() * (8));
        for (int i = r1; i < a.length; i++) {

            a[i] = b[i];

        }

    }

    public static void mutate(int[] a) {
        int in = (int) (Math.random() * (8));
        int num = 1 + (int) (Math.random() * (8));
        a[in] = num;

    }

}
