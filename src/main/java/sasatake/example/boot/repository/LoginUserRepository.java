package sasatake.example.boot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sasatake.example.boot.entity.LoginUser;

@Repository
public interface LoginUserRepository extends CrudRepository<LoginUser, Integer> {
}
