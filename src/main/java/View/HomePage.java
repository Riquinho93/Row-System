package View;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;


import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;

import Model.UserModel;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;
	
	public HomePage() {

		add(new Label("msg", "Row System"));
		
		rederizandoPagina();
		
	}

	// Metodo deRederizar a pagina
	public void rederizandoPagina() {
		// Botão normal
		AjaxLink<?> button = new AjaxLink<Object>("principal") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget arg0) {
				setResponsePage(Colecao.class);

			}
		};
		button.setOutputMarkupId(true);
		add(button);
	}

}
