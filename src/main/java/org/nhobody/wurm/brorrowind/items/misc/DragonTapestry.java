package org.nhobody.wurm.brorrowind.items.misc;

import com.wurmonline.server.behaviours.BehaviourList;
import com.wurmonline.server.items.ItemTemplate;
import com.wurmonline.server.items.ItemTypes;
import com.wurmonline.server.items.Materials;
import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;
import org.nhobody.wurm.brorrowind.Brorrowind;

import java.io.IOException;
import java.util.logging.Level;

public class DragonTapestry {
    public static void onItemTemplatesCreated() {
        ItemTemplateBuilder builder = new ItemTemplateBuilder("mod.nhobody.Brorrowind.DragonTapestry");
        builder.name("Dragon Tapestry", "Dragon Tapestry", "A decorative display of a dragon, the symbol of the Empire.");
        builder.itemTypes(new short[]{
                ItemTypes.ITEM_TYPE_NAMED,
                ItemTypes.ITEM_TYPE_REPAIRABLE,
                ItemTypes.ITEM_TYPE_CLOTH,
                ItemTypes.ITEM_TYPE_DECORATION
        });
        builder.modelName("model.mod.nhobody.Brorrowind.DragonTapestry.");
        builder.material(Materials.MATERIAL_COTTON);
        builder.dimensions(5, 10, 80);
        builder.weightGrams(250);
        builder.behaviourType(BehaviourList.itemBehaviour);
        builder.combatDamage(0);
        builder.decayTime(Long.MAX_VALUE);
        builder.difficulty(40.0f);
        builder.value(1000);

        ItemTemplate template = null;

        try {
            template = builder.build();
        } catch (IOException e) {
            Brorrowind.logger.log(Level.SEVERE, "Failed while creating item template for DragonTapestry.", e);
        }
    }
}
