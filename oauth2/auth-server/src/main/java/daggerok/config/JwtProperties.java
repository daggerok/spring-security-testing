package daggerok.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "security.oauth2.authorization.key-pair")
public class JwtProperties {

  /**
   * KeyStore alias
   */
  String alias;

  /**
   * KeyStore password
   */
  String password;

  /**
   * KeyStore file location
   */
  String filePath;
}
