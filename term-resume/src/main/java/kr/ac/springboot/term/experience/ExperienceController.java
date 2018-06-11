package kr.ac.springboot.term.experience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExperienceController {

	@Autowired
	private ExperienceRepository repo;
	
	// 
    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("result", repo.findAllByOrderByRegdateAsc());
        return "experience";
    }
	
    @GetMapping("/experience")
    public void expereience(Model model) {
        model.addAttribute("result", repo.findAllByOrderByRegdateAsc());
    }
    
    @GetMapping("/register")
    public void registerGET(@ModelAttribute("vo") Experience vo) {
    }

    @PostMapping("/register")
    public String registerPOST(@ModelAttribute("vo") Experience vo) {
        repo.save(vo);
        return "redirect:/";
    }
    
    @GetMapping("/delete/{bno}")
    public String delete(@PathVariable("bno") long bno) {
        if (repo.findById(bno).isPresent()) {
            repo.deleteById(bno);
        } else {
            return "errors/404";
        }
        return "redirect:/";
    }
}