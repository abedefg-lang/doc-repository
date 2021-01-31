package pers.tom.docwarehouse.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.tom.docwarehouse.security.UserInfo;
import pers.tom.docwarehouse.security.UserInfoHolder;

/**
 * @author lijia
 * @description 操作日志
 * @date 2021-01-31 14:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("operation_log")
public class OperationLog {

    @TableId(value = "operation_log_id", type = IdType.AUTO)
    private Long operationLogId;

    @TableField("operator")
    private String operator;

    @TableField("info")
    private String info;

    @TableField("type")
    private String type;

    @TableField("operation_time")
    private Long operationTime;


    public OperationLog(String type, String info){
        this.type = type;
        this.info = info;
        this.operationTime = System.currentTimeMillis();
        UserInfo userInfo = UserInfoHolder.getUserInfo();
        if(userInfo != null){
            operator = userInfo.getUsername();
        }
    }
}
