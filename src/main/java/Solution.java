import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] x = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            x[i] = arItem;
        }

        double[] squaredDistance = calcSquaredDistance(x);
        double standartDeviation = Math.sqrt(calcMean(squaredDistance));

        System.out.println(String.format("%.1f", standartDeviation));

        scanner.close();
    }

    private static double calcMean(int[] param) {
        long sum = 0;
        int n = param.length;
        for (int i = 0; i < n; i++) {
            sum = sum + param[i];
        }
        return (double) sum / n;
    }

    private static double calcMean(double[] param) {
        double sum = 0;
        int n = param.length;
        for (int i = 0; i < n; i++) {
            sum = sum + param[i];
        }
        return sum / n;
    }
    private static double[] calcSquaredDistance(int[] param) {

        double mean = calcMean(param);

        int n = param.length;
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            result[i] = Math.pow(param[i] - mean, 2);
        }
        return result;
    }

}
