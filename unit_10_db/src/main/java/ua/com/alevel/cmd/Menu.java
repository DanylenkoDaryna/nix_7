package ua.com.alevel.cmd;


public class Menu{

    private Menu(){
        System.out.println("it`s mapper class!");
    }

    public static void showMainMenu(){
        System.out.println(Messages10.HORIZONTAL_BORDER
                + Messages10.VERTICAL_BORDER
                + Messages10.WELCOMING
                + Messages10.MAIN_DESCRIPTION
                + Messages10.STOP_PROGRAM
                + Messages10.VERTICAL_BORDER
                + Messages10.HORIZONTAL_BORDER);
    }

    public static void showMenuItems(){
        StringBuilder menuBuilder = new StringBuilder();
        menuBuilder.append(Messages10.HORIZONTAL_BORDER);
        for(int i = 0; i < Messages10.getMenuList().size(); i++){
            menuBuilder.append(Messages10.getMenuList().get(i));
        }
        menuBuilder.append(Messages10.ASK_TO_QUIT_BY_0)
                .append(Messages10.HORIZONTAL_BORDER);
        System.out.println(menuBuilder);
    }
}