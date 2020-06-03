package com.github.geekcloud.security.authorization.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.geekcloud.framework.core.response.ResultWrapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @ClassName: CustomOauthException
 * @author: jeffrey
 * @date: 2020年05月27日
 * @Description: TODO
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonSerialize(using = CustomOauthExceptionSerializer.class)
class CustomOauthException extends OAuth2Exception {

    private final ResultWrapper result;

    CustomOauthException(OAuth2Exception oAuth2Exception) {
        super(oAuth2Exception.getSummary(), oAuth2Exception);
        this.result = ResultWrapper.fail(AuthErrorType.valueOf(oAuth2Exception.getOAuth2ErrorCode().toUpperCase()), oAuth2Exception);
    }
}