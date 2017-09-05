/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.main.betodrive.db;

import javax.ws.rs.core.Response;
import main.betodrive.db.ConcretePersist;
import main.betodrive.entitiesbd.beton.Concrete;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Clément JEANNE <clement.jeanne@vivaldi.net>
 */
public class TestConcretePersist {

	/**
	 * Test of persistConcrete method, of class ConcretePersist.
	 */
	@Test
	public void testPersistConcrete() {
		System.out.println("persistConcrete");
		Concrete pConcrete = null;
		String pData = "";
		ConcretePersist instance = new ConcretePersist();
		Response expResult = null;
		Response result = instance.persistConcrete(pConcrete, pData);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
