package pers.tom.docwarehouse.security;

/**
 * @author tom
 * @description
 * @date 2021/2/2 22:59
 */
public class SecurityInfo {

    public static final String IDENTITY_NAME = "identity";

    public static final String IDENTITY_INFO_NAME = "identityInfo";

    /**身份的唯一标识符*/
    private final Long identity;

    /**身份信息 */
    private final String identityInfo;


    public SecurityInfo(Long identity, String identityInfo){
        this.identity = identity;
        this.identityInfo = identityInfo;
    }

    public Long getIdentity() {
        return identity;
    }

    public String getIdentityInfo() {
        return identityInfo;
    }
}
