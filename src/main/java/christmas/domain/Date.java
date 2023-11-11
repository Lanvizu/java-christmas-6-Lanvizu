package christmas.domain;

import christmas.global.utils.constant.ConsoleType;

import static christmas.global.utils.constant.DateType.DATE_OF_END;
import static christmas.global.utils.constant.DateType.DATE_OF_START;

public class Date {
    private final int inputDate;

    public Date(int inputDate) {
        validate(inputDate);
        this.inputDate = inputDate;
    }

    private void validate(int inputDate) {
        if (inputDate < DATE_OF_START.getDate() || inputDate > DATE_OF_END.getDate()) {
            throw new IllegalArgumentException(ConsoleType.EXCEPTION_DATE.getcomment());
        }
    }

    public int getInputDate() {
        return inputDate;
    }
}
