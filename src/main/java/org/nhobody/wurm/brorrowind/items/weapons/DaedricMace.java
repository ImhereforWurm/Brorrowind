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
public class DaedricMace {

    public static void onItemTemplatesCreated() {

        ItemTemplateBuilder builder = new ItemTemplateBuilder("mod.nhobody.Brorrowind.DaedricMace");
        builder.name("Daedric Mace", "Daedric Mace", "Metal infused with the power of the daedra.");
        builder.itemTypes(new short[]{
                ItemTypes.ITEM_TYPE_NAMED,
                ItemTypes.ITEM_TYPE_REPAIRABLE,
                ItemTypes.ITEM_TYPE_METAL,
                ItemTypes.ITEM_TYPE_WEAPON,
                ItemTypes.ITEM_TYPE_WEAPON_CRUSH,
        });
        builder.modelName("model.mod.nhobody.Brorrowind.DaedricMace.");
        builder.material(Materials.MATERIAL_IRON);
        builder.dimensions(5, 10, 80);
        builder.weightGrams(250);
        builder.behaviourType(BehaviourList.itemBehaviour);
        builder.combatDamage(40);
        builder.decayTime(Long.MAX_VALUE);
        builder.primarySkill(SkillList.MAUL_MEDIUM);
        builder.bodySpaces(MiscConstants.EMPTY_BYTE_PRIMITIVE_ARRAY);
        builder.difficulty(40.0f);
        builder.value(1000);

        ItemTemplate template = null;

        try {
            template = builder.build();
        } catch (IOException e) {
            Brorrowind.logger.log(Level.SEVERE, "Failed while creating item template for Daedric Mace.", e);
        }
        if(template != null) {
            //weapon stats: medium maul
            //new Weapon(template.getTemplateId(), 8.0F, 5.0F, 0.03F, 3, 2, 1.0F, 0.0D);
            //new Weapon(template.getTemplateId(), 9.75F, 4.75F, 0.03F, 3, 2, 1.0F, 0.0D);
            new Weapon(template.getTemplateId(), Brorrowind.daedricMaceDamage, Brorrowind.daedricMaceSpeed, Brorrowind.daedricMaceCrit, 3, 2, Brorrowind.daedricMaceParry, 0.0D);
            if (Brorrowind.enableDaedricWeaponsCrafting) {
                AdvancedCreationEntry craftEntry = CreationEntryCreator.createAdvancedEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING,
                        ItemList.maulHeadMedium, ItemList.shaft, template.getTemplateId(), true, false, 0.0f, true, false, 0, 50, CreationCategories.WEAPONS);
                craftEntry.addRequirement(new CreationRequirement(1, Brorrowind.soulID, 100, true));
            }
        }

    }
}
