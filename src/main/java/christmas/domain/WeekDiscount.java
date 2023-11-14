package christmas.domain;

import christmas.global.utils.constant.DateType;
import christmas.global.utils.constant.DayType;
import christmas.global.utils.constant.DiscountType;

public class WeekDiscount {

    private final int amountOfDiscount;
    private DayType dayType;

    public WeekDiscount(Date inputDate, MenuList menuList) {
        this.amountOfDiscount = getAmountOfDiscount(inputDate, menuList);
    }

    private int getAmountOfDiscount(Date inputDate, MenuList menuList) {
        int amountOfDiscount;
        if (DateType.DATE_OF_WEEKEND.getDates().contains(inputDate.getInputDate())) {
            amountOfDiscount = menuList.getMainCount() * DiscountType.AMOUNT_OF_WEEKEND_DISCOUNT.getValue();
            this.dayType = DayType.Weekend;
            return amountOfDiscount;
        }
        amountOfDiscount = menuList.getDessertCount() * DiscountType.AMOUNT_OF_WEEKDAY_DISCOUNT.getValue();
        this.dayType = DayType.Weekday;
        return amountOfDiscount;
    }

    public int getAmountOfDiscount() {
        return amountOfDiscount;
    }

    public DayType getDayType() {
        return dayType;
    }
}
