package com.zfx.community.entity;

import lombok.Data;

import java.util.Date;

/**
 * 
 * @author zfx
 * @TableName login_ticket
 */
@Data
public class LoginTicket {
    private Integer id;
    private Integer userId;
    private String ticket;

    /**
     * 0-有效; 1-无效;
     */
    private Integer status;

    /**
     * 过期时间
     */
    private Date expired;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", ticket=").append(ticket);
        sb.append(", status=").append(status);
        sb.append(", expired=").append(expired);
        sb.append("]");
        return sb.toString();
    }
}