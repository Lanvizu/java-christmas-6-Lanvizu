package christmas.global.utils.constant;

public enum BadgeType {

    STAR_BADGE("별", 5000),
    TREE_BADGE("트리", 10000),
    SANTA_BADGE("산타", 20000);

    private final String badge;
    private final int value;

    BadgeType(final String badge, final int value) {
        this.badge = badge;
        this.value = value;
    }

    public String getBadge() {
        return badge;
    }

    public int getValue() {
        return value;
    }
}
