package cn.sh.website.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.sh.dto.User;

//@WebFilter(filterName = "sessionFilter", urlPatterns = { "*.html", "*.do" })
public class SessionFilter implements Filter {
	private final Logger logger = LoggerFactory.getLogger(SessionFilter.class);
	private final static String LOGIN_USER = "login_user";
	Set<String> accessUrl = new HashSet<String>();
	{
		accessUrl.add("/login.html");
		accessUrl.add("/index.html");
		accessUrl.add("/user/login.do");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String contextPath = (String) ((HttpServletRequest) request).getContextPath();
		String ServletPath = (String) ((HttpServletRequest) request).getServletPath();
		logger.info(ServletPath);
		if (this.accessUrl.contains(ServletPath) || ServletPath.indexOf("druid") > 0) {
			chain.doFilter(request, response);
		} else {
			HttpServletRequest hRequest = (HttpServletRequest) request;
			User loginUser = (User) hRequest.getSession().getAttribute(LOGIN_USER);
			if (loginUser == null) {
				((HttpServletResponse) response).sendRedirect(contextPath + "/login.html");
			} else {
				chain.doFilter(request, response);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
