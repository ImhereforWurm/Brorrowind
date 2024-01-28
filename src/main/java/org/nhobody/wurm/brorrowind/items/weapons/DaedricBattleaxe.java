package org.nhobody.wurm.brorrowind.items.weapons;

import com.wurmonline.server.Items;
import com.wurmonline.server.MiscConstants;
import com.wurmonline.server.NoSuchItemException;
import com.wurmonline.server.behaviours.BehaviourList;
import com.wurmonline.server.combat.Weapon;
import com.wurmonline.server.items.*;
import com.wurmonline.server.skills.SkillList;
import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;
import org.nhobody.wurm.brorrowind.Brorrowind;

import com.wurmonline.server.items.Item;

import com.wurmonline.server.items.ItemTemplateFactory;


import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaedricBattleaxe {
    public static final Logger logger = Logger.getLogger(DaedricBattleaxe.class.getName());

    public static void onItemTemplatesCreated() {
        ItemTemplateBuilder builder = new ItemTemplateBuilder("mod.nhobody.Brorrowind.DaedricBattleaxe");
        builder.name("Daedric Battleaxe", "Daedric Battleaxes", "Metal infused with the power of the daedra.");
        builder.itemTypes(new short[]{
                ItemTypes.ITEM_TYPE_NAMED,
                ItemTypes.ITEM_TYPE_REPAIRABLE,
                ItemTypes.ITEM_TYPE_METAL,
                ItemTypes.ITEM_TYPE_WEAPON_SLASH,
                ItemTypes.ITEM_TYPE_WEAPON_AXE,
                ItemTypes.ITEM_TYPE_WEAPON,
                ItemTypes.ITEM_TYPE_TWOHANDED
        });
        builder.modelName("model.mod.nhobody.Brorrowind.DaedricBattleaxe.");
        builder.material(Materials.MATERIAL_IRON);
        builder.dimensions(5, 10, 80);
        builder.weightGrams(250);
        builder.behaviourType(BehaviourList.itemBehaviour);
        builder.combatDamage(40);
        builder.decayTime(Long.MAX_VALUE);
        builder.primarySkill(SkillList.AXE_HUGE);
        builder.bodySpaces(MiscConstants.EMPTY_BYTE_PRIMITIVE_ARRAY);
        builder.difficulty(40.0f);
        builder.value(1000);

        ItemTemplate template = null;

        try {
            template = builder.build();
        } catch (IOException e) {
            Brorrowind.logger.log(Level.SEVERE, "Failed while creating item template for Daedric Battleaxe.", e);
        }
        if (template != null) {
            //base weapon stats: huge axe
            //new Weapon(template.getTemplateId(), 12.0F, 6.0F, 0.05F, 5, 5, 0.2F, 0.0D);

            //Brorrowind stats (compensating for buffs/normalization)
            //new Weapon(template.getTemplateId(), 15.2F, 5.9F, 0.05F, 5, 5, 0.2F, 0.0D);
            new Weapon(template.getTemplateId(), Brorrowind.daedricBattleaxeDamage, Brorrowind.daedricBattleaxeSpeed, Brorrowind.daedricBattleaxeCrit, 5, 5, Brorrowind.daedricBattleaxeParry, 0.0D);
            if (Brorrowind.enableDaedricWeaponsCrafting){
                AdvancedCreationEntry craftEntry = CreationEntryCreator.createAdvancedEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING,
                        ItemList.axeHeadHuge, ItemList.shaft, template.getTemplateId(), true, false, 0.0f, true, false, 0, 50, CreationCategories.WEAPONS);
                craftEntry.addRequirement(new CreationRequirement(1, Brorrowind.soulID, 100, true));
            }

        }
    }
}
