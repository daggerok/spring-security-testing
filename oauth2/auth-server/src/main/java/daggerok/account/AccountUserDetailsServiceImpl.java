//package daggerok.account;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import static java.lang.String.format;
//
//@Service
//@RequiredArgsConstructor
//@Transactional(readOnly = true)
//public class AccountUserDetailsServiceImpl implements UserDetailsService {
//
//  final AccountRepository accountRepository;
//
//  @Override
//  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
//
//    return accountRepository.findFirstByUsername(username)
//                            .orElseThrow(() -> new UsernameNotFoundException(
//                                format("account with username '%S' wasn't found.", username)));
//  }
//}
