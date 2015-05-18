package com.bigbear.web;

import static ch.lambdaj.Lambda.on;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

import com.bigbear.entity.Person;
import com.bigbear.model.ModelFactory;
import com.bigbear.model.PersonModel;

public class PersonDetailPage extends WebPage {
	private static final long serialVersionUID = 1L;
	private IModel<Person> model;

	public PersonDetailPage() {
		this(new PersonModel(new Person(1, "Luan")));
	}

	public PersonDetailPage(IModel<Person> model) {
		super(model);
		this.model = model;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(createIdLabel());
		add(createNameLabel());
	}

	private Label createIdLabel() {
		return new Label("idPerson", ModelFactory.buildModel(model, on(Person.class).getId()));
	}

	private Label createNameLabel() {
		return new Label("namePerson", ModelFactory.buildModel(model, on(Person.class).getName()));
	}

	public IModel<Person> getModel() {
		return model;
	}

	public void setModel(IModel<Person> model) {
		this.model = model;
	}
}
