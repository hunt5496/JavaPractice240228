package Java_project;

import java.util.Random;
import java.util.Scanner;

public class Ex_01_NumberGame {
    int targetNumber;
    int guessCount;

    public Ex_01_NumberGame() {
        this.targetNumber = 0;
        this.guessCount = 0;
    }

    public void startGame() {
        Random random = new Random();
        this.targetNumber = random.nextInt(100) + 1;

        boolean isEven = this.targetNumber % 2 == 0;

        if (isEven) {
            System.out.println("컴퓨터가 정한 수는 짝수입니다.");
        } else {
            System.out.println("컴퓨터가 정한 수는 홀수입니다.");
        }

        guessNumber();
    }

    public void guessNumber() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("1에서 100 사이의 수를 입력하세요: ");
            int userGuess = scanner.nextInt();
            guessCount++;

            if (userGuess == targetNumber) {
                System.out.println("축하합니다! " + guessCount + "회만에 정답을 맞췄습니다.");
                break;
            } else if (userGuess < targetNumber) {
                System.out.println("더 큰 수입니다.");
            } else {
                System.out.println("더 작은 수입니다.");
            }
        }
    }

    public static void main(String[] args) {
        Ex_01_NumberGame game = new Ex_01_NumberGame();
        game.startGame();
    }
}