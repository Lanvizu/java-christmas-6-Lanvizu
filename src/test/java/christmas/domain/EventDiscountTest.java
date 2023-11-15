package christmas.domain;

import christmas.global.utils.constant.DiscountType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventDiscountTest {

    @DisplayName("할인 전 총 금액이 12000원 이상 시 샴페인 하나를 증정합니다.")
    @Test
    void should_champagne_when_orMore120000BeforeDiscount() {

        EventDiscount eventDiscount = new EventDiscount(130000);

        assertEquals(eventDiscount.getAmountOfDiscount(),DiscountType.AMOUNT_OF_EVENT_DISCOUNT.getValue());
    }

    @DisplayName("할인 전 총 금액이 12000원 미만 시 이벤트는 적용되지 않습니다.")
    @Test
    void should_zeroDiscount_when_lessThan120000BeforeDiscount() {

        EventDiscount eventDiscount = new EventDiscount(111111);

        assertEquals(eventDiscount.getAmountOfDiscount(), DiscountType.ZERO.getValue());
    }
}