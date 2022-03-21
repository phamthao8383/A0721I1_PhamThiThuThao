package fresher.Team3.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import fresher.Team3.Enities.RolesEnity;
import fresher.Team3.Enities.UsersEnity;
import fresher.Team3.Repository.RoleRepository;
import fresher.Team3.Repository.UserRepository;
import fresher.Team3.Services.UserService;
@Component
public class GoogleUtils {
  @Autowired
  private Environment env;
  public String getToken(final String code) throws ClientProtocolException, IOException {
    String link = env.getProperty("google.link.get.token");
    String response = Request.Post(link)
        .bodyForm(Form.form().add("client_id", env.getProperty("google.app.id"))
            .add("client_secret", env.getProperty("google.app.secret"))
            .add("redirect_uri", env.getProperty("google.redirect.uri")).add("code", code)
            .add("grant_type", "authorization_code").build())
        .execute().returnContent().asString();
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree(response).get("access_token");
    return node.textValue();
  }
  public GooglePojo getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
    String link = env.getProperty("google.link.get.user_info") + accessToken;
    String response = Request.Get(link).execute().returnContent().asString();
    ObjectMapper mapper = new ObjectMapper();
    GooglePojo googlePojo = mapper.readValue(response, GooglePojo.class);
    System.out.println(googlePojo);
    return googlePojo;
  }
  @Autowired
  UserRepository userRepository; 
  @Autowired
  RoleRepository roleRepository; 
  @Autowired
  UserService userService; 
  public UserDetails buildUser(GooglePojo googlePojo) throws UsernameNotFoundException {
	  UsersEnity UsersEnity = userRepository.findByEmail(googlePojo.getEmail());
      if (UsersEnity == null) {
    	  UsersEnity user = new UsersEnity();
			RolesEnity role = roleRepository.findByName("user");
			user.setUsername(googlePojo.getEmail());
			user.setPassword(new BCryptPasswordEncoder(4).encode(googlePojo.getEmail()));
			user.setEmail(googlePojo.getEmail());
			user.getRolesEnities().add(role);
			userService.saveUser(user);
			 UsersEnity = user;
      }
      else {
    	  if (UsersEnity.isEnabled()) {
  			throw new UsernameNotFoundException("User disblae");
  		}
    	  Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
          Set<RolesEnity> roles = UsersEnity.getRolesEnities();
          for (RolesEnity role : roles) {
              grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
          }
          return new org.springframework.security.core.userdetails.User(
            		UsersEnity.getEmail(), UsersEnity.getPassword(), grantedAuthorities);
      }
      return UsersEnity;

      
      
  }
}
