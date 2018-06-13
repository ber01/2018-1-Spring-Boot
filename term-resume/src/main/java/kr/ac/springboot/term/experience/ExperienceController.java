package kr.ac.springboot.term.experience;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.springboot.term.resume.ResumeRepository;

@Controller
@RequestMapping("/experience/")
public class ExperienceController {

	@Autowired
	private ExperienceRepository ex_repo;
	
	@Autowired
	private ResumeRepository re_repo;
	
	// View list
    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("result", ex_repo.findAllByOrderByRegdateAsc());
        return "/experience/experience";
    }
    // End View
    
    // Register Start
    @GetMapping("/register")
    public void registerGET(@ModelAttribute("vo") Experience vo) {
    }
    @PostMapping("/register")
    public String registerPOST(@ModelAttribute("vo") Experience vo) {
    	vo.setResume(re_repo.findById(1L).get());
        ex_repo.save(vo);
        return "redirect:/experience/";
    }
    // Register end
    
    // Delete Start
    @GetMapping("/{bno}/delete")
    public String delete(@PathVariable("bno") long bno) {
        if (ex_repo.findById(bno).isPresent()) {
            ex_repo.deleteById(bno);
        } else {
            return "errors/404";
        }
        return "redirect:/experience/";
    }
    // Delete End
    
    // Update Start
    @GetMapping("/{bno}/update")
    public String editGet(@PathVariable("bno") long bno, @ModelAttribute("vo") Experience vo, Model model) {
        if (ex_repo.findById(bno).isPresent()) {
            model.addAttribute("vo", ex_repo.findById(bno).get());
        } else {
            return "errors/404";
        }
        return "/experience/update";
    }
    @PostMapping("/update")
    public String editPost(@ModelAttribute("vo") Experience vo) {
        Optional<Experience> experience = ex_repo.findById(vo.getBno());
        if (experience.isPresent()) {
            experience.get().setTitle(vo.getTitle());
            experience.get().setContent(vo.getContent());
            experience.get().setRating(vo.getRating());
            ex_repo.save(experience.get());
        } else {
            ex_repo.save(vo);
        }
        return "redirect:/experience/";
    }
    // Update End
    
    // View Start
    @GetMapping("/{bno}")
    public String view(@PathVariable("bno") long bno, Model model) {
        if (ex_repo.findById(bno).isPresent()) {
            model.addAttribute("result", ex_repo.findById(bno).get());
        } else {
            return "errors/404";
        }
        return "/experience/item";
    }
    // End View
}