## auth: warmwind

### 个人整合简化个人在开发中常用的一些依赖组件并提供二次封装的工具类和自动配置

#### 整合了以下的依赖
- spring-boot-starter-web
- spring-boot-starter-data-redis
- fastjson2
- java-jwt
- pagehelper-spring-boot-starter
- commons-lang3
- javax.servlet-api
- easy-captcha
- nashorn-core

#### 项目结构
- core核心包，提供了starter的核心bean以及二次封装了各种工具类
- captcha，基于配置简化生成验证码和自动缓存，目前缓存只支持redis
- jwt，基于配置简化生成jwt
- redis， 提供了fastjson序列化器，lua限流脚本，二次封装了redisCache工具类
- oss，基于配置简化oss的上传和下载