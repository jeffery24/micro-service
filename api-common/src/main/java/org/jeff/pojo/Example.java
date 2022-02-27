package org.jeff.pojo;

import java.util.StringJoiner;

/**
 * 示例测试模型
 *
 * @author jeff
 * @since 1.0.0
 */
public class Example {

    /**
     * 用户名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 电话号码
     */
    private Integer phone;
    /**
     * 会被脱敏的字段
     */
    private String ignoreFiled;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getIgnoreFiled() {
        return ignoreFiled;
    }

    public void setIgnoreFiled(String ignoreFiled) {
        this.ignoreFiled = ignoreFiled;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Example.class.getSimpleName() + "[", "]")
                .add("username='" + username + "'")
                .add("nickname='" + nickname + "'")
                .add("phone=" + phone)
                .add("ignoreFiled='" + ignoreFiled + "'")
                .toString();
    }
}
