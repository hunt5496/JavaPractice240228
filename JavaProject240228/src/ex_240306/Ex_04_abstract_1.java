package ex_240306;

public class Ex_04_abstract_1 extends Idol_abstract {
	// 일반 클래스는, 상속을 받고, 재정의 의무성(강제성)이 없었다면,
	// 추상 클래스를 상속을 받으면, 재정의한 메서드를 반드시 구현해야하는 의무성이 생김.
	// 보시는 것처럼 재정의를 구현 안하면, 컴파일러 오류가 발생함.
	// 간단한 이야기.
	// 선임 개발자가 클래스를 설계를 함. 그런데, 주니어 개발자들이 혹시라도 반드시 구현해야하는 
	// 메서드를 정의하지 않는 경우가 있음. 그럴 때, 추상 클래스, 인터페이스 등을 이용해서,
	// 강제로 재정의를 안하면, 컴파일러 오류가 발생하게끔 합니다.
	// 중요한 메서드는 이런식으로 재정의를 합니다.
	//
	// 클래스 설계의 유연성을 위해서,
	// 반드시 자식 클래스에서 재정의를 한다면, 굳이 부모 클래스에서 구현을 할 필요가 없음.
	// 추상 클래스로, 선언만 하고,
	// 자식 클래스에서 재정의해서 사용함.
	
	
	
	
	public Ex_04_abstract_1(String groupName, String[] groupMembers, String[] groupAlbums) {
		super(groupName, groupMembers, groupAlbums);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void introduceActivityArea() {
		// TODO Auto-generated method stub
		// 추상 클래스는 , 객체를 생성 즉, 인스턴스화 할 수 없다.
		//	Idol_abstract idol_abstract = new Idol_abstract();
		// 클래스, 공장 -> 제품
		// 추상 클래스 : 예) Idol, 전반적인, 추상적인 내용만 있고,
		// 구체화는 자식 클래스에서 재정의해서 이용한다.
		
	}
		
		
	}
		
}
