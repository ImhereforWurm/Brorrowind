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
public class DaedricStaff {


    public static void onItemTemplatesCreated() {

        ItemTemplateBuilder builder = new ItemTemplateBuilder("mod.nhobody.Brorrowind.DaedricStaff");
        builder.name("Daedric Staff", "Daedric Staves", "Metal infused with the power of the daedra.");
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
        builder.modelName("model.mod.nhobody.Brorrowind.DaedricStaff.");
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
            Brorrowind.logger.log(Level.SEVERE, "Failed while creating item template for Daedric Staff.", e);
        }
        if(template != null) {
            //weapon stats: metal staff
            //new Weapon(template.getTemplateId(), 8.0F, 4.0F, 0.0F, 3, 3, 1.0F, 0.0D);

            //new Weapon(template.getTemplateId(), 10.5F, 3.8F, 0.0F, 3, 3, 1.0F, 0.0D);
            new Weapon(template.getTemplateId(), Brorrowind.daedricStaffDamage, Brorrowind.daedricStaffSpeed, Brorrowind.daedricStaffCrit, 3, 3, Brorrowind.daedricStaffParry, 0.0D);

            if (Brorrowind.enableDaedricWeaponsCrafting) {
                AdvancedCreationEntry brassCreate = CreationEntryCreator.createAdvancedEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING,
                        ItemList.brassBar, ItemList.anvilLarge, template.getTemplateId(), true, false, 0.0f, false, false, 0, 50.0D, CreationCategories.WEAPONS);
                brassCreate.addRequirement(new CreationRequirement(1, Brorrowind.soulID, 100, true)); //hardcoded because i am a big dingus

                AdvancedCreationEntry ironCreate = CreationEntryCreator.createAdvancedEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING,
                        ItemList.ironBar, ItemList.anvilLarge, template.getTemplateId(), true, false, 0.0f, false, false, 0, 50.0D, CreationCategories.WEAPONS);
                ironCreate.addRequirement(new CreationRequirement(1, Brorrowind.soulID, 100, true));

                AdvancedCreationEntry steelCreate = CreationEntryCreator.createAdvancedEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING,
                        ItemList.steelBar, ItemList.anvilLarge, template.getTemplateId(), true, false, 0.0f, false, false, 0, 50.0D, CreationCategories.WEAPONS);
                steelCreate.addRequirement(new CreationRequirement(1, Brorrowind.soulID, 100, true));

                AdvancedCreationEntry goldCreate = CreationEntryCreator.createAdvancedEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING,
                        ItemList.goldBar, ItemList.anvilLarge, template.getTemplateId(), true, false, 0.0f, false, false, 0, 50.0D, CreationCategories.WEAPONS);
                goldCreate.addRequirement(new CreationRequirement(1, Brorrowind.soulID, 100, true));

                AdvancedCreationEntry silverCreate = CreationEntryCreator.createAdvancedEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING,
                        ItemList.silverBar, ItemList.anvilLarge, template.getTemplateId(), true, false, 0.0f, false, false, 0, 50.0D, CreationCategories.WEAPONS);
                silverCreate.addRequirement(new CreationRequirement(1, Brorrowind.soulID, 100, true));

                AdvancedCreationEntry copperCreate = CreationEntryCreator.createAdvancedEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING,
                        ItemList.copperBar, ItemList.anvilLarge, template.getTemplateId(), true, false, 0.0f, false, false, 0, 50.0D, CreationCategories.WEAPONS);
                copperCreate.addRequirement(new CreationRequirement(1, Brorrowind.soulID, 100, true));

                AdvancedCreationEntry adamantCreate = CreationEntryCreator.createAdvancedEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING,
                        ItemList.adamantineBar, ItemList.anvilLarge, template.getTemplateId(), true, false, 0.0f, false, false, 0, 50.0D, CreationCategories.WEAPONS);
                adamantCreate.addRequirement(new CreationRequirement(1, Brorrowind.soulID, 100, true));

                AdvancedCreationEntry glimCreate = CreationEntryCreator.createAdvancedEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING,
                        ItemList.glimmerSteelBar, ItemList.anvilLarge, template.getTemplateId(), true, false, 0.0f, false, false, 0, 50.0D, CreationCategories.WEAPONS);
                glimCreate.addRequirement(new CreationRequirement(1, Brorrowind.soulID, 100, true));

                AdvancedCreationEntry seryllCreate = CreationEntryCreator.createAdvancedEntry(SkillList.GROUP_SMITHING_WEAPONSMITHING,
                        ItemList.seryllBar, ItemList.anvilLarge, template.getTemplateId(), true, false, 0.0f, false, false, 0, 50.0D, CreationCategories.WEAPONS);
                seryllCreate.addRequirement(new CreationRequirement(1, Brorrowind.soulID, 100, true));
            }

        }

    }
}
