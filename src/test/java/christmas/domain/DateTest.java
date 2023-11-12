package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class DateTest {

    @DisplayName("31초과 날짜를 입력하면 에러가 발생한다.")
    @Test
    void should_fail_when_hasOverThan31() {
        assertThatThrownBy(() -> new Date(32))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1미만 날짜를 입력하면 에러가 발생한다.")
    @Test
    void should_fail_when_hasLessThan1() {
        assertThatThrownBy(() -> new Date(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

}