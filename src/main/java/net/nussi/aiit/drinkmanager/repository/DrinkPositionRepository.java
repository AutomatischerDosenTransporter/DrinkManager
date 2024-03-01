package net.nussi.aiit.drinkmanager.repository;

import net.nussi.aiit.drinkmanager.model.DrinkPositionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkPositionRepository extends JpaRepository<DrinkPositionModel, Long> {
}