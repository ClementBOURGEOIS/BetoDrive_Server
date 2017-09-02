/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betodrive.crud;

import betodrive.db.OrderPersist;
import betodrive.entitiesbd.HibernateUtil;
import betodrive.entitiesbd.OrderConcrete;
import betodrive.entitiesbd.beton.IngredientAggregat;
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
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author clement.bourgeois
 */
@Path("/Order")
public class CRUDOrder {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/CreateOrder")
	public Response createOrder(String pData) {
		Response lResponse;
		OrderPersist lOrderPersist = new OrderPersist();
		OrderConcrete lOrder = new OrderConcrete();
		lResponse = lOrderPersist.persistOrder(lOrder, pData);
		return lResponse;
	}

	@GET
	@Path("/RetrieveOrder/{i}")
	public Response retrieveOrder(@PathParam("i") String p) {
		Session lSessionGetIngredient = HibernateUtil.getSessionFactory().openSession();
		OrderConcrete lOrder;
		lOrder = (OrderConcrete) lSessionGetIngredient.get(OrderConcrete.class, p);
		lSessionGetIngredient.close();
		String json = new Gson().toJson(lOrder);
		Response lResponse = Response.status(Response.Status.OK).entity(json).build();
		return lResponse;
	}

	@GET
	@Path("/RetrieveAllOrder")
	public Response retrieveOrderALL() {
		Response lResponse;
		Session lSessionOne = HibernateUtil.getSessionFactory().openSession();
		lSessionOne.beginTransaction();
		Query query = lSessionOne.createQuery("from OrderConcrete");
		List<OrderConcrete> lList = query.list();
		ArrayList<IngredientAggregat> list = new ArrayList<>(query.list());
		lSessionOne.close();
		String json = new Gson().toJson(list);
		lResponse = Response.status(Response.Status.FOUND)
				.entity(json).build();
		return lResponse;
	}

	@POST
	@Path("/DeleteOrder/{i}")
	public Response deleteOrder(@PathParam("i") String p) {
		Session lSessionGetIngredient = HibernateUtil.getSessionFactory().openSession();
		lSessionGetIngredient.beginTransaction();
		OrderConcrete lOrder;
		lOrder = (OrderConcrete) lSessionGetIngredient.get(OrderConcrete.class, p);
		lSessionGetIngredient.delete(lOrder);
		lSessionGetIngredient.getTransaction().commit();
		lSessionGetIngredient.close();
		Response lResponse = Response.status(Response.Status.OK).build();
		return lResponse;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/ModifyConstructionSite/{i}")
	public Response modifyOrder(@PathParam("i") String pData) {
		Session lSessionGetIngredient = HibernateUtil.getSessionFactory().openSession();
		OrderConcrete lConcrete;
		lConcrete = (OrderConcrete) lSessionGetIngredient.get(OrderConcrete.class, pData);
		lSessionGetIngredient.close();
		OrderPersist lConcretePersist = new OrderPersist();
		return lConcretePersist.persistOrder(lConcrete, pData);
	}
}
