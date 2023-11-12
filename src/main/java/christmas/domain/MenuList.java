package christmas.domain;

import christmas.global.utils.constant.ConsoleType;
import christmas.global.utils.constant.DiscountType;
import christmas.global.utils.constant.MenuCategoryType;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MenuList {

    private final List<Menu> menuList;

    public MenuList(List<Menu> menuList) {
        validateMenuUnique(menuList);
        validateTotalOfMenuCount(menuList);

        this.menuList = menuList;
    }

    private void validateMenuUnique(List<Menu> menuList) {
        Set<String> uniqueMenus = menuList.stream()
                .map(Menu::getInputMenu)
                .collect(Collectors.toSet());

        if (menuList.size() != uniqueMenus.size()) {
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

    public int getDessertCount() {
        return (int) menuList.stream()
                .filter(menu -> menu.getMenuCategoryType().equals(MenuCategoryType.DESSERT))
                .count();
    }

    public int getMainCount() {
        return (int) menuList.stream()
                .filter(menu -> menu.getMenuCategoryType().equals(MenuCategoryType.MAIN))
                .count();
    }
}
