package ex_240306;

public interface test1 extends test2, test3 {
	// class A extends B
	// 인터페이스 구성품
		// 1) 상수 2) 추상 메소드
		String sNACK_MENUString = "자갈치";
		void showSnackMenu();
		// test1 인터페이스에 여러가지 많은 기능을 다 몰빵.
		// 유지보수가 어려워요.
		// 뒤에 가면, 프레임워크 배울 때, 결합도, 느슨한 결합을 해서, 유지 및 개발을 함.
		// 결론, 상속으로 해당 기능을 다 묶을 수 있지만, 이걸 유지보수 등을 고려해서
		// 느슨하게 결합을 생각을 하자
		// 스프링(프레임워크) , 여기서, MVC 간의 연결 관계가 강하게 하기보다, 느슨하게 작업 함.
		// JSP, 모델2 mvc 등을 생각할 때, 또 마주하게 될 문제임.
		// 하지만, 보통의 프로젝트들은 템플릿 등은 느슨하게 설계를 대다수 합니다.
}
