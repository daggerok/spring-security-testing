//package daggerok.account;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.val;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import java.util.Collection;
//
//import static java.lang.String.format;
//
//@Data
//@Entity
//@NoArgsConstructor
//public class Account implements UserDetails {
//
//  private static final long serialVersionUID = -8418160085198329237L;
//
//  @Id @GeneratedValue Long id;
//  String username;
//  String password;
//  boolean active;
//
//  @Override
//  public Collection<? extends GrantedAuthority> getAuthorities() {
//
//    val role = "admin".equals(username) ? "ADMIN" : "USER";
//    return AuthorityUtils.createAuthorityList(format("ROLE_%s", role));
//  }
//
//  @Override
//  public boolean isAccountNonExpired() {
//    return isEnabled();
//  }
//
//  @Override
//  public boolean isAccountNonLocked() {
//    return isEnabled();
//  }
//
//  @Override
//  public boolean isCredentialsNonExpired() {
//    return isEnabled();
//  }
//
//  @Override
//  public boolean isEnabled() {
//    return active;
//  }
//}
