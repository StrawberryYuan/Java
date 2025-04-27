package hx.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 用户会话监听器：用于统计当前在线用户数量
 */
@WebListener
public class UserSessionListener implements HttpSessionListener {

  // 使用线程安全的 AtomicInteger 来统计在线人数
  private static final AtomicInteger userCount = new AtomicInteger(0);

  @Override
  public void sessionCreated(HttpSessionEvent se) {
    int count = userCount.incrementAndGet();
    System.out.println("✅ 新用户登录，当前在线人数：" + count);
  }

@Override
  public void sessionDestroyed(HttpSessionEvent se) {
    int count = userCount.decrementAndGet();
    System.out.println("⚠️ 用户退出，当前在线人数：" + count);
  }

  /**
   * 提供静态方法供页面或后台获取当前在线人数
   */
  public static int getUserCount() {
    return userCount.get();
  }
}