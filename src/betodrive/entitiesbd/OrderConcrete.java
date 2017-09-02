/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betodrive.entitiesbd;

import betodrive.entitiesbd.beton.Concrete;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author clement.bourgeois
 */
@Entity
@Table(name = "ORDER_CONCRETE", uniqueConstraints = {
	@UniqueConstraint(columnNames = "ID")
	, @UniqueConstraint(columnNames = "DATE_CREATION")})
public class OrderConcrete implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_CREATION", unique = true, nullable = false)
	private Date dateCreation;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CLIENT_ID")
	private Client client;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CONSTRUCTIONSITE_ID")
	private ConstructionSite constructionSite;

//	Centrale centrale;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Concrete_ID")
	private Concrete concrete;

	@Column(name = "QUANTITY", unique = true, nullable = false)
	private Double quantity;

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the chantier
	 */
	public ConstructionSite getConstructionSite() {
		return constructionSite;
	}

	/**
	 * @param constructionSite
	 */
	public void setConstructionSite(ConstructionSite constructionSite) {
		this.constructionSite = constructionSite;
	}

	/**
	 * @return the quantité
	 */
	public double getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 */
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the concrete
	 */
	public Concrete getConcrete() {
		return concrete;
	}

	/**
	 * @param concrete the concrete to set
	 */
	public void setConcrete(Concrete concrete) {
		this.concrete = concrete;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the dateCreation
	 */
	public Date getDateCreation() {
		return dateCreation;
	}

	/**
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
}
