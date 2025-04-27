package hx.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 字符编码过滤器：统一设置请求和响应为UTF-8编码
 */
@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");

    chain.doFilter(request, response);
  }
}