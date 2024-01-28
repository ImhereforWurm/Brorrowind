package org.nhobody.wurm.brorrowind.items.misc;
import java.util.logging.Logger;
import com.wurmonline.server.behaviours.BehaviourList;
import com.wurmonline.server.items.ItemTemplate;
import com.wurmonline.server.items.ItemTypes;
import com.wurmonline.server.items.Materials;
import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;

import java.io.IOException;

public class ShardOfLorkhan {
    public static final Logger logger = Logger.getLogger(ShardOfLorkhan.class.getName());
    public static int templateID;
    public static void onItemTemplatesCreated() throws IOException{
        ItemTemplateBuilder builder = new ItemTemplateBuilder("mod.nhobody.Brorrowind.ShardOfLorkhan");
        builder.name("shard of Lorkhan", "shard of Lorkhan", "Fragments of a greater whole. Side effects include CHIM, awakened sleeping, save file corruption, dragonbreaks, and zero sum extinction.");
        builder.material(Materials.MATERIAL_ADAMANTINE);
        builder.dimensions(10,10,50);
        builder.weightGrams(250);
        builder.behaviourType(BehaviourList.itemBehaviour);
        builder.itemTypes(new short[]{
                ItemTypes.ITEM_TYPE_DECORATION,
                ItemTypes.ITEM_TYPE_TEN_PER_TILE
        });
        builder.modelName("model.mod.nhobody.Brorrowind.ShardOfLorkhan.");

            ItemTemplate template = builder.build();
            templateID = template.getTemplateId();
        logger.info("Shard of Lorhkan TemplateID: "+templateID);
    }
}
