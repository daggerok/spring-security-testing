package daggerok.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;

@Configuration
@EnableOAuth2Client
@RequiredArgsConstructor
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

  final AuthenticationManager authenticationManager;

  @Bean
  public AccessTokenConverter accessTokenConverter() {
    return new DefaultAccessTokenConverter();
  }

  @Override
  public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {

    clients
      .inMemory()
        .withClient("public-app")
          .secret("client")
          .authorizedGrantTypes("password", "authorization_token", "refresh_token")
          .scopes("read")
      .and()
        .withClient("admin-app")
          .secret("admin")
          .authorizedGrantTypes("password", "authorization_token", "refresh_token")
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
      .authenticationManager(authenticationManager)
      .accessTokenConverter(accessTokenConverter());
  }
}
