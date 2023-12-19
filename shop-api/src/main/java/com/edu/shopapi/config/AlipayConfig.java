package com.edu.shopapi.config;

import org.springframework.context.annotation.Configuration;

/**
 * @Author liufuping
 * @Date 2023/12/15 15:30
 * @Version 1.0
 */
@Configuration
public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "9021000132682781";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEuwIBADANBgkqhkiG9w0BAQEFAASCBKUwggShAgEAAoIBAQCehwtqdDnETf51MDvpZDXhYr2JxtHK20ffLzUHw35Po/h5zGLTQ5yFPgSozenApcTrjfQiMpHfOpkbtr33MYSu8fKs5YbuYMlKq/lepCFzqr75mPpyIAx6zJ/v0rSkgNlXx8gnXLUG0R9yvUVGgHAVoI8aNerp0JovEpiP25wpFtiQxSRrAeaBrnO8dd9XZmttK61gmA4agFZeq4gEY5Wxp1sX/vJelJzudzqXs1LdZscjb8luizQrtUx6q1BhAl1hvq48pZcqjF0sYpvVwlbdYwV01WA7giWv5CdYPSC+wIjurX2kZIGoar4lspnOh4KdU7MdLIsbpZOO0LDLZ9alAgMBAAECgf9wFQr9OS+em4ZNVM0HNtLhh+56exfZVTB7m+TimFW1+Ti05Mz6kdMYYcDpmKysiIeyA6uYgiigq82Uyp+FJn2pM2dg1uePot6u7OhjAailHxPnZUGtbvtj10k9RrxxkqgYaCgbrHBRYYnalfdk4Wpd4CdNYNG2fsaEgaFcFOlUIrE45BKlAoNTB4yidQFsqpzvUw4Fwffdyywb/u8pLugVlQooRHHNkIPoLrnOgev8458nbLUGr0GnFJrAQQ9vBYu4x5C7AUO7s7iVyBdEIbJ1vOvuu1EkF2cTYP8p54EQvB32YZCfjWLXjN8X60o3AnHqdu+W8fFKEGYQDXvS2yECgYEA8msZTGzT+bzaE3vrGUYeVSnt6P2DHZED14RjU9Dx1SHEICtPQVbfxGt8tJZ3Kn/qGt3nv7sSWi5wHXbVydTo7MdcublkyGJbdyHzctMlwNL/SJAig2jlbLpA4W4Xswk4TIX/EWgi6s2fyu7lJoBIOTl+x1W8EJOpGIkBbLHqVbkCgYEAp2i8ZhYbULdVQwaLSFtK3NZsdLEjGKvEksp8eUh+YtXqIGuLey9Lu464kVXEUhhzUxsI8QTzgGhJECMmaUmCIcLwZlrYJtfL1hOftPb7ZoenFnbeWuGXteT5cmgqJDR8qb5AxVWMiZFV9ov17MBjIHqW5gt/SLJoad77wL0Tfk0CgYEA32Mh5PNEQxZsPxgqBRhAS2pf+hvi/xPq3mb4wPwCXczH1n0Sg7tyaKZEPIWLOna1XBywulXBC6lPV1dympLAMbFlGSBmZuF8N8Ppex5n49CLvmpT45R+FjtsHlA9NpaAcsPn0DqOMqFZZr/OGjSMWW9KDJZMv1nSsPFPhsJMlsECgYATwDOaB7mpSDfy9G6yVrL6YwHgspVlb759Yw5UcM0YdAxvTsDiA653rlrwKqJC3Ued4m6noOHpoGQeV0dM3LNRsGIUcVtXGdaepyoMe6clbZO0/sk1B7CScTVM3iU6qEac8ClMHs+52z+9Gr4k9H29czkiYvDdbs8Kzpf9IVGPcQKBgCFJeEiUjZAoFFLuV3qcjTnoIaX6JxrGeHpJydyKCrdwEMHtY9y5oXcYoXytm30OIgtxEY5o2VrD2NeiZsHr/b3MjriH9o4vnNtGErOpEDDVvy1dsxL4KulUXdggXaN8UaYSnqd3W9mPKV3WqlGaobkLnUHznbcex7uPHh/ytnqG";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAs24IWGZHcP99JLRsG4Cn3TVvF3o9qu4LSzC6D6DYM/kx/18KsxdfKGvHxuGjmPSdcG3IBC+fQtmBJCoZ4Xx07+e0jr6iiS+UM8kjq6aWxmp9b8WgjK/kToMBLw+NFaZ3hdcUn5tbnzSe8Vnx+H0BbqQoTSb6R+j1UDVSwYROQ9vRLSfAEXolwb6WcYaHNKcSPdpiZKC2EPV73eqDrrPUuUHKQT36rU+rIXy44of8+n/tZl3egGvFMLvLv56GLPXvKcAq/Zm+m2HpYAQpbkAvSU4ybEDP4QjBYMr+NzV1PuzdNEleY9S5SVeXoabtXNBpWfr2vuVuMydlUO6F23JWOwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/orders/add";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";

}
