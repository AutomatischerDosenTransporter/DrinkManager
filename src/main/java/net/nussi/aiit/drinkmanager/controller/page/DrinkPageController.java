package net.nussi.aiit.drinkmanager.controller.page;

import net.nussi.aiit.drinkmanager.model.DrinkModel;
import net.nussi.aiit.drinkmanager.model.DrinkTypeModel;
import net.nussi.aiit.drinkmanager.repository.DrinkPositionRepository;
import net.nussi.aiit.drinkmanager.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/drinks")
public class DrinkPageController {

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private DrinkPositionRepository drinkPositionRepository;


    @GetMapping
    public String get(Model model) {

        return mainPage(model);
    }

    @GetMapping("/create")
    public String create(
            @RequestParam(required = false) Long data,
            Model model
    ) {
        Optional<DrinkModel> optionalDrinkModel = data!= null ? drinkRepository.findById(data) : Optional.empty();
        DrinkModel drinkModel = optionalDrinkModel.orElseGet(DrinkModel::new);
        return createPage(model, drinkModel);
    }

    @PostMapping("/create")
    public String create(
            @ModelAttribute DrinkModel drinkModel,
            Model model
    ) {
        Optional<String> error = drinkModel.isValid();
        if(error.isPresent()) return createPage(model, drinkModel, error.get());

        drinkRepository.save(drinkModel);
        System.out.println("Created: " + drinkModel);

        return "pages/drinks_redirect";
    }

    @GetMapping("/edit")
    public String edit(
            @RequestParam(required = false) Long id,
            Model model
    ) {
        if(id == null) return "pages/drinks_redirect";

        Optional<DrinkModel> optionalDrinkModel = drinkRepository.findById(id);

        if(optionalDrinkModel.isPresent()) {
            DrinkModel drinkModel = optionalDrinkModel.get();
            return editPage(model, drinkModel);
        } else {
            return "pages/drinks_redirect";
        }
    }

    @PostMapping("/edit")
    public String edit(
            @ModelAttribute DrinkModel drinkModel,
            Model model
    ) {
        Optional<String> error = drinkModel.isValid();
        if(error.isPresent()) return editPage(model, drinkModel, error.get());

        if(!drinkRepository.existsById(drinkModel.getId())) return editPage(model,drinkModel,"ID not found!");


        System.out.println("Saved: " + drinkModel);
        drinkRepository.save(drinkModel);

        return "pages/drinks_redirect";
    }

    @GetMapping("/delete")
    public String delete(
            @RequestParam(required = false) Long id,
            Model model
    ) {
        if(drinkRepository.existsById(id)) {
            drinkRepository.deleteById(id);
        }

        return "pages/drinks_redirect";
    }

    public String mainPage(Model model) {
        List<DrinkModel> drinkModels = drinkRepository.findAll();
        model.addAttribute("drinks", drinkModels);
        model.addAttribute("count", drinkModels.size());
        model.addAttribute("page", "drinks");
        return "layout";
    }

    public String createPage(Model model, DrinkModel drinkModel) {
        model.addAttribute("drink", drinkModel);
        model.addAttribute("drink_types", DrinkTypeModel.values());
        model.addAttribute("page", "drinks_create");
        if(!model.containsAttribute("errorMessage")) model.addAttribute("errorMessage", "");
        return "layout";
    }

    public String createPage(Model model, DrinkModel drinkModel, String errorMessage) {
        model.addAttribute("errorMessage",errorMessage);
        return createPage(model, drinkModel);
    }

    public String editPage(Model model, DrinkModel drinkModel) {
        model.addAttribute("drink", drinkModel);
        model.addAttribute("drink_types", DrinkTypeModel.values());
        model.addAttribute("page", "drinks_edit");
        if(!model.containsAttribute("errorMessage")) model.addAttribute("errorMessage", "");
        return "layout";
    }

    public String editPage(Model model, DrinkModel drinkModel, String errorMessage) {
        model.addAttribute("errorMessage",errorMessage);
        return editPage(model, drinkModel);
    }



}
