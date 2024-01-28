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

public class GlassLongsword {
    public static void onItemTemplatesCreated() {

        ItemTemplateBuilder builder = new ItemTemplateBuilder("mod.nhobody.Brorrowind.GlassLongsword");
        builder.name("Glass Longsword", "Glass Longsword", "Forged from rare metals and volcanic glass, this weapon is extremely light.");
        builder.itemTypes(new short[]{
                ItemTypes.ITEM_TYPE_NAMED,
                ItemTypes.ITEM_TYPE_REPAIRABLE,
                ItemTypes.ITEM_TYPE_METAL,
                ItemTypes.ITEM_TYPE_WEAPON,
                ItemTypes.ITEM_TYPE_WEAPON_SWORD,
                ItemTypes.ITEM_TYPE_WEAPON_SLASH,
        });
        builder.modelName("model.mod.nhobody.Brorrowind.GlassLongsword.");
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
            Brorrowind.logger.log(Level.SEVERE, "Failed while creating item template for Glass Longsword.", e);
        }
        if(template != null) {
            //weapon stats: long sword
            //new Weapon(template.getTemplateId(), 5.5F, 4.0F, 0.01F, 3, 3, 1.0F, 0.0D);
            //new Weapon(template.getTemplateId(), 6.7F, 3.6F, 0.01F, 3, 3, 1.0F, 0.0D);
            new Weapon(template.getTemplateId(), Brorrowind.glassLongswordDamage, Brorrowind.glassLongswordSpeed, Brorrowind.glassLongswordCrit, 3, 3, Brorrowind.glassLongswordParry, 0.0D);
            if (Brorrowind.enableGlassWeaponsCrafting) {
                AdvancedCreationEntry craftEntry = CreationEntryCreator.createAdvancedEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING,
                        ItemList.swordBladeLong, ItemList.woodenHandleSword, template.getTemplateId(), true, false, 0.0f, true, false, 0, 50, CreationCategories.WEAPONS);
            }
        }
    }
}