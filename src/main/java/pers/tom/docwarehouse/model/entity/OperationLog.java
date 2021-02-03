package pers.tom.docwarehouse.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.tom.docwarehouse.security.SecurityInfo;
import pers.tom.docwarehouse.security.SecurityInfoHolder;

import java.util.Date;

/**
 * @author tom
 * @description
 * @date 2021/2/2 23:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("operation_log")
public class OperationLog {

    @TableId(value = "operation_log_id", type = IdType.AUTO)
    private Long operationLogId;

    @TableField("info")
    private String info;

    @TableField("created_by")
    private String createdBy;

    @TableField("creator_id")
    private Long creatorId;

    @TableField("create_time")
    private Date createTime;


    public OperationLog(String info){

        this.info = info;

        //由于日志是异步写入 需要手动添加审记信息
        SecurityInfo securityInfo = SecurityInfoHolder.getSecurityInfo();
        this.createdBy = securityInfo == null ? "" : securityInfo.getIdentityInfo();
        this.creatorId = securityInfo == null ? -1L : securityInfo.getIdentity();
        this.createTime = new Date();

    }

}
