package sasatake.example.boot.service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import sasatake.example.boot.entity.User;

@Service
public class UserService {

  public List<User> getUserList() {
    List<User> userList = new ArrayList<User>();

    userList.add(new User("user001"));
    userList.add(new User("user002"));
    userList.add(new User("user003"));
    return userList;
  }

}
