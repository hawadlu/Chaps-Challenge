package nz.ac.vuw.ecs.swen225.gp20.maze.tiles;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import nz.ac.vuw.ecs.swen225.gp20.maze.actors.Actor;

public class NullTile extends Tile {
  @Override
  public boolean isTraversable(Actor actor) {
    return false;
  }

  @Override
  public BufferedImage getImage() throws IOException {
    return ImageIO.read(new File(imageDirectory + "empty.png"));
  }

  @Override
  public String toString() {
    return "Null";
  }
}
