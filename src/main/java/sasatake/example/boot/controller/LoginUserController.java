package sasatake.example.boot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

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

  @GetMapping("/user/{id}")
  public String detail(@PathVariable("id") String id, Model model) {
    Optional<LoginUser> optionalUser = userService.getUser(id);
    optionalUser.ifPresent(user -> model.addAttribute("user", user));
    return "user/detail";
  }

  @GetMapping("/user/register/input")
  public String registerInput(Model model) {
    model.addAttribute("form", new LoginUserForm());
    return "user/register/input";
  }

  @PostMapping("/user/register/confirm")
  public String registerConfirm(@ModelAttribute LoginUserForm form, Model model) {
    model.addAttribute("form", form);
    return "user/register/confirm";
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
    return "user/register/complete";
  }

  @GetMapping("/user/{id}/update/input")
  public String updateInput(@PathVariable("id") String id, Model model) {
    Optional<LoginUser> optionalUser = userService.getUser(id);
    optionalUser.ifPresent(user -> model.addAttribute("form", new LoginUserForm(user)));
    return "user/update/input";
  }

  @PostMapping("/user/update/confirm")
  public String updateConfirm(@ModelAttribute LoginUserForm form, Model model) {
    model.addAttribute("form", form);
    return "user/update/confirm";
  }

  @PostMapping("/user/update")
  public String update(@ModelAttribute LoginUserForm form, Model model) {
    LoginUser user = new LoginUser();
    user.setId(Integer.parseInt(form.getId()));
    user.setName(form.getName());
    userService.updateUser(user);
    return "redirect:/user/update/complete";
  }

  @GetMapping("/user/update/complete")
  public String updateComplete() {
    return "user/update/complete";
  }

}
