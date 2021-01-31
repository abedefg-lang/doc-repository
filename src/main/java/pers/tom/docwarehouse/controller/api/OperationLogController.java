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
import pers.tom.docwarehouse.model.param.OperationLogQuery;
import pers.tom.docwarehouse.model.supports.PageParam;
import pers.tom.docwarehouse.model.supports.PageResult;
import pers.tom.docwarehouse.service.OperationLogService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author lijia
 * @description 操作日志
 * @date 2021-01-31 14:48
 */
@Api(tags = "操作日志管理")
@RestController
@RequestMapping("/api/logs")
@ApiAuthentication
@PackagingResponse
public class OperationLogController {


    private final OperationLogService operationLogService;

    public OperationLogController(OperationLogService operationLogService) {
        this.operationLogService = operationLogService;
    }

    @GetMapping("/pageBy")
    @ApiOperation("分页查询操作日志")
    public PageResult<OperationLogDto> pageBy(OperationLogQuery query,
                                              @Valid PageParam pageParam){

        return operationLogService.pageBy(query, pageParam);
    }


    @GetMapping("/recentLogs")
    @ApiOperation("获取最近的操作日志")
    public List<OperationLogDto> getRecentLog(@RequestParam(value = "count", defaultValue = "10") Integer count){

        return operationLogService.getRecentLogs(count);
    }




}
