package christmas.global.utils.constant;

public enum ConsoleType {

    EMPTY(""),
    COUNT("개"),
    WON("원"),
    NONE("없음"),
    DISCOUNT("-"),
    INPUT_DATE_OF_VISIT("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n" +
            "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    INPUT_MENU_AND_COUNT("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    OUTPUT_EVENT_PREVIEW("12월 %s일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    OUTPUT_MENU_OF_ORDER("\n<주문 메뉴>"),
    OUTPUT_TOTAL_OF_ORDER_BEFORE_DISCOUNT("\n<할인 전 총주문 금액>"),
    OUTPUT_MENU_OF_EVENT("\n<증정 메뉴>"),
    OUTPUT_LIST_OF_DISCOUNT("\n<혜택 내역>"),
    OUTPUT_CHRISTMAS_DISCOUNT("크리스마스 디데이 할인: -%s원"),
    OUTPUT_WEEKDAY_DISCOUNT("평일 할인: -%s원"),
    OUTPUT_WEEKEND_DISCOUNT("주말 할인: -%s원"),
    OUTPUT_SPECIAL_DISCOUNT("특별 할인: -%s원"),
    OUTPUT_EVENT_DISCOUNT("증정 이벤트: -%s원"),
    OUTPUT_TOTAL_OF_DISCOUNT("\n<총혜택 금액>"),
    OUTPUT_DISCOUNT("-%s원"),
    OUTPUT_TOTAL("%s원"),
    OUTPUT_TOTAL_OF_AFTER_DISCOUNT("\n<할인 후 예상 결제 금액>"),
    OUTPUT_EVENT_BADGE("\n<12월 이벤트 배지>"),
    EXCEPTION_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    EXCEPTION_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String comment;

    ConsoleType(final String comment) {
        this.comment = comment;
    }

    public String getcomment() {
        return comment;
    }

    public String getComment(int input) {
        return String.format(comment, input);
    }
}
