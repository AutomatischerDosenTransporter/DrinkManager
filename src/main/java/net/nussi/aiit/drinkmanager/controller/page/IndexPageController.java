package net.nussi.aiit.drinkmanager.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexPageController {
    @GetMapping("/")
    public String get(
            Model model) {
        model.addAttribute("page", "index");
        return "layout";
    }
    @GetMapping("/{page}")
    public String get(@PathVariable String page, Model model) {
        model.addAttribute("page", page);
        return "layout";
    }
}
