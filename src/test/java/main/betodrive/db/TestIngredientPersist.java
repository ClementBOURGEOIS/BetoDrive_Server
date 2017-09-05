/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.main.betodrive.db;

import javax.ws.rs.core.Response;
import main.betodrive.db.IngredientPersist;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Clément JEANNE <clement.jeanne@vivaldi.net>
 */
public class TestIngredientPersist {

	@Test
	public void testCreateIngredient() {
		System.out.println("createIngredient");
		String pDataAggregat = "{\n"
				+ "    \"type\": \"aggregat\",\n"
				+ "    \"stock\": 1.20,\n"
				+ "    \"name\": \"test\"\n"
				+ "}";
		String pDataCement = "{\n"
				+ "    \"type\": \"cement\",\n"
				+ "    \"stock\": 1.20,\n"
				+ "    \"name\": \"test\"\n"
				+ "}";
		String pDataSand = "{\n"
				+ "    \"type\": \"sand\",\n"
				+ "    \"stock\": 1.20,\n"
				+ "    \"name\": \"test\"\n"
				+ "}";
		IngredientPersist instance = new IngredientPersist();
		Response expResult = Response.status(Response.Status.CREATED).build();
		Response resultAggregat = instance.createIngredient(pDataAggregat);
		System.out.println(resultAggregat.getStatus() + "plop");
		Response resultCement = instance.createIngredient(pDataCement);
		Response resultSand = instance.createIngredient(pDataSand);
		assertEquals(resultAggregat.getStatus(), 201);
		assertEquals(resultCement.getStatus(), 201);
		assertEquals(resultSand.getStatus(), 201);
	}

}
