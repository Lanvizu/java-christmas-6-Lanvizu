package christmas.domain;

import christmas.global.utils.constant.DiscountType;

public class EventDiscount {

    private final int amountOfDiscount;

    public EventDiscount(int totalOfMenu) {
        this.amountOfDiscount = getEventDiscount(totalOfMenu);
    }

    private int getEventDiscount(int totalOfMenu) {
        int amountOfDiscount = DiscountType.ZERO.getValue();
        if (totalOfMenu >= DiscountType.MIN_AMOUNT_OF_EVENT.getValue()) {
            amountOfDiscount += DiscountType.AMOUNT_OF_EVENT_DISCOUNT.getValue();
        }
        return amountOfDiscount;
    }

    public int getAmountOfDiscount() {
        return amountOfDiscount;
    }
}
