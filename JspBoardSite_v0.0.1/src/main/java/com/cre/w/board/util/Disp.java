package com.cre.w.board.util;
import com.cre.w.board.Page;

public class Disp {
	Page p = new Page();
	public static String sf(String str, int n) {
		String s=String.format("%-"+n+"s", str);
		return s;
	}
	public static String sfr(String str, int n) {
		String s=String.format("%"+n+"s", str);
		return s;
	}
//	public void dispPageInfo(int page, int lastPage) {
//		w(" 페이지 [ 현재:" + page + " ]");
//		if (page <= 3) {
//			for (int i = 1; i <= p.PER_PAGE && i <= lastPage; i++) {
//				if (i == page) {
//					w(" (" + i + ")");
//				} else {
//					w(" " + i);
//				}
//			}
//			w(" ..");
//		} else if (page >= lastPage - 2) {
//			w(" ..");
//			for (int i = lastPage - 4; i <= page + 2 && i <= lastPage; i++) {
//				if (i == page) {
//					w(" (" + i + ")");
//				} else {
//					w(" " + i);
//				}
//			}
//		} else {
//			w(" ..");
//			for (int i = page - 2; i <= page + 2 && i <= lastPage; i++) {
//				if (i == page) {
//					w(" (" + i + ")");
//				} else {
//					w(" " + i);
//				}
//			}
//			w(" ..");
//		}
//		wn(" [ 마지막:" + lastPage + " ] [ 4.이전 | 5.다음 | 6.선택 ]");
//	}
}
