package com.bigbear.model;

import org.apache.wicket.model.PropertyModel;

import ch.lambdaj.function.argument.Argument;
import ch.lambdaj.function.argument.ArgumentsFactory;

public class ModelFactory {
	/**
	   * Use with the on() function from Lambdaj to have refactor safe property models.
	   *
	   * e.g.
	   * <pre>
	   * import static com.starjar.wicket.ModelFactory.*;
	   * import static ch.lambdaj.Lambda.*;
	   *
	   * Contact contact = getContactFromDB();
	   *
	   * Label l = new Label("id", model(contact, on(Contact.class).getFirstName()));
	   *
	   *
	   * </pre>
	   *
	   * OR
	   *
	   * <pre>
	   * import static com.starjar.wicket.ModelFactory.*;
	   * import static ch.lambdaj.Lambda.*;
	   *
	   * ContactLDM contactLDM = new ContactLDM(contactId);
	   *
	   * Label l = new Label("id", model(contactLDM, on(Contact.class).getFirstName()));
	   * </pre>
	   *
	   * Works as expected for nested objects
	   *
	   * <pre>
	   * Label l = new Label("address", model(contactLDM, on(Contact.class).getAddress().getLine1()));
	   * </pre>
	   *
	   *
	   * @param <T> Type of the model value
	   * @param value
	   * @param proxiedValue
	   * @return
	   */
	  public static <T> PropertyModel<T> buildModel(Object value, T proxiedValue) {
	    Argument<T> a = ArgumentsFactory.actualArgument(proxiedValue);
	    String invokedPN = a.getInkvokedPropertyName();
	    PropertyModel<T> m = new PropertyModel<T>(value, invokedPN);
	    return m;
	  }
}
