package daggerok.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
public class Oauth2Config extends AuthorizationServerConfigurerAdapter {

  @Autowired DataSource dataSource;
  @Autowired PasswordEncoder passwordEncoder;
  @Autowired AuthenticationManager authenticationManager;

  @Override
  public void configure(final AuthorizationServerSecurityConfigurer security) throws Exception {

    security.tokenKeyAccess("permitAll()")
            .checkTokenAccess("isAuthenticated()");
  }

  @Override
  public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
    clients.jdbc(dataSource).passwordEncoder(passwordEncoder);
  }

  @Override
  public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

    endpoints
        .tokenStore(tokenStore())
        .authenticationManager(authenticationManager);
  }

  @Bean
  public TokenStore tokenStore() {
    return new JdbcTokenStore(dataSource);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
