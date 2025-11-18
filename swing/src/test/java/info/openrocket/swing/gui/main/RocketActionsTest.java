package info.openrocket.swing.gui.main;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

import info.openrocket.swing.ServicesForTesting;
import info.openrocket.core.plugin.PluginModule;
import info.openrocket.core.rocketcomponent.BodyTube;
import info.openrocket.core.rocketcomponent.NoseCone;
import info.openrocket.core.rocketcomponent.Parachute;
import info.openrocket.core.rocketcomponent.RocketComponent;
import info.openrocket.core.rocketcomponent.TrapezoidFinSet;
import info.openrocket.core.startup.Application;

/**
 * RocketActions Tester
 * 
 */
public class RocketActionsTest {

	private static Injector injector;

    @BeforeAll
	public static void setup() {
		Module applicationModule = new ServicesForTesting();
		Module pluginModule = new PluginModule();

		injector = Guice.createInjector(applicationModule, pluginModule);
		Application.setInjector(injector);
	}

    /**
     * 
     * Method: copyComponents
     * 
     */
    @Test
    public void testCopyComponentsMaintainParent() throws Exception {

        // Create a list of RocketComponent objects
        List<RocketComponent> components = new ArrayList<>();
        BodyTube bodyTube = new BodyTube(0.5, 0.05);
        components.add(bodyTube);
        NoseCone noseCone = new NoseCone(NoseCone.Shape.CONICAL, 6 * NoseCone.DEFAULT_RADIUS, NoseCone.DEFAULT_RADIUS);
        components.add(noseCone);
        TrapezoidFinSet trapezoidFinSet = new TrapezoidFinSet(3, 0.05, 0.05, 0.025, 0.03);
        components.add(trapezoidFinSet);
        Parachute parachute = new Parachute();
        components.add(parachute);

        // Copy the components
        List<RocketComponent> copiedComponents = RocketActions.copyComponentsMaintainParent(components);

        // Retrieve the copied components by their type
        BodyTube copiedBodyTube = (BodyTube) copiedComponents.stream()
            .filter(c -> c instanceof BodyTube)
            .findFirst()
            .orElse(null);
        NoseCone copiedNoseCone = (NoseCone) copiedComponents.stream()
            .filter(c -> c instanceof NoseCone)
            .findFirst()
            .orElse(null);
        TrapezoidFinSet copiedTrapezoidFinSet = (TrapezoidFinSet) copiedComponents.stream()
            .filter(c -> c instanceof TrapezoidFinSet)
            .findFirst()
            .orElse(null);
        Parachute copiedParachute = (Parachute) copiedComponents.stream()
            .filter(c -> c instanceof Parachute)
            .findFirst()
            .orElse(null);
            
        // Verify that the copied components are not null
        Assertions.assertNotNull(copiedBodyTube);
        Assertions.assertNotNull(copiedNoseCone);
        Assertions.assertNotNull(copiedTrapezoidFinSet);
        Assertions.assertNotNull(copiedParachute);

        // Verify that the copied components have the same properties as the original components
        Assertions.assertEquals(bodyTube.getLength(), copiedBodyTube.getLength());
        Assertions.assertEquals(bodyTube.getOuterRadius(), copiedBodyTube.getOuterRadius());
        Assertions.assertEquals(bodyTube.getThickness(), copiedBodyTube.getThickness());
        Assertions.assertEquals(bodyTube.isFilled(), copiedBodyTube.isFilled());

        Assertions.assertEquals(noseCone.getLength(), copiedNoseCone.getLength());
        // TODO : add more properties to compare

        Assertions.assertEquals(trapezoidFinSet.getFinCount(), copiedTrapezoidFinSet.getFinCount());
        // TODO : add more properties to compare

        Assertions.assertEquals(parachute.getDiameter(), copiedParachute.getDiameter());
        // TODO : add more properties to compare

        // Copies should be distinct objects from originals
        Assertions.assertNotSame(bodyTube, copiedBodyTube);
        Assertions.assertNotSame(noseCone, copiedNoseCone);
        Assertions.assertNotSame(trapezoidFinSet, copiedTrapezoidFinSet);
        Assertions.assertNotSame(parachute, copiedParachute);

        // TODO : parent-child relationships tests
    }
}