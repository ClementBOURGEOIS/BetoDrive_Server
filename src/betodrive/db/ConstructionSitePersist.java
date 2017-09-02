/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betodrive.db;

import betodrive.entitiesbd.ConstructionSite;
import betodrive.entitiesbd.HibernateUtil;
import java.io.IOException;
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
public class ConstructionSitePersist {

	public ConstructionSitePersist() {

	}

	public Response persistConstructionSite(ConstructionSite pConstructionSite, String pData) {
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

			pConstructionSite.setAddress((String) lEntryMap.get("address"));
			pConstructionSite.setName((String) lEntryMap.get("name"));

			Session lSessionOne = HibernateUtil.getSessionFactory().openSession();
			lSessionOne.beginTransaction();
			lSessionOne.saveOrUpdate(pConstructionSite);
			lSessionOne.getTransaction().commit();
			lSessionOne.close();
			lResponse = Response.status(Status.CREATED)
					.entity(pConstructionSite.getId()).build();

		} catch (IOException ex) {
			Logger.getLogger(ConstructionSitePersist.class.getName()).log(Level.SEVERE, null, ex);
			lResponse = Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}

		return lResponse;
	}

}
