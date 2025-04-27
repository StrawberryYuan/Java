package hx.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse resp = (HttpServletResponse) response;
    HttpSession session = req.getSession(false);
    String uri = req.getRequestURI();

    if (uri.contains("login.jsp") || uri.contains("register.jsp") ||
        uri.contains("LoginServlet") || uri.contains("RegisterServlet") ||
        uri.contains(".css") || uri.contains(".js") || uri.contains(".png") || uri.contains(".jpg") ||
        uri.contains("left.jsp") || uri.contains("welcome.jsp") ||
        uri.contains("UserSessionListener") || uri.contains("index.jsp")) {
      chain.doFilter(request, response);
      return;

    }

    if (session != null && session.getAttribute("user") != null) {
      chain.doFilter(request, response);
    } else {
      resp.sendRedirect("login.jsp");
    }
  }
}