package com.warmwind.wwcore.core.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author warmwind
 * @createTime 2024-03-02 14:48
 */
public class VerifyCode {

    /**
     * 验证码key
     */
    private String key;

    /**
     * 验证码base64编码
     */
    private String image;

    /**
     * 验证码文本值
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String text;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
