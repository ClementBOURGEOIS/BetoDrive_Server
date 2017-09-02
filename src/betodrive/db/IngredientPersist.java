/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betodrive.db;

import betodrive.entitiesbd.HibernateUtil;
import betodrive.entitiesbd.beton.Ingredient;
import betodrive.entitiesbd.beton.IngredientAdjuvant;
import betodrive.entitiesbd.beton.IngredientAggregat;
import betodrive.entitiesbd.beton.IngredientCement;
import betodrive.entitiesbd.beton.IngredientSand;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.hibernate.classic.Session;

/**
 *
 * @author Clément JEANNE <clement.jeanne@vivaldi.net>
 */
public class IngredientPersist {

	public IngredientPersist() {

	}

	public Response createIngredient(String pData) {
		Response lResponse = Response.status(Status.INTERNAL_SERVER_ERROR).entity("Something went unexpectidly in IngredientPersist").build();
		ObjectMapper lObjectMapper;
		Map<String, Object> lEntryMap;
		Iterator<Object> lIter = null;
		Ingredient lIngredient = null;
		// creation of the object mapper
		lObjectMapper = new ObjectMapper();
		System.out.println(pData);
		try {
			lEntryMap = lObjectMapper.readValue(pData,
					new TypeReference<Map<String, Object>>() {
			});
			switch (lEntryMap.get("type").toString()) {
				case "sand":
					lIngredient = new IngredientSand();
					break;
				case "aggregat":
					lIngredient = new IngredientAggregat();
					break;
				case "cement":
					lIngredient = new IngredientCement();
					break;
				case "adjuvant":
					lIngredient = new IngredientAdjuvant();
					break;

			}
			if (lIngredient == null) {
				lResponse = Response.status(Status.INTERNAL_SERVER_ERROR).entity("Ingredient type undifined or bad definition").build();
			} else {
				System.out.println("Starting to persist{0} " + lEntryMap.get("type").toString());
				lResponse = persistIngredient(lIngredient, pData);
			}
		} catch (IOException ex) {
			Logger.getLogger(IngredientPersist.class.getName()).log(Level.SEVERE, null, ex);
			lResponse = Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}

		return lResponse;
	}

	public Response createIngredient(String pData, int i) {
		Response lResponse = Response.status(Status.INTERNAL_SERVER_ERROR).entity("Something went unexpectidly in IngredientPersist").build();
		ObjectMapper lObjectMapper;
		Map<String, Object> lEntryMap;
		Iterator<Object> lIter = null;
		Ingredient lIngredient = null;
		// creation of the object mapper
		lObjectMapper = new ObjectMapper();
		System.out.println(pData);
		try {
			lEntryMap = lObjectMapper.readValue(pData,
					new TypeReference<Map<String, Object>>() {
			});
			Session lSessionGetIngredient = HibernateUtil.getSessionFactory().openSession();
			switch (lEntryMap.get("type").toString()) {
				case "sand":
					IngredientSand lSand;
					lIngredient = (IngredientSand) lSessionGetIngredient.get(IngredientSand.class, i);
					lSessionGetIngredient.close();
					break;
				case "aggregat":
					IngredientAggregat lAggregat;
					lAggregat = (IngredientAggregat) lSessionGetIngredient.get(IngredientAggregat.class, i);
					lSessionGetIngredient.close();
					break;
				case "cement":
					IngredientCement lCement;
					lCement = (IngredientCement) lSessionGetIngredient.get(IngredientCement.class, i);
					lSessionGetIngredient.close();
					break;
				case "adjuvant":
					IngredientAdjuvant lAdjuvant;
					lAdjuvant = (IngredientAdjuvant) lSessionGetIngredient.get(IngredientCement.class, i);
					lSessionGetIngredient.close();
					break;

			}
			if (lIngredient == null) {
				lResponse = Response.status(Status.INTERNAL_SERVER_ERROR).entity("Ingredient type undifined or bad definition").build();
			} else {
				System.out.println("Starting to persist " + lEntryMap.get("type").toString());
				lResponse = persistIngredient(lIngredient, pData);
			}
		} catch (IOException ex) {
			Logger.getLogger(IngredientPersist.class.getName()).log(Level.SEVERE, null, ex);
			lResponse = Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}

		return lResponse;
	}

	private Response persistIngredient(Ingredient pIngredient, String pData) {
		Response lResponse;
		ObjectMapper lObjectMapper;
		Map<String, Object> lEntryMap;
		Iterator<Object> lIter = null;

		// creation of the object mapper
		lObjectMapper = new ObjectMapper();

		try {
			lEntryMap = lObjectMapper.readValue(pData,
					new TypeReference<Map<String, Object>>() {
			});

			Session lSessionOne = HibernateUtil.getSessionFactory().openSession();
			lSessionOne.beginTransaction();
			pIngredient.setNom((String) lEntryMap.get("name"));
			pIngredient.setStock((Double) lEntryMap.get("stock"));
			lSessionOne.saveOrUpdate(pIngredient);
			lSessionOne.getTransaction().commit();
			lSessionOne.close();
			Logger.getLogger(IngredientPersist.class.getName()).log(Level.FINE, "Persisted", pIngredient.getId());
			lResponse = Response.status(Status.CREATED).build();

		} catch (IOException ex) {
			Logger.getLogger(IngredientPersist.class.getName()).log(Level.SEVERE, null, ex);
			lResponse = Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		return lResponse;
	}

}
