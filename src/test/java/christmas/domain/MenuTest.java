package christmas.domain;

import christmas.global.utils.constant.MenuCategoryType;

import christmas.global.utils.constant.MenuType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class MenuTest {

    @DisplayName("메뉴에 없는 이름 입력시 에러가 발생한다.")
    @Test
    void should_fail_when_inputNotInMenu() {
        assertThatThrownBy(() -> new Menu("양송이없는수프", 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1개 미만의 개수를 입력시 에러가 발생한다.")
    @Test
    void should_fail_when_inputCountLessThan_1() {
        assertThatThrownBy(() -> new Menu("양송이수프", -1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("20개 초과의 개수를 입력시 에러가 발생한다.")
    @Test
    void should_fail_when_inputCountOverThan_20() {
        assertThatThrownBy(() -> new Menu("양송이수프", 21))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 메뉴의 종류를 가져와 저장한다")
    @Test
    void should_getCorrectType_when_inputMenu() {
        Menu menu = new Menu("양송이수프", 2);
        Assertions.assertThat(menu.getMenuCategoryType()).isEqualTo(MenuCategoryType.APPETIZER);
    }

    @DisplayName("입력한 메뉴의 가격을 가져와 저장한다")
    @Test
    void should_getCorrectPrice_when_inputMenu() {
        Menu menu = new Menu("양송이수프", 2);
        Assertions.assertThat(menu.getMenuPrice()).isEqualTo(MenuType.MUSHROOM_SOUP.getMenuPrice());
    }
}