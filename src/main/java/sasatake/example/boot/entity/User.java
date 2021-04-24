package sasatake.example.boot.entity;

import java.util.UUID;

public class User {

  public User(String name) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
  }

  private String id;
  private String name;

  public String getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

}