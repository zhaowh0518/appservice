package com.disappearwind.app.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.disappearwind.app.util.FileUtil;

/**
 * @description 接口未上线前给客户端的示例数据
 */
public class ExampleInterceptor extends HandlerInterceptorAdapter{
	/**
	 * 在业务处理器处理请求之前被调用 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
	 * 如果返回true 执行下一个拦截器,直到所有的拦截器都执行完毕 再执行被拦截的Controller 然后进入拦截器链,
	 * 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String data = getExampleData(request);
		out.print(data);
		return false;
	}

	/**
	 * 取web-inf下的示例数据
	 */
	private String getExampleData(HttpServletRequest request) {
		String data = null;
		
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());

		@SuppressWarnings("deprecation")
		String path = request.getRealPath("/");
		String[] params = url.split("/");
		if (params != null && params.length == 3) {
			path = path + "\\WEB-INF\\examples\\" + params[1] + "\\" + params[2] + ".json";
			data = FileUtil.readFile(path);
		}
		return data;
	}

	
}
