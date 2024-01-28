package org.nhobody.wurm.brorrowind.actions;

import com.wurmonline.server.Items;
import com.wurmonline.server.Server;
import com.wurmonline.server.behaviours.Action;
import com.wurmonline.server.behaviours.ActionEntry;
import com.wurmonline.server.behaviours.Actions;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.players.Player;
import com.wurmonline.server.skills.SkillList;
import com.wurmonline.server.skills.Skill;
import org.gotti.wurmunlimited.modsupport.actions.ActionPerformer;
import org.gotti.wurmunlimited.modsupport.actions.BehaviourProvider;
import org.gotti.wurmunlimited.modsupport.actions.ModAction;
import org.gotti.wurmunlimited.modsupport.actions.ModActions;
import org.nhobody.wurm.brorrowind.items.misc.ShardOfLorkhan;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShardOfLorkhanAction implements ModAction {
    public static final Logger logger = Logger.getLogger(ShardOfLorkhan.class.getName());
    private final short actionId;
    private final ActionEntry actionEntry;
    public ShardOfLorkhanAction() {
        logger.info("ShardOfLorkhanAction()");
        actionId = (short) ModActions.getNextActionId();
        actionEntry = ActionEntry.createEntry(
                actionId,
                "absorb",
                "absorbing",
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
                return this.getBehavioursFor(performer, object);
            }
            @Override
            public List<ActionEntry> getBehavioursFor(Creature performer, Item object)
            {
                if(performer instanceof Player && object != null && object.getTemplateId() == ShardOfLorkhan.templateID) {
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
            public boolean action(Action act, Creature performer, Item target, short action, float counter)
            {
                try{
                    if(performer instanceof Player){
                        if (target.getTemplate().getTemplateId() != ShardOfLorkhan.templateID){
                            performer.getCommunicator().sendNormalServerMessage("You can only absorb a Shard of Lorkhan, not this!");
                            return true;
                        }
                        if (!performer.isWithinDistanceTo(target.getPosX(), target.getPosY(), performer.getPositionZ(), 4)) {
                            performer.getCommunicator().sendNormalServerMessage("You are too far away to absorb.");
                            act.stop(true);
                            return true;
                        }
                        if (counter == 1.0f) {
                            performer.getCommunicator().sendNormalServerMessage("You start to absorb the "+target.getName()+".");
                            Server.getInstance().broadCastAction(performer.getName() + " begins absorbing the "+target.getName()+".", performer, 5);
                            act.setTimeLeft(200);
                            performer.sendActionControl("Absorbing", true, act.getTimeLeft());
                        } else if (counter * 10.0f > performer.getCurrentAction().getTimeLeft()) {
                            Skill toImprove = performer.getSkills().getSkill(SkillList.BODY_STRENGTH);
                            toImprove.setKnowledge(toImprove.getKnowledge()+1D,false);
                            toImprove = performer.getSkills().getSkill(SkillList.BODY_CONTROL);
                            toImprove.setKnowledge(toImprove.getKnowledge()+1D,false);
                            toImprove = performer.getSkills().getSkill(SkillList.BODY_STAMINA);
                            toImprove.setKnowledge(toImprove.getKnowledge()+1D,false);
                            toImprove = performer.getSkills().getSkill(SkillList.MIND_LOGICAL);
                            toImprove.setKnowledge(toImprove.getKnowledge()+1D,false);
                            toImprove = performer.getSkills().getSkill(SkillList.MIND_SPEED);
                            toImprove.setKnowledge(toImprove.getKnowledge()+1D,false);
                            toImprove = performer.getSkills().getSkill(SkillList.SOUL_DEPTH);
                            toImprove.setKnowledge(toImprove.getKnowledge()+1D,false);
                            toImprove = performer.getSkills().getSkill(SkillList.SOUL_STRENGTH);
                            toImprove.setKnowledge(toImprove.getKnowledge()+1D,false);
                            Items.destroyItem(target.getWurmId());
                            return true;
                        }
                    }else{
                        logger.info("Somehow a non-player activated a "+target.getTemplate().getName()+".");
                    }
                    return false;
                }catch(Exception e){
                    logger.log(Level.WARNING, "", e);
                    return true;
                }
            }
            @Override
            public boolean action(Action act, Creature performer, Item source, Item target, short action, float counter)
            {
                return this.action(act, performer, target, action, counter);
            }
        };
    }
}