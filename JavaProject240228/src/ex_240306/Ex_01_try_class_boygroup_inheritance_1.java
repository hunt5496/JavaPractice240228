package ex_240306;

import ex_240304.Idol;

public class Ex_01_try_class_boygroup_inheritance_1 extends Idol {
	// 상속 기본 문법
	// 자식 클래스 extends 부모 클래스
	// 주의사항,
	// 반드시 부모 클래스가 초기화가 되어야한다.
	public Ex_01_try_class_boygroup_inheritance_1(String groupName, String[] groupMembers, String[] groupAlbums) {
		super(groupName, groupMembers, groupAlbums);
		// TODO Auto-generated constructor stub
	}

	// 자식 클래스에서 추가로 1) 변수 2) 메서드를 구성안했는데
	// 오버라이딩 테스트.
	// introduceAlbum() 메서드를 재정의 해보기.
	// 해당 메서드는 부모에도 존재하고, 자식에도 존재합니다. 우선 순위는 누가 우선이냐? 자식 클래스이다.
	public void introduceAlbum() {
		for(String album : this.groupAlbums ) {
			System.out.println(this.groupName + "의 오버라이딩한 앨범 : " + album + "있습니다.");
		}
	}
	
	
}