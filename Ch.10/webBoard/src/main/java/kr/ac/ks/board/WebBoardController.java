package kr.ac.ks.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/boards/")
public class WebBoardController {

    @Autowired
    private WebBoardRepository repo;

    @GetMapping("/list")
    public void list(Model model) {
        model.addAttribute("result", repo.findAllByOrderByRegdateDesc());
    }

    @GetMapping("/{bno}")
    public String view(@PathVariable("bno") long bno, Model model) {
        if (repo.findById(bno).isPresent()) {
            model.addAttribute("result", repo.findById(bno).get());
        } else {
            return "errors/404";
        }
        return "boards/item";
    }

    @GetMapping("/register")
    public void registerGET(@ModelAttribute("vo") WebBoard vo) {
    }

    @PostMapping("/register")
    public String registerPOST(@ModelAttribute("vo") WebBoard vo) {
        repo.save(vo);
        return "redirect:/boards/list";
    }

    @GetMapping("/delete/{bno}")
    public String delete(@PathVariable("bno") long bno) {
        if (repo.findById(bno).isPresent()) {
            repo.deleteById(bno);
        } else {
            return "errors/404";
        }
        return "redirect:/boards/list";
    }

    @GetMapping("/edit/{bno}")
    public String editGet(@PathVariable("bno") long bno, @ModelAttribute("vo") WebBoard vo, Model model) {
        if (repo.findById(bno).isPresent()) {
            model.addAttribute("vo", repo.findById(bno).get());
        } else {
            return "errors/404";
        }
        return "boards/edit";
    }

    @PostMapping("/edit")
    public String editPost(@ModelAttribute("vo") WebBoard vo) {
        Optional<WebBoard> webBoard = repo.findById(vo.getBno());
        if (webBoard.isPresent()) {
            webBoard.get().setTitle(vo.getTitle());
            webBoard.get().setContent(vo.getContent());
            webBoard.get().setWriter(vo.getWriter());
            repo.save(webBoard.get());
        } else {
            repo.save(vo);
        }
        return "redirect:/boards/list";
    }

}