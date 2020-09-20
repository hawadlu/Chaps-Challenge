package nz.ac.vuw.ecs.swen225.gp20.maze.tiles;

import nz.ac.vuw.ecs.swen225.gp20.maze.actors.Actor;

public class InfoTile extends FreeTile {
  private final String info;

  public InfoTile(String info) {
    this.info = info;
  }

  public InfoTile(String info, Actor actor) {
    super(actor);
    this.info = info;
  }

  public String getInfo() {
    return info;
  }

  @Override
  public boolean isTraversable(Actor actor) {
    return true;
  }
}