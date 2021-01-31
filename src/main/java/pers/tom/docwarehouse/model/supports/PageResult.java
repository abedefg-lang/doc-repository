package pers.tom.docwarehouse.model.supports;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;
import pers.tom.docwarehouse.utils.CollectionUtils2;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

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
    private Long total;

    @ApiModelProperty("查询结果")
    private List<T> list;


    public static <S, T> PageResult<T> fromIPage(Page<S> page, Function<S, T> function){

        Assert.notNull(page, "page不能为null");
        Assert.notNull(function, "function不能为null");
        List<S> records = page.getRecords();
        List<T> list = CollectionUtils2.isEmpty(records) ? Collections.emptyList() : CollectionUtils2.transform(records, function);

        return new PageResult<>(page.getTotal(), list);
    }

}
