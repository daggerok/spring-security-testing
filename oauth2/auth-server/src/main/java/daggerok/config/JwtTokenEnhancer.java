package daggerok.config;

import lombok.val;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.Collections;

import static java.util.Collections.singletonMap;

@Component
public class JwtTokenEnhancer implements TokenEnhancer {

  @Override
  public OAuth2AccessToken enhance(final OAuth2AccessToken accessToken, final OAuth2Authentication authentication) {
    val defaultOAuth2AccessToken = (DefaultOAuth2AccessToken) accessToken;
    defaultOAuth2AccessToken.setAdditionalInformation(singletonMap("ololo", "trololo"));
    return accessToken;
  }
}
