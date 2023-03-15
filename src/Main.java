import java.util.Scanner;

enum Roman {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10);
    private final int value;

    Roman(int value) {
        this.value = value;
    }

    public int toInt() {
        return value;
    }
}

public class Main {
    public static void main(String[] args) throws FormatException, BelowZeroException, DifferentNumbersException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            calc(input);
        }
    }

    public static void calc(String input) throws FormatException, BelowZeroException, DifferentNumbersException {
        String[] data = input.split(" ");

        if (data.length != 3)
            throw new FormatException();

        boolean isRoman1 = checkIsRoman(data[0]);
        boolean isRoman2 = checkIsRoman(data[2]);

        if ((isRoman1 && !isRoman2) || (!isRoman1 && isRoman2))
            throw new DifferentNumbersException();

        boolean allIsRoman = isRoman1 && isRoman2;

        int value1 = allIsRoman ? convertRomanToInt(data[0]) : Integer.parseInt(data[0]);
        int value2 = allIsRoman ? convertRomanToInt(data[2]) : Integer.parseInt(data[2]);

        if (value1 > 10 || value2 > 10)
            throw new FormatException();

        String operation = data[1];

        int result = 0;

        switch (operation) {
            case "+" -> result = value1 + value2;
            case "-" -> result = value1 - value2;
            case "*" -> result = value1 * value2;
            case "/" -> result = value1 / value2;
            default -> {
            }
        }

        String output = allIsRoman ? convertIntToRoman(result) : Integer.toString(result);

        System.out.println(output);
    }

    public static boolean checkIsRoman(String value) {
        boolean isRoman = false;
        Roman[] romans = Roman.values();
        for (Roman roman : romans) {
            if (value.equals(roman.name())) {
                isRoman = true;
                break;
            }
        }
        return isRoman;
    }

    public static int convertRomanToInt(String value) {
        int result = 0;
        Roman[] romans = Roman.values();
        for (Roman roman : romans) {
            if (value.equals(roman.name())) {
                result = roman.toInt();
                break;
            }
        }
        return result;
    }

    public static String convertIntToRoman(int value) throws BelowZeroException {
        if (value <= 0)
            throw new BelowZeroException();

        String result = "";
        Roman[] romans = Roman.values();
        for (Roman roman : romans) {
            if (value == roman.toInt()) {
                result = roman.name();
                break;
            }
        }
        return result;
    }
}

class FormatException extends Exception {
    FormatException() {
        super("Некорретный формат введённых данных");
    }
}

class BelowZeroException extends Exception {
    BelowZeroException() {
        super("В римской системе нет отрицательных чисел");
    }
}

class DifferentNumbersException extends Exception {
    DifferentNumbersException() {
        super("Используются одновременно разные системы счисления");
    }
}