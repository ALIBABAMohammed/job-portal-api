package com.jobportal.job_portal_app.ws;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Component

@Controller
public class HomeController {
    public String home() {
        return "index";
    }
}
