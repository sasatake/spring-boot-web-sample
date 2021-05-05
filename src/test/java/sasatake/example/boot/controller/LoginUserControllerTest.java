package sasatake.example.boot.controller;

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

@SpringBootTest
@AutoConfigureMockMvc
public class LoginUserControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void list() throws Exception {

    mvc.perform(MockMvcRequestBuilders.get("/users").accept(MediaType.TEXT_HTML_VALUE)).andExpect(status().isOk())
        .andExpect(view().name("user/list")).andExpect(model().attributeExists("userList"));
  }
}