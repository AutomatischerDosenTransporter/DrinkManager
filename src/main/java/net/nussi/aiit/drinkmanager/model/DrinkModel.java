package net.nussi.aiit.drinkmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DrinkModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    public String name;
    public DrinkTypeModel type;

    @OneToMany
    public List<DrinkPositionModel> positions = new ArrayList<>();


}
