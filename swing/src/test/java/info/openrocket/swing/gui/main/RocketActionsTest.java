package info.openrocket.swing.gui.main;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

import info.openrocket.core.rocketcomponent.BodyTube;
import info.openrocket.core.rocketcomponent.NoseCone;
import info.openrocket.core.rocketcomponent.Parachute;
import info.openrocket.core.rocketcomponent.Rocket;
import info.openrocket.core.rocketcomponent.TrapezoidFinSet;
import info.openrocket.core.rocketcomponent.NoseCone.Shape;

/**
 * Simple smoke tests that instantiate several RocketComponent types and log their properties.
 */
public class RocketActionsTest {
	private static final Logger log = LoggerFactory.getLogger(RocketActionsTest.class);

	@Test
	public void constructVariousComponents() {
		// Create a body tube
		BodyTube body = new BodyTube(0.5, 0.05);
		log.info("Constructed BodyTube: length={} radius={}", body.getLength(), body.getOuterRadius());

		// Create a nose cone
		NoseCone nose = new NoseCone(NoseCone.Shape.CONICAL, 6 * NoseCone.DEFAULT_RADIUS, NoseCone.DEFAULT_RADIUS);
		log.info("Constructed NoseCone: baseRadius={} length={}", nose.getBaseRadius(), nose.getLength());

		// Create a fin set
		TrapezoidFinSet fins = new TrapezoidFinSet(3, 0.05, 0.05, 0.025, 0.03);
		log.info("Constructed TrapezoidFinSet: finCount={}", fins.getFinCount());

		// Create a parachute
		Parachute para = new Parachute();
		log.info("Constructed Parachute: diameter={}", para.getDiameter());
	}
}
