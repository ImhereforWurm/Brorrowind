package org.nhobody.wurm.brorrowind.items;

import com.wurmonline.server.MiscConstants;
import com.wurmonline.server.behaviours.BehaviourList;
import com.wurmonline.server.combat.Weapon;
import com.wurmonline.server.items.*;
import com.wurmonline.server.skills.SkillList;
import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;
import org.nhobody.wurm.brorrowind.Brorrowind;

import java.io.IOException;
import java.util.logging.Level;

public class DagothTPose {
    public static void onItemTemplatesCreated() {

        ItemTemplateBuilder builder = new ItemTemplateBuilder("mod.nhobody.Brorrowind.DagothTPose");
        builder.name("Dagoth Ur T Pose", "Dagoth Ur T Pose (several)", "Dagoth Ur asserts his dominance over all of Brorrowind. This is a test item.");
        builder.itemTypes(new short[]{
                ItemTypes.ITEM_TYPE_NAMED,
                ItemTypes.ITEM_TYPE_REPAIRABLE,
                ItemTypes.ITEM_TYPE_METAL,
        });
        builder.modelName("model.mod.nhobody.Brorrowind.DagothTPose.");
        builder.material(Materials.MATERIAL_STONE);
        builder.dimensions(500, 500, 2000);
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
            Brorrowind.logger.log(Level.SEVERE, "Failed while creating item template for Dagoth Ur T Pose.", e);
        }
        if(template != null) {

        }

    }
}