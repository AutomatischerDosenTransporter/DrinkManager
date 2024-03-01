package net.nussi.aiit.drinkmanager.controller.rest;

import net.nussi.aiit.drinkmanager.model.DrinkModel;
import net.nussi.aiit.drinkmanager.model.DrinkPositionModel;
import net.nussi.aiit.drinkmanager.model.DrinkTypeModel;
import net.nussi.aiit.drinkmanager.repository.DrinkPositionRepository;
import net.nussi.aiit.drinkmanager.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drink")
public class DrinkController {


}
