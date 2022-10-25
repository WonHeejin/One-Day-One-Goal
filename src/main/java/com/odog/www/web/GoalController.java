package com.odog.www.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class GoalController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/goal/save")
    public String goalSave() {
        return "goal-save";
    }
}
