package org.nhobody.wurm.brorrowind.items.armor;

import com.wurmonline.server.behaviours.BehaviourList;
import com.wurmonline.server.items.ItemTemplate;
import com.wurmonline.server.items.ItemTypes;
import com.wurmonline.server.items.Materials;
import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;
import org.nhobody.wurm.brorrowind.Brorrowind;

import java.io.IOException;
import java.util.logging.Level;

public class DarkBrotherhoodHelm {
    public static void onItemTemplatesCreated() {
        ItemTemplateBuilder builder = new ItemTemplateBuilder("mod.nhobody.Brorrowind.DarkBrotherhoodHelm");
        builder.name("dark brotherhood helm", "dark brotherhood helm", "Helmet used by members of the Dark Brotherhood. Functionally the same as leather armor.");
        builder.itemTypes(new short[]{
                ItemTypes.ITEM_TYPE_NAMED,
                ItemTypes.ITEM_TYPE_REPAIRABLE,
                ItemTypes.ITEM_TYPE_LEATHER,
                ItemTypes.ITEM_TYPE_ARMOUR,
        });
        builder.modelName("model.mod.nhobody.Brorrowind.DarkBrotherhoodHelm.");
        builder.material(Materials.MATERIAL_LEATHER);
        builder.dimensions(2, 40, 40);
        builder.weightGrams(250);
        builder.behaviourType(BehaviourList.itemBehaviour);
        builder.combatDamage(40);
        builder.decayTime(Long.MAX_VALUE);
        builder.bodySpaces(new byte[]{1, 28});
        builder.difficulty(40.0f);
        builder.value(1000);

        ItemTemplate template = null;

        try {
            template = builder.build();
        } catch (IOException e) {
            Brorrowind.logger.log(Level.SEVERE, "Failed while creating item template for DarkBrotherhoodHelm.", e);
        }
        if(template != null) {}
    }
}
