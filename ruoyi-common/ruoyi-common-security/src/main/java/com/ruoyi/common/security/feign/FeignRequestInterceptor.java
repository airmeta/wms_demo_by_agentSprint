package com.ruoyi.common.security.feign;

import com.ruoyi.common.core.constant.Constants;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.utils.ServletUtils;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.security.context.SecurityContextHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Feign interceptor: propagate Authorization header to downstream services.
 */
@Component
public class FeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        // From servlet request (gateway forwarded)
        HttpServletRequest request = ServletUtils.getRequest();
        if (request != null) {
            String token = request.getHeader(Constants.TOKEN_HEADER);
            if (StringUtils.isNotEmpty(token) && token.startsWith(Constants.TOKEN_PREFIX)) {
                token = token.substring(7);
            }
            if (StringUtils.isNotEmpty(token)) {
                requestTemplate.header(Constants.TOKEN_HEADER, token);
            }
        }
        // From thread local (inter-service calls)
        LoginUser loginUser = SecurityContextHolder.get();
        if (loginUser != null && StringUtils.isNotEmpty(loginUser.getToken())) {
            requestTemplate.header(Constants.TOKEN_HEADER, loginUser.getToken());
        }
    }
}
