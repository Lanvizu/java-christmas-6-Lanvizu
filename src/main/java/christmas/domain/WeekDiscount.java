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
        if (DateType.DATE_OF_WEEKEND.getDates().contains(inputDate.getInputDate())) {
            this.dayType = DayType.Weekend;
            return menuList.getMainCount() * DiscountType.AMOUNT_OF_WEEKEND_DISCOUNT.getValue();
        }
        this.dayType = DayType.Weekday;
        return menuList.getDessertCount() * DiscountType.AMOUNT_OF_WEEKDAY_DISCOUNT.getValue();
    }

    public int getAmountOfDiscount() {
        return amountOfDiscount;
    }

    public DayType getDayType() {
        return dayType;
    }
}
