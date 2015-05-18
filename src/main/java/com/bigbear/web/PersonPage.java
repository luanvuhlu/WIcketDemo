package com.bigbear.web;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.head.PriorityHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.HiddenField;
import org.apache.wicket.model.IModel;

import com.bigbear.entity.Person;
import com.bigbear.model.ModelFactory;
import com.bigbear.model.PersonModel;
import com.bigbear.util.EntityUtil;

import static ch.lambdaj.Lambda.*;

public class PersonPage extends WebPage {
	private static final long serialVersionUID = 1L;
	private IModel<Person> model;

	public PersonPage() {
		this(new PersonModel(new Person(1, "Luan")));
	}

	public PersonPage(IModel<Person> model) {
		super();
		this.model = model;
		setDefaultModel(model);
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(new PriorityHeaderItem(JavaScriptHeaderItem
				.forReference(getApplication().getJavaScriptLibrarySettings()
						.getJQueryReference())));
		response.render(JavaScriptHeaderItem.forScript(
				EntityUtil.getProductsListData(), null));
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		Form<Person> form = new Form<Person>("form", model) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
				setResponsePage(new PersonDetailPage(model));
			}
		};
		add(form);
		form.add(createProductSelect2());
		// add(new Label("script",
		// EntityUtil.getProductsListData()).setEscapeModelStrings(false));
	}

	@Override
	protected void onDetach() {
		super.onDetach();
		this.model.detach();
	}

	private Label createIdLabel() {
		return new Label("idPerson", ModelFactory.buildModel(model,
				on(Person.class).getId()));
	}

	private Label createNameLabel() {
		return new Label("namePerson", ModelFactory.buildModel(model,
				on(Person.class).getName()));
	}
	private DropDownChoice<String> createProductSelect2() {
		return new DropDownChoice<String>("product"){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void renderHead(IHeaderResponse response) {
				response.render(OnDomReadyHeaderItem.forScript("$('#"
						+ getMarkupId() + "').select2({data:data});"));
			}
		};
	}
	private HiddenField<String> createProductSelect() {
		return new HiddenField<String>("product") {
			/**
		 * 
		 */
			private static final long serialVersionUID = 1L;

			@Override
			public void renderHead(IHeaderResponse response) {
				response.render(OnDomReadyHeaderItem.forScript("$('#"
						+ getMarkupId() + "').select2({data:data});"));
			}
		};
	}

	public IModel<Person> getModel() {
		return model;
	}

	public void setModel(IModel<Person> model) {
		this.model = model;
	}
}
