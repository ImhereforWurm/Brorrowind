package org.nhobody.wurm.brorrowind.items.misc;

import com.wurmonline.server.behaviours.BehaviourList;
import com.wurmonline.server.items.ItemTemplate;
import com.wurmonline.server.items.ItemTypes;
import com.wurmonline.server.items.Materials;
import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;
import org.nhobody.wurm.brorrowind.Brorrowind;

import java.io.IOException;
import java.util.logging.Level;

public class DwemerBarrel {
    public static void onItemTemplatesCreated() {

        ItemTemplateBuilder builder = new ItemTemplateBuilder("mod.nhobody.Brorrowind.DwemerBarrel");
        builder.name("Dwemer Barrel", "Dwemer Barrels", "A big metal barrel.");
        builder.itemTypes(new short[]{
                ItemTypes.ITEM_TYPE_NAMED,
                ItemTypes.ITEM_TYPE_OWNER_DESTROYABLE,
                ItemTypes.ITEM_TYPE_HOLLOW,
                ItemTypes.ITEM_TYPE_METAL,
                ItemTypes.ITEM_TYPE_DESTROYABLE,
                ItemTypes.ITEM_TYPE_CONTAINER_LIQUID,
                ItemTypes.ITEM_TYPE_TURNABLE,
                ItemTypes.ITEM_TYPE_DECORATION,
                ItemTypes.ITEM_TYPE_REPAIRABLE,
                ItemTypes.ITEM_TYPE_NOT_MISSION,
                ItemTypes.ITEM_TYPE_TRANSPORTABLE,
                ItemTypes.ITEM_TYPE_PLANTABLE,
        });
        builder.modelName("model.mod.nhobody.Brorrowind.DwemerBarrel.");
        builder.material(Materials.MATERIAL_IRON);
        builder.dimensions(50, 50, 100);
        builder.weightGrams(2500);
        builder.behaviourType(BehaviourList.itemBehaviour);
        builder.combatDamage(0);
        builder.decayTime(Long.MAX_VALUE);
        builder.difficulty(40.0f);
        builder.value(1000);

        ItemTemplate template = null;

        try {
            template = builder.build();
        } catch (IOException e) {
            Brorrowind.logger.log(Level.SEVERE, "Failed while creating item template for DwemerBarrel.", e);
        }
    }
}
