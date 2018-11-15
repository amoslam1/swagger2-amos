package org.amos.swagger2.model.auto.permissions;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "role_permissions_rel")
public class RolePermissionsRel implements Serializable {
    /**
     * 自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户ID（用户表外键）
     */
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 权限ID（权限键）
     */
    @Column(name = "permissions_id")
    private Long permissionsId;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 修改者
     */
    private String operator;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 修改时间
     */
    @Column(name = "modifed_time")
    private Date modifedTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取自增
     *
     * @return id - 自增
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增
     *
     * @param id 自增
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户ID（用户表外键）
     *
     * @return role_id - 用户ID（用户表外键）
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置用户ID（用户表外键）
     *
     * @param roleId 用户ID（用户表外键）
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取权限ID（权限键）
     *
     * @return permissions_id - 权限ID（权限键）
     */
    public Long getPermissionsId() {
        return permissionsId;
    }

    /**
     * 设置权限ID（权限键）
     *
     * @param permissionsId 权限ID（权限键）
     */
    public void setPermissionsId(Long permissionsId) {
        this.permissionsId = permissionsId;
    }

    /**
     * 获取创建者
     *
     * @return creator - 创建者
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建者
     *
     * @param creator 创建者
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取修改者
     *
     * @return operator - 修改者
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 设置修改者
     *
     * @param operator 修改者
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * 获取创建时间
     *
     * @return created_time - 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取修改时间
     *
     * @return modifed_time - 修改时间
     */
    public Date getModifedTime() {
        return modifedTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifedTime 修改时间
     */
    public void setModifedTime(Date modifedTime) {
        this.modifedTime = modifedTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleId=").append(roleId);
        sb.append(", permissionsId=").append(permissionsId);
        sb.append(", creator=").append(creator);
        sb.append(", operator=").append(operator);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifedTime=").append(modifedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}