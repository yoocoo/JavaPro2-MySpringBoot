package acheng1314.cn.shiro;

import acheng1314.cn.domain.User;
import acheng1314.cn.service.UserServiceImpl;
import acheng1314.cn.util.LogE;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * author by 程 2016/11/25
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserServiceImpl userService;

    /*
     * 登录信息和用户验证信息验证(non-Javadoc)
     * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken user = (UsernamePasswordToken) token;
        LogE.getInstance(ShiroRealm.class).logOutLittle("开始登录====>\n用户为：" + user.getUsername());

        String userLogin = user.getUsername();
        char[] password = user.getPassword();

        User loginResult = null;
        try {
            loginResult = userService.login(userLogin, new String(password));
        } catch (Exception e) {
            e.printStackTrace();
            LogE.getInstance(ShiroRealm.class).logOutLittle("登录异常结束====>\n用户为：" + user.getUsername());
            throw new AuthenticationException(e.getMessage());
        }
        LogE.getInstance(ShiroRealm.class).logOutLittle("登录成功====>\n用户为：" + user.getUsername());
        return new SimpleAuthenticationInfo(loginResult, user.getPassword(), this.getName());
//        User result4Find;
//
//        try {
//            result4Find = userService.findOneById(userLogin);
//        } catch (NotFoundException e) {
//            throw new AuthenticationException(e.getMessage());
//        }
//        return new SimpleAuthenticationInfo(result4Find, result4Find.getUserPass(), this.getName());

    }

    /*
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法(non-Javadoc)
     * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {

        User result4Find = (User) pc.asList().get(0);

        SimpleAuthorizationInfo perList = new SimpleAuthorizationInfo();
//        try {
//            if (result4Find.getUserActivationKey().equals("admin"))
//                perList.addStringPermissions(PermissionUtil.getAdminPer());
//            else perList.addStringPermissions(PermissionUtil.getOtherPer());
//        } catch (Exception e) {
//            e.printStackTrace();
//            perList.addStringPermissions(PermissionUtil.getOtherPer());
//        }
        return perList;
    }

}

/**
 * 学习资料------Shiro：
 * Apache.shrio 1.3.2
 * <p>
 * (一)Shiro能做什么：
 * 1.验证用户身份
 * 2.用户访问权限控制，比如：1、判断用户是否分配了一定的安全角色。2、判断用户是否被授予完成某个操作的权限
 * 3.在非 web 或 EJB 容器的环境下可以任意使用Session API
 * 4.可以响应认证、访问控制，或者 Session 生命周期中发生的事件
 * 5.可将一个或以上用户安全数据源数据组合成一个复合的用户 “view”(视图)
 * 6.支持单点登录(SSO)功能
 * 7.支持提供“Remember Me”服务，获取用户关联信息而无需登录
 * 8.等等——都集成到一个有凝聚力的易于使用的API。
 * （二）Shiro 框架有什么：
 * 1.Authentication（认证）：用户身份识别，通常被称为用户“登录”
 * 2.Authorization（授权）：访问控制。比如某个用户是否具有某个操作的使用权限。
 * 3.Session Management（会话管理）：特定于用户的会话管理,甚至在非web 或 EJB 应用程序。
 * 4.Cryptography（加密）：在对数据源使用加密算法加密的同时，保证易于使用。
 */