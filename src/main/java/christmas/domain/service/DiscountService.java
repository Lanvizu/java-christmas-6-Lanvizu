package christmas.domain.service;

import christmas.domain.*;
import christmas.global.utils.constant.ConsoleType;
import christmas.global.utils.constant.DayType;
import christmas.global.utils.constant.DiscountType;
import christmas.global.utils.constant.MenuType;
import christmas.global.utils.view.OutputView;

import java.util.stream.Stream;

public class DiscountService {

    public TotalManage outputTotalDiscountPart(Date inputDate, MenuList menuList) {
        TotalManage totalManage = new TotalManage(inputDate, menuList);

        outputAmountBeforeDiscount(totalManage);
        outputEventMenu(totalManage);
        outputDiscounts(totalManage);
        outputTotalDiscount(totalManage);
        outputTotalAfterDiscount(totalManage);
        return totalManage;
    }

    private void outputAmountBeforeDiscount(TotalManage totalManage) {
        OutputView.commonOutputLine(ConsoleType.OUTPUT_TOTAL_OF_ORDER_BEFORE_DISCOUNT.getcomment());
        OutputView.commonOutputLine(totalManage.getTotalOfMenu() + ConsoleType.WON.getcomment());
    }

    private void outputEventMenu(TotalManage totalManage) {
        OutputView.commonOutputLine(ConsoleType.OUTPUT_MENU_OF_EVENT.getcomment());
        if (totalManage.getEventDiscount().getAmountOfDiscount() == DiscountType.AMOUNT_OF_EVENT_DISCOUNT.getValue()) {
            OutputView.commonOutputLine(MenuType.CHAMPAGNE.getMenuName() + DiscountType.MIN_COUNT_OF_MENU.getValue()
                    + ConsoleType.COUNT.getcomment());
            return;
        }
        OutputView.commonOutputLine(ConsoleType.NONE.getcomment());
    }

    private void outputDiscounts(TotalManage totalManage) {
        OutputView.commonOutputLine(ConsoleType.OUTPUT_LIST_OF_DISCOUNT.getcomment());
        boolean anyDiscountApplied = Stream.of(outputChristmasDiscount(totalManage),
                        outputWeekDiscount(totalManage), outputSpecialDiscount(totalManage), outputEventDiscount(totalManage))
                .anyMatch(Boolean::valueOf);

        if (!anyDiscountApplied) {
            OutputView.commonOutputLine(ConsoleType.NONE.getcomment());
        }
    }

    private boolean outputChristmasDiscount(TotalManage totalManage) {
        ChristmasDiscount christmasDiscount = totalManage.getChristmasDiscount();
        if (christmasDiscount.getAmountOfDiscount() > DiscountType.ZERO.getValue()) {
            OutputView.commonOutputLine(ConsoleType.OUTPUT_CHRISTMAS_DISCOUNT.
                    getComment(christmasDiscount.getAmountOfDiscount()));
            return true;
        }
        return false;
    }

    private boolean outputWeekDiscount(TotalManage totalManage) {
        WeekDiscount weekDiscount = totalManage.getWeekDiscount();
        if (weekDiscount.getDayType().equals(DayType.Weekend)) {
            OutputView.commonOutputLine(ConsoleType.OUTPUT_WEEKEND_DISCOUNT.getComment(weekDiscount.getAmountOfDiscount()));
            return true;
        }
        if (weekDiscount.getDayType().equals(DayType.Weekday)
                && weekDiscount.getAmountOfDiscount() > DiscountType.ZERO.getValue()) {
            OutputView.commonOutputLine(ConsoleType.OUTPUT_WEEKEND_DISCOUNT.getComment(weekDiscount.getAmountOfDiscount()));
            return true;
        }
        return false;
    }

    private boolean outputSpecialDiscount(TotalManage totalManage) {
        SpecialDiscount specialDiscount = totalManage.getSpecialDiscount();
        if (specialDiscount.getAmountOfDiscount() > DiscountType.ZERO.getValue()) {
            OutputView.commonOutputLine(ConsoleType.OUTPUT_SPECIAL_DISCOUNT.getComment(specialDiscount.getAmountOfDiscount()));
            return true;
        }
        return false;
    }

    private boolean outputEventDiscount(TotalManage totalManage) {
        SpecialDiscount specialDiscount = totalManage.getSpecialDiscount();
        if (specialDiscount.getAmountOfDiscount() > DiscountType.ZERO.getValue()) {
            OutputView.commonOutputLine(ConsoleType.OUTPUT_EVENT_DISCOUNT.getComment(specialDiscount.getAmountOfDiscount()));
            return true;
        }
        return false;
    }

    private void outputTotalDiscount(TotalManage totalManage) {
        OutputView.commonOutputLine(ConsoleType.OUTPUT_TOTAL_OF_DISCOUNT.getcomment());
        int totalOfDiscount = totalManage.getTotalOfDiscount();
        if (totalOfDiscount > DiscountType.ZERO.getValue()) {
            OutputView.commonOutputLine(ConsoleType.OUTPUT_DISCOUNT.getComment(totalOfDiscount));
            return;
        }
        OutputView.commonOutputLine(DiscountType.ZERO.getValue() + ConsoleType.WON.getcomment());
    }

    private void outputTotalAfterDiscount(TotalManage totalManage) {
        OutputView.commonOutputLine(ConsoleType.OUTPUT_TOTAL_OF_AFTER_DISCOUNT.getcomment());
        int totalAfterDiscount = totalManage.getTotalOfMenu() - totalManage.getTotalOfDiscount();
        OutputView.commonOutputLine(ConsoleType.OUTPUT_TOTAL.getComment(totalAfterDiscount));
    }
}