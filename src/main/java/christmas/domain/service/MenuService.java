package christmas.domain.service;

import christmas.domain.Date;
import christmas.domain.Menu;
import christmas.domain.MenuList;
import christmas.global.utils.constant.ConsoleType;
import christmas.global.utils.view.OutputView;

public class MenuService {
    public void outputTotalMenuPart(Date inputDate, MenuList menuList) {
        outputPreview(inputDate);
        outputInputMenus(menuList);
    }

    private void outputPreview(Date inputDate) {
        OutputView.commonOutputLine(ConsoleType.OUTPUT_EVENT_PREVIEW.getComment(inputDate.getInputDate()));
    }

    private void outputInputMenus(MenuList menuList) {
        OutputView.commonOutputLine(ConsoleType.OUTPUT_MENU_OF_ORDER.getcomment());
        for (Menu menu : menuList.getMenuList()) {
            outputMenus(menu);
        }
    }

    private void outputMenus(Menu menu) {
        OutputView.commonOutputLine(menu.getInputMenu() + menu.getMenuCount() + ConsoleType.COUNT.getcomment());
    }
}