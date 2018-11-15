package org.amos.swagger2.model.auto.permissions;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Permissions implements Serializable {
    /**
     * 自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 中文简体权限名
     */
    @Column(name = "zh_cn_name")
    private String zhCnName;

    /**
     * 中文繁体权限名
     */
    @Column(name = "zh_hk_name")
    private String zhHkName;

    /**
     * 英文权限名
     */
    @Column(name = "en_name")
    private String enName;

    /**
     * 权限名
     */
    @Column(name = "permissions_name")
    private String permissionsName;

    /**
     * 图标
     */
    private String icon;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 访问地址
     */
    private String url;

    /**
     * 父级菜单ID,-1代表一级菜单
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 是否禁用（0：正常、1：禁用）
     */
    @Column(name = "is_disable")
    private Byte isDisable;

    /**
     * 优先级
     */
    private Byte priority;

    /**
     * 1：该权限是permissions,2:该权限是controller
     */
    @Column(name = "pms_or_ctl")
    private String pmsOrCtl;

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
     * 获取中文简体权限名
     *
     * @return zh_cn_name - 中文简体权限名
     */
    public String getZhCnName() {
        return zhCnName;
    }

    /**
     * 设置中文简体权限名
     *
     * @param zhCnName 中文简体权限名
     */
    public void setZhCnName(String zhCnName) {
        this.zhCnName = zhCnName;
    }

    /**
     * 获取中文繁体权限名
     *
     * @return zh_hk_name - 中文繁体权限名
     */
    public String getZhHkName() {
        return zhHkName;
    }

    /**
     * 设置中文繁体权限名
     *
     * @param zhHkName 中文繁体权限名
     */
    public void setZhHkName(String zhHkName) {
        this.zhHkName = zhHkName;
    }

    /**
     * 获取英文权限名
     *
     * @return en_name - 英文权限名
     */
    public String getEnName() {
        return enName;
    }

    /**
     * 设置英文权限名
     *
     * @param enName 英文权限名
     */
    public void setEnName(String enName) {
        this.enName = enName;
    }

    /**
     * 获取权限名
     *
     * @return permissions_name - 权限名
     */
    public String getPermissionsName() {
        return permissionsName;
    }

    /**
     * 设置权限名
     *
     * @param permissionsName 权限名
     */
    public void setPermissionsName(String permissionsName) {
        this.permissionsName = permissionsName;
    }

    /**
     * 获取图标
     *
     * @return icon - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取备注
     *
     * @return remarks - 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取访问地址
     *
     * @return url - 访问地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置访问地址
     *
     * @param url 访问地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取父级菜单ID,-1代表一级菜单
     *
     * @return parent_id - 父级菜单ID,-1代表一级菜单
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父级菜单ID,-1代表一级菜单
     *
     * @param parentId 父级菜单ID,-1代表一级菜单
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取是否禁用（0：正常、1：禁用）
     *
     * @return is_disable - 是否禁用（0：正常、1：禁用）
     */
    public Byte getIsDisable() {
        return isDisable;
    }

    /**
     * 设置是否禁用（0：正常、1：禁用）
     *
     * @param isDisable 是否禁用（0：正常、1：禁用）
     */
    public void setIsDisable(Byte isDisable) {
        this.isDisable = isDisable;
    }

    /**
     * 获取优先级
     *
     * @return priority - 优先级
     */
    public Byte getPriority() {
        return priority;
    }

    /**
     * 设置优先级
     *
     * @param priority 优先级
     */
    public void setPriority(Byte priority) {
        this.priority = priority;
    }

    /**
     * 获取1：该权限是permissions,2:该权限是controller
     *
     * @return pms_or_ctl - 1：该权限是permissions,2:该权限是controller
     */
    public String getPmsOrCtl() {
        return pmsOrCtl;
    }

    /**
     * 设置1：该权限是permissions,2:该权限是controller
     *
     * @param pmsOrCtl 1：该权限是permissions,2:该权限是controller
     */
    public void setPmsOrCtl(String pmsOrCtl) {
        this.pmsOrCtl = pmsOrCtl;
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
        sb.append(", zhCnName=").append(zhCnName);
        sb.append(", zhHkName=").append(zhHkName);
        sb.append(", enName=").append(enName);
        sb.append(", permissionsName=").append(permissionsName);
        sb.append(", icon=").append(icon);
        sb.append(", remarks=").append(remarks);
        sb.append(", url=").append(url);
        sb.append(", parentId=").append(parentId);
        sb.append(", isDisable=").append(isDisable);
        sb.append(", priority=").append(priority);
        sb.append(", pmsOrCtl=").append(pmsOrCtl);
        sb.append(", creator=").append(creator);
        sb.append(", operator=").append(operator);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifedTime=").append(modifedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}