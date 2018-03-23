package acheng1314.cn.controller.api;

import acheng1314.cn.domain.ResponseCode;
import acheng1314.cn.domain.User;
import acheng1314.cn.service.UserServiceImpl;
import acheng1314.cn.util.GsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 数据接口的使用
 */
@Api(description = "后台获取用户信息的API接口，需要用户登录权限！")
@RestController
@RequestMapping("/endSys/api/user")
public class SysUserApi {
    @Autowired
    private UserServiceImpl userService;

    @ApiOperation(value = "获取用户信息的集合", notes = "用户信息分页查询")
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object getGoodsList() {
        List<User> userList = userService.selectList();
        if (null != userList && userList.isEmpty()) return GsonUtils.toJsonObjStr(null, ResponseCode.EMPTY, null);
        return GsonUtils.toJsonObjStr(userList, ResponseCode.OK, "获取数据成功!");
    }
/**
 * 教程资料：
 * 常见swagger注解一览与使用
 *最常用的5个注解
 * @Api：修饰整个类，描述Controller的作用
 * @ApiOperation：描述一个类的一个方法，或者说一个接口
 * @ApiParam：单个参数描述
 * @ApiParams:多个参数描述
 * @ApiModel：用对象来接收参数
 * @ApiProperty：用对象接收参数时，描述对象的一个字段
 *
 * 例子：
        @ApiParam(value = "token", required = true) @RequestParam String token
        Web前端/移动端HTTP请求方式：直接把参数附带到URL后面，或者用AJAX方法，表单提交。
 */

}
