import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Utils {
    public static int[] readNumbersFromFile(String filename) {
        int[] numbers = null;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                Scanner scanner = new Scanner(line);
                while (scanner.hasNextInt()) {
                    int number = scanner.nextInt();
                    if (numbers == null) {
                        numbers = new int[1];
                        numbers[0] = number;
                    } else {
                        int[] newNumbers = new int[numbers.length + 1];
                        System.arraycopy(numbers, 0, newNumbers, 0, numbers.length);
                        newNumbers[numbers.length] = number;
                        numbers = newNumbers;
                    }
                }
                scanner.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers;
    }

    public static int scanInt() {
        int N = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            while (!scanner.hasNextInt()){
                scanner.next();
            }
            N = scanner.nextInt();
        } while (N <= 0);
        return N;
    }

    public static double scanDouble() {
        Scanner scanner = new Scanner(System.in);
        double input;

        do {
            while (!scanner.hasNextDouble()) {
                scanner.next();
            }
            input = scanner.nextDouble();
        } while (input < 0);

        return input;
    }

    public static String scanString() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        return input;
    }
}
