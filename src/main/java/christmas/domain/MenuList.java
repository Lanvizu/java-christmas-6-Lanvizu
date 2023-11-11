package christmas.domain;

import christmas.global.utils.constant.ConsoleType;
import christmas.global.utils.constant.DiscountType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MenuList {

    private final List<Menu> menuList;

    public MenuList(List<Menu> menuList) {
        validateMenuUnique(menuList);
        validateTotalOfMenuCount(menuList);

        this.menuList = menuList;
    }

    private void validateMenuUnique(List<Menu> menuList) {
        List<String> onlyMenuNames = new ArrayList<>();
        for (Menu menu : menuList) {
            onlyMenuNames.add(menu.getInputMenu());
        }
        Set<String> uniqueMenus = new HashSet<>(onlyMenuNames);
        if (onlyMenuNames.size() != uniqueMenus.size()) {
            throw new IllegalArgumentException(ConsoleType.EXCEPTION_ORDER.getcomment());
        }
    }

    private void validateTotalOfMenuCount(List<Menu> menuList) {
        int totalOfMenuCounts = DiscountType.ZERO.getValue();
        for (Menu menu : menuList) {
            totalOfMenuCounts += menu.getMenuCount();
        }
        if (totalOfMenuCounts > DiscountType.MAX_COUNT_OF_MENU.getValue()) {
            throw new IllegalArgumentException(ConsoleType.EXCEPTION_ORDER.getcomment());
        }
    }

    public List<Menu> getMenuList() {
        return menuList;
    }
//    디저트,메인메뉴 개수 가져오는 기능 추가
}
