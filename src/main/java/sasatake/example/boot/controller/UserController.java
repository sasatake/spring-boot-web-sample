package sasatake.example.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sasatake.example.boot.service.UserService;

@Controller
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/users")
  public String list(Model model) {
    model.addAttribute("userList", userService.getUserList());
    return "user/list";
  }
}
