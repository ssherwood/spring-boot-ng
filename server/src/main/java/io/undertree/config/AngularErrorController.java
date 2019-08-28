package io.undertree.config;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This custom controller is _essential_ to allow Angular default HTML5 routing
 * to work seamlessly with Spring Boot.
 *
 * Please refer to this question (Specifically, the answer "If you're tired of trying to solve this problem..."):
 * https://stackoverflow.com/questions/43913753/spring-boot-with-redirecting-with-single-page-angular2
 *
 * This allows real API 404s to be returned and any other bad route requests to forward
 * to index.html
 */
@Controller
public class AngularErrorController implements ErrorController {
    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "forward:/index.html";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
