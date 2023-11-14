package christmas.domain;

import christmas.global.utils.constant.DateType;
import christmas.global.utils.constant.DiscountType;

public class SpecialDiscount {

    private final int amountOfDiscount;

    public SpecialDiscount(Date inputDate) {
        this.amountOfDiscount = getAmountOfDiscount(inputDate);
    }

    private int getAmountOfDiscount(Date inputDate) {
        if (DateType.DATE_OF_SPECIAL.getDates().contains(inputDate.getInputDate())) {
            return DiscountType.AMOUNT_OF_SPECIAL_DISCOUNT.getValue();
        }
        return DiscountType.ZERO.getValue();
    }

    public int getAmountOfDiscount() {
        return amountOfDiscount;
    }
}
