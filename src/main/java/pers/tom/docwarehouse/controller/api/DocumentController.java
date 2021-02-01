package pers.tom.docwarehouse.controller.api;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.tom.docwarehouse.annotation.ApiAuthentication;
import pers.tom.docwarehouse.annotation.PackagingResponse;

/**
 * @author tom
 * @description 文档controller
 * @date 2021/2/2 0:34
 */
@Api(tags = "文档管理")
@RequestMapping("/api/documents")
@RestController
@ApiAuthentication
@PackagingResponse
public class DocumentController {
}
