package christmas.domain;

import christmas.global.utils.constant.DiscountType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChristmasDiscountTest {

    @DisplayName("25일까지 100원씩 증가하는 할인이 적용된다.")
    @Test
    void should_plusDiscount_when_1To25() {

        ChristmasDiscount christmasDiscountOf1 = new ChristmasDiscount(new Date(1));
        ChristmasDiscount christmasDiscountOf25 = new ChristmasDiscount(new Date(25));

        assertEquals(christmasDiscountOf1.getAmountOfDiscount(), 1000);
        assertEquals(christmasDiscountOf25.getAmountOfDiscount(), 3400);
    }

    @DisplayName("25일 초과시 크리스마스 할인은 적용되지 않는다.")
    @Test
    void should_discountZero_when_overThan25() {

        ChristmasDiscount christmasDiscountOf26 = new ChristmasDiscount(new Date(26));

        assertEquals(christmasDiscountOf26.getAmountOfDiscount(), DiscountType.ZERO.getValue());
    }
}