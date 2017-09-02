/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betodrive.entitiesbd.beton;

/**
 *
 * @author Clément JEANNE <clement.jeanne@vivaldi.net>
 */
public interface Ingredient {

	/**
	 *
	 * @return
	 */
	public Integer getId();

	public Double getStock();

	public void setStock(Double pStrock);

	public String getNom();

	public void setNom(String pNom);

}
