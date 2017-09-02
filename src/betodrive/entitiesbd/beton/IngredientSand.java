/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betodrive.entitiesbd.beton;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Clément BOURGEOIS
 */
@Entity
@Table(name = "SAND_TYPE", uniqueConstraints = {
	@UniqueConstraint(columnNames = "ID")})
public class IngredientSand implements Serializable, Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "STOCK", unique = false, nullable = false)
	private Double stock;

	@Column(name = "NOM", unique = false, nullable = false)
	private String nom;

	/**
	 * @return the nom
	 */
	@Override
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the stock
	 */
	@Override
	public Double getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	@Override
	public void setStock(Double stock) {
		this.stock = stock;
	}

	@Override
	public Integer getId() {
		return id;
	}
}
