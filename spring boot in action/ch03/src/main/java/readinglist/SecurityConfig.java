package readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
// 扩展了 WebSecurityConfigurerAdapter 的配置类
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private ReaderRepository readerRepository;
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
        .antMatchers("/").access("hasRole('READER')") // 要求登陆者有READER角色
        .antMatchers("/**").permitAll() // 其他所有请求路径向所有用户开发访问权限
      .and()
      .formLogin()
        .loginPage("/login") // 设置登陆表单的路径
        .failureUrl("/login?error=true");
        // 将登陆页和登陆失败页（带有一个error属性）指定到了/login
  }
  
  @Override
  protected void configure(
              AuthenticationManagerBuilder auth) throws Exception {
    auth
      .userDetailsService(new UserDetailsService() {
        // 定义自定义 UserDetailsService
        @Override
        public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
          UserDetails userDetails = readerRepository.findOne(username);
          if (userDetails != null) {
            return userDetails;
          }
          throw new UsernameNotFoundException("User '" + username + "' not found.");
        }
      });
  }

}
