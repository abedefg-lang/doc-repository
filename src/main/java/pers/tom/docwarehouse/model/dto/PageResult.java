package pers.tom.docwarehouse.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author tom
 * @description 分页查询结果
 * @date 2021/1/31 0:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class PageResult<T> {

    @ApiModelProperty("总数")
    private Integer total;

    @ApiModelProperty("查询结果")
    private List<T> list;


    public <U>PageResult<U> map(Function<T, U> function){
        PageResult<U> newPage = new PageResult<>();
        newPage.setTotal(total);
        List<U> newList = CollectionUtils.isEmpty(list) ? Collections.emptyList() : list.stream().map(function).collect(Collectors.toList());
        newPage.setList(newList);
        return newPage;
    }
}
