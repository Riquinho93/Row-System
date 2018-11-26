package view;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.extensions.markup.html.tabs.TabbedPanel;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;

import entitidades.OrdemModel;

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
		final TextField<String> status = new TextField<String>("status");

		modelo.setOutputMarkupId(true);
		status.setOutputMarkupId(true);
		

		// Data entrada
		DatePicker datePickerInicial = new DatePicker() {
			private static final long serialVersionUID = 1L;

			@Override
			protected boolean alignWithIcon() {
				return true;
			}

			@Override
			protected boolean enableMonthYearSelection() {
				return false;
			}
		};

		DateTextField data = new DateTextField("dtEntrada", "dd/MM/yyyy");
		datePickerInicial.setAutoHide(true);
		data.add(datePickerInicial);
		data.setOutputMarkupId(true);
		form.add(data);

		// Data saida
		DatePicker datePickerSaida = new DatePicker() {
			private static final long serialVersionUID = 1L;

			@Override
			protected boolean alignWithIcon() {
				return true;
			}

			@Override
			protected boolean enableMonthYearSelection() {
				return false;
			}
		};

		DateTextField data2 = new DateTextField("dtSaida", "dd/MM/yyyy");
		datePickerSaida.setAutoHide(true);
		data2.add(datePickerSaida);
		data2.setOutputMarkupId(true);
		form.add(data2);

		// Criando botão de enviar
		// Botão Ajax
		AjaxButton ajaxButton = new AjaxButton("submit") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);

				executarAoSalvar(target, ordemModel);

				target.add(modelo);
				target.add(status);
			}
		};
		ajaxButton.setOutputMarkupId(true);

		add(form);
		form.add(modelo);
		form.add(status);
		form.add(ajaxButton);

	}

	// Enviando os dados para o HomePage
	public void executarAoSalvar(AjaxRequestTarget target, OrdemModel ordemModel) {

	}

}
