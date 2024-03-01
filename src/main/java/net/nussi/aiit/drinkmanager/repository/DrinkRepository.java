package net.nussi.aiit.drinkmanager.repository;

import net.nussi.aiit.drinkmanager.model.DrinkModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<DrinkModel, Long> {
}