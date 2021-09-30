package ua.com.alevel.cmd;


public class Menu{

    private Menu(){
        System.out.println("it`s mapper class!");
    }

    public static void showMainMenu(){
        System.out.println(AppMessages.HORIZONTAL_BORDER
                + AppMessages.VERTICAL_BORDER
                + AppMessages.WELCOMING
                + AppMessages.MAIN_DESCRIPTION
                + AppMessages.STOP_PROGRAM
                + AppMessages.VERTICAL_BORDER
                + AppMessages.HORIZONTAL_BORDER);
    }

    public static void showMenuItems(){
        StringBuilder menuBuilder = new StringBuilder();
        menuBuilder.append(AppMessages.HORIZONTAL_BORDER);
        for(int i = 0; i < AppMessages.getMenuList().size(); i++){
            menuBuilder.append(AppMessages.getMenuList().get(i));
        }
        menuBuilder.append(AppMessages.ASK_TO_QUIT_BY_0)
                .append(AppMessages.HORIZONTAL_BORDER);
        System.out.println(menuBuilder);
    }
}