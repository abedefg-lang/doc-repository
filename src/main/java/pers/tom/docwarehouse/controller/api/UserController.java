package pers.tom.docwarehouse.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import pers.tom.docwarehouse.annotation.ApiAuthentication;
import pers.tom.docwarehouse.annotation.PackagingResponse;
import pers.tom.docwarehouse.model.dto.AuthUser;
import pers.tom.docwarehouse.model.dto.UserDto;
import pers.tom.docwarehouse.model.param.LoginParam;
import pers.tom.docwarehouse.model.query.UserQuery;
import pers.tom.docwarehouse.model.supports.PageParam;
import pers.tom.docwarehouse.model.supports.PageResult;
import pers.tom.docwarehouse.service.UserService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author tom
 * @description
 * @date 2021/2/2 23:58
 */
@RestController
@RequestMapping("/api/users")
@Api(tags = "用户接口")
@PackagingResponse
//@CrossOrigin
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

    @GetMapping("/listBy")
    @ApiOperation("条件查询用户")
    @ApiAuthentication
    public List<UserDto> listBy(UserQuery userQuery){

        return userService.listBy(userQuery);
    }

    @GetMapping("/pageBy")
    @ApiOperation("分页查询用户信息")
    @ApiAuthentication
    public PageResult<UserDto> pageBy(UserQuery userQuery,
                                      @Valid PageParam pageParam){

        return userService.pageBy(userQuery, pageParam);
    }

}
