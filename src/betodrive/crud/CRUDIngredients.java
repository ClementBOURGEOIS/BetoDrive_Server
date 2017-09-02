/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betodrive.crud;

import betodrive.db.ConstructionSitePersist;
import betodrive.db.IngredientPersist;
import betodrive.entitiesbd.ConstructionSite;
import betodrive.entitiesbd.HibernateUtil;
import betodrive.entitiesbd.beton.IngredientAggregat;
import betodrive.entitiesbd.beton.IngredientCement;
import betodrive.entitiesbd.beton.IngredientSand;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Clément JEANNE <clement.jeanne@vivaldi.net>
 */
@Path("/Ingredient")
public class CRUDIngredients {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/CreateIngredient")
	public Response createIngredients(String pData) {
		Response lResponse;
		IngredientPersist lIngredientPersist = new IngredientPersist();
		lResponse = lIngredientPersist.createIngredient(pData);

		return lResponse;
	}

	@GET
	@Path("/RetrieveSand/{i}")
	public Response retrieveIngredientSand(@PathParam("i") Integer p) {
		Session lSessionGetIngredient = HibernateUtil.getSessionFactory().openSession();
		IngredientSand lSand;
		lSand = (IngredientSand) lSessionGetIngredient.get(IngredientSand.class, p);
		lSessionGetIngredient.close();
		String json = new Gson().toJson(lSand);
		Response lResponse = Response.status(Response.Status.OK).entity(json).build();
		return lResponse;
	}

	@GET
	@Path("/RetrieveCement/{i}")
	public Response retrieveIngredientCement(@PathParam("i") Integer p) {
		Session lSessionGetIngredient = HibernateUtil.getSessionFactory().openSession();
		IngredientCement lCement;
		lCement = (IngredientCement) lSessionGetIngredient.get(IngredientCement.class, p);
		lSessionGetIngredient.close();
		String json = new Gson().toJson(lCement);
		Response lResponse = Response.status(Response.Status.OK).entity(json).build();
		return lResponse;
	}

	@GET
	@Path("/RetrieveAggregat/{i}")
	public Response retrieveIngredientAggregat(@PathParam("i") Integer p) {
		Session lSessionGetIngredient = HibernateUtil.getSessionFactory().openSession();
		IngredientAggregat lAggregat;
		lAggregat = (IngredientAggregat) lSessionGetIngredient.get(IngredientAggregat.class, p);
		lSessionGetIngredient.close();
		String json = new Gson().toJson(lAggregat);
		Response lResponse = Response.status(Response.Status.OK).entity(json).build();
		return lResponse;
	}

	@GET
	@Path("/RetrieveAllSand")
	public Response retrieveIngredientsAllSand() {
		Response lResponse;
		Session lSessionOne = HibernateUtil.getSessionFactory().openSession();
		lSessionOne.beginTransaction();
		Query query = lSessionOne.createQuery("from IngredientSand");
		List<IngredientSand> lList = query.list();
		ArrayList<IngredientSand> list = new ArrayList<>(query.list());
		lSessionOne.close();
		String json = new Gson().toJson(list);
		lResponse = Response.status(Response.Status.FOUND)
				.entity(json).build();
		return lResponse;
	}

	@GET
	@Path("/RetrieveAllCement")
	public Response retrieveIngredientsAllCement() {
		Response lResponse;
		Session lSessionOne = HibernateUtil.getSessionFactory().openSession();
		lSessionOne.beginTransaction();
		Query query = lSessionOne.createQuery("from Address");
		List<IngredientCement> lList = query.list();
		ArrayList<IngredientCement> list = new ArrayList<>(query.list());
		lSessionOne.close();
		String json = new Gson().toJson(list);
		lResponse = Response.status(Response.Status.FOUND)
				.entity(json).build();
		return lResponse;
	}

	@GET
	@Path("/RetrieveAllAggregat")
	public Response retrieveIngredientsAllAggregat() {
		Response lResponse;
		Session lSessionOne = HibernateUtil.getSessionFactory().openSession();
		lSessionOne.beginTransaction();
		Query query = lSessionOne.createQuery("from Address");
		List<IngredientAggregat> lList = query.list();
		ArrayList<IngredientAggregat> list = new ArrayList<>(query.list());
		lSessionOne.close();
		String json = new Gson().toJson(list);
		lResponse = Response.status(Response.Status.FOUND)
				.entity(json).build();
		return lResponse;
	}

	@DELETE
	@Path("/RetrieveSand/{i}")
	public Response deleteIngredientSand(@PathParam("i") Integer p) {
		Session lSessionGetIngredient = HibernateUtil.getSessionFactory().openSession();
		lSessionGetIngredient.beginTransaction();
		IngredientSand lIngredientSand;
		lIngredientSand = (IngredientSand) lSessionGetIngredient.get(IngredientSand.class, p);
		lSessionGetIngredient.delete(lIngredientSand);
		lSessionGetIngredient.getTransaction().commit();
		lSessionGetIngredient.close();
		Response lResponse = Response.status(Response.Status.OK).build();
		return lResponse;
	}

	@DELETE
	@Path("/RetrieveCement/{i}")
	public Response deleteIngredientCement(@PathParam("i") Integer p) {
		Session lSessionGetIngredient = HibernateUtil.getSessionFactory().openSession();
		lSessionGetIngredient.beginTransaction();
		IngredientCement lIngredientCement;
		lIngredientCement = (IngredientCement) lSessionGetIngredient.get(IngredientCement.class, p);
		lSessionGetIngredient.delete(lIngredientCement);
		lSessionGetIngredient.getTransaction().commit();
		lSessionGetIngredient.close();
		Response lResponse = Response.status(Response.Status.OK).build();
		return lResponse;
	}

	@POST
	@Path("/RetrieveSand/{i}")
	public Response deleteIngredientAggregat(@PathParam("i") Integer p) {
		Session lSessionGetIngredient = HibernateUtil.getSessionFactory().openSession();
		lSessionGetIngredient.beginTransaction();
		IngredientAggregat lIngredientAggregat;
		lIngredientAggregat = (IngredientAggregat) lSessionGetIngredient.get(IngredientAggregat.class, p);
		lSessionGetIngredient.delete(lIngredientAggregat);
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
