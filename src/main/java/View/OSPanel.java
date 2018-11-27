package view;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.LoadableDetachableModel;

import entitidades.CoresModel;
import entitidades.OrdemModel;

public class OSPanel extends Panel {

	private static final long serialVersionUID = 1L;

	private ListView<CoresModel> listViewCoresTam = null;
	private WebMarkupContainer listContainerCoresTam = null;
	private LoadableDetachableModel<List<CoresModel>> loadListCoresTam;
	private List<CoresModel> listCoresTam = new ArrayList<CoresModel>();
	Form<CoresModel> form2;

	public OSPanel(String id) {
		this(id, new OrdemModel());

	}

	public OSPanel(String id, final OrdemModel ordemModel) {
		super(id);
		add(new Label("message", "Ordem de Serviço"));
		pecasTam();
		add(listCores());

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

	// Metodo Peças
	private void pecasTam() {

		CoresModel cores = new CoresModel();
		CompoundPropertyModel<CoresModel> compoundPropertyModel = new CompoundPropertyModel<CoresModel>(cores);
		form2 = new Form<CoresModel>("form2", compoundPropertyModel);
		
		final TextField<CoresModel> cor = new TextField<CoresModel>("cor");
		final TextField<CoresModel> tam = new TextField<CoresModel>("tam");
		
		
//		listCoresTam = (List<CoresModel>) cores;
		//criar uma lista aux para carregar a lista
		
		cor.setOutputMarkupId(true);
		tam.setOutputMarkupId(true);

		AjaxButton ajaxButton = new AjaxButton("add") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form2) {
				super.onSubmit(target, form2);
				CoresModel coresAjax = (CoresModel) form2.getModelObject();
				listCoresTam.add(coresAjax);
				target.add(listContainerCoresTam);
			}
		};
		ajaxButton.setOutputMarkupId(true);

		add(form2);
		form2.add(cor);
		form2.add(tam);
		form2.add(ajaxButton);

	}

	// ListView
	private WebMarkupContainer listCores() {
		listContainerCoresTam = new WebMarkupContainer("theContainerCoresTam");
		listContainerCoresTam.setOutputMarkupId(true);
		loadListCoresTam = new LoadableDetachableModel<List<CoresModel>>() {

			private static final long serialVersionUID = 1L;

			protected List<CoresModel> load() {
				return listCoresTam;
			}
		};

		// Criando a lista View
		listViewCoresTam = new ListView<CoresModel>("listViewCoresTam", loadListCoresTam) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<CoresModel> item) {

				CoresModel user = item.getModelObject();
				// item.add(new Label("ID", user.getId()));
				
				item.add(new Label("cor", user.getCor()));
				item.add(new Label("tam", user.getTam()));
				item.add(removendo(user));
			}

		}.setReuseItems(true);

		listViewCoresTam.setOutputMarkupId(true);

		// Aparecer no container
		listContainerCoresTam.add(listViewCoresTam);

		return listContainerCoresTam;
	}

	// Removendo modelo com ajaxLink
	protected Component removendo(CoresModel user) {
		AjaxLink<CoresModel> button1 = new AjaxLink<CoresModel>("delet") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				CoresModel user = new CoresModel();
				if (user.getIddCores() == user.getIddCores()) {
					listCoresTam.remove(user);
					
				}
				
				add(listContainerCoresTam);
			};
		};
		button1.setOutputMarkupId(true);
		form2.add(button1);
		return button1;
	}

}
