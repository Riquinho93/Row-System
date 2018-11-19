package View;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.WindowClosedCallback;
import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.LoadableDetachableModel;

import Model.CadastroModel;
import Model.ColecaoModel;
import Model.OrdemModel;

public class Colecao extends HomePage {

	private static final long serialVersionUID = 1L;

	Form<?> form = new Form<Object>("form");
	private ModalWindow modalWindow;
	private ArrayList<ColecaoModel> colecaoModels = new ArrayList<ColecaoModel>();

	private ListView<ColecaoModel> listView = null;

	// Criando um container
	private WebMarkupContainer listContainer = null;
	private LoadableDetachableModel<List<ColecaoModel>> loadList;

	public Colecao() {

		// Metodo do container
		add(divConteiner());

		// Chamando pagina OS

		add(new Label("message", "COLEÇÕES"));

		// Modal Windows
		modalWindow = new ModalWindow("modalWindow");
		new ColecaoPanel(modalWindow.getContentId());

		add(modalWindow);

		// modalWindow.add(samplePanel);

		// Criando janela do Perfil
		add(new AjaxLink<String>("viewLink") {
			private static final long serialVersionUID = -182677973237618503L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				ColecaoPanel colecaoPanel = new ColecaoPanel(modalWindow.getContentId()) {

					private static final long serialVersionUID = 1L;

					public void executarAoSalvar(AjaxRequestTarget target, ColecaoModel colecaoModel) {

						colecaoModels.add(colecaoModel);
						form.clearInput();
						form.modelChanged();
						// form.setModelObject(userModel);

						target.add(listContainer);
						// modalWindow.clearOriginalDestination();
						modalWindow.close(target);
					};
				};

				modalWindow.setContent(colecaoPanel);
				target.add(listContainer);
				modalWindow.show(target);

			}

		});

		// Colocando nome da janela
		// modalWindow.setTitle("Second Window");

		// Fachando a janela
		modalWindow.setWindowClosedCallback(new WindowClosedCallback() {
			private static final long serialVersionUID = -162677973237618503L;

			@Override
			public void onClose(AjaxRequestTarget target) {
				modalWindow.close(target);
			}
		});

		// Data
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

		DateTextField data = new DateTextField("dtColecao", "dd/MM/yyyy");
		datePickerInicial.setAutoHide(true);
		data.add(datePickerInicial);
		data.setOutputMarkupId(true);
		form.add(data);
	}

	// ListView
	private WebMarkupContainer divConteiner() {
		listContainer = new WebMarkupContainer("theContainer");
		listContainer.setOutputMarkupId(true);
		loadList = new LoadableDetachableModel<List<ColecaoModel>>() {

			private static final long serialVersionUID = 1L;

			protected List<ColecaoModel> load() {
				return colecaoModels;
			}
		};
		// Criando a lista View
		listView = new ListView<ColecaoModel>("listview", loadList) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<ColecaoModel> item) {
				ColecaoModel user = item.getModelObject();
				// item.add(new Label("ID", user.getId()));
				item.add(new Label("nome", user.getNome()));
				item.add(new Label("dtColecao", user.getDtColecao()));
				item.add(visualizar(item.getIndex(), user));
				item.add(editando(user));
				item.add(removendo(item.getIndex()));
			}

		};

		listView.setOutputMarkupId(true);
		// Encapsular a ListView aqui WebMarkupContainer

		// listContainer.add(new
		// AjaxSelfUpdatingTimerBehavior(Duration.seconds(3)));
		// Aparecer no container
		listContainer.add(listView);

		return listContainer;
	}

	// Removendo modelo com ajaxLink
	protected Component removendo(final int index) {
		AjaxLink<ColecaoModel> button1 = new AjaxLink<ColecaoModel>("del") {
			ColecaoModel answer = new ColecaoModel();

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				DeletColecao deletColecao = new DeletColecao(modalWindow.getContentId(), answer) {

					private static final long serialVersionUID = 1L;

					public void executarAoSalvar(AjaxRequestTarget target, ColecaoModel colecaoModel) {
						if (colecaoModel.isAnswer() == true) {
							colecaoModels.remove(index);
							target.add(listContainer);
						}

						modalWindow.close(target);
					};
				};
				deletColecao.setOutputMarkupId(true);
				modalWindow.setContent(deletColecao);
				modalWindow.show(target);
			}
		};
		button1.setOutputMarkupId(true);
		form.add(button1);
		return button1;
	}

	// Editando os campos
	AjaxLink<CadastroModel> editando(final ColecaoModel colecaoModel) {
		AjaxLink<CadastroModel> button1 = new AjaxLink<CadastroModel>("alt") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				ColecaoPanel colecaoPanel = new ColecaoPanel(modalWindow.getContentId(), colecaoModel) {

					private static final long serialVersionUID = 1L;

					public void executarAoSalvar(AjaxRequestTarget target, ColecaoModel colecaoModel) {

						target.add(listContainer);
						modalWindow.close(target);
					};
				};

				colecaoPanel.setOutputMarkupId(true);
				modalWindow.setContent(colecaoPanel);
				modalWindow.show(target);

			}
		};

		button1.setOutputMarkupId(true);
		form.add(button1);
		return button1;
	}

	// Pagina OS

	AjaxLink<OrdemModel> visualizar(final int index, final ColecaoModel user) {
		AjaxLink<OrdemModel> button1 = new AjaxLink<OrdemModel>("vis") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				setResponsePage(OrdemServico.class);

			}
		};

		button1.setOutputMarkupId(true);
		form.add(button1);
		return button1;
	}

}