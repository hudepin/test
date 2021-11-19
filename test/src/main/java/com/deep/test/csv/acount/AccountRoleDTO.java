package com.deep.test.csv.acount;

/**
 * @author <a href="mailto:depin.hu@bl.com">hudepin</a>
 * @Description <p></p>
 * @ClassName AccountRoleDTO
 * @create_date 2021.08.16 11:11
 * @since
 */
public class AccountRoleDTO {
    private Long accountId;
    private Long roleId;

    public AccountRoleDTO() {
    }

    public AccountRoleDTO(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
