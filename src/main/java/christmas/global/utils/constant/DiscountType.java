package christmas.global.utils.constant;

public enum DiscountType {

    ZERO(0),
    COUNT_OF_EVENT_MENU(1),
    MIN_COUNT_OF_MENU(1),
    MAX_COUNT_OF_MENU(20),
    AMOUNT_OF_FIRST_CHRISTMAS_DISCOUNT(1000),
    AMOUNT_OF_PLUS_CHRISTMAS_DISCOUNT(100),
    AMOUNT_OF_WEEKDAY_DISCOUNT(2023),
    AMOUNT_OF_WEEKEND_DISCOUNT(2023),
    AMOUNT_OF_SPECIAL_DISCOUNT(1000),
    AMOUNT_OF_EVENT_DISCOUNT(25000),
    MIN_AMOUNT_OF_ORDER(10000),
    MIN_AMOUNT_OF_EVENT(120000);

    private final int value;

    DiscountType(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
