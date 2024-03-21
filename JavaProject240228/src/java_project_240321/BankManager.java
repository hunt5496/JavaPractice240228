package java_project_240321;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> accounts = new HashMap<>();

        System.out.println("<< 통장 관리 프로그램입니다. >>");

        while (true) {
            System.out.print("이름과 금액 입력>> ");
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                System.out.println("프로그램을 종료합니다...");
                break;
            }

                if (!input.contains(" ")) {
                System.out.println("잘못된 입력입니다. 이름과 금액을 공백으로 구분하여 입력해주세요.");
                continue; 
            }

            String[] tokens = input.split(" ");
            String name = tokens[0];
            int amount;

            try {
                amount = Integer.parseInt(tokens[1]);
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 금액은 숫자로 입력해주세요.");
                continue;
            }


            accounts.put(name, accounts.getOrDefault(name, 0) + amount);

            // 잔액 출력 , (괄호하나씩 계속 누락됨..)
            System.out.print("(");
            for (Map.Entry<String, Integer> entry : accounts.entrySet()) {
                System.out.print(entry.getKey() + ">" + entry.getValue() + "원");
                if (entry.getKey() != accounts.keySet().toArray()[accounts.size() - 1]) {
                    System.out.print(")");
                }
            }
            System.out.println(")");
        }

        scanner.close();
    }
}