package view;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	// Form<?> form = new Form<Object>("form");
	public HomePage() {
		// add(form);
		add(new Label("msg", "Row System"));

		add(rederizandoPagina());

	}

	// Metodo deRederizar a pagina
	public AjaxLink<?> rederizandoPagina() {
		// Botão normal
		AjaxLink<Object> button = new AjaxLink<Object>("principal") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget arg0) {
				setResponsePage(ColecaoForm.class);

			}
		};
		button.setOutputMarkupId(true);
		add(button);
		return button;
	}

}
