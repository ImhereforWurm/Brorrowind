package org.nhobody.wurm.brorrowind.actions;

import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.items.ItemList;
import com.wurmonline.server.players.Player;
import com.wurmonline.server.sounds.SoundPlayer;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.BehaviourProvider;
import org.gotti.wurmunlimited.modsupport.actions.ModAction;
import org.gotti.wurmunlimited.modsupport.actions.ModActions;
import org.nhobody.wurm.brorrowind.items.misc.ShardOfLorkhan;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FortunateSonEmote implements ModAction {
    public static final Logger logger = Logger.getLogger(ShardOfLorkhan.class.getName());
    private final short actionId;
    private final ActionEntry actionEntry;
    public FortunateSonEmote() {
        logger.info("FortunateSonEmote()");
        actionId = (short) ModActions.getNextActionId();
        actionEntry = ActionEntry.createEntry(
                actionId,
                "It ain't me...",
                "It ain't me...",
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
                if (source.getTemplate().getTemplateId() == ItemList.wandDeity && object.getTemplate().getTemplateId() == ItemList.wandDeity)
                {
                    return Collections.singletonList(actionEntry);
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
            public boolean action(Action act, Creature performer, Item source, Item target, short action, float counter)
            {
                try{
                    if(performer instanceof Player)
                        if(source.getTemplate().getTemplateId() == ItemList.wandDeity && target.getTemplate().getTemplateId() == ItemList.wandDeity) {
                            {
                                SoundPlayer.playSound("sound.mod.nhobody.Brorrowind.FortunateSon", performer, 1.6F);
                                return true;
                            }
                        }
                        else{
                            logger.info("Somehow a non-player tried to go to vietnam.");
                        }
                    return false;
                }catch(Exception e){
                    logger.log(Level.WARNING, "Exception thrown for FortunateSonEmote", e);
                    return true;
                }
            }
        };
    }
}