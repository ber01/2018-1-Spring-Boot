package kr.ac.springboot.term.experience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExperienceController {

	@Autowired
	private ExperienceRepository repo;
	
    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("result", repo.findAllByOrderByBnoAsc());
        return "exlist";
    }
	
    @GetMapping("/experience")
    public String expereience() {
        return "experience";
    }
}
