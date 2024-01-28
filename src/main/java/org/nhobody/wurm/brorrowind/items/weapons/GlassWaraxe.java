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

public class GlassWaraxe {
    public static void onItemTemplatesCreated() {

        ItemTemplateBuilder builder = new ItemTemplateBuilder("mod.nhobody.Brorrowind.GlassWaraxe");
        builder.name("Glass Waraxe", "Glass Waraxe", "Forged from rare metals and volcanic glass, this weapon is extremely light.");
        builder.itemTypes(new short[]{
                ItemTypes.ITEM_TYPE_NAMED,
                ItemTypes.ITEM_TYPE_REPAIRABLE,
                ItemTypes.ITEM_TYPE_METAL,
                ItemTypes.ITEM_TYPE_WEAPON_SLASH,
                ItemTypes.ITEM_TYPE_WEAPON_AXE,
                ItemTypes.ITEM_TYPE_WEAPON,
        });
        builder.modelName("model.mod.nhobody.Brorrowind.GlassWaraxe.");
        builder.material(Materials.MATERIAL_IRON);
        builder.dimensions(5, 10, 80);
        builder.weightGrams(250);
        builder.behaviourType(BehaviourList.itemBehaviour);
        builder.combatDamage(40);
        builder.decayTime(Long.MAX_VALUE);
        builder.primarySkill(SkillList.AXE_LARGE);
        builder.bodySpaces(MiscConstants.EMPTY_BYTE_PRIMITIVE_ARRAY);
        builder.difficulty(40.0f);
        builder.value(1000);

        ItemTemplate template = null;

        try {
            template = builder.build();
        } catch (IOException e) {
            Brorrowind.logger.log(Level.SEVERE, "Failed while creating item template for GlassWaraxe.", e);
        }
        if(template != null) {
            //weapon stats: large axe
            //new Weapon(template.getTemplateId(), 6.5F, 4.0F, 0.03F, 4, 5, 0.3F, 0.0D);
            //new Weapon(template.getTemplateId(), 8.4F, 4.0F, 0.03F, 4, 5, 0.3F, 0.0D);
            new Weapon(template.getTemplateId(), Brorrowind.glassWaraxeDamage, Brorrowind.glassWaraxeSpeed, Brorrowind.glassWaraxeCrit, 4, 5, Brorrowind.glassWaraxeParry, 0.0D);
            if (Brorrowind.enableGlassWeaponsCrafting) {
                AdvancedCreationEntry craftEntry = CreationEntryCreator.createAdvancedEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING,
                        ItemList.axeHeadMedium, ItemList.shaft, template.getTemplateId(), true, false, 0.0f, true, false, 0, 50, CreationCategories.WEAPONS);
            }
        }
    }
}