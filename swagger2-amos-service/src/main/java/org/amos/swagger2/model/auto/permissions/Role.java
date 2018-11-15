package org.amos.swagger2.model.auto.permissions;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Role implements Serializable {
    /**
     * 自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 是否禁用（0：正常、1：禁用）
     */
    @Column(name = "is_disable")
    private Byte isDisable;

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
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
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
        sb.append(", name=").append(name);
        sb.append(", remarks=").append(remarks);
        sb.append(", isDisable=").append(isDisable);
        sb.append(", creator=").append(creator);
        sb.append(", operator=").append(operator);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifedTime=").append(modifedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}