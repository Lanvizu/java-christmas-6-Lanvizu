package christmas.domain;

import christmas.global.utils.constant.DateType;
import christmas.global.utils.constant.DiscountType;

public class ChristmasDiscount {

    private final int amountOfDiscount;

    public ChristmasDiscount(Date inputDate) {
        this.amountOfDiscount = getAmountOfDiscount(inputDate.getInputDate());
    }

    private int getAmountOfDiscount(int inputDate) {
        int amountOfDiscount = DiscountType.ZERO.getValue();
        if (inputDate <= DateType.DATE_OF_EVENT_END.getDate()) {
            amountOfDiscount = DiscountType.AMOUNT_OF_FIRST_CHRISTMAS_DISCOUNT.getValue()
                    + (inputDate - 1) * DiscountType.AMOUNT_OF_PLUS_CHRISTMAS_DISCOUNT.getValue();
        }
        return amountOfDiscount;
    }

    public int getAmountOfDiscount() {
        return amountOfDiscount;
    }
}
