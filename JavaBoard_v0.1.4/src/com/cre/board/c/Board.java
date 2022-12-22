package com.cre.board.c;

import com.cre.board.c.proc.ProcLogin;
import com.cre.board.c.proc.ProcSignUp;
import com.cre.board.c.util.Ci;
import com.cre.board.c.util.display.Disp;

public class Board {
	public static final String VERSION = "v0.1.4";
	public static final String TITLE = "게시판 (" + VERSION + ")";

	// 사용자 입력을 담는 변수.
	//	이 변수 하나만으로 입력을 관리해야 댓글 쓰기, 추천하기 등의 행동을 해도 꼬이지 않음.
	public static String input;
	// 메인화면에서 인기글 탭으로 들어가면 읽기 전용이라 그것을 구분하기 위한 변수
	public static boolean readOnly = false;
	// 로그인 여부를 구분하는 변수. ""면 로그아웃상태. ""가 아니면 로그인 상태..
	public static String loginId = "";
	public static String loginGrade = "";

	GeneralBoard gb = new GeneralBoard(); //자유게시판
	PopularPosts pp = new PopularPosts(); //인기글
	ProcSignUp psu = new ProcSignUp(); //가입
	ProcLogin pl = new ProcLogin(); //로그인

	public void run() {
		board: while (true) {
			Disp.spaceln(5); //그냥 공간 띄우는거
			Disp.home(); //메인 화면 실행
			Disp.spaceln(10);
			input = Ci.r(); //입력받는 식
			switch (input) {
			case "1":
				gb.run(); // 자유게시판 진입
				break;
			case "2":
				pp.run(); // 인기글 진입
				break;
			case "3":
				if (loginId.equals("")) { //로그인상태가 아니면 로그인 진입
					pl.login();
				} else { //로그인상태면 로그아웃
					Disp.infoPrint("로그아웃 할래요? [ o.로그아웃 | x.취소 ]");
					input = Ci.r();
					switch (input) {
					case "o":
						loginId = "";
						loginGrade = "";
						break;
					case "x":
						Disp.infoPrint("취소했습니다.");
						break;
					}
				}
				break;
			case "4":
				psu.signUp(); // 가입 진입
				break;
			case "x":
				Disp.infoPrint("프로그램을 종료합니다."); // 프로그램 종료
				break board;
			}
		}
	}
}
