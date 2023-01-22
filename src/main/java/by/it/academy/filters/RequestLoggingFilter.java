package by.it.academy.filters;

import org.apache.log4j.Logger;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@WebFilter(urlPatterns = {"/user/*"})
public class RequestLoggingFilter extends HttpFilter {
    private static final long serialVersionUID = 79745434264L;
    private Logger log;

    @Override
    public void init() {
        log = Logger.getLogger(RequestLoggingFilter.class);
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        Map<String, ArrayList<String>> headers = getHeaders(req);
        log.info(req.getRequestURL() + ": " + headers);
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
    private Map<String, ArrayList<String>> getHeaders(HttpServletRequest req){
        return (Map<String, ArrayList<String>>) Collections.list(req.getHeaderNames()).stream()
                .collect(Collectors.toMap(Function.identity(),
                        h -> Collections.list(req.getHeaders(String.valueOf(h)))));
    }
}
