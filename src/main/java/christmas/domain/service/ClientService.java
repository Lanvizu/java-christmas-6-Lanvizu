package christmas.domain.service;

import christmas.domain.Date;
import christmas.domain.Menu;
import christmas.domain.MenuList;
import christmas.global.utils.constant.ConsoleType;
import christmas.global.utils.view.InputView;
import christmas.global.utils.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class ClientService {

    private static final String SPLITTER = ",";
    private static final String SPLITTER_INPUT_MENU = "-";

    public Date getInputDate() {
        OutputView.commonOutputLine(ConsoleType.INPUT_DATE_OF_VISIT.getcomment());
        while (true) {
            String input = InputView.input();
            try {
                return new Date(Integer.parseInt(input));
            } catch (IllegalArgumentException e) {
                OutputView.commonOutputLine(ConsoleType.EXCEPTION_DATE.getcomment());
            }
        }
    }

    public MenuList getInputMenu() {
        OutputView.commonOutputLine(ConsoleType.INPUT_MENU_AND_COUNT.getcomment());
        while (true) {
            String input = InputView.input();
            try {
                List<String> inputMenusAndCounts = Arrays.stream(input.split(SPLITTER))
                        .toList();
                return convertInputToMenuList(inputMenusAndCounts);
            } catch (IllegalArgumentException e) {
                OutputView.commonOutputLine(ConsoleType.EXCEPTION_ORDER.getcomment());
            }
        }
    }

    private MenuList convertInputToMenuList(List<String> inputMenusAndCounts) {
        MenuList menuList = new MenuList();
        for (String inputMenuAndCount : inputMenusAndCounts) {
            List<String> menuAndCount = Arrays.stream(inputMenuAndCount.split(SPLITTER_INPUT_MENU))
                    .toList();
            menuList.addMenuList(new Menu(menuAndCount.get(0), Integer.parseInt(menuAndCount.get(1))));
        }
        return menuList;
    }
}