package pers.tom.docrepository.controller.api;

import io.swagger.annotations.Api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.tom.docrepository.service.UserService;

/**
 * @author lijia
 * @description user controller
 * @date 2021-01-29 13:35
 */
@RestController
@RequestMapping("/api/users")
@Api(tags = "用户管理")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


}
