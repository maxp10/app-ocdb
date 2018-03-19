package org.jboss.tools.example.springmvc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Beer implements Serializable
{
    private static final long serailVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 1, max = 45)
    private String name;

    @NotNull
    @Size(min = 1, max = 1)
    @Digits(fraction = 0, integer = 1)
    private String rating;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName() {
	this.name = name;
    }

    public String getRating() {
	return rating;
    }

    public void setRating() {
	this.rating = rating;
    }
}
