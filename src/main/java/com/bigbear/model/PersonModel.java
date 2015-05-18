package com.bigbear.model;

import org.apache.wicket.model.IModel;

import com.bigbear.entity.Person;

public class PersonModel implements IModel<Person> {
	private static final long serialVersionUID = 1L;
	private Person person;
	public PersonModel(Person p) {
		this.person=p;
	}
	@Override
	public void detach() {
		person=null;
	}

	@Override
	public Person getObject() {
		return person;
	}

	@Override
	public void setObject(Person object) {
		this.person=object;
	}

}
