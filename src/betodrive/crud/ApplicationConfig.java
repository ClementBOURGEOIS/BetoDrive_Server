/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betodrive.crud;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author clement.bourgeois
 */
@ApplicationPath("") // set the path to REST web services
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		return (Set<Class<?>>) new HashSet<>(Arrays.asList(CRUDConcrete.class, CRUDOrder.class, CRUDIngredients.class, CRUDConstructionSite.class, CRUDOrder.class));
	}
}
