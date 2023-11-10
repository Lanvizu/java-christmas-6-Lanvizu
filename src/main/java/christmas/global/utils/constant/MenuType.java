package christmas.global.utils.constant;

public enum MenuType {

    MUSHROOM_SOUP("양송이수프", 6000, MenuCategoryType.APPETIZER),
    TAPAS("타파스", 5500, MenuCategoryType.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, MenuCategoryType.APPETIZER),
    T_BONE_STEAK("티본스테이크", 55000, MenuCategoryType.MAIN),
    BARBECUE_RIBS("바비큐립", 54000, MenuCategoryType.MAIN),
    SEAFOOD_PASTA("해산물파스타", 35000, MenuCategoryType.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, MenuCategoryType.MAIN),
    CHOCOLATE_CAKE("초코케이크", 15000, MenuCategoryType.DESSERT),
    ICE_CREAM("아이스크림", 5000, MenuCategoryType.DESSERT),
    COKE_ZERO("제로콜라", 3000, MenuCategoryType.DRINK),
    RED_WINE("레드와인", 60000, MenuCategoryType.DRINK),
    CHAMPAGNE("샴페인", 25000, MenuCategoryType.DRINK);

    private final String menuName;
    private final int menuPrice;
    private final MenuCategoryType menuCategory;

    MenuType(final String menuName, final int menuPrice, final MenuCategoryType menuCategory) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuCategory = menuCategory;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public MenuCategoryType getMenuCategory() {
        return menuCategory;
    }
}
