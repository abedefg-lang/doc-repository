package pers.tom.docwarehouse.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.tom.docwarehouse.annotation.ApiAuthentication;
import pers.tom.docwarehouse.annotation.PackagingResponse;
import pers.tom.docwarehouse.model.dto.OperationLogDto;
import pers.tom.docwarehouse.model.query.OperationLogQuery;
import pers.tom.docwarehouse.model.supports.PageParam;
import pers.tom.docwarehouse.model.supports.PageResult;
import pers.tom.docwarehouse.service.OperationLogService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author tom
 * @description 操作日志controller
 * @date 2021/2/3 22:18
 */
@RestController
@RequestMapping("/api/logs")
@Api(tags = "操作日志接口")
@ApiAuthentication
@PackagingResponse
public class OperationLogController {

    private final OperationLogService logService;

    public OperationLogController(OperationLogService logService) {
        this.logService = logService;
    }

    @GetMapping("/recentLog")
    @ApiOperation("查询最近的操作日志 默认10条")
    public List<OperationLogDto> getRecentLog(@RequestParam(value = "count", defaultValue = "10") Integer count){

        return logService.getRecentLog(count);
    }


    @GetMapping("/pageBy")
    @ApiOperation("分页查询操作日志")
    public PageResult<OperationLogDto> pageBy(OperationLogQuery logQuery,
                                              @Valid PageParam pageParam){

        return logService.pageBy(logQuery, pageParam);
    }
}
