package acheng1314.cn.domain;

import org.springframework.data.annotation.Id;

public class Menu {
    private static final long serialVersionUID = -3258839839160856613L;
    private String menu;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}
