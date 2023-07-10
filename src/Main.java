import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите арифметическое выражение: ");
        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input) {
        String[] tokens = input.split(" ");
        if (tokens.length != 3) {
            throw new IllegalArgumentException("Некорректное выражение");
        }

        int a = parseNumber(tokens[0]);
        int b = parseNumber(tokens[2]);

        switch (tokens[1]) {
            case "+":
                return String.valueOf(a + b);
            case "-":
                return String.valueOf(a - b);
            case "*":
                return String.valueOf(a * b);
            case "/":
                if (b == 0) {
                    throw new IllegalArgumentException("Деление на ноль недопустимо");
                }
                return String.valueOf(a / b);
            default:
                throw new IllegalArgumentException("Некорректная операция");
        }
    }

    private static int parseNumber(String token) {
        try {
            int number = Integer.parseInt(token);
            if (number < 1 || number > 10) {
                throw new IllegalArgumentException("Число должно быть от 1 до 10");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Некорректное число: " + token);
        }
    }
}
