package christmas.domain;

import christmas.global.utils.constant.MenuType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TotalManageTest {

    @DisplayName("메인 메뉴가 추가된 경우")
    @Nested
    class addMainMenuToList {

        private MenuList menuList;

        @BeforeEach
        void setUp() {
            Menu menu1 = new Menu("바비큐립", 3);
            Menu menu2 = new Menu("타파스", 4);
            this.menuList = new MenuList();
            menuList.addMenuList(menu1);
            menuList.addMenuList(menu2);
        }

        @DisplayName("날짜와 메뉴 리스트를 통해 전체 가격을 가져옵니다.")
        @Test
        void should_getTotalOfMenu_when_getDateAndMenuList() {

            TotalManage totalManage = new TotalManage(new Date(7), menuList);

            assertEquals(totalManage.getTotalOfMenu(), MenuType.BARBECUE_RIBS.getMenuPrice() * 3
                    + MenuType.TAPAS.getMenuPrice() * 4);
        }
    }

}