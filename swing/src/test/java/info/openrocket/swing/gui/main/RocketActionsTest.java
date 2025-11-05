package info.openrocket.swing.gui.main;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import info.openrocket.core.rocketcomponent.BodyTube;
import info.openrocket.core.rocketcomponent.NoseCone;
import info.openrocket.core.rocketcomponent.Parachute;
import info.openrocket.core.rocketcomponent.RocketComponent;
import info.openrocket.core.rocketcomponent.TrapezoidFinSet;

/**
 * RocketActions Tester
 * 
 */
public class RocketActionsTest {

    /**
     * 
     * Method: copyComponents
     * 
     */
    @Test
    public void testCopyComponentsMaintainParent() throws Exception {
        List<RocketComponent> components = new ArrayList<>();
        components.add(new BodyTube(0.5, 0.05));
        components.add(new NoseCone(NoseCone.Shape.CONICAL, 6 * NoseCone.DEFAULT_RADIUS, NoseCone.DEFAULT_RADIUS));
        components.add(new TrapezoidFinSet(3, 0.05, 0.05, 0.025, 0.03));
        components.add(new Parachute());

        List<RocketComponent> copiedComponents = RocketActions.copyComponentsMaintainParent(components);

        // TODO: Asserts
    }
}