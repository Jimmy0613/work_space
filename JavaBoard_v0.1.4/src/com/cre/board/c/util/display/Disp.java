package com.cre.board.c.util.display;

import com.cre.board.c.Board;
import com.cre.board.c.List;
import com.cre.board.c.Page;
import com.cre.board.c.db.DataUpdate;
import com.cre.board.c.util.Cw;

public class Disp {
	public static void title() {
		Cw.lineLeo();
		Cw.dot();
		Cw.space(60);
		Cw.dot();
		Cw.wn();
		Cw.dot();
		Cw.space(23);
		Cw.w(Board.TITLE);
		Cw.space(24);
		Cw.dot();
		Cw.wn();
		Cw.dot();
		Cw.space(60);
		Cw.dot();
		Cw.wn();
		Cw.lineLeo();
	}

	public static void notice() {
		Disp.infoPrint(" [ π’ κ³΅μ§μ¬ν­ π’ ] ");
		Cw.wn("1.νμ/λΉνμμ μλλ€. λ‘κ·ΈμΈ νμ§ μμ μ λΉνμμΌλ‘ νμλ©λλ€.");
		Cw.wn("γ΄ λΉνμμ κ²μκΈ μΆμ²μ νκ±°λ λ°μ μ μμ΅λλ€.");
		Cw.wn("γ΄ μ΅μ΄ κ°μ μ μΌλ° νμμλλ€.");
		Cw.wn("γ΄ κ²μκΈ 5κ° μμ± μ μ΄μ¬ νμμ΄ λ©λλ€.");
		Cw.wn("γ΄ κ²μκΈ 10κ° μμ± μ μ΅κ³  νμμ΄ λ©λλ€.");
		Cw.wn("γ΄ κ²μκΈμ μ­μ ν  κ²½μ° νμ λ±κΈμ΄ λ΄λ €κ° μ μμ΅λλ€.");
		Cw.wn("2.μ€λμ BEST: μ€λ μμ±λ κΈ μ€ κ°μ₯ ννΈ(β€)λ₯Ό λ§μ΄ λ°μ κΈ 3κ°λ₯Ό λ³΄μ¬μ€λλ€.");
		Cw.wn("3.μΈκΈ°κΈ: λͺ¨λ  κΈ μ€ κ°μ₯ μ‘°νμκ° λμ κΈ 10κ°λ₯Ό λ³΄μ¬μ€λλ€.");
		Cw.wn("4.κ²μκΈ μμ± μ μ€λ°κΏ: '\\n'μ μλ ₯νμΈμ.");
	}
	
	public static void home() {
		title();
		List dl = new List();
		if (Board.loginId.equals("")) { //λ‘κ·ΈμΈ/λ‘κ·Έμμ μνμ λ°λΌ λ°λ..
			Disp.infoPrint(" [ 1.μμ κ²μν | 2.μΈκΈ°κΈ | x.μ’λ£ ] [ 3.λ‘κ·ΈμΈ | 4.νμκ°μ ]");
			Cw.wn("[ π νμμ λ³΄ π ] λ‘κ·ΈμΈνμΈμ.");
		} else {
			DataUpdate du = new DataUpdate();
			du.updateLoginInfo();
			Disp.infoPrint(" [ 1.μμ κ²μν | 2.μΈκΈ°κΈ | x.μ’λ£ ] [ 3.λ‘κ·Έμμ ]");
			Cw.wn("[ π νμμ λ³΄ π ] " + Board.loginId + " λ (λ±κΈ: " + Board.loginGrade + ")");
		}
		notice();
		dl.todayBest();
		Cw.lineLeo();
	}

	public static void infoPrint(String s) {
		Cw.lineBar();
		Cw.wn("β€π€β€" + s + "β€π€β€");
		Cw.lineBar();
	}

	public static void spaceln(int n) {
		for (int i = 0; i < n; i++) {
			Cw.wn();
		}
	}

	public static void boardTitle(String str) {
		Cw.lineLeo();
		Cw.lineBar();
		Cw.wn(Cw.LEO + str + " " + Cw.LEO);
		Cw.lineBar();
		Cw.lineLeo();
	}

	public static void dispPageInfo(int page, int lastPage) {
		Cw.w(" νμ΄μ§ [ νμ¬:" + page + " ]");
		if (page <= 3) {
			for (int i = 1; i <= Page.PER_PAGE && i <= lastPage; i++) {
				if (i == page) {
					Cw.w(" (" + i + ")");
				} else {
					Cw.w(" " + i);
				}
			}
			Cw.w(" ..");
		} else if (page >= lastPage - 2) {
			Cw.w(" ..");
			for (int i = lastPage - 4; i <= page + 2 && i <= lastPage; i++) {
				if (i == page) {
					Cw.w(" (" + i + ")");
				} else {
					Cw.w(" " + i);
				}
			}
		} else {
			Cw.w(" ..");
			for (int i = page - 2; i <= page + 2 && i <= lastPage; i++) {
				if (i == page) {
					Cw.w(" (" + i + ")");
				} else {
					Cw.w(" " + i);
				}
			}
			Cw.w(" ..");
		}
		Cw.wn(" [ λ§μ§λ§:" + lastPage + " ] [ 4.μ΄μ  | 5.λ€μ | 6.μ ν ]");
		Cw.lineBar();
	}

}
