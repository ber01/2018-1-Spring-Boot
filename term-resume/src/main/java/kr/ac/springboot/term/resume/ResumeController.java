package kr.ac.springboot.term.resume;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResumeController {

    // '/' ==> list
    // '/register' ==> create
    // '/{rno} ==> view
    // '/{rno}/update ==> update'
    // '/{rno}/delete ==> delete'
	
    @GetMapping("/")
    public String index(Model model) {
        Resume resume = new Resume();
        resume.setName("민경환");
        model.addAttribute("resume", resume);
        return "resume";
    }

    @GetMapping("/resume")
    public String resumeIndex(Model model) {
        Resume resume = new Resume();
        resume.setName("민경환");
        model.addAttribute("resume", resume);
        return "resume";
    }
}
