package org.nhobody.wurm.brorrowind.actions;

import com.wurmonline.server.Items;
import com.wurmonline.server.Server;
import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.players.Player;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.BehaviourProvider;
import org.gotti.wurmunlimited.modsupport.actions.ModAction;
import org.gotti.wurmunlimited.modsupport.actions.ModActions;
import org.nhobody.wurm.brorrowind.items.misc.BrewmasterSpice;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class BrewmasterSpiceAction implements ModAction{
    public static final Logger logger = Logger.getLogger(BrewmasterSpiceAction.class.getName());
    public static final int brewItemID = BrewmasterSpice.templateID;
    private final short actionId;
    private final ActionEntry actionEntry;

    public BrewmasterSpiceAction() {
        logger.info("BrewmasterSpiceAction()");
        actionId = (short) ModActions.getNextActionId();
        actionEntry = ActionEntry.createEntry(
                actionId,
                "Infuse",
                "infusing",
                new int[]{Actions.ACTION_TYPE_NOMOVE}
        );
        ModActions.registerAction(actionEntry);
    }
    @Override
    public BehaviourProvider getBehaviourProvider()
    {
        return new BehaviourProvider() {
            @Override
            public List<ActionEntry> getBehavioursFor(Creature performer, Item source, Item object)
            {
                Item[] itemsInContainer = object.getItemsAsArray();
                if(performer instanceof Player && object != null && itemsInContainer.length >  0 && source.getTemplateId() == brewItemID) {
                    for (Item item : itemsInContainer)
                    {
                        if (item.canBeFermented())
                        {
                            return Collections.singletonList(actionEntry);
                        }
                    }
                }
                return null;
            }
        };
    }
    @Override
    public ActionPerformer getActionPerformer()
    {
        return new ActionPerformer() {
            @Override
            public short getActionId() {
                return actionId;
            }
            @Override
            public boolean action(Action act, Creature performer, Item source, Item target, short num, float counter)
            {
                try{
                    if(performer instanceof Player)
                    {
                        if (source.getTemplate().getTemplateId() != brewItemID)
                        {
                            performer.getCommunicator().sendNormalServerMessage("You cannot bless the brew with this!");
                            return true;
                        }
                        if (target.getItemsAsArray().length <= 0)
                        {
                            performer.getCommunicator().sendNormalServerMessage("The container is empty!");
                            return true;
                        }
                        if (target.getItemsAsArray().length > 0){
                            for (Item item : target.getItemsAsArray())
                            {
                                if (item.canBeFermented() && item.getAuxData() == (byte)32)
                                {
                                    if (counter == 1.0f)
                                    {
                                        performer.getCommunicator().sendNormalServerMessage("You begin to bless the brew.");
                                        Server.getInstance().broadCastAction(performer.getName() + " begins to bless the brew. ", performer, 5);
                                        act.setTimeLeft(30);
                                        performer.sendActionControl("Blessing the brew", true, act.getTimeLeft());
                                    }
                                    else if (counter * 10.0f > performer.getCurrentAction().getTimeLeft())
                                    {
                                        float originalQl = item.getQualityLevel();
                                        item.setQualityLevel(originalQl+10f);
                                        item.setAuxData((byte)0);
                                        performer.getCommunicator().sendNormalServerMessage("You bless the brew.");
                                        Server.getInstance().broadCastAction(performer.getName() + " blesses the brew. ", performer, 5);
                                        logger.log(Level.INFO, "Just attempted to improve quality of " + item.getName() + ". Original ql: "+originalQl+" and current ql: "+item.getQualityLevel());
                                        Items.destroyItem(source.getWurmId());
                                        return true;
                                    }
                                }
                                if (item.canBeFermented() && item.getAuxData() == (byte)0)
                                {
                                    performer.getCommunicator().sendNormalServerMessage("This is already fermented and ready for drinking!");
                                    return true;
                                }
                                if (item.canBeFermented() && item.getAuxData() == (byte)16)
                                {
                                    performer.getCommunicator().sendNormalServerMessage("You must start the fermentation process before you can infuse the booze.");
                                    return true;
                                }
                            }
                        }
                    }
                    else
                    {
                        logger.info("Somehow a non-player tried to use brewmaster spice.");
                    }
                    return false;
                }
                catch(Exception e)
                {
                    logger.log(Level.WARNING, "Exception thrown for brewmaster spice action", e);
                    return true;
                }
            }
        };
    }
}
