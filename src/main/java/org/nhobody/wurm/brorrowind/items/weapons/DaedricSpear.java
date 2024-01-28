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

public class DaedricSpear {
    public static void onItemTemplatesCreated() {

        ItemTemplateBuilder builder = new ItemTemplateBuilder("mod.nhobody.Brorrowind.DaedricSpear");
        builder.name("Daedric Spear", "Daedric Spears", "Metal infused with the power of the daedra.");
        builder.itemTypes(new short[]{
                ItemTypes.ITEM_TYPE_DISARM_TRAP,
                ItemTypes.ITEM_TYPE_NAMED,
                ItemTypes.ITEM_TYPE_REPAIRABLE,
                ItemTypes.ITEM_TYPE_METAL, //base longspear is wood. doesn't make sense for daedric.
                ItemTypes.ITEM_TYPE_WEAPON_PIERCE,
                ItemTypes.ITEM_TYPE_WEAPON,
                ItemTypes.ITEM_TYPE_WEAPON_POLEARM,
                ItemTypes.ITEM_TYPE_TWOHANDED
        });
        builder.modelName("model.mod.nhobody.Brorrowind.DaedricSpear.");
        builder.material(Materials.MATERIAL_IRON);
        builder.dimensions(5, 10, 80);
        builder.weightGrams(250);
        builder.behaviourType(BehaviourList.itemBehaviour);
        builder.combatDamage(40);
        builder.decayTime(Long.MAX_VALUE);
        builder.primarySkill(SkillList.SPEAR_LONG);
        builder.bodySpaces(MiscConstants.EMPTY_BYTE_PRIMITIVE_ARRAY);
        builder.difficulty(40.0f);
        builder.value(1000);

        ItemTemplate template = null;

        try {
            template = builder.build();
        } catch (IOException e) {
            Brorrowind.logger.log(Level.SEVERE, "Failed while creating item template for Daedric Spear.", e);
        }
        if(template != null) {
            //weapon stats: Steel spear(metal long spear)
            //new Weapon(template.getTemplateId(), 9.0F, 5.0F, 0.06F, 7, 4, 1.0F, 0.0D);
            //new Weapon(template.getTemplateId(), 10.5F, 4.75F, 0.06F, 7, 4, 1.0F, 0.0D);
            new Weapon(template.getTemplateId(), Brorrowind.daedricSpearDamage, Brorrowind.daedricSpearSpeed, Brorrowind.daedricSpearCrit, 7, 4, Brorrowind.daedricSpearParry, 0.0D);

            if (Brorrowind.enableDaedricWeaponsCrafting) {
                AdvancedCreationEntry craftEntry = CreationEntryCreator.createAdvancedEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING,
                        ItemList.staffSteel, ItemList.spearTip, template.getTemplateId(), true, false, 0.0f, true, false, 0, 50, CreationCategories.WEAPONS);
                craftEntry.addRequirement(new CreationRequirement(1, Brorrowind.soulID, 100, true));
            }
        }

    }
}
