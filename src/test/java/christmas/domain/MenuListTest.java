package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MenuListTest {

    @DisplayName("메뉴를 리스트에 추가할 시")
    @Nested
    class addMenuToList {

        private MenuList menuList;

        @BeforeEach
        void setUp() {
            Menu menu = new Menu("양송이수프", 3);
            this.menuList = new MenuList();
            menuList.addMenuList(menu);
        }

        @DisplayName("정상적으로 메뉴 추가 시 해당 정보가 리스트에 저장된다.")
        @Test
        void should_saveMenu_when_addNormalMenu() {
            Menu redWine = new Menu("레드와인", 3);
            menuList.addMenuList(redWine);
            assertTrue(menuList.getMenuList().contains(redWine));
        }

        @DisplayName("이미 추가된 메뉴와 동일한 메뉴가 추가되면 에러가 발생한다.")
        @Test
        void should_error_when_addSameMenu() {
            Menu soup = new Menu("양송이수프", 4);
            assertThatThrownBy(
                    () -> menuList.addMenuList(soup))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("총 주문 개수가 20개를 초과 시 에러가 발생한다.")
        @Test
        void should_error_when_addOverThen20() {
            Menu champagne = new Menu("샴페인", 18);
            assertThatThrownBy(
                    () -> menuList.addMenuList(champagne))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}