package christmas.domain;

import christmas.global.utils.constant.ConsoleType;
import christmas.global.utils.constant.DiscountType;
import christmas.global.utils.constant.MenuCategoryType;
import christmas.global.utils.constant.MenuType;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final String inputMenu;
    private final int menuCount;
    private final int menuPrice;
    private final MenuCategoryType menuCategoryType;

    public Menu(String inputMenu, int menuCount) {
        isInputMenuValid(inputMenu, getAllMenuNames());
        validateMenuCount(menuCount);
        this.menuCategoryType = getMenuCategory(inputMenu);
        this.menuPrice = getMenuPrice(inputMenu);
        this.inputMenu = inputMenu;
        this.menuCount = menuCount;
    }

    private static int getMenuPrice(String inputMenu) {
        MenuType[] menuTypes = MenuType.values();
        for (MenuType menuType : menuTypes) {
            if (menuType.getMenuName().equals(inputMenu)) {
                return menuType.getMenuPrice();
            }
        }
        throw new IllegalArgumentException(ConsoleType.EXCEPTION_ORDER.getcomment());
    }

    private static MenuCategoryType getMenuCategory(String inputMenu) {
        MenuType[] menuTypes = MenuType.values();
        for (MenuType menuType : menuTypes) {
            if (menuType.getMenuName().equals(inputMenu)) {
                return menuType.getMenuCategory();
            }
        }
        throw new IllegalArgumentException(ConsoleType.EXCEPTION_ORDER.getcomment());
    }

    private static List<String> getAllMenuNames() {
        MenuType[] menuTypes = MenuType.values();
        List<String> allMenuNames = new ArrayList<>();

        for (MenuType menuType : menuTypes) {
            allMenuNames.add(menuType.getMenuName());
        }

        return allMenuNames;
    }

    private static void isInputMenuValid(String inputMenu, List<String> allMenuNames) {
        if (!allMenuNames.contains(inputMenu)) {
            throw new IllegalArgumentException(ConsoleType.EXCEPTION_ORDER.getcomment());
        }
    }

    private void validateMenuCount(int menuCount) {
        if (menuCount < DiscountType.MIN_COUNT_OF_MENU.getValue() || menuCount > DiscountType.MAX_COUNT_OF_MENU.getValue()) {
            throw new IllegalArgumentException(ConsoleType.EXCEPTION_ORDER.getcomment());
        }
    }

    public String getInputMenu() {
        return inputMenu;
    }

    public int getMenuCount() {
        return menuCount;
    }

    public MenuCategoryType getMenuCategoryType() {
        return menuCategoryType;
    }

    public int getMenuPrice() {
        return menuPrice;
    }
}
