package ex_240228;

// 특정 기능을 가져와서 사용 시, 반드시 임포트 해야합니다.
// 다른 패키지(폴더)에 있는 기능을 이용 시에는 반드시 사용해야함.
import java.util.Scanner;

public class Ex_3_Scanner {

	public static void main(String[] args) {
		System.out.println("당신의 이름과 나이를 작성해주세요.>(예) 이상용 41");
		// 클래스명 참조형 변수명 = new 클래스명();
		Scanner scanner = new Scanner(System.in);
		String nameString = scanner.next();
		
		// 나이를 입력 후 받을 변수를
		int age = scanner.nextInt();
		
		
		System.out.println("입력한 이름은 : " + nameString );
		System.out.println("입력한 나이 : " + age );
	}

}
