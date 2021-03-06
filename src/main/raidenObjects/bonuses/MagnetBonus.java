package main.raidenObjects.bonuses;

import main.motionControllers.HoveringXMotionController;
import main.motionControllers.MotionController;
import main.motionControllers.XYMotionController;
import main.raidenObjects.aircrafts.shootingAircrafts.PlayerAircraft;
import main.utils.Faction;
import main.utils.InitLocation;

import static main.World.windowWidth;

/**
 * Bonus that gives player the ability to attract other bonuses.
 *
 * @see PlayerAircraft#getMagnetCountdown()
 *
 * @author 张哲瑞
 */
public final class MagnetBonus extends BaseBonus {
    static int effectiveGameSteps = 300;

    public MagnetBonus() {
        super("MagnetBonus",20, 20, Faction.BONUS);
        MotionController XController = new HoveringXMotionController(0.5f, 20, windowWidth - 20);
        MotionController XYController = XYMotionController.createFromXController(
                XController, 1.5f);
        this.registerMotionController(XYController);
    }

    public MagnetBonus(float x, float y) {
        this();
        setX(x);
        setY(y);
    }

    public MagnetBonus(InitLocation initLocation) {
        this();
        initXFromLocation(initLocation);;
    }

    @Override
    public void bonus(PlayerAircraft aircraft) {
        super.bonus(aircraft);
        aircraft.getMagnetCountdown().extendDurationBy(effectiveGameSteps);
    }
}
