package hx.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * 系统初始化监听器：在服务器启动时初始化必要数据
 */
@WebListener
public class SystemInitListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("🌟 系统启动，正在执行初始化操作...");
    sce.getServletContext().setAttribute("sysName", "在线考试管理系统");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("🛑 系统关闭，资源释放完成。");
  }
}