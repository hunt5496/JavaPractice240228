package java_project_240321;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DrinkPrice {

	public static void main(String[] args) {
		Map<String, Integer> drinkPrices = new HashMap<>();
		drinkPrices.put("밀키스", 700);
        drinkPrices.put("코카콜라", 800);
        drinkPrices.put("펩시", 1000);
        drinkPrices.put("칠성사이다", 1200);
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("밀키스, 코카콜라, 펩시, 칠성사이다가 있습니다. ");
        
        while (true) {
        	System.out.println("선택 >> ");
        	String Choice = scanner.nextLine();
        	
        	if (Choice.equals("그만")) {
        		System.out.println("종료합니다...");
        		break;
        	}
        	Integer price = drinkPrices.get(Choice);
        	if (price !=null) {
        		System.out.println(Choice + "는 " + price + "원 입니다.");
        	} else {
        		System.out.println("해당 음료수가 없습니다.");
        	}
        	       	
        }
                     
	}

}
