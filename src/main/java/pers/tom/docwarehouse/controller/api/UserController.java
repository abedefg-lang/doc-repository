package pers.tom.docwarehouse.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.tom.docwarehouse.annotation.ApiAuthentication;
import pers.tom.docwarehouse.annotation.PackagingResponse;
import pers.tom.docwarehouse.model.dto.UserDto;
import pers.tom.docwarehouse.model.param.LoginParam;
import pers.tom.docwarehouse.security.SecurityConstant;
import pers.tom.docwarehouse.security.UserInfo;
import pers.tom.docwarehouse.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


/**
 * @author lijia
 * @description user controller
 * @date 2021-01-29 13:35
 */
@RestController
@RequestMapping("/api/users")
@Api(tags = "用户管理")
@PackagingResponse
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    @ApiOperation("登录")
    public UserDto login(@RequestBody @Valid LoginParam loginParam,
                         HttpSession session){

        UserDto user = userService.login(loginParam);

        //添加到session中
        UserInfo userInfo = new UserInfo(user.getUserId(), user.getUsername(), user.getLastLoginTime());
        session.setAttribute(SecurityConstant.USER_INFO_SESSION_KEY, userInfo);
        session.setMaxInactiveInterval(SecurityConstant.USER_LOGIN_EXPIRATION_TIME);

        return user;
    }


    @PostMapping("/logout")
    @ApiOperation("登出")
    @ApiAuthentication
    public void logout(HttpSession session){
        session.removeAttribute(SecurityConstant.USER_INFO_SESSION_KEY);
        userService.logout();
    }

}
