package cloud.web.simple.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class boardController {

    @GetMapping()
    public String threading(){

        return "board/thread";
    }

    @GetMapping("/{id}")
    public String board(@PathVariable int id,
                        Model model){

        model.addAttribute("id", id);
        return "board/post";
    }

    @GetMapping("/write")
    public String writePost(){

        return "board/writeForm";
    }

    @GetMapping("/update/{id}")
    public String updatePost(@PathVariable int id,
                             Model model){

        model.addAttribute("id", id);
        return "board/writeForm";
    }
}
