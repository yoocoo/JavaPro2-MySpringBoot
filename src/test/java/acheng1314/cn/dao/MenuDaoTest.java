package acheng1314.cn.dao;

import acheng1314.cn.BaseTest;
import acheng1314.cn.domain.Menu;
import acheng1314.cn.domain.MenuTest;
import acheng1314.cn.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MenuDaoTest extends BaseTest {
    @Autowired
    private MenuDao menuDao;
    @Test
   public  void findAll() throws Exception {
        List<Menu> all = menuDao.findAll();
        all.forEach(menu -> loge(menu.toString()));
    }
}
