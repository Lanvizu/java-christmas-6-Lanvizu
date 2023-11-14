package christmas.domain;

public class TotalManage {

    private final int totalOfMenu;
    private ChristmasDiscount christmasDiscount;
    private WeekDiscount weekDiscount;
    private EventDiscount eventDiscount;
    private SpecialDiscount specialDiscount;
    private int totalOfDiscount;

    public TotalManage(Date inputDate, MenuList menuList) {
        this.totalOfMenu = getTotalOfMenu(menuList);
        getChristmasDiscount(inputDate);
        getWeekDiscount(inputDate, menuList);
        getSpecialDiscount(inputDate);
        getEventDiscount(totalOfMenu);
        getTotalOfDiscount(christmasDiscount, weekDiscount, eventDiscount, specialDiscount);
    }

    private void getEventDiscount(int totalOfMenu) {
        this.eventDiscount = new EventDiscount(totalOfMenu);
    }

    private void getSpecialDiscount(Date inputDate) {
        this.specialDiscount = new SpecialDiscount(inputDate);
    }

    private void getWeekDiscount(Date inputDate, MenuList menuList) {
        this.weekDiscount = new WeekDiscount(inputDate, menuList);
    }

    private void getChristmasDiscount(Date inputDate) {
        this.christmasDiscount = new ChristmasDiscount(inputDate);
    }

    private void getTotalOfDiscount(ChristmasDiscount christmasDiscount, WeekDiscount weekDiscount,
                                   EventDiscount eventDiscount, SpecialDiscount specialDiscount) {
        this.totalOfDiscount = christmasDiscount.getAmountOfDiscount() + weekDiscount.getAmountOfDiscount()
                + eventDiscount.getAmountOfDiscount() + specialDiscount.getAmountOfDiscount();
    }

    private int getTotalOfMenu(MenuList menuList) {
        return menuList.getMenuList().stream()
                .mapToInt(menu -> menu.getMenuPrice() * menu.getMenuCount())
                .sum();
    }

    public int getTotalOfMenu() {
        return totalOfMenu;
    }

    public int getTotalOfDiscount() {
        return totalOfDiscount;
    }

    public ChristmasDiscount getChristmasDiscount() {
        return christmasDiscount;
    }

    public EventDiscount getEventDiscount() {
        return eventDiscount;
    }

    public SpecialDiscount getSpecialDiscount() {
        return specialDiscount;
    }

    public WeekDiscount getWeekDiscount() {
        return weekDiscount;
    }
}
