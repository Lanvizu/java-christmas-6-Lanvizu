package christmas.domain;

import christmas.global.utils.constant.BadgeType;

public class Badge {
    private final BadgeType badgeType;

    public Badge(int totalOfDiscount) {
        this.badgeType = validateBadge(totalOfDiscount);
    }

    private BadgeType validateBadge(int totalOfDiscount) {
        if (totalOfDiscount >= BadgeType.SANTA_BADGE.getValue()) {
            return BadgeType.STAR_BADGE;
        }
        if (totalOfDiscount >= BadgeType.TREE_BADGE.getValue()) {
            return BadgeType.TREE_BADGE;
        }
        if (totalOfDiscount >= BadgeType.STAR_BADGE.getValue()) {
            return BadgeType.STAR_BADGE;
        }
        return BadgeType.OTHER;
    }

    public BadgeType getBadgeType() {
        return badgeType;
    }
}
