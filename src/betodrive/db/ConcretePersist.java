/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betodrive.db;

import betodrive.entitiesbd.HibernateUtil;
import betodrive.entitiesbd.beton.Concrete;
import betodrive.entitiesbd.beton.IngredientAdjuvant;
import betodrive.entitiesbd.beton.IngredientAggregat;
import betodrive.entitiesbd.beton.IngredientCement;
import betodrive.entitiesbd.beton.IngredientSand;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.hibernate.Session;

/**
 *
 * @author Clément JEANNE <clement.jeanne@vivaldi.net>
 */
public class ConcretePersist {

	public ConcretePersist() {

	}

	public Response persistConcrete(Concrete pConcrete, String pData) {
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

			Session lSessionGetIngredient = HibernateUtil.getSessionFactory().openSession();
			IngredientCement lIngredientCement;
			lIngredientCement = (IngredientCement) lSessionGetIngredient.get(IngredientCement.class, (Serializable) lEntryMap.get("cement"));
			IngredientAggregat lIngredientAggregat = (IngredientAggregat) lSessionGetIngredient.get(IngredientAggregat.class, (Serializable) lEntryMap.get("aggregat"));
			IngredientSand lIngredientSand = (IngredientSand) lSessionGetIngredient.get(IngredientSand.class, (Serializable) lEntryMap.get("sand"));
			IngredientAdjuvant lIngredientAdjuvant = (IngredientAdjuvant) lSessionGetIngredient.get(IngredientAdjuvant.class, (Serializable) lEntryMap.get("adjuvant"));
			lSessionGetIngredient.close();

			pConcrete.setCement(lIngredientCement);
			pConcrete.setqCement((Double) lEntryMap.get("qCement"));
			pConcrete.setAggregat(lIngredientAggregat);
			pConcrete.setqAggregat((Double) lEntryMap.get("qAggregat"));
			pConcrete.setSand(lIngredientSand);
			pConcrete.setqSand((Double) lEntryMap.get("qSand"));
			pConcrete.setAdjuvant(lIngredientAdjuvant);
			pConcrete.setqAdjuvant((Double) lEntryMap.get("qAdjuvant"));
			pConcrete.setqSand((Double) lEntryMap.get("qWater"));
			System.out.println(pConcrete.getqCement());
			System.out.println(pConcrete.getqAggregat() + "azeaeaeaeazeazeaze");

			Session lSessionOne = HibernateUtil.getSessionFactory().openSession();
			lSessionOne.beginTransaction();
			lSessionOne.saveOrUpdate(pConcrete);
			lSessionOne.getTransaction().commit();
			lSessionOne.close();
			lResponse = Response.status(Status.CREATED)
					.entity(pConcrete.getId()).build();

		} catch (IOException ex) {
			Logger.getLogger(ConcretePersist.class.getName()).log(Level.SEVERE, null, ex);
			lResponse = Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}

		return lResponse;
	}

}
