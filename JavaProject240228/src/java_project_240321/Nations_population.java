package java_project_240321;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Nations_population {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Integer> nations = new HashMap<String, Integer>();
	
		System.out.println("나라 이름과 인구를 5개 입력하세요. (예: Korea 5000)");
		for (int i = 0; i < 5; i++) {
			System.out.print("나라 이름, 인구 >> ");
			String nationInput = scanner.nextLine();
			String[] inputTokens = nationInput.split(" ");
			if (inputTokens.length != 2) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				i--;
				continue;
			}
			String nation = inputTokens[0];
			int population;
			try {
				population = Integer.parseInt(inputTokens[1]);
			} catch (NumberFormatException e) {
				System.out.println("인구는 숫자로 입력해주세요. 다시 입력해주세요.");
				i--;
				continue;
			}
			nations.put(nation, population);					
		}

		String smallestNation = "";
		int smallestPopulation = Integer.MAX_VALUE;
		for (Map.Entry<String, Integer> entry : nations.entrySet()) {
			if(entry.getValue() < smallestPopulation) {
				smallestNation = entry.getKey();
				smallestPopulation = entry.getValue();
			}
		}
		
		System.out.println("제일 인구가 적은 나라는 (" + smallestNation + ", " + smallestPopulation + ")");
		
		scanner.close();	
	}
}
