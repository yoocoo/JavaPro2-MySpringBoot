package acheng1314.cn.service;

import acheng1314.cn.dao.UserDao;
import acheng1314.cn.domain.User;
import acheng1314.cn.exception.EnterInfoErrorException;
import acheng1314.cn.exception.NotFoundException;
import acheng1314.cn.util.CipherUtils;
import acheng1314.cn.util.DateUtil;
import acheng1314.cn.util.EncryptUtils;
import acheng1314.cn.util.StringUtils;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by pc on 2017/8/11.
 */
@Service("userService")
@Aspect
//  Spring只支持XML方式而没有实现注解的方式（也叫AspectJ方式）的AOP，
// 所以要使用@Aspect注解，
// 只能引入AspectJ相关的 jar 包 aopalliance-1.0.jar 和 aspectjweaver.jar。
//@Pointcut()
public class UserServiceImpl extends ServiceImpl<UserDao, User> {

    @Transactional
    public void addOneUser(User entity) throws Exception {
        if (StringUtils.isEmpty(entity.getLoginName(), entity.getPassword()))
            throw new Exception("用户名或密码不能为空！");
        //创建插入时间
        Integer createTime = DateUtil.getIntTime();
        entity.setCreateDate(createTime);
        //MD5密码加盐后再sha256加密
        entity.setPassword(EncryptUtils.encryptPassword(entity.getPassword().toLowerCase()
                , createTime.toString()));
        entity.setUsed(true);   //默认可用
        baseMapper.addUser(entity);
    }

    @Transactional
    public User login(String userLogin, String userPass) throws EnterInfoErrorException, NotFoundException {
        if (StringUtils.isEmpty(userLogin) || StringUtils.isEmpty(userPass)) {
            throw new EnterInfoErrorException("用户名和密码不能为空！请检查！");
        }
        User result = null;
        result = findOneById(userLogin);
        if (null == result) throw new NotFoundException("用户未找到！");
        if (!result.isUsed()) throw new EnterInfoErrorException("用户禁止登陆！");
        try {
            userPass = userPass.toLowerCase();  //将大写md5转换为小写md5
            if (userPass.length() > 16 && userPass.length() == 32) {    //32位小写转换为16位小写
                userPass = userPass.substring(8, 24).toLowerCase();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new EnterInfoErrorException("密码错误！");
        }

        String encryptPassword = EncryptUtils.encryptPassword(userPass, result.getCreateDate().toString());
        if (!encryptPassword.equals(result.getPassword())) {
            throw new EnterInfoErrorException("用户名和密码不匹配！");
        }
        return result;
    }

    @Transactional
    public User findOneById(String userLogin) {
        return baseMapper.findOneByKey(userLogin);
    }

    public List<User> selectList() {
        return baseMapper.findAll();
    }

    public void delUser(String loginName) {
        baseMapper.delUser(loginName);
    }

    public User findOneByLoginName(String loginName) {
        return baseMapper.findOneByKey(loginName);
    }

    @Transactional
    public void updateUser(User user) throws Exception {
        User tmpSwap = findOneByLoginName(user.getLoginName());
        int notDo = 0;
        //交换昵称
        if (!StringUtils.isEmpty(user.getName())
                || !tmpSwap.getName().equals(user.getName())) tmpSwap.setName(user.getName());
        else notDo++;
        //交换职务
        if (!StringUtils.isEmpty(user.getDuty())
                || !tmpSwap.getDuty().equals(user.getDuty())) tmpSwap.setDuty(user.getDuty());
        else notDo++;
        //交换密码
        if (!StringUtils.isEmpty(user.getPassword())) {
            //32位小写转换为16位小写
            if (user.getPassword().length() > 16 && user.getPassword().length() == 32) {
                user.setPassword(user.getPassword()
                        .substring(8, 24)
                        .toLowerCase());
            }
            tmpSwap.setPassword(EncryptUtils.encryptPassword(user.getPassword().toLowerCase()
                    , tmpSwap.getCreateDate().toString()));
        } else notDo++;
        //交换可否使用
        if (user.isUsed() == tmpSwap.isUsed()) notDo++;

        if (notDo == 4) throw new Exception("什么都没做！不需要更新哦！");

        tmpSwap.setUsed(user.isUsed());

        baseMapper.updateById(tmpSwap);
    }
}
