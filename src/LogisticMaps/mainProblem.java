package LogisticMaps;

import static java.lang.Math.abs;

public class mainProblem {
    public static void main(String[] args) {
        // first problem
        solveFirstProblem();

        // second problem
        solveSecondProblem();

        // third problem
        solveThirdProblem();

        // fourth problem
        solveFourthProblem();

    }

    private static void solveFirstProblem() {
        double r = 0.88;
        double d = 9;
        double x_n = d/10;
        double X_n = d/10 + 0.0001;
        int n = 0;

        while (X_n < 1.1 * x_n) {
            X_n = getFormulaValue(r, X_n);
            x_n = getFormulaValue(r, x_n);
            n++;
        }

        System.out.println("the value of n is: " + n);
    }

    private static void solveSecondProblem() {
        double r_start = 0.2;
        double r_end = 0.92;
        double step = 0.01;
        double d = 9;
        double x_n = d/10;
        double x_n_modif = d/10;
        int n = 0;

        for (double r = r_start; r <= r_end; r += step) {
            while (n < 200) {
                x_n = getFormulaValue(r, x_n);
                x_n_modif = getModifiedFormulaValue(r, x_n_modif);
                n++;
            }
            System.out.println("the value of r is: " + r);
            System.out.println("the x_200 for normal formula is: " + x_n);
            System.out.println("the x_200 for modified formula is: " + x_n_modif);
        }
    }

    private static void solveThirdProblem() {
        double r = 0.785;
        double d_1 = 9;
        double d_2 = 2;
        double x_n = d_1/10;
        double x_n_1 = 0;

        while (true) {
            x_n_1 = x_n;
            x_n = getSecondOrderFormulaValue(r, x_n);
            if (Math.abs(x_n - x_n_1) <= Math.pow(10, -15.9)) {
                System.out.println("The fixed point is: " + x_n);
                break;
            }
            System.out.println(x_n);
        }
    }


    private static void solveFourthProblem() {
        double x_f_1 = 0.5;
        double x_n;
        double x_n_1;
        int n = 0;
        double approx_x_f = 0;
        double r_0 = 0;

        for (double r = 0.001; r < 1; r += 0.001) {
            x_n = 0.2;
            while (true) {
                x_n_1 = x_n;
                x_n = getSecondOrderFormulaValue(r, x_n);
                if (Math.abs(x_n - x_n_1) <= Math.pow(10, -15)) {
                    System.out.println("The fixed point is: " + x_n);
                    System.out.println("r is: " + r);
                    if (Math.abs(x_n - x_f_1) < Math.pow(10, -15)) {
                        return;
                    }
                    break;
                }
            }
        }
    }

    private static double getFormulaValue(double r, double x_n) {
        return 4 * r * x_n * (1 - x_n);
    }

    private static double getModifiedFormulaValue(double r, double x_n) {
        return (4 * r * x_n * (1 - x_n))/10 * 10;
    }

    private static double getSecondOrderFormulaValue(double r, double x_n) {
        x_n = 4 * r * x_n * (1 - x_n);
        return 4 * r * x_n * (1 - x_n);
    }
}
