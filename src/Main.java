import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FormatException {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String input = scanner.nextLine();
            calc(input);
        }
    }

    public static void calc(String input) throws FormatException {
        int result = 0;
        String[] data = input.split(" ");

        if (data.length != 3)
            throw new FormatException();

        int value1 = Integer.parseInt(data[0]);
        int value2 = Integer.parseInt(data[2]);

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
}

class FormatException extends Exception {
    FormatException() {
        super("Некорретный формат введённых данных");
    }
}