import java.util.Random;
import java.util.Scanner;

interface Game {
    void start();

    boolean checkGuess(int guess);
}

class NumberGuessingGame implements Game {
    private final int rangeStart;
    private final int rangeEnd;
    private int randomNumber;

    public NumberGuessingGame(int rangeStart, int rangeEnd) {
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }

    @Override
    public void start() {
        randomNumber = new Random().nextInt(rangeEnd - rangeStart + 1) + rangeStart;
        System.out.println("Число задумано. Попробуйте угадать.");
    }

    @Override
    public boolean checkGuess(int guess) {
        if (guess == randomNumber) {
            System.out.println("Вы угадали!");
            return true;
        } else if (guess > randomNumber) {
            System.out.println("Загаданное число меньше.");
        } else {
            System.out.println("Загаданное число больше.");
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Угадай число!");
        do {
            System.out.println("Выберите диапозон чисел: ");
            System.out.println("От:");
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            System.out.println("До:");
            int b = scanner.nextInt();

            Game game = new NumberGuessingGame(a, b);
            game.start();

            while (true) {
                System.out.println("Введите число: ");
                int guess = scanner.nextInt();
                if (game.checkGuess(guess)) {
                    break;
                }
            }

            System.out.println("Хотите сыграть еще?");
            if (!scanner.next().equalsIgnoreCase("да")) {
                break;
            }
        } while (true);
    }
}
