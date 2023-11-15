package christmas.domain;

import christmas.global.utils.constant.DiscountType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeekDiscountTest {

    @DisplayName("메인 메뉴가 추가된 경우")
    @Nested
    class addMainMenuToList {

        private MenuList menuList;

        @BeforeEach
        void setUp() {
            Menu menu = new Menu("바비큐립", 3);
            this.menuList = new MenuList();
            menuList.addMenuList(menu);
        }

        @DisplayName("평일에 디저트 메뉴를 주문 시 주간 할인이 적용됩니다.")
        @Test
        void should_weekdayDiscount_when_orderDessertMenuOnWeekday() {

            Menu iceCream = new Menu("아이스크림", 3);
            menuList.addMenuList(iceCream);
            WeekDiscount weekDiscount = new WeekDiscount(new Date(7), menuList);
            assertEquals(weekDiscount.getAmountOfDiscount(), DiscountType.AMOUNT_OF_WEEKDAY_DISCOUNT.getValue());
        }

        @DisplayName("평일에 디저트 메뉴를 주문하지 않을 경우 주간 할인이 적용되지않는다.")
        @Test
        void should_zeroWeekdayDiscount_when_orderNoDessertMenuOnWeekday() {

            WeekDiscount weekDiscount = new WeekDiscount(new Date(7), menuList);
            assertEquals(weekDiscount.getAmountOfDiscount(), DiscountType.ZERO.getValue());
        }
    }

    @DisplayName("디저트 메뉴가 추가된 경우")
    @Nested
    class addDessertMenuToList {

        private MenuList menuList;

        @BeforeEach
        void setUp() {
            Menu menu = new Menu("아이스크림", 3);
            this.menuList = new MenuList();
            menuList.addMenuList(menu);
        }

        @DisplayName("주말에 메인 메뉴를 주문하지 않은 경우 주말 할인이 적용되지않는다.")
        @Test
        void should_zeroWeekendDiscount_when_orderNoMainMenuOnWeekend() {

            WeekDiscount weekDiscount = new WeekDiscount(new Date(8), menuList);
            assertEquals(weekDiscount.getAmountOfDiscount(), DiscountType.ZERO.getValue());
        }

        @DisplayName("주말에 메인 메뉴를 주문 시 주말 할인이 적용됩니다.")
        @Test
        void should_weekendDiscount_when_orderMainMenuOnWeekend() {

            Menu mainMenu = new Menu("바비큐립", 3);
            menuList.addMenuList(mainMenu);
            WeekDiscount weekDiscount = new WeekDiscount(new Date(8), menuList);
            assertEquals(weekDiscount.getAmountOfDiscount(), DiscountType.AMOUNT_OF_WEEKEND_DISCOUNT.getValue());
        }
    }
}