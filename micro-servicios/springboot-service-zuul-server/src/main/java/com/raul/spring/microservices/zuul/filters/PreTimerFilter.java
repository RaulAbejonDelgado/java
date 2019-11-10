package com.raul.spring.microservices.zuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class PreTimerFilter  extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(PreTimerFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     *  used to do some validation
     * @return true executes run false not execute
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s request routed at %s",request.getMethod(), request.getRequestURL().toString()));

        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        return request;
    }
}
