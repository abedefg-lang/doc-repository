package pers.tom.docwarehouse.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tom
 * @description user 信息
 * @date 2021/1/30 21:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecurityInfo {

    /**userId*/
    private Long userId;

    /**username*/
    private String username;

}
