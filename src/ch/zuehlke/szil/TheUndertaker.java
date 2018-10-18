package ch.zuehlke.szil;

import java.awt.Color;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.Rules;
import robocode.ScannedRobotEvent;

public class TheUndertaker extends Robot {

  public void run() {
    setBodyColor(Color.BLACK);
    setRadarColor(Color.RED);
    setBulletColor(Color.GREEN);
    setScanColor(Color.BLUE);

    while(true) {
      turnLeft(15);
    }
  }

  @Override
  public void onHitWall(HitWallEvent event) {
    turnRight(-event.getBearing());
    ahead(100);
  }

  @Override
  public void onScannedRobot(ScannedRobotEvent event) {
    turnRight(event.getBearing());
    ahead(event.getDistance() + 5);
    fire(Rules.MAX_BULLET_POWER);
  }

}
