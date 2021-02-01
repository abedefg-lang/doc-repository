package pers.tom.docwarehouse.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.tom.docwarehouse.annotation.PackagingResponse;
import pers.tom.docwarehouse.model.param.LoginParam;
import pers.tom.docwarehouse.model.dto.AuthUser;
import pers.tom.docwarehouse.service.UserService;

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
    public AuthUser login(@RequestBody @Valid LoginParam loginParam){

        return userService.login(loginParam);
    }


}
