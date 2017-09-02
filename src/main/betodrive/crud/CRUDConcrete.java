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
import main.betodrive.db.ConcretePersist;
import main.betodrive.entitiesbd.HibernateUtil;
import main.betodrive.entitiesbd.beton.Concrete;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author clement.bourgeois
 */
@Path("/Recipe")
public class CRUDConcrete {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/CreateRecipe")
	public Response createRecette(String pData) {
		Response lResponse;
		ConcretePersist lConcretePersist = new ConcretePersist();
		Concrete pConcrete = new Concrete();
		lResponse = lConcretePersist.persistConcrete(pConcrete, pData);
		return lResponse;
	}

	@GET
	@Path("/RetrieveRecipe/{i}")
	public Response retrieveRecette(@PathParam("i") Integer p) {
		Session lSessionGetIngredient = HibernateUtil.getSessionFactory().openSession();
		Concrete lConcrete;
		lConcrete = (Concrete) lSessionGetIngredient.get(Concrete.class, p);
		lSessionGetIngredient.close();
		String json = new Gson().toJson(lConcrete);
		Response lResponse = Response.status(Response.Status.OK).entity(json).build();
		return lResponse;
	}

	@GET
	@Path("/RetrieveAllRecipe")
	public Response retrieveRecetteALL() {
		Response lResponse;
		Session lSessionOne = HibernateUtil.getSessionFactory().openSession();
		lSessionOne.beginTransaction();
		Query query = lSessionOne.createQuery("from Concrete");
		List<Concrete> lList = query.list();
		ArrayList<Concrete> list = new ArrayList<>(query.list());
		lSessionOne.close();
		String json = new Gson().toJson(list);
		lResponse = Response.status(Response.Status.OK)
				.entity(json).build();
		return lResponse;
	}

	@POST
	@Path("/DeleteRecipe/{i}")
	public Response deleteRecette(@PathParam("i") Integer p) {
		Session lSessionGetIngredient = HibernateUtil.getSessionFactory().openSession();
		lSessionGetIngredient.beginTransaction();
		Concrete lConcrete;
		lConcrete = (Concrete) lSessionGetIngredient.get(Concrete.class, p);
		lSessionGetIngredient.delete(lConcrete);
		lSessionGetIngredient.getTransaction().commit();
		lSessionGetIngredient.close();
		Response lResponse = Response.status(Response.Status.OK).build();
		return lResponse;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/ModifyRecipe/{i}")
	public Response modifyRecette(@PathParam("i") String pData) {
		Session lSessionGetIngredient = HibernateUtil.getSessionFactory().openSession();
		Concrete lConcrete;
		lConcrete = (Concrete) lSessionGetIngredient.get(Concrete.class, pData);
		lSessionGetIngredient.close();
		ConcretePersist lConcretePersist = new ConcretePersist();
		return lConcretePersist.persistConcrete(lConcrete, pData);
	}
}
