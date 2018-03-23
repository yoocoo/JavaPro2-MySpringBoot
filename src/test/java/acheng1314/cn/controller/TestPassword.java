package acheng1314.cn.controller;

import acheng1314.cn.util.EncryptUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.rowset.Predicate;
import java.time.LocalDateTime;
import java.time.Month;

//通过单元测试来验证BlogProperties中的属性是否已经根据配置文件加载了。
//@RunWith(SpringJUnit4ClassRunner.class)

public class TestPassword {
    @Test
    public void getPassword() throws Exception {
        String userPass = "123456";
        Integer date = 123123123;
        String encryptPassword = EncryptUtils.encryptPassword(userPass, date.toString());
        System.out.println("PrintTest:" + encryptPassword);
    }

    public static void main(String[] args) {

        LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
        System.out.println("PrintTest1:" + sylvester);

        String userPass = "123456";
        userPass = userPass.toLowerCase();  //将大写md5转换为小写md5
        if (userPass.length() > 16 && userPass.length() == 32) {    //32位小写转换为16位小写
            userPass = userPass.substring(8, 24).toLowerCase();
        }
        Integer date = 123123123;
        String encryptPassword = EncryptUtils.encryptPassword(userPass, date.toString());

        System.out.println("PrintTest:" + encryptPassword);
    }
}
