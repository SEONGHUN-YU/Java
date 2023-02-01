package com.yu.feb013jl.main;

import com.yu.feb013jl.cvs.CVS;
import com.yu.feb013jl.snack.Snack;

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
		int menu = 0;
		while (true) {
			menu = view.showMainMenu();
			if (menu == 10) {
				break;
			} else if (menu == 1) {
				cvs = view.showRegCVSMenu();
				StoreDAO.insertCVS(cvs);
			} else if (menu == 2) {
				s = view.showRegSnackMenu();
				StoreDAO.insertSnack(s);
			}
		}
		view.destroy();
	}
}
