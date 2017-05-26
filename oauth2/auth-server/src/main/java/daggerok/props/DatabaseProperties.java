package daggerok.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "db")
public class DatabaseProperties {

  /**
   * Database name.
   */
  String name;

  /**
   * Database user username.
   */
  String user;

  /**
   * Database user password.
   */
  String pass;

  @Data
  public static class Server {

    /**
     * Database server hostname.
     */
    Integer port;

    /**
     * Database server listening port.
     */
    String host;
  }
}
