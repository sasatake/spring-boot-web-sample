package sasatake.example.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sasatake.example.boot.entity.LoginUser;
import sasatake.example.boot.repository.LoginUserRepository;

@Service
public class LoginUserService {

  @Autowired
  private LoginUserRepository userRepository;

  public List<LoginUser> getUserList() {
    return (List<LoginUser>) userRepository.findAll();
  }

  public Optional<LoginUser> getUser(String id) {
    var intId = Integer.parseInt(id);
    return userRepository.findById(intId);
  }

  public void registerUser(LoginUser user) {
    userRepository.save(user);
  }

  public void updateUser(LoginUser user) {
    if (userRepository.existsById(user.getId())) {
      userRepository.save(user);
    }
  }

}
