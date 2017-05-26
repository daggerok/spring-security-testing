package daggerok.config;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import static java.util.Arrays.asList;

@Configuration
@RequiredArgsConstructor
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

  final JwtTokenEnhancer jwtTokenEnhancer;
  final AuthenticationManager authenticationManager;

  @Bean
  public AccessTokenConverter accessTokenConverter() {
    return new DefaultAccessTokenConverter();
  }

  @Bean
  public TokenStore tokenStore() {
    return new JwtTokenStore(jwtAccessTokenConverter());
  }

  @Bean
  public JwtAccessTokenConverter jwtAccessTokenConverter() {
    val jwtAccessTokenConverter = new JwtAccessTokenConverter();
    jwtAccessTokenConverter.setSigningKey("123");
    return jwtAccessTokenConverter;
  }

  @Bean
  @Primary
  public DefaultTokenServices tokenServices() {
    val defaultTokenServices = new DefaultTokenServices();
    defaultTokenServices.setTokenStore(tokenStore());
    defaultTokenServices.setSupportRefreshToken(true);
    return defaultTokenServices;
  }

  @Bean
  TokenEnhancerChain tokenEnhancerChain() {
    val tokenEnhancerChain = new TokenEnhancerChain();
    tokenEnhancerChain.setTokenEnhancers(asList(jwtTokenEnhancer, jwtAccessTokenConverter()));
    return tokenEnhancerChain;
  }

  @Override
  public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {

    clients
        .inMemory()
        .withClient("public-app")
        .secret("client")
        .authorizedGrantTypes("implicit", "password", "client_credentials", "authorization_code", "refresh_token")
        .scopes("read")
        .and()
        .withClient("admin-app")
        .secret("admin")
        .authorizedGrantTypes("implicit", "password", "client_credentials", "authorization_code", "refresh_token")
        .scopes("read", "write");
  }

  @Override
  public void configure(final AuthorizationServerSecurityConfigurer security) throws Exception {

    security
        .tokenKeyAccess("permitAll()")
        .checkTokenAccess("isAuthenticated()");
  }

  @Override
  public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

    endpoints
        .tokenStore(tokenStore())
        .tokenEnhancer(tokenEnhancerChain())
        .authenticationManager(authenticationManager);
  }
}
