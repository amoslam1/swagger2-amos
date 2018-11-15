package org.amos.swagger2.model.auto.permissions;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class User implements Serializable {
    /**
     * 随机32位
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐（随机数）
     */
    private String salt;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 名称
     */
    private String name;

    /**
     * 头像URL
     */
    @Column(name = "portrait_url")
    private String portraitUrl;

    /**
     * 是否禁用（0：正常、1：禁用）
     */
    @Column(name = "is_disable")
    private Byte isDisable;

    /**
     * 用户会话ID
     */
    @Column(name = "session_id")
    private String sessionId;

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
     * 获取随机32位
     *
     * @return id - 随机32位
     */
    public String getId() {
        return id;
    }

    /**
     * 设置随机32位
     *
     * @param id 随机32位
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取盐（随机数）
     *
     * @return salt - 盐（随机数）
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置盐（随机数）
     *
     * @param salt 盐（随机数）
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
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
     * 获取头像URL
     *
     * @return portrait_url - 头像URL
     */
    public String getPortraitUrl() {
        return portraitUrl;
    }

    /**
     * 设置头像URL
     *
     * @param portraitUrl 头像URL
     */
    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
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
     * 获取用户会话ID
     *
     * @return session_id - 用户会话ID
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * 设置用户会话ID
     *
     * @param sessionId 用户会话ID
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
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
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", salt=").append(salt);
        sb.append(", email=").append(email);
        sb.append(", name=").append(name);
        sb.append(", portraitUrl=").append(portraitUrl);
        sb.append(", isDisable=").append(isDisable);
        sb.append(", sessionId=").append(sessionId);
        sb.append(", creator=").append(creator);
        sb.append(", operator=").append(operator);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifedTime=").append(modifedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}