package me.maoburu.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AccessFilter extends ZuulFilter{

	private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);
	
	//是否启动过滤器
	@Override
	public boolean shouldFilter() {
		return true;
	}

	//具体过滤逻辑
	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		
		logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
		Object accestToken = request.getParameter("accessToken");
		if (accestToken == null) {
			logger.warn("accessToken is null");
			context.setSendZuulResponse(false);
			context.setResponseStatusCode(401);
			return null;
		}
		logger.info("access token is ok");
		return null;
	}

	//过滤方式，请求前
	@Override
	public String filterType() {
		
		return "pre";
	}

	//过滤器优先级顺序
	@Override
	public int filterOrder() {
		return 0;
	}

}
