package net.nussi.aiit.drinkmanager.beans;

import net.nussi.aiit.drinkmanager.model.DrinkModel;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Base64;
import java.util.Optional;


public class DrinkModelConverter {

    public static Optional<String> toString(DrinkModel model) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(model);

            return Optional.of(Base64.getEncoder().encodeToString(bos.toByteArray()));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public static Optional<DrinkModel> fromString(String data) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(data);
            ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
            ObjectInputStream ois = new ObjectInputStream(bis);

            DrinkModel model = (DrinkModel) ois.readObject();
            if (model == null) return Optional.empty();
            return Optional.of(model);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
