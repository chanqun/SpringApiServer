package kr.or.chan.interceptor;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInterceptor extends HandlerInterceptorAdapter {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		LocalDateTime dayTime = LocalDateTime.now();

		logger.debug("요청 URL:{}, 시간:{}, 클라이언트ip:{} ", request.getRequestURL(), dayTime.toString(), request.getRemoteAddr());

		return true;
	}
}
