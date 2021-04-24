package sasatake.example.boot.controller;

import java.util.List;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import sasatake.example.boot.entity.User;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void list() throws Exception {

    List<User> userList = new ArrayList<User>();
    userList.add(new User("user001"));
    userList.add(new User("user002"));
    userList.add(new User("user003"));

    mvc.perform(MockMvcRequestBuilders.get("/users").accept(MediaType.TEXT_HTML_VALUE).flashAttr("userList", userList))
        .andExpect(status().isOk()).andExpect(view().name("user/list")).andExpect(model().attributeExists("userList"));
  }
}