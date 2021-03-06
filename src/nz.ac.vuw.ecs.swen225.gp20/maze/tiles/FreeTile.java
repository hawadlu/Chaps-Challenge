package nz.ac.vuw.ecs.swen225.gp20.maze.tiles;

import com.google.common.base.Preconditions;
import java.awt.image.BufferedImage;
import java.io.IOException;
import nz.ac.vuw.ecs.swen225.gp20.maze.actors.Actor;
import nz.ac.vuw.ecs.swen225.gp20.maze.actors.Player;
import nz.ac.vuw.ecs.swen225.gp20.maze.items.Item;
import nz.ac.vuw.ecs.swen225.gp20.maze.items.Treasure;

public class FreeTile extends Tile {
  private Item item;

  public FreeTile() { }

  public FreeTile(Item item) {
    this.item = item;
  }

  public FreeTile(Actor actor) {
    super(actor);
  }

  public Actor getActor() {
    return actor;
  }

  public boolean hasItem() {
    return item != null;
  }

  public Item getItem() {
    return item;
  }

  @Override
  public boolean isTraversable(Actor actor) {
    Preconditions.checkNotNull(actor, "ExitLock isTraversable is being given a null actor");
    return actor.isPlayer() || item == null;
  }

  @Override
  public void moveEvent(Actor actor, Actor.Direction direction) {
    Preconditions.checkNotNull(actor, "FreeTile moveEvent is being given a null actor");
    // Add any items on this tile to player inventory
    if (item != null && actor.isPlayer()) {
      Player player = (Player) actor;
      if (item instanceof Treasure) {
        player.pickupTreasure();
        actor.getMaze().reduceTreasuresLeft();
      } else {
        player.pickup(item);
      }
      item = null;
    }

    actor.getMaze().setDisplayText("");
  }

  @Override
  public BufferedImage getImage() throws IOException {
    return getImageProxy("floor");
  }

  @Override
  public String toString() {
    return "Floor";
  }
}
