package christmas.domain;

import christmas.global.utils.constant.BadgeType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BadgeTest {

    @DisplayName("총 할인 가격이 20000원 이상 시 산타 배지가 지정된다.")
    @Test
    void should_santaBadge_when_discountOrMore20000() {

        Badge badge = new Badge(25000);
        assertEquals(badge.getBadgeType().getBadge(), BadgeType.SANTA_BADGE.getBadge());
    }

    @DisplayName("총 할인 가격이 10000원 이상 시 트리 배지가 지정된다.")
    @Test
    void should_treeBadge_when_discountOrMore10000() {

        Badge badge = new Badge(18000);
        assertEquals(badge.getBadgeType().getBadge(), BadgeType.TREE_BADGE.getBadge());
    }

    @DisplayName("총 할인 가격이 5000원 이상 시 별 배지가 지정된다.")
    @Test
    void should_starBadge_when_discountOrMore5000() {

        Badge badge = new Badge(7000);
        assertEquals(badge.getBadgeType().getBadge(), BadgeType.STAR_BADGE.getBadge());
    }

    @DisplayName("총 할인 가격이 5000원 미만일 경우 배지가 지정되지 않는다.")
    @Test
    void should_NoBadge_when_discountLessThen5000() {

        Badge badge = new Badge(2000);
        assertEquals(badge.getBadgeType().getBadge(), (BadgeType.OTHER.getBadge()));
    }
}