package kr.or.chan.interceptor;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		HttpSession session = request.getSession();

		if (Objects.isNull(session.getAttribute("email"))) {
			try {
				response.sendRedirect(request.getContextPath() + "/login");
			} catch (IOException ex) {
				logger.error("exception [login페이지 이동] 요청 URL:{}", request.getRequestURL(), ex);
			}

			return false;
		}

		return true;
	}
}
