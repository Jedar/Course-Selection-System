package main.fudan.CourseSelectionSystem.filter;

import main.fudan.CourseSelectionSystem.consts.Constant;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    private String sessionKey;
    private String redirectUrl;
    private String studentRedirectUrl;
    private String teacherRedirectUrl;
    private String managerRedirectUrl;
    private String studentUrls;
    private String teacherUrls;
    private String managerUrls;
    private String uncheckedUrls;
    private String encoding;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);

        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) resp;

        /* 设置编码 */
        httpRequest.setCharacterEncoding(encoding);
        httpResponse.setCharacterEncoding(encoding);

        /* 获取网页白名单 */
        String servletPath = httpRequest.getServletPath();
        List<String> urls = Arrays.asList(uncheckedUrls.split(","));
        /* 如果在白名单内，通过过滤器 */
        if (urls.contains(servletPath)) {
            chain.doFilter(req, resp);
            return;
        }

        String user = (String)httpRequest.getSession().getAttribute(Constant.SESSION_USER);
        String permission = (String)httpRequest.getSession().getAttribute(Constant.SESSION_PERMISSION);
        System.out.println(user);
        /* 未登录拦截 */
        if ((user == null)) {
            System.out.println(httpRequest.getContextPath() + redirectUrl);
            httpResponse.sendRedirect(httpRequest.getContextPath() + redirectUrl);
            return;
        }
        /* 登录后权限控制 */
        if (permission.equals(Constant.PERM_TEACHER)){
            urls = Arrays.asList(teacherUrls.split(","));
            if (urls.contains(servletPath)){
                chain.doFilter(req, resp);
                return;
            }
            httpResponse.sendRedirect(httpRequest.getContextPath() + teacherRedirectUrl);
            return;
        }
        if (permission.equals(Constant.PERM_STUDENT)){
            urls = Arrays.asList(studentUrls.split(","));
            if (urls.contains(servletPath)){
                chain.doFilter(req, resp);
                return;
            }
            httpResponse.sendRedirect(httpRequest.getContextPath() + studentRedirectUrl);
            return;
        }
        if (permission.equals(Constant.PERM_MANAGER)){
            urls = Arrays.asList(managerUrls.split(","));
            if (urls.contains(servletPath)){
                chain.doFilter(req, resp);
                return;
            }
            httpResponse.sendRedirect(httpRequest.getContextPath() + managerRedirectUrl);
            return;
        }
        chain.doFilter(httpRequest, httpResponse);
    }

    public void init(FilterConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        //获取XML文件中配置参数
        sessionKey = servletContext.getInitParameter("userSessionKey");
        redirectUrl = servletContext.getInitParameter("redirectPage");
        uncheckedUrls = servletContext.getInitParameter("uncheckedUrls");
        encoding = servletContext.getInitParameter("encoding");
        studentRedirectUrl = servletContext.getInitParameter(Constant.HOME_STUDENT);
        studentUrls = servletContext.getInitParameter(Constant.PAGES_STUDENT);
        teacherRedirectUrl = servletContext.getInitParameter(Constant.HOME_TEACHER);
        teacherUrls = servletContext.getInitParameter(Constant.PAGES_TEACHER);
        managerRedirectUrl = servletContext.getInitParameter(Constant.HOME_MANAGER);
        managerUrls = servletContext.getInitParameter(Constant.PAGES_MANAGER);
    }

}
