package org.nhobody.wurm.brorrowind.commands;

import com.wurmonline.server.creatures.Communicator;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.players.Player;
import com.wurmonline.server.structures.Floor;
import com.wurmonline.server.structures.Wall;
import com.wurmonline.server.zones.VolaTile;
import com.wurmonline.server.zones.Zones;
import com.wurmonline.server.structures.Fence;
import org.nhobody.wurm.brorrowind.Brorrowind;

import java.util.StringTokenizer;
import java.util.logging.Level;

public class ProtectFromPlayers {
    public static boolean onPlayerMessage(Communicator communicator, String msg) {
        Player performer = communicator.getPlayer();
        if (msg.startsWith("#addprotections "))
            if (performer.getPower() < 5) {
                Brorrowind.logger.log(Level.INFO, String.format("Player %s tried to use #addprotections command with a power of " + performer.getPower(), new Object[]{performer.getName()}));
            } else {
                try {
                    StringTokenizer tokens = new StringTokenizer(msg);
                    tokens.nextToken();
                    if (tokens.hasMoreTokens())
                    {
                        int radius = Integer.parseInt(tokens.nextToken(), 10);
                        SetProtections(performer, radius, true);
                    }
                    return true;
                } catch (Exception e) {
                    performer.getCommunicator().sendAlertServerMessage("Error: " + e.toString());
                }
            }
        if (msg.startsWith("#removeprotections "))
            if (performer.getPower() < 5) {
                Brorrowind.logger.log(Level.INFO, String.format("Player %s tried to use #removeprotections command with a power of " + performer.getPower(), new Object[]{performer.getName()}));
            } else {
                try {
                    StringTokenizer tokens = new StringTokenizer(msg);
                    tokens.nextToken();
                    if (tokens.hasMoreTokens()) {
                        int radius = Integer.parseInt(tokens.nextToken(), 10);
                        SetProtections(performer, radius, false);
                    }
                    return true;
                } catch (Exception e) {
                    performer.getCommunicator().sendAlertServerMessage("Error: " + e.toString());
                }
            }
        return false;
    }
    private static void SetProtections(Player performer, int radius, boolean restrictionToggle) {
        for (int x = performer.getTileX() - radius; x <= performer.getTileX() + radius; x++) {
            for (int y = performer.getTileY() - radius; y <= performer.getTileY() + radius; y++) {
                if (x >= 0 && y >= 0 && x < Zones.worldTileSizeX && y < Zones.worldTileSizeY) {
                    VolaTile tile = Zones.getTileOrNull(x, y, performer.isOnSurface());
                    if (tile != null) {
                        Zones.protectedTiles[x][y] = restrictionToggle;
                        for (Item item : tile.getItems()) {
                            item.setHasNoDecay(restrictionToggle);
                            item.setIsNoTake(restrictionToggle);
                            item.setIsNotSpellTarget(restrictionToggle);
                            item.setIsIndestructible((restrictionToggle));
                            item.setIsNotLockable(restrictionToggle);
                            item.setIsNotLockpickable(restrictionToggle);
                            item.setIsNotTurnable(restrictionToggle);
                            item.setIsNoMove(restrictionToggle);
                            item.setIsOwnerMoveable(restrictionToggle);
                            item.setIsOwnerTurnable(restrictionToggle);
                            item.setIsNotPaintable(restrictionToggle);
                            item.setIsNotRuneable(restrictionToggle);
                            item.setIsNoImprove(restrictionToggle);
                            item.setIsNoRepair(restrictionToggle);
                            item.setIsNoDrag(restrictionToggle);
                            item.setIsNoDrop(restrictionToggle);
                            item.setIsNoPut(restrictionToggle);
                            item.setIsPlanted(restrictionToggle);
                        }
                        for (Wall wall : tile.getWalls()) {
                            wall.setHasNoDecay(restrictionToggle);
                            wall.setIsNoTake(restrictionToggle);
                            wall.setIsNotSpellTarget(restrictionToggle);
                            wall.setIsIndestructible((restrictionToggle));
                            wall.setIsNotLockable(restrictionToggle);
                            wall.setIsNotLockpickable(restrictionToggle);
                            wall.setIsNotTurnable(restrictionToggle);
                            wall.setIsNoMove(restrictionToggle);
                            wall.setIsOwnerMoveable(restrictionToggle);
                            wall.setIsOwnerTurnable(restrictionToggle);
                            wall.setIsNotPaintable(restrictionToggle);
                            wall.setIsNotRuneable(restrictionToggle);
                            wall.setIsNoImprove(restrictionToggle);
                            wall.setIsNoRepair(restrictionToggle);
                            wall.setIsNoDrag(restrictionToggle);
                            wall.setIsNoDrop(restrictionToggle);
                            wall.setIsNoPut(restrictionToggle);
                            wall.setIsPlanted(restrictionToggle);
                        }
                        for (Floor floor : tile.getFloors()) {
                            floor.setHasNoDecay(restrictionToggle);
                            floor.setIsNoTake(restrictionToggle);
                            floor.setIsNotSpellTarget(restrictionToggle);
                            floor.setIsIndestructible((restrictionToggle));
                            floor.setIsNotLockable(restrictionToggle);
                            floor.setIsNotLockpickable(restrictionToggle);
                            floor.setIsNotTurnable(restrictionToggle);
                            floor.setIsNoMove(restrictionToggle);
                            floor.setIsOwnerMoveable(restrictionToggle);
                            floor.setIsOwnerTurnable(restrictionToggle);
                            floor.setIsNotPaintable(restrictionToggle);
                            floor.setIsNotRuneable(restrictionToggle);
                            floor.setIsNoImprove(restrictionToggle);
                            floor.setIsNoRepair(restrictionToggle);
                            floor.setIsNoDrag(restrictionToggle);
                            floor.setIsNoDrop(restrictionToggle);
                            floor.setIsNoPut(restrictionToggle);
                            floor.setIsPlanted(restrictionToggle);
                        }
                        for (Fence fence : tile.getAllFences()) {
                            fence.setHasNoDecay(restrictionToggle);
                            fence.setIsNoTake(restrictionToggle);
                            fence.setIsNotSpellTarget(restrictionToggle);
                            fence.setIsIndestructible((restrictionToggle));
                            fence.setIsNotLockable(restrictionToggle);
                            fence.setIsNotLockpickable(restrictionToggle);
                            fence.setIsNotTurnable(restrictionToggle);
                            fence.setIsNoMove(restrictionToggle);
                            fence.setIsOwnerMoveable(restrictionToggle);
                            fence.setIsOwnerTurnable(restrictionToggle);
                            fence.setIsNotPaintable(restrictionToggle);
                            fence.setIsNotRuneable(restrictionToggle);
                            fence.setIsNoImprove(restrictionToggle);
                            fence.setIsNoRepair(restrictionToggle);
                            fence.setIsNoDrag(restrictionToggle);
                            fence.setIsNoDrop(restrictionToggle);
                            fence.setIsNoPut(restrictionToggle);
                            fence.setIsPlanted(restrictionToggle);
                        }
                    }
                }
            }
        }
        if (restrictionToggle) {
            performer.getCommunicator().sendAlertServerMessage("Added protection for all items on tiles in radius of " + radius);
        }
        if (!restrictionToggle){
            performer.getCommunicator().sendAlertServerMessage("Removed protection from tiles in radius of " + radius);
        }
    }
}




