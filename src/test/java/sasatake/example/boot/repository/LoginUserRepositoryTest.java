package sasatake.example.boot.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;

import sasatake.example.boot.entity.LoginUser;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class LoginUserRepositoryTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private LoginUserRepository repository;

  @Test
  public void testFindAll() throws Exception {

    LoginUser user001 = new LoginUser();
    user001.setName("001");
    LoginUser user002 = new LoginUser();
    user001.setName("002");
    LoginUser user003 = new LoginUser();
    user001.setName("003");

    this.entityManager.persist(user001);
    this.entityManager.persist(user002);
    this.entityManager.persist(user003);

    List<LoginUser> userList = (List<LoginUser>) this.repository.findAll();
    assertThat(userList.size()).isEqualTo(3);
  }
}
