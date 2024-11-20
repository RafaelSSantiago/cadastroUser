package cadastrouser.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;
  private String password;

  public String getPassword() {
    return password;
  }

  public String getUsername() {
    return username;
  }

  public String setPassword(String password) {
    return this.password = password;
  }

  public String setName(String password) {
    return this.password = password;
  }

}