package sasatake.example.boot.controller.form;

import lombok.Getter;
import lombok.Setter;

import sasatake.example.boot.entity.LoginUser;;

@Getter
@Setter
public class LoginUserForm {

  public LoginUserForm() {
    this.id = "";
    this.name = "";
  }

  public LoginUserForm(LoginUser user) {
    this.id = Integer.toString(user.getId());
    this.name = user.getName();
  }

  private String id;

  private String name;

}
