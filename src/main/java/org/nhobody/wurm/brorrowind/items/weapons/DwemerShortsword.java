package org.nhobody.wurm.brorrowind.items.weapons;

import com.wurmonline.server.MiscConstants;
import com.wurmonline.server.behaviours.BehaviourList;
import com.wurmonline.server.combat.Weapon;
import com.wurmonline.server.items.*;
import com.wurmonline.server.skills.SkillList;
import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;
import org.nhobody.wurm.brorrowind.Brorrowind;

import java.io.IOException;
import java.util.logging.Level;

public class DwemerShortsword {
    public static void onItemTemplatesCreated() {

        ItemTemplateBuilder builder = new ItemTemplateBuilder("mod.nhobody.Brorrowind.DwemerShortsword");
        builder.name("Dwemer Shortsword", "Dwemer Shortsword", "A weapon forged by a long forgotten people.");
        builder.itemTypes(new short[]{
                ItemTypes.ITEM_TYPE_NAMED,
                ItemTypes.ITEM_TYPE_REPAIRABLE,
                ItemTypes.ITEM_TYPE_METAL,
                ItemTypes.ITEM_TYPE_WEAPON_PIERCE,
                ItemTypes.ITEM_TYPE_WEAPON,
                ItemTypes.ITEM_TYPE_WEAPON_SWORD,
        });
        builder.modelName("model.mod.nhobody.Brorrowind.DwemerShortsword.");
        builder.material(Materials.MATERIAL_IRON);
        builder.dimensions(5, 10, 80);
        builder.weightGrams(250);
        builder.behaviourType(BehaviourList.itemBehaviour);
        builder.combatDamage(40);
        builder.decayTime(Long.MAX_VALUE);
        builder.primarySkill(SkillList.SWORD_LONG);
        builder.bodySpaces(MiscConstants.EMPTY_BYTE_PRIMITIVE_ARRAY);
        builder.difficulty(40.0f);
        builder.value(1000);

        ItemTemplate template = null;

        try {
            template = builder.build();
        } catch (IOException e) {
            Brorrowind.logger.log(Level.SEVERE, "Failed while creating item template for DwemerShortsword.", e);
        }
        if(template != null) {
            //weapon stats: short sword
            //new Weapon(template.getTemplateId(), 4.0F, 3.0F, 0.1F, 2, 1, 1.0F, 0.0D);
            //new Weapon(template.getTemplateId(), 5.5F, 3.0F, 0.1F, 2, 1, 1.0F, 0.0D);
            new Weapon(template.getTemplateId(), Brorrowind.dwemerShortswordDamage, Brorrowind.dwemerShortswordSpeed, Brorrowind.dwemerShortswordCrit, 2, 1, Brorrowind.dwemerShortswordParry, 0.0D);
            if(Brorrowind.enableDwemerWeaponsCrafting) {
                AdvancedCreationEntry craftEntry = CreationEntryCreator.createAdvancedEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING,
                        ItemList.swordBladeShort, ItemList.woodenHandleSword, template.getTemplateId(), true, false, 0.0f, true, false, 0, 50, CreationCategories.WEAPONS);
            }
        }
    }
}
