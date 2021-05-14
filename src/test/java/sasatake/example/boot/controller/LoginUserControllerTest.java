package sasatake.example.boot.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlTemplate;

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

  @Test
  public void registerInput() throws Exception {

    mvc.perform(MockMvcRequestBuilders.get("/user/register/input").accept(MediaType.TEXT_HTML_VALUE))
        .andExpect(status().isOk()).andExpect(view().name("user/input")).andExpect(model().attributeExists("form"));
  }

  @Test
  public void registerConfirm() throws Exception {

    mvc.perform(MockMvcRequestBuilders.post("/user/register/confirm").accept(MediaType.TEXT_HTML_VALUE))
        .andExpect(status().isOk()).andExpect(view().name("user/confirm")).andExpect(model().attributeExists("form"));
  }

  @Test
  public void register() throws Exception {

    mvc.perform(MockMvcRequestBuilders.post("/user/register").accept(MediaType.TEXT_HTML_VALUE))
        .andExpect(status().is3xxRedirection()).andExpect(redirectedUrlTemplate("/user/register/complete"));
  }

  @Test
  public void registerComplete() throws Exception {

    mvc.perform(MockMvcRequestBuilders.get("/user/register/complete").accept(MediaType.TEXT_HTML_VALUE))
        .andExpect(status().isOk()).andExpect(view().name("user/complete"));
  }

}