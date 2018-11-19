package View;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

import Model.OrdemModel;

public class OSPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public OSPanel(String id) {
		this(id, new OrdemModel());

	}

	public OSPanel(String id, final OrdemModel ordemModel) {
		super(id);
		add(new Label("message", "Ordem de Serviço"));

		Form<OrdemModel> form = new Form<OrdemModel>("form", new CompoundPropertyModel<OrdemModel>(ordemModel));

		final TextField<String> modelo = new TextField<String>("modelo");

		modelo.setOutputMarkupId(true);

		// Criando botão de enviar
		// Botão Ajax
		AjaxButton ajaxButton = new AjaxButton("submit") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);

				executarAoSalvar(target, ordemModel);

				target.add(modelo);
			}
		};
		ajaxButton.setOutputMarkupId(true);

		add(form);
		form.add(modelo);
		form.add(ajaxButton);

	}

	// Enviando os dados para o HomePage
	public void executarAoSalvar(AjaxRequestTarget target, OrdemModel ordemModel) {

	}

}
