package kr.ac.springboot.term.experience;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExperienceController {

    @GetMapping("/experience")
    public String expereience(Model model) {
        return "experience";
    }
}
