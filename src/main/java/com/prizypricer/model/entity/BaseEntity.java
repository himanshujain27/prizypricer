package com.prizypricer.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.prizypricer.util.Constant;

/**
 * @author Himanshu
 */

@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -3693722656019995591L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	protected Long id = Constant.DEFAULT_VALUE;

	@Column(name = "created", nullable = false, updatable = false)
	protected Date created;

	@Column(name = "updated", nullable = false)
	protected Date updated;

	@PrePersist
	public void beforeCreate() {
		created = new Date(System.currentTimeMillis());
		updated = new Date(System.currentTimeMillis());
	}

	@PreUpdate
	public void beforeUpdate() {
		updated = new Date(System.currentTimeMillis());
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public boolean isNew() {
		return (this.id == null) || (this.id == -1L);
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}
