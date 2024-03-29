package ex_240315;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ex_01_Socket_singlechat_server {
	// 짝지랑, 실제로 1:1 채팅 연습해보기.
	// 준비물 1) 서로 역할이 필요, 누가 : 서버 , 누가2 : 클라이언트
	// 서버역할 : 상대방 클라이언트에게 , 본인의 IP
	// 기본 윈도우즈 방화벽이 설정. 해제
	// 검색 : 고급 보안이 포함된 Windows Defender 방화벽 앱을 실행. 키워드 : 방화벽
	// 순서1 ) 인바운드 규칙 우클릭 -> 새 규칙 클릭.
	// 순서2 ) 포트 클릭
	// 순서3 ) TCP 체크, 특정 포트 : 9999
	// 순서4 ) 연결 허용 클릭.
	// 순서5 ) 도메인, 공용, 개인 다 체크 다음.
	// 순서6 ) 이름 '1_1_채팅 연습 with 짝지 포트 9999'
	// 예) win + R -> cmd -> ipconfig -> 10.100.104.14(내꺼) , 이 IP 알려주기. 추가로 포트 : 9999
	// 파일명 서버 , 실행
	
	// 클라이언트 역할 : 서버의 IP 주소와 포트를 이용해서, 변경.
	// socket = new Socket("localhost",9999); 수정이 필요
	// socket = new Socket("10.100.104.14",9999);
	// 파일명 클라이언트 , 실행.
	
	
	
	// 서버에서, 해당 소켓을 이용해서, 특정 포트 번호로 개방할 예정.
	// 1인 2역으로, 본인 서버도 되고 동시에 클라이언트 역할도 할 예정.
	public static void main(String[] args) throws IOException {
		// 데이터를 전달하기 위해서는 File Input Output이 필요함.
		// 기반 스트림, 보조 스트림 등이 필요해요.
		// 문자를 읽기 위한 도구.
		BufferedReader inBufferedReader = null;
		// 문자를 쓰기 위한 도구.
		BufferedWriter outBufferedWriter = null;
		
		// 순서1, 선언 부분
				// 재료 1) BufferedReader 2) BufferedWriter 3) ServerSocket 4) Socket
				// 5) Scanner
		
		
		
		// 서버 소켓 클래스 인스턴스, 연결을 위한 도구
		ServerSocket listener = null;
		
		// 소켓을 이용해서, 통신하기 위한 도구.
		Socket socket = null;
		
		// UI 대신, 스캐너 클래스를 이용해서, 콘솔로 작업하기.
		Scanner scanner = new Scanner(System.in);
		
		// 파일의 입출력 또는 통신 연결 등은 반드시 예외처리가 필요함.
		
		try {
			// 순서2 구현 부분
			// 1) 연결 파트 2) 데이터 전송, 받기
			
			
			// 순서3 연결 대기
			// 연결을 위한 로직
			// 서버는 통신 대기를 하기위한 작업.
			
			listener = new ServerSocket(9999);
			System.out.println("연결을 기다리는 중...");
			
			// 순서4 연결 수락
			// 연결하기 위한 도구, socket 의 accept 메서드 이용하기.
			// 클라이언트와 서버가 socket이라는 인스턴스를 이용을 해서, 통신할 예정.
			socket = listener.accept();
			
			
			// 데이터를 주고받는 로직. 파일의 IO(InputOutput), 데코레이터 패턴으로.
			// 보조 스트림이 , 기반 스트림을 감싸는 작업.
			// socket.getInputStream() : 바이트를 읽고, 기반 스트림
			// new InputStreamReader() : 문자로 읽기 , 보조 스트림
			// new BufferedReader() : 문자로 읽기, 보조 스트림
			// 용도는 소켓이 데이터를 읽기 위한 용도.
			
			// 순서5 데이터 전송 및 받기위한 인스턴스 초기화
			inBufferedReader =
					new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			
			// 출력용
			// socket.getOutputStream() : 바이트로 출력하기, 기반 스트림
			// new OutputStreamWriter() : 문자로 출력하기 , 보조 스트림
			// new BufferedWriter() : 문자로 출력하기, 보조 스트림
			outBufferedWriter = 
					new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			 
			// 서버는 , 클라이언트와 연결이 되었다면,
			// 반복문, 계속 데이터를 받기 위한 준비를 계속하기. ( 무한 반복)
			
			// 순서6 무한 반복, 데이터 전달 및 받기
			while(true) {
				// 데이터를 읽기 작업. inBufferedReader 이용하기, 한줄씩 읽기 readLine()
				// 상대방으로부터 전달 받은 메세지를 처리하는 로직.
				String message = inBufferedReader.readLine();
				if(message.equals("exit")) {
					System.out.println("종료합니다. ");
					break;
				}
				System.out.println("클라이언트 : " + message);
				System.out.println("메세지 입력하기>> ");
				
				// 스캐너로 내가 입력한 메세지를 받을 변수 선언.
				// 본인이 메세지를 보내기 위한 로직.
				String sendMessage = scanner.nextLine();
				// 출력용 도구로 , 내가 쓴 메세지 담기.
				outBufferedWriter.write(sendMessage + "\n");
				// 인스턴스에 남아있는 메세지 다 보내기.
				outBufferedWriter.flush();
				
				
			}
			
			
			
		} catch (Exception e) {
			
		}finally {
			// 순서7 자원 반납
			// 자원 반납, 역순으로 반납.
			scanner.close();
			socket.close();
			listener.close();
			
		}
		
		
	}

	
	
}
