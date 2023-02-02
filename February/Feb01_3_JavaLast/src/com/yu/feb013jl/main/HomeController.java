package com.yu.feb013jl.main;

import java.util.ArrayList;

import com.yu.feb013jl.cvs.CVS;
import com.yu.feb013jl.cvs.CVSDAO_t;
import com.yu.feb013jl.snack.Snack;
import com.yu.feb013jl.snack.SnackDAO_t;

// ---------------
// 1. 편의점 등록
// ...
// 10. 종료
// ---------------
// 뭐 : 1
// ---------------
// 1. 편의점 등록
// ...
// 10. 종료
// ---------------
// 뭐 : 2
// ---------------
// ...
// ---------------
// 뭐 : 10 

public class HomeController {
	public static void main(String[] args) {
		Console view = new Console();
		CVS cvs = null;
		Snack s = null;
		String result = null;
		ArrayList<CVS> cvs_al = null;
		ArrayList<Snack> snacks = null;
		int pageCount = 0;
		int searchPageCount = 0;
		int page = 0;
		int menu = 0;
		String searchTxt = null;
		while (true) {
			menu = view.showMainMenu();
			if (menu == 10) {
				break;
			} else if (menu == 1) {
				cvs = view.showRegCVSMenu();
				result = StoreDAO_rough.insertCVS(cvs);
				view.printResult(result);
			} else if (menu == 2) {
				s = view.showRegSnackMenu();
				result = StoreDAO_rough.insertSnack(s);
				view.printResult(result);
			} else if (menu == 3) {
				pageCount = CVSDAO_t.getCDAO().getAllPageCount();
				page = view.showSelectPageMenu(pageCount);
				cvs_al = CVSDAO_t.getCDAO().getAllCVS(page);
				view.showAllCVS(cvs_al);
			} else if (menu == 4) { // 쌀국수 -> 쌀국수집 쫙(DB안의) -> 그중에 (전체에서) 몇페이지꺼 볼래요? -> 정보출력
				pageCount = SnackDAO_t.getSDAO().getAllPageCount();
				page = view.showSelectPageMenu(pageCount);
				snacks = SnackDAO_t.getSDAO().getAllSnack(page);
				view.showAllSnack(snacks);
			} else if (menu == 5) {
				searchTxt = view.showSearchMenu();
				pageCount = CVSDAO_t.getCDAO().getsearchPageCount(searchTxt);
				page = view.showSelectPageMenu(pageCount);
			} else if (menu == 6) {

			}
		}
		view.destroy();
	}
}
