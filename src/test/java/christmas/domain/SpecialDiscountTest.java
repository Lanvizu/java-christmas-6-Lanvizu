package christmas.domain;

import christmas.global.utils.constant.DiscountType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecialDiscountTest {

    @DisplayName("일요일에 해당하는 경우 할인이 적용된다.")
    @Test
    void should_specialDiscount_when_sunday() {

        SpecialDiscount specialDiscountOf24 = new SpecialDiscount(new Date(24));

        assertEquals(specialDiscountOf24.getAmountOfDiscount(), DiscountType.AMOUNT_OF_SPECIAL_DISCOUNT.getValue());
    }

    @DisplayName("크리스마스인 경우 할인이 적용된다.")
    @Test
    void should_specialDiscount_when_christmas() {

        SpecialDiscount specialDiscountOf25 = new SpecialDiscount(new Date(25));

        assertEquals(specialDiscountOf25.getAmountOfDiscount(), DiscountType.AMOUNT_OF_SPECIAL_DISCOUNT.getValue());
    }

    @DisplayName("special 날짜가 아닌 경우 할인이 적용되지 않는다.")
    @Test
    void should_zeroDiscount_when_outOfSpecialDays() {

        SpecialDiscount specialDiscountOf22 = new SpecialDiscount(new Date(22));

        assertEquals(specialDiscountOf22.getAmountOfDiscount(), DiscountType.ZERO.getValue());
    }
}