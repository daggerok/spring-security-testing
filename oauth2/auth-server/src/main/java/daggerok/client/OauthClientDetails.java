package daggerok.client;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@Accessors(chain = true)
public class OauthClientDetails {

  private static final long serialVersionUID = 2714843477616118736L;

  @Id
  String clientId;
  String resourceIds;
  String clientSecret;
  String scope;
  String authorizedGrantTypes;
  String webServerRedirectUri;
  String authorities;
  Integer accessTokenValidity = 36000;
  Integer refreshTokenValidity = 36000;
  String additionalInformation;
  boolean autoapprove;
}
