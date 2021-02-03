package pers.tom.docwarehouse.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import pers.tom.docwarehouse.annotation.ApiAuthentication;
import pers.tom.docwarehouse.annotation.PackagingResponse;
import pers.tom.docwarehouse.model.dto.AuthUser;
import pers.tom.docwarehouse.model.param.LoginParam;
import pers.tom.docwarehouse.model.supports.BaseResult;
import pers.tom.docwarehouse.service.UserService;

import javax.validation.Valid;

/**
 * @author tom
 * @description
 * @date 2021/2/2 23:58
 */
@RestController
@RequestMapping("/api/users")
@Api(tags = "用户接口")
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

    @GetMapping("/test")
    @ApiAuthentication
    public BaseResult<String> testApi(@RequestParam("str") String str){
        return BaseResult.ok(str);
    }

}
