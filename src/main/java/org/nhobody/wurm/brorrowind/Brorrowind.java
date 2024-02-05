package org.nhobody.wurm.brorrowind;

import com.wurmonline.server.creatures.Communicator;
import com.wurmonline.server.items.ItemTemplate;
import com.wurmonline.server.items.ItemTemplateFactory;
import org.gotti.wurmunlimited.modloader.interfaces.*;
import org.gotti.wurmunlimited.modsupport.actions.ModActions;
import org.nhobody.wurm.brorrowind.actions.*;
import org.nhobody.wurm.brorrowind.buildings.*;
import org.nhobody.wurm.brorrowind.commands.ProtectFromPlayers;
import org.nhobody.wurm.brorrowind.items.*;
import org.nhobody.wurm.brorrowind.items.armor.DarkBrotherhoodHelm;
import org.nhobody.wurm.brorrowind.items.misc.*;
import org.nhobody.wurm.brorrowind.items.weapons.*;
import org.nhobody.wurm.brorrowind.races.*;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Brorrowind implements WurmServerMod, ItemTemplatesCreatedListener, Versioned, ServerStartedListener, PlayerMessageListener, Configurable {
    public static final Logger logger = Logger.getLogger(Brorrowind.class.getName());
    public static int soulID;
    public static boolean enableBrewmasterSpice = true;
    public static boolean enableBrewmasterSpiceCrafting = true;
    public static boolean enableShardOfLorkhan = true;
    public static boolean enableProtectFromPlayers = true;
    public static boolean enableRaceMasks = true;
    public static boolean enableRaceMasksCrafting = true;
    public static boolean enableNwahEmote = true;
    public static boolean enableFortunateSon = true;
    public static boolean enableStructures = true;
    public static boolean enableDecorations = true;
    public static boolean enableDarkBrotherhoodHelm = true;

    public static boolean enableBladedFist = true;
    public static float bladedFistDamage, bladedFistSpeed, bladedFistCrit, bladedFistParry;
    public static double bladedFistSkillpenalty;
    public static boolean enableDaedricWeapons = true;
    public static boolean enableDaedricWeaponsCrafting = true;

    public static float daedricBattleaxeDamage, daedricBattleaxeSpeed, daedricBattleaxeCrit, daedricBattleaxeParry;
    public static float daedricClaymoreDamage, daedricClaymoreSpeed, daedricClaymoreCrit, daedricClaymoreParry;
    public static float daedricDaikatanaDamage, daedricDaikatanaSpeed, daedricDaikatanaCrit, daedricDaikatanaParry;
    public static float daedricKatanaDamage, daedricKatanaSpeed, daedricKatanaCrit, daedricKatanaParry;
    public static float daedricLongswordDamage, daedricLongswordSpeed, daedricLongswordCrit, daedricLongswordParry;
    public static float daedricMaceDamage, daedricMaceSpeed, daedricMaceCrit, daedricMaceParry;
    public static float daedricScytheDamage, daedricScytheSpeed, daedricScytheCrit, daedricScytheParry;
    public static double daedricScytheSkillpenalty;
    public static float daedricSickleDamage, daedricSickleSpeed, daedricSickleCrit, daedricSickleParry;
    public static double daedricSickleSkillpenalty;
    public static float daedricSpearDamage, daedricSpearSpeed, daedricSpearCrit, daedricSpearParry;
    public static float daedricStaffDamage, daedricStaffSpeed, daedricStaffCrit, daedricStaffParry;
    public static float daedricWakazashiDamage, daedricWakazashiSpeed, daedricWakazashiCrit, daedricWakazashiParry;
    public static float daedricWaraxeDamage, daedricWaraxeSpeed, daedricWaraxeCrit, daedricWaraxeParry;
    public static float daedricWarhammerDamage, daedricWarhammerSpeed, daedricWarhammerCrit, daedricWarhammerParry;


    public static boolean enableDwemerWeapons = true;
    public static boolean enableDwemerWeaponsCrafting = true;
    public static float dwemerBattleaxeDamage, dwemerBattleaxeSpeed, dwemerBattleaxeCrit, dwemerBattleaxeParry;
    public static float dwemerClaymoreDamage, dwemerClaymoreSpeed, dwemerClaymoreCrit, dwemerClaymoreParry;
    public static float dwemerHalbredDamage, dwemerHalbredSpeed, dwemerHalbredCrit, dwemerHalbredParry;
    public static float dwemerLongspearDamage, dwemerLongspearSpeed, dwemerLongspearCrit, dwemerLongspearParry;
    public static float dwemerMaceDamage, dwemerMaceSpeed, dwemerMaceCrit, dwemerMaceParry;
    public static float dwemerShortswordDamage, dwemerShortswordSpeed, dwemerShortswordCrit, dwemerShortswordParry;
    public static float dwemerWaraxeDamage, dwemerWaraxeSpeed, dwemerWaraxeCrit, dwemerWaraxeParry;
    public static float dwemerWarhammerDamage, dwemerWarhammerSpeed, dwemerWarhammerCrit, dwemerWarhammerParry;


    public static boolean enableGlassWeapons = true;
    public static boolean enableGlassWeaponsCrafting = true;

    public static float glassClaymoreDamage, glassClaymoreSpeed, glassClaymoreCrit, glassClaymoreParry;
    public static float glassDaggerDamage, glassDaggerSpeed, glassDaggerCrit, glassDaggerParry;
    public static float glassHalberdDamage, glassHalberdSpeed, glassHalberdCrit, glassHalberdParry;
    public static float glassLongswordDamage, glassLongswordSpeed, glassLongswordCrit, glassLongswordParry;
    public static float glassStaffDamage, glassStaffSpeed, glassStaffCrit, glassStaffParry;
    public static float glassWaraxeDamage, glassWaraxeSpeed, glassWaraxeCrit, glassWaraxeParry;


    @Override
    public void configure(Properties properties) {
        enableBrewmasterSpice = Boolean.parseBoolean(properties.getProperty("enableBrewmasterSpice",String.valueOf(enableBrewmasterSpice)));
        enableBrewmasterSpiceCrafting = Boolean.parseBoolean(properties.getProperty("enableBrewmasterSpiceCrafting",String.valueOf(enableBrewmasterSpiceCrafting)));
        enableShardOfLorkhan = Boolean.parseBoolean(properties.getProperty("enableShardOfLorkhan",String.valueOf(enableShardOfLorkhan)));
        enableProtectFromPlayers = Boolean.parseBoolean(properties.getProperty("enableProtectFromPlayers",String.valueOf(enableProtectFromPlayers)));
        enableRaceMasks = Boolean.parseBoolean(properties.getProperty("enableRaceMasks",String.valueOf(enableRaceMasks)));
        enableRaceMasksCrafting = Boolean.parseBoolean(properties.getProperty("enableRaceMasksCrafting",String.valueOf(enableRaceMasksCrafting)));
        enableNwahEmote = Boolean.parseBoolean(properties.getProperty("enableNwahEmote",String.valueOf(enableNwahEmote)));
        enableFortunateSon = Boolean.parseBoolean(properties.getProperty("enableFortunateSon",String.valueOf(enableFortunateSon)));
        enableStructures = Boolean.parseBoolean(properties.getProperty("enableStructures",String.valueOf(enableStructures)));
        enableDecorations = Boolean.parseBoolean(properties.getProperty("enableDecorations",String.valueOf(enableDecorations)));
        enableDarkBrotherhoodHelm = Boolean.parseBoolean(properties.getProperty("enableDarkBrotherhoodHelm",String.valueOf(enableDarkBrotherhoodHelm)));

        enableBladedFist = Boolean.parseBoolean(properties.getProperty("enableBladedFist",String.valueOf(enableBladedFist)));
        bladedFistDamage = Float.parseFloat(properties.getProperty("bladedFistDamage",String.valueOf(3.8F)));
        bladedFistSpeed = Float.parseFloat(properties.getProperty("bladedFistSpeed",String.valueOf(2.2F)));
        bladedFistCrit = Float.parseFloat(properties.getProperty("bladedFistCrit",String.valueOf(0.002F)));
        bladedFistParry = Float.parseFloat(properties.getProperty("bladedFistParry",String.valueOf(0.2F)));
        bladedFistSkillpenalty = Double.parseDouble(properties.getProperty("bladedFistSkillpenalty", String.valueOf(0.5D)));

        enableDaedricWeapons = Boolean.parseBoolean(properties.getProperty("enableDaedricWeapons",String.valueOf(enableDaedricWeapons)));
        enableDaedricWeaponsCrafting = Boolean.parseBoolean(properties.getProperty("enableDaedricWeaponsCrafting",String.valueOf(enableDaedricWeaponsCrafting)));

        daedricBattleaxeDamage = Float.parseFloat(properties.getProperty("daedricBattleaxeDamage",String.valueOf(14F)));
        daedricBattleaxeSpeed = Float.parseFloat(properties.getProperty("daedricBattleaxeSpeed",String.valueOf(6F)));
        daedricBattleaxeCrit = Float.parseFloat(properties.getProperty("daedricBattleaxeCrit",String.valueOf(0.05F)));
        daedricBattleaxeParry = Float.parseFloat(properties.getProperty("daedricBattleaxeParry",String.valueOf(0.2F)));

        daedricClaymoreDamage = Float.parseFloat(properties.getProperty("daedricClaymoreDamage",String.valueOf(11F)));
        daedricClaymoreSpeed = Float.parseFloat(properties.getProperty("daedricClaymoreSpeed",String.valueOf(5F)));
        daedricClaymoreCrit = Float.parseFloat(properties.getProperty("daedricClaymoreCrit",String.valueOf(0.05F)));
        daedricClaymoreParry = Float.parseFloat(properties.getProperty("daedricClaymoreParry",String.valueOf(1.0F)));

        daedricDaikatanaDamage = Float.parseFloat(properties.getProperty("daedricDaikatanaDamage", String.valueOf(11F)));
        daedricDaikatanaSpeed = Float.parseFloat(properties.getProperty("daedricDaikatanaSpeed", String.valueOf(5F)));
        daedricDaikatanaCrit = Float.parseFloat(properties.getProperty("daedricDaikatanaCrit", String.valueOf(0.05F)));
        daedricDaikatanaParry = Float.parseFloat(properties.getProperty("daedricDaikatanaParry", String.valueOf(1.0F)));

        daedricKatanaDamage = Float.parseFloat(properties.getProperty("daedricKatanaDamage", String.valueOf(6.5F)));
        daedricKatanaSpeed = Float.parseFloat(properties.getProperty("daedricKatanaSpeed", String.valueOf(4.0F)));
        daedricKatanaCrit = Float.parseFloat(properties.getProperty("daedricKatanaCrit", String.valueOf(0.01F)));
        daedricKatanaParry = Float.parseFloat(properties.getProperty("daedricKatanaParry", String.valueOf(1.0F)));

        daedricLongswordDamage = Float.parseFloat(properties.getProperty("daedricLongswordDamage", String.valueOf(6.5F)));
        daedricLongswordSpeed = Float.parseFloat(properties.getProperty("daedricLongswordSpeed", String.valueOf(4.0F)));
        daedricLongswordCrit = Float.parseFloat(properties.getProperty("daedricLongswordCrit", String.valueOf(0.01F)));
        daedricLongswordParry = Float.parseFloat(properties.getProperty("daedricLongswordParry", String.valueOf(1.0F)));

        daedricMaceDamage = Float.parseFloat(properties.getProperty("daedricMaceDamage", String.valueOf(9.0F)));
        daedricMaceSpeed = Float.parseFloat(properties.getProperty("daedricMaceSpeed", String.valueOf(5.0F)));
        daedricMaceCrit = Float.parseFloat(properties.getProperty("daedricMaceCrit", String.valueOf(0.03F)));
        daedricMaceParry = Float.parseFloat(properties.getProperty("daedricMaceParry", String.valueOf(1.0F)));

        daedricScytheDamage = Float.parseFloat(properties.getProperty("daedricScytheDamage", String.valueOf(11.0F)));
        daedricScytheSpeed = Float.parseFloat(properties.getProperty("daedricScytheSpeed", String.valueOf(5.0F)));
        daedricScytheCrit = Float.parseFloat(properties.getProperty("daedricScytheCrit", String.valueOf(0.08F)));
        daedricScytheParry = Float.parseFloat(properties.getProperty("daedricScytheParry", String.valueOf(0.2F)));
        daedricScytheSkillpenalty = Double.parseDouble(properties.getProperty("daedricScytheSkillpenalty", String.valueOf(0.0D)));

        daedricSickleDamage = Float.parseFloat(properties.getProperty("daedricSickleDamage", String.valueOf(7.0F)));
        daedricSickleSpeed = Float.parseFloat(properties.getProperty("daedricSickleSpeed", String.valueOf(3.0F)));
        daedricSickleCrit = Float.parseFloat(properties.getProperty("daedricSickleCrit", String.valueOf(0.02F)));
        daedricSickleParry = Float.parseFloat(properties.getProperty("daedricSickleParry", String.valueOf(0.2F)));
        daedricSickleSkillpenalty = Double.parseDouble(properties.getProperty("daedricSickleSkillpenalty", String.valueOf(0.0D)));

        daedricSpearDamage = Float.parseFloat(properties.getProperty("daedricSpearDamage", String.valueOf(11.0F)));
        daedricSpearSpeed = Float.parseFloat(properties.getProperty("daedricSpearSpeed", String.valueOf(5.0F)));
        daedricSpearCrit = Float.parseFloat(properties.getProperty("daedricSpearCrit", String.valueOf(0.06F)));
        daedricSpearParry = Float.parseFloat(properties.getProperty("daedricSpearParry", String.valueOf(1.0F)));

        daedricStaffDamage = Float.parseFloat(properties.getProperty("daedricStaffDamage", String.valueOf(10.0F)));
        daedricStaffSpeed = Float.parseFloat(properties.getProperty("daedricStaffSpeed", String.valueOf(4.0F)));
        daedricStaffCrit = Float.parseFloat(properties.getProperty("daedricStaffCrit", String.valueOf(0.0F)));
        daedricStaffParry = Float.parseFloat(properties.getProperty("daedricStaffParry", String.valueOf(1.0F)));

        daedricWakazashiDamage = Float.parseFloat(properties.getProperty("daedricWakazashiDamage", String.valueOf(5.0F)));
        daedricWakazashiSpeed = Float.parseFloat(properties.getProperty("daedricWakazashiSpeed", String.valueOf(3.0F)));
        daedricWakazashiCrit = Float.parseFloat(properties.getProperty("daedricWakazashiCrit", String.valueOf(0.1F)));
        daedricWakazashiParry = Float.parseFloat(properties.getProperty("daedricWakazashiParry", String.valueOf(1.0F)));

        daedricWaraxeDamage = Float.parseFloat(properties.getProperty("daedricWaraxeDamage", String.valueOf(7.5F)));
        daedricWaraxeSpeed = Float.parseFloat(properties.getProperty("daedricWaraxeSpeed", String.valueOf(4.0F)));
        daedricWaraxeCrit = Float.parseFloat(properties.getProperty("daedricWaraxeCrit", String.valueOf(0.03F)));
        daedricWaraxeParry = Float.parseFloat(properties.getProperty("daedricWaraxeParry", String.valueOf(0.3F)));

        daedricWarhammerDamage = Float.parseFloat(properties.getProperty("daedricWarhammerDamage", String.valueOf(13.0F)));
        daedricWarhammerSpeed = Float.parseFloat(properties.getProperty("daedricWarhammerSpeed", String.valueOf(6.0F)));
        daedricWarhammerCrit = Float.parseFloat(properties.getProperty("daedricWarhammerCrit", String.valueOf(0.03F)));
        daedricWarhammerParry = Float.parseFloat(properties.getProperty("daedricWarhammerParry", String.valueOf(1.0F)));

        enableDwemerWeapons = Boolean.parseBoolean(properties.getProperty("enableDwemerWeapons",String.valueOf(enableDwemerWeapons)));
        enableDwemerWeaponsCrafting = Boolean.parseBoolean(properties.getProperty("enableDwemerWeaponsCrafting",String.valueOf(enableDwemerWeaponsCrafting)));

        dwemerBattleaxeDamage = Float.parseFloat(properties.getProperty("dwemerBattleaxeDamage", String.valueOf(12.0F)));
        dwemerBattleaxeSpeed = Float.parseFloat(properties.getProperty("dwemerBattleaxeSpeed", String.valueOf(6.0F)));
        dwemerBattleaxeCrit = Float.parseFloat(properties.getProperty("dwemerBattleaxeCrit", String.valueOf(0.05F)));
        dwemerBattleaxeParry = Float.parseFloat(properties.getProperty("dwemerBattleaxeParry", String.valueOf(0.2F)));

        dwemerClaymoreDamage = Float.parseFloat(properties.getProperty("dwemerClaymoreDamage", String.valueOf(9.0F)));
        dwemerClaymoreSpeed = Float.parseFloat(properties.getProperty("dwemerClaymoreSpeed", String.valueOf(5.0F)));
        dwemerClaymoreCrit = Float.parseFloat(properties.getProperty("dwemerClaymoreCrit", String.valueOf(0.05F)));
        dwemerClaymoreParry = Float.parseFloat(properties.getProperty("dwemerClaymoreParry", String.valueOf(1.0F)));

        dwemerHalbredDamage = Float.parseFloat(properties.getProperty("dwemerHalbredDamage", String.valueOf(9.0F)));
        dwemerHalbredSpeed = Float.parseFloat(properties.getProperty("dwemerHalbredSpeed", String.valueOf(5.0F)));
        dwemerHalbredCrit = Float.parseFloat(properties.getProperty("dwemerHalbredCrit", String.valueOf(0.06F)));
        dwemerHalbredParry = Float.parseFloat(properties.getProperty("dwemerHalbredParry", String.valueOf(1.0F)));

        dwemerLongspearDamage = Float.parseFloat(properties.getProperty("dwemerLongspearDamage", String.valueOf(9.0F)));
        dwemerLongspearSpeed = Float.parseFloat(properties.getProperty("dwemerLongspearSpeed", String.valueOf(5.0F)));
        dwemerLongspearCrit = Float.parseFloat(properties.getProperty("dwemerLongspearCrit", String.valueOf(0.06F)));
        dwemerLongspearParry = Float.parseFloat(properties.getProperty("dwemerLongspearParry", String.valueOf(1.0F)));

        dwemerMaceDamage = Float.parseFloat(properties.getProperty("dwemerMaceDamage", String.valueOf(8.0F)));
        dwemerMaceSpeed = Float.parseFloat(properties.getProperty("dwemerMaceSpeed", String.valueOf(5.0F)));
        dwemerMaceCrit = Float.parseFloat(properties.getProperty("dwemerMaceCrit", String.valueOf(0.03F)));
        dwemerMaceParry = Float.parseFloat(properties.getProperty("dwemerMaceParry", String.valueOf(1.0F)));

        dwemerShortswordDamage = Float.parseFloat(properties.getProperty("dwemerShortswordDamage", String.valueOf(4.0F)));
        dwemerShortswordSpeed = Float.parseFloat(properties.getProperty("dwemerShortswordSpeed", String.valueOf(3.0F)));
        dwemerShortswordCrit = Float.parseFloat(properties.getProperty("dwemerShortswordCrit", String.valueOf(0.1F)));
        dwemerShortswordParry = Float.parseFloat(properties.getProperty("dwemerShortswordParry", String.valueOf(1.0F)));

        dwemerWaraxeDamage = Float.parseFloat(properties.getProperty("dwemerWaraxeDamage", String.valueOf(6.5F)));
        dwemerWaraxeSpeed = Float.parseFloat(properties.getProperty("dwemerWaraxeSpeed", String.valueOf(4.0F)));
        dwemerWaraxeCrit = Float.parseFloat(properties.getProperty("dwemerWaraxeCrit", String.valueOf(0.03F)));
        dwemerWaraxeParry = Float.parseFloat(properties.getProperty("dwemerWaraxeParry", String.valueOf(0.3F)));

        dwemerWarhammerDamage = Float.parseFloat(properties.getProperty("dwemerWarhammerDamage", String.valueOf(11.0F)));
        dwemerWarhammerSpeed = Float.parseFloat(properties.getProperty("dwemerWarhammerSpeed", String.valueOf(6.0F)));
        dwemerWarhammerCrit = Float.parseFloat(properties.getProperty("dwemerWarhammerCrit", String.valueOf(0.03F)));
        dwemerWarhammerParry= Float.parseFloat(properties.getProperty("dwemerWarhammerParry", String.valueOf(1.0F)));


        enableGlassWeapons = Boolean.parseBoolean(properties.getProperty("enableGlassWeapons",String.valueOf(enableGlassWeapons)));
        enableGlassWeaponsCrafting = Boolean.parseBoolean(properties.getProperty("enableGlassWeaponsCrafting",String.valueOf(enableGlassWeaponsCrafting)));


        glassClaymoreDamage = Float.parseFloat(properties.getProperty("glassClaymoreDamage", String.valueOf(9.0F)));
        glassClaymoreSpeed = Float.parseFloat(properties.getProperty("glassClaymoreSpeed", String.valueOf(5.0F)));
        glassClaymoreCrit = Float.parseFloat(properties.getProperty("glassClaymoreCrit", String.valueOf(0.05F)));
        glassClaymoreParry = Float.parseFloat(properties.getProperty("glassClaymoreParry", String.valueOf(1.0F)));

        glassDaggerDamage = Float.parseFloat(properties.getProperty("glassDaggerDamage", String.valueOf(4.0F)));
        glassDaggerSpeed = Float.parseFloat(properties.getProperty("glassDaggerSpeed", String.valueOf(3.0F)));
        glassDaggerCrit = Float.parseFloat(properties.getProperty("glassDaggerCrit", String.valueOf(0.1F)));
        glassDaggerParry = Float.parseFloat(properties.getProperty("glassDaggerParry", String.valueOf(1.0F)));

        glassHalberdDamage = Float.parseFloat(properties.getProperty("glassHalberdDamage", String.valueOf(9.0F)));
        glassHalberdSpeed = Float.parseFloat(properties.getProperty("glassHalberdSpeed", String.valueOf(5.0F)));
        glassHalberdCrit = Float.parseFloat(properties.getProperty("glassHalberdCrit", String.valueOf(0.06F)));
        glassHalberdParry = Float.parseFloat(properties.getProperty("glassHalberdParry", String.valueOf(1.0F)));

        glassLongswordDamage = Float.parseFloat(properties.getProperty("glassLongswordDamage", String.valueOf(5.5F)));
        glassLongswordSpeed = Float.parseFloat(properties.getProperty("glassLongswordSpeed", String.valueOf(4.0F)));
        glassLongswordCrit = Float.parseFloat(properties.getProperty("glassLongswordCrit", String.valueOf(0.01F)));
        glassLongswordParry = Float.parseFloat(properties.getProperty("glassLongswordParry", String.valueOf(1.0F)));

        glassStaffDamage = Float.parseFloat(properties.getProperty("glassStaffDamage", String.valueOf(8.0F)));
        glassStaffSpeed = Float.parseFloat(properties.getProperty("glassStaffSpeed", String.valueOf(4.0F)));
        glassStaffCrit = Float.parseFloat(properties.getProperty("glassStaffCrit", String.valueOf(0.0F)));
        glassStaffParry = Float.parseFloat(properties.getProperty("glassStaffParry", String.valueOf(1.0F)));

        glassWaraxeDamage = Float.parseFloat(properties.getProperty("glassWaraxeDamage", String.valueOf(6.5F)));
        glassWaraxeSpeed = Float.parseFloat(properties.getProperty("glassWaraxeSpeed", String.valueOf(4.0F)));
        glassWaraxeCrit = Float.parseFloat(properties.getProperty("glassWaraxeCrit", String.valueOf(0.03F)));
        glassWaraxeParry = Float.parseFloat(properties.getProperty("glassWaraxeParry", String.valueOf(0.3F)));

    }
    @Override
    public void preInit(){
        ModActions.init();
    }
    @Override
    public void onServerStarted(){
        logger.log(Level.INFO, "test");
    }
    @Override
    public void onItemTemplatesCreated() {
        ItemTemplate[] testTemplateArray = ItemTemplateFactory.getInstance().getTemplates();
        for (ItemTemplate itemTemplate: testTemplateArray) {
            if (itemTemplate.getName() == "soul"){
                soulID = itemTemplate.getTemplateId();
            }
        }

        try {
            if(enableBrewmasterSpice){
                BrewmasterSpice.onItemTemplatesCreated();
                ModActions.registerAction(new BrewmasterSpiceAction());
            }
            if(enableShardOfLorkhan){
                ShardOfLorkhan.onItemTemplatesCreated();
                ModActions.registerAction(new ShardOfLorkhanAction());
            }
            if(enableRaceMasks){
                Argonian.onItemTemplatesCreated();
                Argonian_Female.onItemTemplatesCreated();
                Dunmer.onItemTemplatesCreated();
                Dunmer_Female.onItemTemplatesCreated();
                Altmer.onItemTemplatesCreated();
                Altmer_Female.onItemTemplatesCreated();
                Khajiit.onItemTemplatesCreated();
                Khajiit_Female.onItemTemplatesCreated();
                Orsimer.onItemTemplatesCreated();
                Orsimer_Female.onItemTemplatesCreated();
                Bosmer.onItemTemplatesCreated();
                Bosmer_Female.onItemTemplatesCreated();
            }
            if(enableNwahEmote){
                ModActions.registerAction(new NwahEmote());
            }
            if(enableFortunateSon){
                ModActions.registerAction(new FortunateSonEmote());
            }
            if(enableStructures){
                commonhousetall02.onItemTemplatesCreated();
                exdwrventer00.onItemTemplatesCreated();
                in_dwrv_corr2_04.onItemTemplatesCreated();
                in_dwrv_corr2_00.onItemTemplatesCreated();
                in_dwrv_corr3_01.onItemTemplatesCreated();
                ex_common_tower_thatch.onItemTemplatesCreated();
                ex_nord_house_01.onItemTemplatesCreated();
                ex_nord_house_02.onItemTemplatesCreated();
                ex_nord_house_03.onItemTemplatesCreated();
                ex_de_shack_03.onItemTemplatesCreated();
                ex_de_shack_02.onItemTemplatesCreated();
                ex_dwrv_observ00.onItemTemplatesCreated();
                ex_velothi_entrance_02.onItemTemplatesCreated();
                CensusAndExcise.onItemTemplatesCreated();
                Tradehouse.onItemTemplatesCreated();
                Siltstrider.onItemTemplatesCreated();

                HlaaluCouncil.onItemTemplatesCreated();
                RedoranCouncil.onItemTemplatesCreated();
                TelvaniCouncil.onItemTemplatesCreated();

                Vivec_Canton.onItemTemplatesCreated();
                Vivec_Canton2.onItemTemplatesCreated();
                Vivec_Temple_Base.onItemTemplatesCreated();
                Vivec_Temple.onItemTemplatesCreated();
                Vivec_HighFane.onItemTemplatesCreated();
                Ministry_Of_Truth.onItemTemplatesCreated();
            }
            if(enableDecorations){
                DwemerPuzzleBox.onItemTemplatesCreated();
                Pillow.onItemTemplatesCreated();
                DwemerMug.onItemTemplatesCreated();
                DwemerGoblet.onItemTemplatesCreated();
                DwemerGear.onItemTemplatesCreated();
                DwemerCoherer.onItemTemplatesCreated();
                DwemerScraps.onItemTemplatesCreated();
                DwemerBarrel.onItemTemplatesCreated();
                Chargen_Papers.onItemTemplatesCreated();
                DragonTapestry.onItemTemplatesCreated();
                ToddTapestry.onItemTemplatesCreated();
                DagothTPose.onItemTemplatesCreated();
                CreatureTestObject.onItemTemplatesCreated();
            }
            if(enableDarkBrotherhoodHelm){
                DarkBrotherhoodHelm.onItemTemplatesCreated();
                //DarkBrotherhoodBoots.onItemTemplatesCreated();
                //currently disabled, couldn't get the settings right for armor models 1/25/24
            }
            if(enableBladedFist){
                BladedFist.onItemTemplatesCreated();
            }
            if(enableDaedricWeapons){
                DaedricWakazashi.onItemTemplatesCreated();
                DaedricWaraxe.onItemTemplatesCreated();
                DaedricBattleaxe.onItemTemplatesCreated();
                DaedricMace.onItemTemplatesCreated();
                DaedricWarhammer.onItemTemplatesCreated();
                DaedricStaff.onItemTemplatesCreated();
                DaedricKatana.onItemTemplatesCreated();
                DaedricLongsword.onItemTemplatesCreated();
                DaedricDaikatana.onItemTemplatesCreated();
                DaedricClaymore.onItemTemplatesCreated();
                DaedricSpear.onItemTemplatesCreated();
                DaedricScythe.onItemTemplatesCreated();
                DaedricSickle.onItemTemplatesCreated();
            }
            if(enableDwemerWeapons){
                DwemerBattleaxe.onItemTemplatesCreated();
                DwemerClaymore.onItemTemplatesCreated();
                DwemerHalberd.onItemTemplatesCreated();
                DwemerLongspear.onItemTemplatesCreated();
                DwemerMace.onItemTemplatesCreated();
                DwemerShortsword.onItemTemplatesCreated();
                DwemerWaraxe.onItemTemplatesCreated();
                DwemerWarhammer.onItemTemplatesCreated();
            }
            if(enableGlassWeapons){
                GlassClaymore.onItemTemplatesCreated();
                GlassDagger.onItemTemplatesCreated();
                GlassHalberd.onItemTemplatesCreated();
                GlassLongsword.onItemTemplatesCreated();
                GlassStaff.onItemTemplatesCreated();
                GlassWaraxe.onItemTemplatesCreated();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String getVersion() {
        return "1.0";
    }


    public MessagePolicy onPlayerMessage(Communicator communicator, String message, String title) {
        if (message.startsWith("#")&&enableProtectFromPlayers){
            return ProtectFromPlayers.onPlayerMessage(communicator, message) ? MessagePolicy.DISCARD : MessagePolicy.PASS;
        }
         return MessagePolicy.PASS;
    }

    @Deprecated
    public boolean onPlayerMessage(Communicator communicator, String msg) {
        return false;
    }

}
