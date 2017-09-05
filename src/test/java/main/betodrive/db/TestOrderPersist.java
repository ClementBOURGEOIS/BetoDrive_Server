/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.main.betodrive.db;

import javax.ws.rs.core.Response;
import main.betodrive.db.OrderPersist;
import main.betodrive.entitiesbd.OrderConcrete;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Clément JEANNE <clement.jeanne@vivaldi.net>
 */
public class TestOrderPersist {

	/**
	 * Test of persistOrder method, of class OrderPersist.
	 */
	@Test
	public void testPersistOrder() {
		System.out.println("persistOrder");
		OrderConcrete pOrder = null;
		String pData = "";
		OrderPersist instance = new OrderPersist();
		Response expResult = null;
		Response result = instance.persistOrder(pOrder, pData);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
