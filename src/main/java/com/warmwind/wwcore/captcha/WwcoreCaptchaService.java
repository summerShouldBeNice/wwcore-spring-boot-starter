package com.warmwind.wwcore.captcha;

import com.warmwind.wwcore.core.constants.CaptchaConstants;
import com.warmwind.wwcore.core.constants.RedisConstants;
import com.warmwind.wwcore.core.domain.AjaxResult;
import com.warmwind.wwcore.core.enums.CreateMode;
import com.warmwind.wwcore.core.utils.RandomUtils;
import com.warmwind.wwcore.redis.WwcoreRedisCache;
import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.ChineseCaptcha;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.SpecCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.warmwind.wwcore.core.constants.CaptchaConstants.CAPTCHA_BASE64;
import static com.warmwind.wwcore.core.constants.CaptchaConstants.CAPTCHA_TEXT;
import static com.warmwind.wwcore.core.constants.RedisConstants.CAPTCHA;

/**
 * @author warmwind
 * @createTime 2024-03-05 18:32
 */
@Service
public class WwcoreCaptchaService {

    @Autowired
    private WwcoreRedisCache redisCache;

    Map<String, String> captchaInfo = new HashMap<>();

    private WwcoreCaptchaProperties wwcoreCaptchaProperties;

    public WwcoreCaptchaProperties getWwcoreCaptchaProperties() {
        return wwcoreCaptchaProperties;
    }

    public void setWwcoreCaptchaProperties(WwcoreCaptchaProperties wwcoreCaptchaProperties) {
        this.wwcoreCaptchaProperties = wwcoreCaptchaProperties;
    }

    public AjaxResult getCode() {
        AjaxResult ajaxResult = new AjaxResult();
        boolean isEnable = wwcoreCaptchaProperties.isEnable();
        ajaxResult.put("captchaEnable", isEnable);
        if (!isEnable) {
            return ajaxResult;
        }
        int width = wwcoreCaptchaProperties.getWidth();
        int height = wwcoreCaptchaProperties.getHeight();
        switch (wwcoreCaptchaProperties.getType()){
            case "png" -> getPngCaptcha(width, height);
            case "gif" -> getGifCaptcha(width, height);
            case "chinese" -> getChineseCaptcha(width, height);
            case "arithmetic" -> getArithmeticCaptcha(width, height);
        }
        String captchaId = UUID.randomUUID() + "-" +RandomUtils.generateRandomStr(10, CreateMode.ALL);
        ajaxResult.put("captchaId", captchaId);
        ajaxResult.put("imageBase64", captchaInfo.get(CAPTCHA_BASE64));
        if (wwcoreCaptchaProperties.isCache()) {
            redisCache.setCacheObject(CAPTCHA + captchaId, captchaInfo.get(CAPTCHA_TEXT), wwcoreCaptchaProperties.getExpire(), TimeUnit.SECONDS);
        }
        return ajaxResult;
    }

    public Map<String, String> getPngCaptcha(int width, int height) {
        SpecCaptcha captcha = new SpecCaptcha(width, height);
        String text = captcha.text();
        captchaInfo.put(CAPTCHA_BASE64, captcha.toBase64());
        captchaInfo.put(CAPTCHA_TEXT, text);
        System.out.println("captcha:" + text);
        return captchaInfo;
    }

    public Map<String, String> getGifCaptcha(int width, int height) {
        GifCaptcha captcha = new GifCaptcha(width, height);
        String text = captcha.text();// 获取验证码的字符
        captchaInfo.put(CAPTCHA_BASE64, captcha.toBase64());
        captchaInfo.put(CAPTCHA_TEXT, text);
        System.out.println("captcha:" + text);
        return captchaInfo;
    }

    public Map<String, String> getChineseCaptcha(int width, int height) {
        ChineseCaptcha captcha = new ChineseCaptcha(width, height);
        String text = captcha.text();// 获取验证码的字符
        captchaInfo.put(CAPTCHA_BASE64, captcha.toBase64());
        captchaInfo.put(CAPTCHA_TEXT, text);
        System.out.println("captcha:" + text);
        return captchaInfo;
    }

    public Map<String, String> getArithmeticCaptcha(int width, int height) {
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(width, height);
        String text = captcha.text();// 获取验证码的字符
        captchaInfo.put(CAPTCHA_BASE64, captcha.toBase64());
        captchaInfo.put(CAPTCHA_TEXT, text);
        System.out.println("captcha:" + text);
        return captchaInfo;
    }


}
