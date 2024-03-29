package com.green.greengram4.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "app") //yaml파일에 app / yaml파일내용을 가지고 객체화해주고 싶으면 사용? 메인클래스에 @ConfigurationPropertiesScan
public class AppProperties {

    private final Jwt jwt = new Jwt();

    @Getter
    @Setter
    public static class Jwt { //이너클래스 static으로 안하면 속성에 접근이가능해짐
        private String secret;
        private String headerSchemeName;
        private String tokenType;
        private long accessTokenExpiry;
        private long refreshTokenExpiry;
        private int refreshTokenCookieMaxAge;

        public void setRefreshTokenExpiry(long refreshTokenExpiry) {
            this.refreshTokenExpiry = refreshTokenExpiry;
            this.refreshTokenCookieMaxAge = (int) (refreshTokenExpiry * 0.001);
        }
    }
}
