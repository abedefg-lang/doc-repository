package pers.tom.docwarehouse.controller.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import pers.tom.docwarehouse.annotation.ApiAuthentication;
import pers.tom.docwarehouse.annotation.PackagingResponse;
import pers.tom.docwarehouse.model.dto.ModuleDto;
import pers.tom.docwarehouse.model.dto.base.BaseResult;
import pers.tom.docwarehouse.model.dto.base.PageResult;
import pers.tom.docwarehouse.model.entity.Module;
import pers.tom.docwarehouse.model.param.ModuleParam;
import pers.tom.docwarehouse.model.param.base.PageParam;
import pers.tom.docwarehouse.model.query.ModuleQuery;
import pers.tom.docwarehouse.service.ModuleService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author tom
 * @description
 * @date 2021/1/30 15:46
 */
@RestController
@RequestMapping("/api/modules")
@Api(tags = "模块管理")
@PackagingResponse
@ApiAuthentication
public class ModuleController {

    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @PostMapping
    @ApiOperation("创建模块")
    public Module createModule(@RequestBody @Valid ModuleParam module){

        return moduleService.createModule(module);
    }

    @GetMapping("/{moduleId}")
    @ApiOperation("获取单个模块信息")
    public ModuleDto getOne(@PathVariable("moduleId") Long moduleId){

        return moduleService.convertTo(moduleService.getById(moduleId));
    }

    @DeleteMapping("/{moduleId}")
    @ApiOperation("删除单个模块")
    public BaseResult<Boolean> deleteOne(@PathVariable("moduleId") Long moduleId){

        return BaseResult.ok(moduleService.removeById(moduleId));
    }

    @GetMapping("/listBy")
    @ApiOperation("条件查询模块数据")
    public List<ModuleDto> listBy(ModuleQuery moduleQuery){

        return moduleService.converterList(moduleService.list(moduleQuery.toQueryWrapper()));
    }

    @GetMapping("/pageBy")
    @ApiModelProperty("分页查询模块数据")
    public PageResult<ModuleDto> pageBy(ModuleQuery moduleQuery,
                                        @Valid PageParam pageParam){

        Page<Module> page = new Page<>(pageParam.getPage(), pageParam.getPageSize(), pageParam.getSearchTotal());
        moduleService.page(page, moduleQuery.toQueryWrapper());

        return PageResult.fromIPage(page, moduleService::convertTo);
    }

}
