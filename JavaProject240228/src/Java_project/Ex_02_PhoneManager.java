package Java_project;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Ex_02_PhoneManager {
    private Map<String, Ex_02_Phone> phoneBook;

    public Ex_02_PhoneManager() {
        this.phoneBook = new HashMap<>();
    }

    public void addPhone(String name, String tel, String address) {
        Ex_02_Phone newPhone = new Ex_02_Phone(name, tel, address);
        phoneBook.put(name, newPhone);
        System.out.println("저장되었습니다...");
    }

    public void searchPhone(String name) {
        if (phoneBook.containsKey(name)) {
            Ex_02_Phone foundPhone = phoneBook.get(name);
            System.out.println(foundPhone.getName() + "의 번호와 주소는 " + foundPhone.getTel() + ", " + foundPhone.getAddress() + " 입니다.");
        } else {
            System.out.println(name + " 은(는) 없습니다.");
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("인원수 >> ");
        int numberOfPeople = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numberOfPeople; i++) {
            System.out.print("이름과 전화번호(번호는 연속적으로 입력), 주소 >> ");
            String inputLine = scanner.nextLine();
            String[] inputArray = inputLine.split(" ");

            if (inputArray.length == 3) {
                String name = inputArray[0];
                String tel = inputArray[1];
                String address = inputArray[2];

                addPhone(name, tel, address);
            } else {
                System.out.println("잘못된 입력 형식입니다. 다시 입력하세요.");
                i--; 
            }
        }

        while (true) {
            System.out.print("\n검색할 이름 >> ");
            String searchName = scanner.nextLine();

            if (searchName.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다...");
                break;
            } else {
                searchPhone(searchName);
            }
        }

        scanner.close();
    }
}