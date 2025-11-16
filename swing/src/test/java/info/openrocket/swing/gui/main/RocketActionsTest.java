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
        @Test
        assertEquals(components.size(), copiedComponents.size());
        assertEquals(components.get(0).getClass(), copiedComponents.get(0).getClass());
        assertEquals(components.get(1).getClass(), copiedComponents.get(1).getClass());
        assertEquals(components.get(2).getClass(), copiedComponents.get(2).getClass());
        assertEquals(components.get(3).getClass(), copiedComponents.get(3).getClass());

        assertEquals(components.get(0).getLength(), copiedComponents.get(0).getLength());
        assertEquals(components.get(0).getRadius(), copiedComponents.get(0).getRadius());
        assertEquals(components.get(1).getLength(), copiedComponents.get(1).getLength());
        assertEquals(components.get(1).getRadius(), copiedComponents.get(1).getRadius());
        assertEquals(components.get(2).getRootChord(), copiedComponents.get(2).getRootChord());
        assertEquals(components.get(2).getTipChord(), copiedComponents.get(2).getTipChord());
        assertEquals(components.get(2).getSweep(), copiedComponents.get(2).getSweep());
        assertEquals(components.get(2).getHeight(), copiedComponents.get(2).getHeight());
        assertEquals(components.get(3).getDiameter(), copiedComponents.get(3).getDiameter());
        assertEquals(components.get(3).getArea(), copiedComponents.get(3).getArea());


        // Copies should be distinct objects from originals
        assertNotSame(components.get(0), copiedComponents.get(0));
        assertNotSame(components.get(1), copiedComponents.get(1));
        assertNotSame(components.get(2), copiedComponents.get(2));
        assertNotSame(components.get(3), copiedComponents.get(3));


        //Todo : parent-child relationship tests

        //Todo : test for paste operation

        // Todo : test for duplicate operation

        // Todo : test for cut operation
    }
}