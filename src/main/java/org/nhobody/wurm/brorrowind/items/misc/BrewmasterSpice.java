package org.nhobody.wurm.brorrowind.items.misc;

import com.wurmonline.server.behaviours.BehaviourList;
import com.wurmonline.server.items.*;
import com.wurmonline.server.skills.SkillList;
import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;
import org.nhobody.wurm.brorrowind.Brorrowind;

import java.io.IOException;
import java.util.logging.Level;

public class BrewmasterSpice {
    public static int templateID;
    public static void onItemTemplatesCreated() {
        ItemTemplateBuilder builder = new ItemTemplateBuilder("mod.nhobody.Brorrowind.BrewmasterSpice");
        builder.name("Brewmaster Spice", "Brewmaster Spice", "The secret to ancient Dwemer distilling methods.");
        builder.itemTypes(new short[]{
                ItemTypes.ITEM_TYPE_NAMED,
                ItemTypes.ITEM_TYPE_REPAIRABLE,
        });
        builder.modelName("model.mod.nhobody.Brorrowind.DwemerMug.");
        builder.material(Materials.MATERIAL_IRON);
        builder.dimensions(5, 10, 50);
        builder.weightGrams(250);
        builder.behaviourType(BehaviourList.itemBehaviour);
        builder.combatDamage(0);
        builder.decayTime(Long.MAX_VALUE);
        builder.difficulty(40.0f);
        builder.value(1000);
        builder.containerSize(1,1,1);

        ItemTemplate template = null;

        try {
            template = builder.build();
            templateID = template.getTemplateId();
        } catch (IOException e) {
            Brorrowind.logger.log(Level.SEVERE, "Failed while creating item template for BrewmasterSpice.", e);
        }
        if (template != null && Brorrowind.enableBrewmasterSpiceCrafting)
        {
            AdvancedCreationEntry testEntry = CreationEntryCreator.createAdvancedEntry(SkillList.ALCHEMY_NATURAL,
                    ItemList.basil,ItemList.sage,template.getTemplateId(),true, false, 0.0f, true, false,0,0,CreationCategories.ALCHEMY);
            testEntry.addRequirement(new CreationRequirement(1, ItemList.oregano,1, true));
        }
    }
}