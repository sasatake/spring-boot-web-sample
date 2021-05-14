package sasatake.example.boot.repository;

import java.util.List;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;

import sasatake.example.boot.entity.LoginUser;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    TransactionDbUnitTestExecutionListener.class })
@Transactional
public class LoginUserRepositoryTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private LoginUserRepository repository;

  @Test
  @DatabaseSetup("/data/LoginUserNoData.xml")
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

  @Test
  @DatabaseSetup("/data/LoginUserNoData.xml")
  @ExpectedDatabase(value = "/data/LoginUser001.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
  public void save() throws Exception {

    LoginUser user001 = new LoginUser();
    user001.setName("001");
    LoginUser result = this.repository.save(user001);
    this.entityManager.flush();
    assertThat(result.getName()).isEqualTo(user001.getName());
  }

}
