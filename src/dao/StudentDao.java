package dao;

import java.util.Scanner;
import dto.StudentDto;

// Data Access Object
public class StudentDao {
	Scanner sc = new Scanner(System.in);
	
	private StudentDto students[] = {
		new StudentDto("홍길동", 24, 172.1,75, 80, 85),
		new StudentDto("성춘향", 15, 154.3, 80, 85, 92),
		new StudentDto("일지매", 19, 182.9, 90, 80, 100),	// 3명 데이터 미리 넣어놓기
	};
	private int count;
	
//	기본함수	
	public StudentDao() {
		//students = new StudentDto[10];	// 10명 까지 입력 가능
		count = 0;	// 3명 데이터가 이미 들어있기 때문에 새로 추가할 때는 3부터 시작
	}
//	정보 입력	
	public void insert() {	// 학생 정보 추가
		System.out.println("학생 정보 추가 >> ");
		
		System.out.print("이름 = ");
		String name = sc.next();
		
		System.out.print("나이 = ");
		int age = sc.nextInt();
		
		System.out.print("신장 = ");
		double height = sc.nextDouble();
		
		System.out.print("국어 = ");
		int kor = sc.nextInt();
		
		System.out.print("영어 = ");
		int eng = sc.nextInt();
		
		System.out.print("수학 = ");
		int math = sc.nextInt();
		
		students[count] = new StudentDto(name, age, height, kor, eng, math);
		count++;
		
	}
//	정보 삭제	
	public void delete() {	// 이름 -> "", 나이 -> 0 으로 설정
		System.out.print("삭제할 정보의 이름을 입력하세요: ");
		String name = sc.next();
		for (int i = 0; i < students.length; i++) {
			if(students[i].getName().equals(name)) {
			students[i].setName("");
			students[i].setAge(0);
			System.out.print("삭제가 완료되었습니다.");
			break;
			}
			else {
				System.out.print("데이터를 찾을 수 없습니다.");
				break;
			}
		}
	}
//	정보 검색	
	public void select() {	// 이름 -> 검색 후 출력 / 없으면 "데이터 찾을 수 없습니다"
		System.out.print("검색할 이름을 입력하세요: ");
		String name = sc.next();
		for (int i = 0; i < students.length; i++) {
			if(students[i].getName().equals(name)) {
				System.out.print(students[i]);
				break;
			}
			else {
				System.out.print("데이터를 찾을 수 없습니다.");
				break;
			}
		}
	}
	
//	정보 수정	
	public void update() { // 이름 -> 검색 후 수정: 국어, 수학, 영어 중 원하는 과목 수정
		System.out.print("수정할 정보의 이름을 입력하세요: ");
		String name = sc.next();
		for (int i = 0; i < students.length; i++) {
			if(students[i].getName().equals(name)) {
				System.out.print("수정하고싶은 과목을 입력하세요: ");
				String str = sc.next();
				
				switch(str) {
					case "국어":{
						System.out.print("점수를 입력하세요: ");
						int scr1 = sc.nextInt();
						students[i].setKor(scr1);
						System.out.print("수정이 완료되었습니다.");
						break;
					}
					case "영어":{
						System.out.print("점수를 입력하세요: ");
						int scr2 = sc.nextInt();
						students[i].setEng(scr2);
						System.out.print("수정이 완료되었습니다.");
						break;
					}
					case "수학":{
						System.out.print("점수를 입력하세요: ");
						int scr3 = sc.nextInt();
						students[i].setMath(scr3);
						System.out.print("수정이 완료되었습니다.");
						break;
					}
					default:{
						System.out.print("다시 입력하세요. ");
						break;
					}
				}
			}

		}
	}
//	모두 출력
	public void allprint() {	// CRUD에 포함 안됨
		for (StudentDto dto : students) {
			if(dto != null && !dto.getName().equals("")) {
				System.out.println(dto.toString());
			}
		}
	}
//	과목별 1등 출력
	public void NumberOne() {
		int kor = students[0].getKor();
		String fkor = students[0].getName();
		int eng = students[0].getEng();
		String feng = students[0].getName();
		int math = students[0].getMath();
		String fmath = students[0].getName();
		
		for(int i = 1; i < students.length; i++) {
			if(kor < students[i].getKor()) {
				kor = students[i].getKor();
				fkor = students[i].getName();
			}
			
			if(eng < students[i].getEng()) {
				eng = students[i].getEng();
				feng = students[i].getName();
			}
			
			if(math < students[i].getMath()) {
				math = students[i].getMath();
				fmath = students[i].getName();
			}
		}
		System.out.println("\n======과목별 1등=======");
		System.out.println("[국어] " + fkor + ": " + kor + "점");
		System.out.println("[영어] " + feng + ": " + eng + "점");
		System.out.println("[수학] " + fmath + ": " + math + "점");
	}
	
	public void scravg() {
		int Ksum = 0;
		int Esum = 0;
		int Msum = 0;

		
		for (int i = 0; i < students.length; i++) {
			Ksum += students[i].getKor();
			Esum += students[i].getEng();
			Msum += students[i].getMath();
		}
		double Kavg = (double)Math.round(((double)Ksum / students.length)*10) / 10;	//반올림
		double Eavg = (double)Math.round((double)Esum / students.length * 10) / 10;
		double Mavg = (double)Math.round((double)Msum / students.length * 10) / 10;
		
		
		System.out.println("\n======과목별 총점 및 평균======");
		System.out.println("[국어] 총점: " + Ksum + ", " + "평균: " + Kavg);
		System.out.println("[영어] 총점: " + Esum + ", " + "평균: " + Eavg);
		System.out.println("[수학] 총점: " + Msum + ", " + "평균: " + Mavg);
	}

}
