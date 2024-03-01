package net.nussi.aiit.drinkmanager.controller.page;

import net.nussi.aiit.drinkmanager.beans.DrinkModelConverter;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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
        List<DrinkPositionModel> positions = new ArrayList<>();
        positions.add(new DrinkPositionModel(null, 0.0, 10.0));

        drinkPositionRepository.saveAll(positions);
        drinkRepository.save(new DrinkModel(null, "Mezzo Mix", DrinkTypeModel.THIRD_LITTER, positions));

        List<DrinkModel> drinkModels = drinkRepository.findAll();
        model.addAttribute("drinks", drinkModels);
        model.addAttribute("count", drinkModels.size());


        model.addAttribute("page", "drinks");
        return "layout";
    }

    @GetMapping("/create")
    public String create(
            @RequestParam(required = false) String data,
            Model model
    ) {
        Optional<DrinkModel> optionalDrinkModel = DrinkModelConverter.fromString(data);
        DrinkModel drinkModel = optionalDrinkModel.orElseGet(DrinkModel::new);

        model.addAttribute("drink", drinkModel);
        model.addAttribute("page", "drinks_create");
        return "layout";
    }



}
