package main;

import java.util.Scanner;

import dao.StudentDao;

// 유저가 접속하는 클래스
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 학생 정보 관리 클래스
		StudentDao dao = new StudentDao();
		
		// menu
		while(true) {	// 무조건 무한루프부터
			System.out.println("\n");
			System.out.println("학생 정보 프로그램 >>>>>>>>>>>");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 정보 삭제");
			System.out.println("3. 학생 정보 검색");
			System.out.println("4. 학생 정보 수정");
			System.out.println("5. 모두 출력");
			System.out.println("6. 과목의 1등");
			System.out.println("7. 점수의 총점과 평균");
			
			System.out.print("작업 >> ");
			int work = sc.nextInt();
			
			switch(work) {
				case 1:{
					dao.insert();
					break;
				}
				case 2:{
					dao.delete();
					break;
				}
				case 3:{
					dao.select();
					break;
				}
				case 4:{
					dao.update();
					break;
				}
				case 5:{
					dao.allprint();
					break;
				}
				case 6:{
					dao.NumberOne();
					break;
				}
				case 7:{
					dao.scravg();
					break;
				}
				
			}
			
		}

	}

}
