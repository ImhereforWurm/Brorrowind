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

public class GlassStaff {
    public static void onItemTemplatesCreated() {

        ItemTemplateBuilder builder = new ItemTemplateBuilder("mod.nhobody.Brorrowind.GlassStaff");
        builder.name("Glass Staff", "Glass Staff", "Forged from rare metals and volcanic glass, this weapon is extremely light.");
        builder.itemTypes(new short[]{
                ItemTypes.ITEM_TYPE_NAMED,
                ItemTypes.ITEM_TYPE_REPAIRABLE,
                ItemTypes.ITEM_TYPE_DISARM_TRAP,
                ItemTypes.ITEM_TYPE_METAL,
                ItemTypes.ITEM_TYPE_WEAPON,
                ItemTypes.ITEM_TYPE_WEAPON_POLEARM,
                ItemTypes.ITEM_TYPE_WEAPON_CRUSH,
                ItemTypes.ITEM_TYPE_TWOHANDED
        });
        builder.modelName("model.mod.nhobody.Brorrowind.GlassStaff.");
        builder.material(Materials.MATERIAL_IRON);
        builder.dimensions(5, 10, 80);
        builder.weightGrams(250);
        builder.behaviourType(BehaviourList.itemBehaviour);
        builder.combatDamage(40);
        builder.decayTime(Long.MAX_VALUE);
        builder.primarySkill(SkillList.STAFF);
        builder.bodySpaces(MiscConstants.EMPTY_BYTE_PRIMITIVE_ARRAY);
        builder.difficulty(40.0f);
        builder.value(1000);

        ItemTemplate template = null;

        try {
            template = builder.build();
        } catch (IOException e) {
            Brorrowind.logger.log(Level.SEVERE, "Failed while creating item template for GlassStaff.", e);
        }
        if(template != null) {
            //weapon stats: metal staff
            //new Weapon(template.getTemplateId(), 8.0F, 4.0F, 0.0F, 3, 3, 1.0F, 0.0D);
            //new Weapon(template.getTemplateId(), 9.5F, 3.8F, 0.0F, 3, 3, 1.0F, 0.0D);
            new Weapon(template.getTemplateId(), Brorrowind.glassStaffDamage, Brorrowind.glassStaffSpeed, Brorrowind.glassStaffCrit, 3, 3, Brorrowind.glassStaffParry, 0.0D);
            if (Brorrowind.enableGlassWeaponsCrafting) {
                CreationEntryCreator.createSimpleEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING, ItemList.anvilLarge, ItemList.brassBar,
                        template.getTemplateId(), false, true, 0.0f, false, false, CreationCategories.WEAPONS);
                CreationEntryCreator.createSimpleEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING, ItemList.anvilLarge, ItemList.ironBar,
                        template.getTemplateId(), false, true, 0.0f, false, false, CreationCategories.WEAPONS);
                CreationEntryCreator.createSimpleEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING, ItemList.anvilLarge, ItemList.steelBar,
                        template.getTemplateId(), false, true, 0.0f, false, false, CreationCategories.WEAPONS);
                CreationEntryCreator.createSimpleEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING, ItemList.anvilLarge, ItemList.goldBar,
                        template.getTemplateId(), false, true, 0.0f, false, false, CreationCategories.WEAPONS);
                CreationEntryCreator.createSimpleEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING, ItemList.anvilLarge, ItemList.silverBar,
                        template.getTemplateId(), false, true, 0.0f, false, false, CreationCategories.WEAPONS);
                CreationEntryCreator.createSimpleEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING, ItemList.anvilLarge, ItemList.zincBar,
                        template.getTemplateId(), false, true, 0.0f, false, false, CreationCategories.WEAPONS);
                CreationEntryCreator.createSimpleEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING, ItemList.anvilLarge, ItemList.tinBar,
                        template.getTemplateId(), false, true, 0.0f, false, false, CreationCategories.WEAPONS);
                CreationEntryCreator.createSimpleEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING, ItemList.anvilLarge, ItemList.bronzeBar,
                        template.getTemplateId(), false, true, 0.0f, false, false, CreationCategories.WEAPONS);
                CreationEntryCreator.createSimpleEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING, ItemList.anvilLarge, ItemList.leadBar,
                        template.getTemplateId(), false, true, 0.0f, false, false, CreationCategories.WEAPONS);
                CreationEntryCreator.createSimpleEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING, ItemList.anvilLarge, ItemList.copperBar,
                        template.getTemplateId(), false, true, 0.0f, false, false, CreationCategories.WEAPONS);
                CreationEntryCreator.createSimpleEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING, ItemList.anvilLarge, ItemList.adamantineBar,
                        template.getTemplateId(), false, true, 0.0f, false, false, CreationCategories.WEAPONS);
                CreationEntryCreator.createSimpleEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING, ItemList.anvilLarge, ItemList.glimmerSteelBar,
                        template.getTemplateId(), false, true, 0.0f, false, false, CreationCategories.WEAPONS);
                CreationEntryCreator.createSimpleEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING, ItemList.anvilLarge, ItemList.seryllBar,
                        template.getTemplateId(), false, true, 0.0f, false, false, CreationCategories.WEAPONS);

            }
        }
    }
}