package net.nussi.aiit.drinkmanager.controller.page;

import net.nussi.aiit.drinkmanager.model.DrinkModel;
import net.nussi.aiit.drinkmanager.model.DrinkPositionModel;
import net.nussi.aiit.drinkmanager.model.DrinkTypeModel;
import net.nussi.aiit.drinkmanager.repository.DrinkPositionRepository;
import net.nussi.aiit.drinkmanager.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/drink")
public class DrinkPageController {

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private DrinkPositionRepository drinkPositionRepository;

    @GetMapping
    public String get(Model model) {
        List<DrinkPositionModel> positions = new ArrayList<>();
        positions.add(new DrinkPositionModel(null, 0.0, 10.0));

        drinkPositionRepository.saveAll(positions);
        drinkRepository.save(new DrinkModel(null, "Mezzo Mix", DrinkTypeModel.THIRD_LITTER, positions));

        List<DrinkModel> drinkModels = drinkRepository.findAll();
        model.addAttribute("drinks", drinkModels);
        model.addAttribute("count", drinkModels.size());

        return "drink_page";
    }


    @GetMapping("/{id}")
    public String accountCreatePage(
            Model model,
            @PathVariable Long id
    ) {
        Optional<DrinkModel> optionalDrinkModel = drinkRepository.findById(id);
        if (optionalDrinkModel.isEmpty())  {
            model.addAttribute("message", "Username not found!");
            return "drink_error";
        }
        DrinkModel drinkModel = optionalDrinkModel.get();

        model.addAttribute("drink", drinkModel);

        return "drink_info";
    }
}
