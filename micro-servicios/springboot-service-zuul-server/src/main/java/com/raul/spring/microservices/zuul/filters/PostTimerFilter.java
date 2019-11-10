package com.raul.spring.microservices.zuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class PostTimerFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(PostTimerFilter.class);

    @Override
    public String filterType() {
        return "post";
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
        log.info("Entered to post");

        long startTime = (Long) request.getAttribute("startTime");
        long entTime = System.currentTimeMillis();
        long totalTime = entTime - startTime ;

        log.info(String.format("The total time in seconds is %d",totalTime / 1000));
        log.info(String.format("The total time in mili seconds is %d",totalTime ));

        return request;
    }
}
