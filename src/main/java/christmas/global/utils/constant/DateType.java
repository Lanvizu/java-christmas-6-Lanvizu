package christmas.global.utils.constant;

import java.util.Arrays;
import java.util.List;

public enum DateType {

    DATE_OF_START(1),
    DATE_OF_END(31),
    DATE_OF_EVENT_END(25),
    DATE_OF_WEEKEND(Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30)),
    DATE_OF_SPECIAL(Arrays.asList(3, 10, 17, 24, 25, 31));

    private final List<Integer> dates;

    DateType(int date) {
        this.dates = List.of(date);
    }

    DateType(List<Integer> dates) {
        this.dates = dates;
    }

    public List<Integer> getDates() {
        return dates;
    }

    public int getDate() {
        return dates.get(0);
    }
}
