package christmas.domain;

import christmas.global.utils.constant.DateType;
import christmas.global.utils.constant.DiscountType;

public class WeekDiscount {

    private final int amountOfDiscount;

    public WeekDiscount(int inputDate, MenuList menuList) {
        this.amountOfDiscount = getAmountOfDiscount(inputDate, menuList);
    }

    private int getAmountOfDiscount(int inputDate, MenuList menuList) {
        int amountOfDiscount = 0;
        if (DateType.DATE_OF_WEEKEND.getDates().contains(inputDate)) {
            amountOfDiscount = menuList.getMainCount() * DiscountType.AMOUNT_OF_WEEKEND_DISCOUNT.getValue();
            return amountOfDiscount;
        }
        amountOfDiscount = menuList.getDessertCount() * DiscountType.AMOUNT_OF_WEEKDAY_DISCOUNT.getValue();
        return amountOfDiscount;
    }

    public int getAmountOfDiscount() {
        return amountOfDiscount;
    }
}
