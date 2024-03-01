package net.nussi.aiit.drinkmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DrinkPositionModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    public double x;
    public double y;
}
