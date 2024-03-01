package net.nussi.aiit.drinkmanager.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexPageController {
    @GetMapping("/")
    public String get(Model model) {
        return "index_page";
    }
}
