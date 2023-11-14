package christmas;

import christmas.domain.controller.ChristmasController;
import christmas.domain.service.BadgeService;
import christmas.domain.service.ClientService;
import christmas.domain.service.DiscountService;
import christmas.domain.service.MenuService;

public class Application {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        MenuService menuService = new MenuService();
        DiscountService discountService = new DiscountService();
        BadgeService badgeService = new BadgeService();
        ChristmasController christmasController = new ChristmasController(clientService, menuService, discountService, badgeService);
        christmasController.run();
    }
}
