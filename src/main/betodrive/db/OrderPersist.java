/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.betodrive.db;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import main.betodrive.entitiesbd.Client;
import main.betodrive.entitiesbd.ConstructionSite;
import main.betodrive.entitiesbd.HibernateUtil;
import main.betodrive.entitiesbd.OrderConcrete;
import main.betodrive.entitiesbd.beton.Concrete;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.hibernate.Session;

/**
 *
 * @author Clément JEANNE <clement.jeanne@vivaldi.net>
 */
public class OrderPersist {

	public OrderPersist() {

	}

	public Response persistOrder(OrderConcrete pOrder, String pData) {
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

			Concrete lConcrete = (Concrete) lSessionGetIngredient.get(Concrete.class, (Serializable) lEntryMap.get("concrete"));
			Client lClient = (Client) lSessionGetIngredient.get(Client.class, (Serializable) lEntryMap.get("client"));
			ConstructionSite lConstructionSite = (ConstructionSite) lSessionGetIngredient.get(ConstructionSite.class, (Serializable) lEntryMap.get("constructionSite"));
			lSessionGetIngredient.close();

			pOrder.setDateCreation(new Date());
			pOrder.setQuantity((double) lEntryMap.get("quantity"));
			pOrder.setConcrete(lConcrete);
			pOrder.setClient(lClient);
			pOrder.setConstructionSite(lConstructionSite);

			Session lSessionOne = HibernateUtil.getSessionFactory().openSession();
			lSessionOne.beginTransaction();
			lSessionOne.saveOrUpdate(pOrder);
			lSessionOne.getTransaction().commit();
			lSessionOne.close();
			lResponse = Response.status(Status.CREATED).entity(pOrder.getId()).build();

		} catch (IOException ex) {
			Logger.getLogger(ConcretePersist.class.getName()).log(Level.SEVERE, null, ex);
			lResponse = Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}

		return lResponse;
	}

}
