package View;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.feedback.ErrorLevelFeedbackMessageFilter;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.FeedbackMessages;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.validator.EmailAddressValidator;
import org.apache.wicket.validation.validator.StringValidator;

import Model.CadastroModel;

public class Cadastro extends HomePage {
	private static final long serialVersionUID = 1L;

	// private java.util.List dados;
	private List<String> dados;
	private ArrayList<String> genderChoices = new ArrayList<String>();
	private ListView<String> listView2 = null;
	private ArrayList<CadastroModel> users = new ArrayList<CadastroModel>();
	private CadastroModel cadastro;
	private FeedbackPanel feedbackPanel;
	private WebMarkupContainer listContainer2 = null;

	// DateTextField dataSaidaInicial = null;
	
	public Cadastro() {
		feedbackPanel = new FeedbackPanel("feedbackPanel");
		
		// add(new FeedbackPanel("feedbackMessage", new
		// ErrorLevelFeedbackMessageFilter(FeedbackMessage.ERROR)));

		add(new Label("msg", "CADASTRO"));
		imprimir();
		// add valores na data
		dados = new ArrayList();
		dados.add("Alemão");
		// dados.add("Português");
		// dados.add(new CadastroModel("Inglês"));
		// dados.add(new CadastroModel("Português"));

		// add um item na listview e atualizara automaticamente os outros itens

		ListView listView = new ListView("list", dados) {
			protected void populateItem(ListItem item) {
				CadastroModel cad = new CadastroModel();
				final CheckBox chkSeleciona = new CheckBox("idioms");
				// item.add(new CheckBox("idioms", new PropertyModel(cad,
				// "idioms")));
				item.add(new Label("name", cad.getName()));
				// item.add(chkSeleciona);
				// item.add(new CheckBox("idioms", new PropertyModel(cad,
				// "idioms")));
				chkSeleciona.add(new AjaxEventBehavior("idioms") {
					private static final long serialVersionUID = -5356375735369681460L;

					@Override
					protected void onEvent(AjaxRequestTarget target) {
					}

				});
				item.add(chkSeleciona);
			}

		};

		listView.setReuseItems(true);
		listView.setOutputMarkupId(true);
		add(listView);

		cadastro = new CadastroModel();
		CompoundPropertyModel<CadastroModel> compoundPropertyModel = new CompoundPropertyModel<CadastroModel>(cadastro);
		Form<CadastroModel> form = new Form<CadastroModel>("formularioCadastro", compoundPropertyModel) {
			@Override
			protected void onSubmit() {
				// CadastroModel cadastroAjax = getModelObject();
				// System.out.println("Os dados vem aqui: " + cadastroAjax);
				System.out.println("DDD:" + dados);
			
				//setResponsePage(HomePage.class);
			}
		};

		add(form);
		TextField<String> nome = new TextField<String>("nome");
		TextField<String> sobrenome = new TextField<String>("sobrenome");
		NumberTextField<Integer> idade = new NumberTextField<Integer>("idade");
		TextField<String> telefone = new TextField<String>("telefone");
		TextField<String> email = new TextField<String>("email");
		TextField<String> endereco = new TextField<String>("endereco");
		TextArea<String> comentario = new TextArea<String>("text");

		// Tá vindo null
		add(listContainer2);
		// Validações
		nome.setRequired(true);
		sobrenome.setRequired(true);
		idade.setRequired(true);
		endereco.setRequired(true);
		email.setRequired(true);
		form.add(nome, sobrenome, idade, telefone, email, endereco, comentario, listView);
		
		
		AjaxButton ajaxButton = new AjaxButton("submit") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				CadastroModel cadastroAjax = (CadastroModel) form.getModelObject();
				users.add(cadastroAjax);
				executarAoSalvar(target, cadastro);
				// nome.setEnabled(false);
				// executarAoSalvar(target, users);
				form.clearInput();
				form.modelChanged();
				form.setDefaultModelObject(cadastro);
				target.add(listContainer2);
				//onError(target);
				target.add(form);
				//onError(target);
				System.out.println("aaa" + cadastroAjax);

			}
			
			private void executarAoSalvar(AjaxRequestTarget target, CadastroModel cadastro) {
				
				
			}

			@Override
			protected void onError(AjaxRequestTarget target, Form<?> form) {
				// TODO Auto-generated method stub
				super.onError(target, form);
				target.add(feedbackPanel);
			}
			
		};
		add(feedbackPanel);
		feedbackPanel.setOutputMarkupId(true);

		ajaxButton.setOutputMarkupId(true);
		form.add(ajaxButton);
		
		//Data
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

		DateTextField data = new DateTextField("dtnascimento", "dd/MM/yyyy");
		datePickerInicial.setAutoHide(true);
		data.add(datePickerInicial);
		data.setOutputMarkupId(true);
		form.add(data);

		RadioGroup<Boolean> radioGroupAtivo = new RadioGroup<Boolean>("gender");
		radioGroupAtivo.setRequired(true);
		radioGroupAtivo
				.add(new Radio<Boolean>("sim", new Model<Boolean>(true)).add(new AttributeModifier("id", "sim")));
		radioGroupAtivo
				.add(new Radio<Boolean>("nao", new Model<Boolean>(false)).add(new AttributeModifier("id", "nao")));

		form.add(radioGroupAtivo);

	}
	
	

	private void imprimir() {
		// ListView

		listContainer2 = new WebMarkupContainer("theContainer2");

		// Carregando a listView
		IModel loadList = new LoadableDetachableModel() {

			private static final long serialVersionUID = 1L;

			protected Object load() {
				CadastroModel user = new CadastroModel();
				return users;
			}
		};
		// Imprimindo dados
		listView2 = new ListView("list2", loadList) {
			protected void populateItem(ListItem item) {
				CadastroModel user = (CadastroModel) item.getModelObject();
				item.add(new Label("nome", user.getNome()));
				item.add(new Label("sobrenome", user.getSobrenome()));
				item.add(new Label("idade", user.getIdade()));
				item.add(new Label("dtnascimento", user.getDtnascimento()));
				item.add(new Label("gender", user.isGender()));
				item.add(new Label("telefone", user.getTelefone()));
				item.add(new Label("email", user.getEmail()));
				item.add(new Label("endereco", user.getEndereco()));
				item.add(new Label("idioms", user.getIdioms()));
				item.add(new Label("text", user.getText()));
			}
		};
		listView2.setReuseItems(true);
		listContainer2.setOutputMarkupId(true);
		listView2.setOutputMarkupId(true);
		listContainer2.add(listView2);
	}
	// public void executarAoSalvar(AjaxRequestTarget target,
	// ArrayList<CadastroModel> users) {
	//
	// users.addAll(users);
	// /*.clearInput();
	// form.modelChanged();
	// form.setModelObject(userModel);*/
	// target.add(listContainer);
	// };
}
