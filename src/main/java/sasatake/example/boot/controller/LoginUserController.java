package sasatake.example.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import sasatake.example.boot.service.LoginUserService;
import sasatake.example.boot.controller.form.LoginUserForm;
import sasatake.example.boot.entity.LoginUser;;

@Controller
public class LoginUserController {

  @Autowired
  private LoginUserService userService;

  @GetMapping("/users")
  public String list(Model model) {
    model.addAttribute("userList", userService.getUserList());
    return "user/list";
  }

  @GetMapping("/user/register/input")
  public String registerInput(Model model) {
    model.addAttribute("form", new LoginUserForm());
    return "user/input";
  }

  @PostMapping("/user/register/confirm")
  public String registerConfirm(@ModelAttribute LoginUserForm form, Model model) {
    model.addAttribute("form", form);
    return "user/confirm";
  }

  @PostMapping("/user/register")
  public String register(@ModelAttribute LoginUserForm form, Model model) {
    LoginUser user = new LoginUser();
    user.setName(form.getName());
    userService.registerUser(user);
    return "redirect:/user/register/complete";
  }

  @GetMapping("/user/register/complete")
  public String registerComplete() {
    return "user/complete";
  }

}
