/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.betodrive.crud;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import main.betodrive.db.ConstructionSitePersist;
import main.betodrive.entitiesbd.ConstructionSite;
import main.betodrive.entitiesbd.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author clement.bourgeois
 */
@Path("/ConstructionSite")
public class CRUDConstructionSite {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/CreateConstructionSite")
	public Response createConstructionSite(String pData) {
		Response lResponse;
		ConstructionSitePersist lConstructionSitePersist = new ConstructionSitePersist();
		ConstructionSite pConstructionSite = new ConstructionSite();
		lResponse = lConstructionSitePersist.persistConstructionSite(pConstructionSite, pData);
		return lResponse;
	}

	@GET
	@Path("/RetrieveConstructionSite/{i}")
	public Response retrieveConstructionSite(@PathParam("i") Integer p) {
		Session lSessionGetIngredient = HibernateUtil.getSessionFactory().openSession();
		ConstructionSite lConstructionSite;
		lConstructionSite = (ConstructionSite) lSessionGetIngredient.get(ConstructionSite.class, p);
		lSessionGetIngredient.close();
		String json = new Gson().toJson(lConstructionSite);
		Response lResponse = Response.status(Response.Status.OK).entity(json).build();
		return lResponse;
	}

	@GET
	@Path("/RetrieveAllConstructionSite")
	public Response retrieveConstructionSiteALL() {
		Response lResponse;
		Session lSessionOne = HibernateUtil.getSessionFactory().openSession();
		lSessionOne.beginTransaction();
		Query query = lSessionOne.createQuery("from ConstructionSite");
		List<ConstructionSite> lList = query.list();
		ArrayList<ConstructionSite> list = new ArrayList<>(query.list());
		lSessionOne.close();
		String json = new Gson().toJson(list);
		lResponse = Response.status(Status.FOUND)
				.entity(json).build();
		return lResponse;
	}

	@POST
	@Path("/DeleteConstructionSite/{i}")
	public Response deleteConstructionSite(@PathParam("i") Integer p) {
		Session lSessionGetIngredient = HibernateUtil.getSessionFactory().openSession();
		lSessionGetIngredient.beginTransaction();
		ConstructionSite lConstructionSite;
		lConstructionSite = (ConstructionSite) lSessionGetIngredient.get(ConstructionSite.class, p);
		lSessionGetIngredient.delete(lConstructionSite);
		lSessionGetIngredient.getTransaction().commit();
		lSessionGetIngredient.close();
		Response lResponse = Response.status(Response.Status.OK).build();
		return lResponse;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/ModifyConstructionSite/{i}")
	public Response modifyConstructionSite(@PathParam("i") String pData) {
		Session lSessionGetIngredient = HibernateUtil.getSessionFactory().openSession();
		ConstructionSite lConcrete;
		lConcrete = (ConstructionSite) lSessionGetIngredient.get(ConstructionSite.class, pData);
		lSessionGetIngredient.close();
		ConstructionSitePersist lConcretePersist = new ConstructionSitePersist();
		return lConcretePersist.persistConstructionSite(lConcrete, pData);
	}
}
