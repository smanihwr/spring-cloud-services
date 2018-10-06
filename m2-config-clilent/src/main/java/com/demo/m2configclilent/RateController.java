package com.demo.m2configclilent;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateController {

    @Value("${rate}")
    String rate;

    @Value("${lanecount}")
    String laneCount;

    @Value("${tollstart}")
    String tollStart;

    @GetMapping("rate")
    public String getRate(Model model) {
        model.addAttribute("rateamount", rate);
        model.addAttribute("lanecount", laneCount);
        model.addAttribute("tollstart", tollStart);

        //name of the view
        return "rateview";
    }
}
