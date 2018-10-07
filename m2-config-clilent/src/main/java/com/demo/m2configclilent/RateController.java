package com.demo.m2configclilent;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RefreshScope
public class RateController {

    @Value("${rate}")
    String rate;

    @Value("${lanecount}")
    String laneCount;

    @Value("${tollstart}")
    String tollStart;

    @Value("${connstring}")
    String connstring;

    @GetMapping("rate")
    public String getRate(Model model) {
        model.addAttribute("rateamount", rate);
        model.addAttribute("lanes", laneCount);
        model.addAttribute("tollstart", tollStart);
        model.addAttribute("connstring", connstring);

        //name of the view
        return "rateview";
    }
}
