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
import java.util.logging.Logger;

public class BladedFist {
    public static final Logger logger = Logger.getLogger(DaedricBattleaxe.class.getName());

    public static void onItemTemplatesCreated() {
        ItemTemplateBuilder builder = new ItemTemplateBuilder("mod.nhobody.Brorrowind.BladedFist");
        builder.name("Bladed Fist", "Bladed Fist", "A deadly blade that utilizes hand to hand combat skills.");
        builder.itemTypes(new short[]{
                ItemTypes.ITEM_TYPE_NAMED,
                ItemTypes.ITEM_TYPE_REPAIRABLE,
                ItemTypes.ITEM_TYPE_METAL,
                ItemTypes.ITEM_TYPE_WEAPON_SLASH,
                ItemTypes.ITEM_TYPE_WEAPON,
                ItemTypes.ITEM_TYPE_WEAPON_MELEE
        });
        builder.modelName("model.mod.nhobody.Brorrowind.BladedFist.");
        builder.material(Materials.MATERIAL_IRON);
        builder.dimensions(5, 10, 80);
        builder.weightGrams(250);
        builder.behaviourType(BehaviourList.itemBehaviour);
        builder.combatDamage(40);
        builder.decayTime(Long.MAX_VALUE);
        builder.primarySkill(SkillList.WEAPONLESS_FIGHTING);
        builder.bodySpaces(MiscConstants.EMPTY_BYTE_PRIMITIVE_ARRAY);
        builder.difficulty(40.0f);
        builder.value(1000);

        ItemTemplate template = null;

        try {
            template = builder.build();
        } catch (IOException e) {
            Brorrowind.logger.log(Level.SEVERE, "Failed while creating item template for Bladed Fist.", e);
        }
        if (template != null) {
            //base weapon stats: custom/new. here are defaults for knuckles from wyvernmod:
            //new Weapon(Knuckles.templateId, 3.8f, 2.2f, 0.002f, 1, 1, 0.2f, 0.5d);


            //Brorrowind stats: currently only adding 1 to damage, as it appears it was not buffed further by armory mod.
            //new Weapon(Knuckles.templateId, 4.8f, 2.2f, 0.002f, 1, 1, 0.2f, 0.5d);
            new Weapon(template.getTemplateId(), Brorrowind.bladedFistDamage, Brorrowind.bladedFistSpeed, Brorrowind.bladedFistCrit, 1, 1, Brorrowind.bladedFistParry, Brorrowind.bladedFistSkillpenalty);
            if (Brorrowind.enableDaedricWeaponsCrafting){
                AdvancedCreationEntry craftEntry = CreationEntryCreator.createAdvancedEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING,
                        ItemList.swordBladeShort, ItemList.leatherGlove, template.getTemplateId(), true, false, 0.0f, true, false, 0, 50, CreationCategories.WEAPONS);
            }

        }
    }
}