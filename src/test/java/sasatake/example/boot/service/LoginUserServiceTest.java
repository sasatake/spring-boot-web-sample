package sasatake.example.boot.service;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import sasatake.example.boot.repository.LoginUserRepository;
import sasatake.example.boot.entity.LoginUser;

@SpringBootTest
public class LoginUserServiceTest {

  @MockBean
  private LoginUserRepository loginUserRepository;

  @Autowired
  private LoginUserService loginUserService;

  @Test
  void exampleTest() {
    List<LoginUser> userList = new ArrayList<LoginUser>();

    LoginUser user001 = new LoginUser();
    user001.setName("001");
    LoginUser user002 = new LoginUser();
    user001.setName("002");
    LoginUser user003 = new LoginUser();
    user001.setName("003");

    userList.add(user001);
    userList.add(user002);
    userList.add(user003);

    given(this.loginUserRepository.findAll()).willReturn(userList);

    List<LoginUser> result = loginUserService.getUserList();
    assertThat(result.size()).isEqualTo(3);

  }

}
