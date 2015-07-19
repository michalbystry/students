package amg.start.filters;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

public class DurationFilter implements Filter {

	// private static final Logger log =
	// LoggerFactory.getLogger(ServletFilter.class);

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String requestURL=null;
		
if(request instanceof HttpServletRequest){
	HttpServletRequest httpServlerRequest = (HttpServletRequest) request;
	requestURL = httpServlerRequest.getRequestURL().toString();
}
long startTime = System.nanoTime();

chain.doFilter(request, response);

long endTime = System.nanoTime();
System.out.println("Duration: "+(endTime-startTime)+" nano. Url: "+requestURL);

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
