package acheng1314.cn.controller;

import acheng1314.cn.dao.MenuDaoTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class MenuControllerTest {
    @Autowired
    private  MenuDaoTest menuDaoTest;

    @Test
    public void test() throws Exception {

        // 创建三个User，并验证User总数
        menuDaoTest.findAll();
        //menuDaoTest.save(new MenuTest(1L, "didi"));
        //menuDaoTest.save(new MenuTest(2L, "mama"));
        //menuDaoTest.save(new MenuTest(3L, "kaka"));
        //Assert.assertEquals(3, menuDaoTest.findAll().size());

        // 删除一个User，再验证User总数
        //MenuTest u = menuDaoTest.findOne(1L);
        //menuDaoTest.delete(u);
        //Assert.assertEquals(2, menuDaoTest.findAll().size());

        // 删除一个User，再验证User总数
        menuDaoTest.findAll();
         //System.out.println("PrintTest:"+menuDaoTest.findAll());
        //assertEquals(3, menuDaoTest.findAll().);
        //Assert.assertEquals(3, menuDaoTest.findAll().);
        //Assert.assertEquals(3, new MenuControllerTest().test());

    }


}
