/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.main.betodrive.db;

import javax.ws.rs.core.Response;
import main.betodrive.db.ConstructionSitePersist;
import main.betodrive.entitiesbd.ConstructionSite;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Clément JEANNE <clement.jeanne@vivaldi.net>
 */
public class ConstructionSitePersistTest {

	public ConstructionSitePersistTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of persistConstructionSite method, of class ConstructionSitePersist.
	 */
	@Test
	public void testPersistConstructionSite() {
		System.out.println("persistConstructionSite");
		ConstructionSite pConstructionSite = null;
		String pData = "";
		ConstructionSitePersist instance = new ConstructionSitePersist();
		Response expResult = null;
		Response result = instance.persistConstructionSite(pConstructionSite, pData);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
