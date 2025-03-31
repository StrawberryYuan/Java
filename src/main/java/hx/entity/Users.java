package hx.entity;

public class Users {
  private int userId;       // 数据库中对应 userId
  private String userName;
  private String password;
  private String sex;
  private String email;

  // 你已有的无 ID 构造器
  public Users(String userName, String password, String sex, String email) {
    this.userName = userName;
    this.password = password;
    this.sex = sex;
    this.email = email;
  }

  // 增加一个包含 userId 的构造器（方便查询后封装）
  public Users(int userId, String userName, String password, String sex, String email) {
    this.userId = userId;
    this.userName = userName;
    this.password = password;
    this.sex = sex;
    this.email = email;
  }

  // 无参构造（给表单封装用）
  public Users() {}

  public int getUserId() {
    return userId;
  }
  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  public String getSex() {
    return sex;
  }
  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
}