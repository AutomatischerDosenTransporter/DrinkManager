package net.nussi.aiit.drinkmanager.model;

import jakarta.persistence.*;
import lombok.*;
import net.nussi.aiit.drinkmanager.beans.DrinkModelConverter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DrinkModel implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    public String name;
    public DrinkTypeModel type;

    @OneToMany
    public List<DrinkPositionModel> positions = new ArrayList<>();

    public String getData() {
        Optional<String> optionalDrinkModel = DrinkModelConverter.toString(this);
        return optionalDrinkModel.orElse("");
    }

    public Optional<String> isValid() {
        if(this.name.isEmpty() || this.name.isBlank()) return Optional.of("Name is blank.");
        return Optional.empty();
    }
}
