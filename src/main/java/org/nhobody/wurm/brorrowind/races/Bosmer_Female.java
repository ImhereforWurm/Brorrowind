package org.nhobody.wurm.brorrowind.races;

import com.wurmonline.server.behaviours.BehaviourList;
import com.wurmonline.server.items.*;
import com.wurmonline.server.skills.SkillList;
import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;
import org.nhobody.wurm.brorrowind.Brorrowind;

import java.io.IOException;
import java.util.logging.Level;

public class Bosmer_Female {
    public static void onItemTemplatesCreated() {
        ItemTemplateBuilder builder = new ItemTemplateBuilder("mod.nhobody.Brorrowind.Bosmer_Female");
        builder.name("Bosmer_Female", "Bosmer_Female", "Wood elves, known for their love of trees and cannibalism.");
        builder.itemTypes(new short[]{
                ItemTypes.ITEM_TYPE_NAMED,
                ItemTypes.ITEM_TYPE_REPAIRABLE,
                ItemTypes.ITEM_TYPE_LEATHER,
                ItemTypes.ITEM_TYPE_ARMOUR,
                ItemTypes.ITEM_TYPE_NO_IMPROVE,
        });
        builder.modelName("model.mod.nhobody.Brorrowind.Bosmer_Female.");
        builder.material(Materials.MATERIAL_LEATHER);
        builder.dimensions(2, 40, 40);
        builder.weightGrams(250);
        builder.behaviourType(BehaviourList.itemBehaviour);
        builder.combatDamage(40);
        builder.decayTime(Long.MAX_VALUE);
        builder.bodySpaces(new byte[]{29});
        builder.value(1000);

        ItemTemplate template = null;

        try {
            template = builder.build();
        } catch (IOException e) {
            Brorrowind.logger.log(Level.SEVERE, "Failed while creating item template for Bosmer_Female.", e);
        }
        if(template != null && Brorrowind.enableRaceMasksCrafting) {
            CreationEntryCreator.createSimpleEntry(SkillList.THATCHING, ItemList.mixedGrass, ItemList.mixedGrass,
                    template.getTemplateId(), false, true, 0.0f, false, false, CreationCategories.ALCHEMY);
        }
    }
}
