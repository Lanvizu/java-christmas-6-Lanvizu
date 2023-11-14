package christmas.domain.service;

import christmas.domain.Badge;
import christmas.domain.TotalManage;
import christmas.global.utils.constant.ConsoleType;
import christmas.global.utils.view.OutputView;

public class BadgeService {
    public void outputBadge(TotalManage totalManage) {
        OutputView.commonOutputLine(ConsoleType.OUTPUT_EVENT_BADGE.getcomment());
        int totalOfDiscount = totalManage.getTotalOfDiscount();
        Badge badge = new Badge(totalOfDiscount);
        OutputView.commonOutputLine(badge.getBadgeType().getBadge());
    }
}