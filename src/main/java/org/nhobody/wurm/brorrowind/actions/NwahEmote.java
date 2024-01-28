package org.nhobody.wurm.brorrowind.actions;

import com.wurmonline.server.Server;
import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.players.Player;
import com.wurmonline.server.sounds.SoundPlayer;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.BehaviourProvider;
import org.gotti.wurmunlimited.modsupport.actions.ModAction;
import org.gotti.wurmunlimited.modsupport.actions.ModActions;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class NwahEmote implements ModAction{
    public static final Logger logger = Logger.getLogger(NwahEmote.class.getName());
    private final short actionId;
    private final ActionEntry actionEntry;
    public NwahEmote() {
        logger.info("NwahEmote()");

        actionId = (short) ModActions.getNextActionId();
        actionEntry = ActionEntry.createEntry(
                actionId,
                "Use the N word",
                "Using the N word",
                new int[]{}
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
                return Collections.singletonList(actionEntry);
            }
            @Override
            public List<ActionEntry> getBehavioursFor(Creature performer, Item object)
            {
                return Collections.singletonList(actionEntry);
            }
            @Override
            public List<ActionEntry> getBehavioursFor(Creature performer, int tilex, int tiley, boolean onSurface, int tile){
                return Collections.singletonList(actionEntry);
            }
            @Override
            public List<ActionEntry> getBehavioursFor(Creature performer, Item object, int tilex, int tiley, boolean onSurface, int tile) {
                return Collections.singletonList(actionEntry);
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
            public boolean action(Action act, Creature performer, Item target, short action, float counter) {
                try{
                    if(performer instanceof Player){
                        if (counter == 1.0f) {
                            performer.getCommunicator().sendNormalServerMessage("You unleash your inner gamer.");
                            Server.getInstance().broadCastAction(performer.getName() + " unleashes his inner gamer. ", performer, 5);
                            act.setTimeLeft(30);
                            performer.sendActionControl("Using the N word", true, act.getTimeLeft()); //string comparison?
                        } else if (counter * 10.0f > performer.getCurrentAction().getTimeLeft()) {
                            SoundPlayer.playSound("sound.mod.nhobody.Brorrowind.Nwah", performer, 1.6F);
                            return true;
                        }
                    }
                    return false;
                }catch(Exception e){
                    logger.log(Level.WARNING, "Exception thrown for Nwah action", e);
                    return true;
                }
            }
            @Override
            public boolean action(Action act, Creature performer, Item source, Item target, short action, float counter)
            {
                try {
                    return this.action(act, performer, target, action, counter);
                }
                catch(Exception e){
                    logger.log(Level.WARNING, "Exception thrown for Nwah action", e);
                    return true;
                }
            }
            @Override
            public boolean action(Action act, Creature performer, int tilex, int tiley, boolean onSurface, int tile, short action, float counter) {
                try {
                    Item target = null;
                    return this.action(act, performer, target, action, counter);
                }
                catch(Exception e){
                    logger.log(Level.WARNING, "Exception thrown for Nwah action", e);
                    return true;
                }
            }
            @Override
            public boolean action(Action act, Creature performer, Item source, int tilex, int tiley, boolean onSurface, int heightOffset, int tile, short action, float counter) {
                try {
                    Item target = null;
                    return this.action(act, performer, target, action, counter);
                }
                catch(Exception e){
                    logger.log(Level.WARNING, "Exception thrown for Nwah action", e);
                    return true;
                }
            }
        };
    }
}

