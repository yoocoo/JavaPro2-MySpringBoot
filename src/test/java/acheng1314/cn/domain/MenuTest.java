package acheng1314.cn.domain;

import org.springframework.data.annotation.Id;

public class MenuTest {
    @Id
    private Long id;
    private String menu;

    public MenuTest(Long id, String menu) {
        this.id = id;
        this.menu = menu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}
