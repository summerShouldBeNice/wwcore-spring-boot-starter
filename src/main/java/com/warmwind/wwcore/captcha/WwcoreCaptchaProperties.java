package com.warmwind.wwcore.captcha;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author warmwind
 * @createTime 2024-03-05 18:31
 */
@ConfigurationProperties(prefix = "wwcore.captcha")
public class WwcoreCaptchaProperties {

    private boolean enable;

    private String type = "png";

    private int width = 200;

    private int height = 40;

    private int expire = 60;

    private boolean cache = false;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public boolean isCache() {
        return cache;
    }

    public void setCache(boolean cache) {
        this.cache = cache;
    }

    @Override
    public String toString() {
        return "WwcoreCaptchaProperties{" +
                "enable=" + enable +
                ", type='" + type + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", expire=" + expire +
                ", cache=" + cache +
                '}';
    }
}
