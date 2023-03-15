import java.util.Scanner;

enum Roman {
    I(1), V(5), X(10), L(50), C(100), D(500), M(1000);
    private final int value;
    Roman(int value) {
        this.value = value;
    }
    public int toInt() {
        return value;
    }
}

public class Main {
    public static void main(String[] args) throws FormatException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            calc(input);
        }
    }

    public static void calc(String input) throws FormatException {
        int result = 0;
        String[] data = input.split(" ");

        if (data.length != 3)
            throw new FormatException();

        int value1 = convertRomanToInt(data[0]);
        int value2 = convertRomanToInt(data[2]);

        String operation = data[1];

        switch (operation) {
            case "+" -> result = value1 + value2;
            case "-" -> result = value1 - value2;
            case "*" -> result = value1 * value2;
            case "/" -> result = value1 / value2;
            default -> {
            }
        }

        System.out.println(result);
    }

    public static int convertRomanToInt(String romanNumber) {
        int result = 0;
        String[] numbers = romanNumber.split("");
        for (String number : numbers) {
            Roman roman = Roman.valueOf(number);
            result += roman.toInt();
        }
        return result;
    }
}

class FormatException extends Exception {
    FormatException() {
        super("Некорретный формат введённых данных");
    }
}