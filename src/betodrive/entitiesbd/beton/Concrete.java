/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betodrive.entitiesbd.beton;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Clément BOURGEOIS
 */
@Entity
@Table(name = "BETON_TYPE", uniqueConstraints = {
	@UniqueConstraint(columnNames = "ID")})
public class Concrete implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CEMENT_ID")
	private IngredientCement cement;

	@Column(name = "QUANTITY_CEMENT", unique = false, nullable = false)
	private Double qCement;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AGGREGAT_ID")
	private IngredientAggregat aggregat;

	@Column(name = "QUANTITY_AGGREGAT", unique = false, nullable = false)
	private Double qAggregat;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SAND_ID")
	private IngredientSand sand;

	@Column(name = "QUANTITY_SAND", unique = false, nullable = false)
	private Double qSand;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ADJUVANT_ID")
	private IngredientAdjuvant adjuvant;

	@Column(name = "QUANTITY_ADJUVANT", unique = false, nullable = false)
	private Double qAdjuvant;

	@Column(name = "QUANTITY_WATER", unique = false, nullable = false)
	private Double qWater;

	/**
	 * @return the qCement
	 */
	public Double getqCement() {
		return qCement;
	}

	/**
	 * @param qCement the qCement to set
	 */
	public void setqCement(Double qCement) {
		this.qCement = qCement;
	}

	/**
	 * @return the qAggregat
	 */
	public Double getqAggregat() {
		return qAggregat;
	}

	/**
	 * @param qAggregat the qAggregat to set
	 */
	public void setqAggregat(Double qAggregat) {
		this.qAggregat = qAggregat;
	}

	/**
	 * @return the qSand
	 */
	public Double getqSand() {
		return qSand;
	}

	/**
	 * @param qSand the qSand to set
	 */
	public void setqSand(Double qSand) {
		this.qSand = qSand;
	}

	/**
	 * @return the cement
	 */
	public IngredientCement getCement() {
		return cement;
	}

	/**
	 * @param cement the cement to set
	 */
	public void setCement(IngredientCement cement) {
		this.cement = cement;
	}

	/**
	 * @return the aggregat
	 */
	public IngredientAggregat getAggregat() {
		return aggregat;
	}

	/**
	 * @param aggregat the aggregat to set
	 */
	public void setAggregat(IngredientAggregat aggregat) {
		this.aggregat = aggregat;
	}

	/**
	 * @return the sand
	 */
	public IngredientSand getSand() {
		return sand;
	}

	/**
	 * @param sand the sand to set
	 */
	public void setSand(IngredientSand sand) {
		this.sand = sand;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the qWater
	 */
	public Double getqWater() {
		return qWater;
	}

	/**
	 * @param qWater the qWater to set
	 */
	public void setqWater(Double qWater) {
		this.qWater = qWater;
	}

	/**
	 * @return the qAdjuvant
	 */
	public Double getqAdjuvant() {
		return qAdjuvant;
	}

	/**
	 * @param qAdjuvant the qAdjuvant to set
	 */
	public void setqAdjuvant(Double qAdjuvant) {
		this.qAdjuvant = qAdjuvant;
	}

	/**
	 * @return the adjuvant
	 */
	public IngredientAdjuvant getAdjuvant() {
		return adjuvant;
	}

	/**
	 * @param adjuvant the adjuvant to set
	 */
	public void setAdjuvant(IngredientAdjuvant adjuvant) {
		this.adjuvant = adjuvant;
	}

}
