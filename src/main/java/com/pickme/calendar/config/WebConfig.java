package com.pickme.calendar.config;

import com.pickme.calendar.config.security.JwtInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    /*
     * WebMvcConfigurer:
     * - Spring MVC 설정을 커스터마이징할 수 있는 인터페이스.
     * - 인터셉터 등록, CORS 설정, 뷰 컨트롤러 추가 등 다양한 웹 관련 설정을 커스터마이징할 때 사용.
     */

    private final JwtInterceptor jwtInterceptor;
    /*
     * JwtInterceptor:
     * - JWT(토큰) 기반 인증을 처리하는 인터셉터.
     * - HTTP 요청에서 토큰을 확인하고 인증 정보를 검증하는 역할을 수행.
     * - `final` 키워드로 선언되어 생성 후 변경 불가.
     */

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        /*
         * addInterceptors:
         * - Spring MVC의 인터셉터를 등록하는 메서드.
         * - HTTP 요청이 컨트롤러에 도달하기 전에 특정 작업을 수행하도록 인터셉터를 추가.
         */

        registry.addInterceptor(jwtInterceptor).addPathPatterns("/calendar/**") // /calendar/** 경로에 인터셉터 적용
                .excludePathPatterns("/swagger-ui/**"); // /swagger-ui/** 경로는 인터셉터 적용 제외
        /*
         * registry.addInterceptor(jwtInterceptor):
         * - JwtInterceptor를 인터셉터 체인에 추가하여 동작하게 설정.
         *
         * .addPathPatterns("/**"):
         * - 모든 URL 요청 경로에 대해 인터셉터가 작동하도록 설정.
         * - 특정 경로만 인터셉트하려면 "/api/**" 또는 "/interviews/**"와 같이 경로를 지정.
         *
         * .excludePathPatterns("/swagger-ui/**"):
         * - "/swagger-ui/**" 경로는 인터셉터의 적용을 제외하도록 설정.
         * - Swagger UI와 관련된 요청은 JwtInterceptor를 거치지 않도록 설정.
         * - Swagger UI가 정상적으로 작동하려면 인증을 요구하지 않기 위해 이 경로를 제외.
         */
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");

    }

}
