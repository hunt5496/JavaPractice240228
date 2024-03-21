package java_project_240321;

import java.util.Scanner;

public class WordCounter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("입력해주세요(Exit로 종료): ");
			String input = scanner.nextLine();
			
			if(input.equals("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			String[] words = input.split(",");
			int wordCount = words.length;
			System.out.println("어절 개수는 " + wordCount);
						
		}
		
		scanner.close();
		
		
	}
}
