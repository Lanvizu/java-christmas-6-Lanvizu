package christmas.domain.controller;

import christmas.domain.Date;
import christmas.domain.MenuList;
import christmas.domain.TotalManage;
import christmas.domain.service.BadgeService;
import christmas.domain.service.ClientService;
import christmas.domain.service.DiscountService;
import christmas.domain.service.MenuService;

public class ChristmasController {
    private final ClientService clientService;
    private final MenuService menuService;
    private final DiscountService discountService;
    private final BadgeService badgeService;

    public ChristmasController(ClientService clientService, MenuService menuService,
                               DiscountService discountService, BadgeService badgeService) {
        this.clientService = clientService;
        this.menuService = menuService;
        this.discountService = discountService;
        this.badgeService = badgeService;
    }

    public void run() {
        Date inputDate = clientService.getInputDate();
        MenuList menuList = clientService.getInputMenu();
        menuService.outputTotalMenuPart(inputDate, menuList);
        TotalManage totalManage = discountService.outputTotalDiscountPart(inputDate, menuList);
        badgeService.outputBadge(totalManage);
    }
}