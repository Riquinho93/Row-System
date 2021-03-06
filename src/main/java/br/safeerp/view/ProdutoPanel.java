package br.safeerp.view;

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
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.LoadableDetachableModel;

import br.safeerp.entitidades.AdicionaisModel;
import br.safeerp.entitidades.PecaModel;
import br.safeerp.entitidades.CorteModel;
import br.safeerp.entitidades.MateriaisModel;
import br.safeerp.entitidades.ModeloModel;
import br.safeerp.entitidades.ProdutoModel;
import br.safeerp.entitidades.PessoaModel;
import br.safeerp.entitidades.TecidoModel;

public class ProdutoPanel extends Panel {

	private static final long serialVersionUID = 1L;
	// Atributos para Pessoa
	private ListView<PessoaModel> listViewPessoa = null;
	private WebMarkupContainer listContainerPessoa = null;
	private LoadableDetachableModel<List<PessoaModel>> loadListPessoa;
	private List<PessoaModel> listPessoa = new ArrayList<PessoaModel>();
	Form<PessoaModel> form0;

	// Atributos para cores e tamanho
	private ListView<PecaModel> listViewCoresTam = null;
	private WebMarkupContainer listContainerCoresTam = null;
	private LoadableDetachableModel<List<PecaModel>> loadListCoresTam;
	private List<PecaModel> listCoresTam = new ArrayList<PecaModel>();
	Form<PecaModel> form2;

	// Atributos para Serviço
	private ListView<TecidoModel> listViewTecido = null;
	private WebMarkupContainer listContainerTecido = null;
	private LoadableDetachableModel<List<TecidoModel>> loadListTecido;
	private List<TecidoModel> listTecido = new ArrayList<TecidoModel>();
	Form<TecidoModel> form4;

	// Atributos para Materiais
	private ListView<MateriaisModel> listViewMateriais = null;
	private WebMarkupContainer listContainerMaterias = null;
	private LoadableDetachableModel<List<MateriaisModel>> loadListMateriais;
	private List<MateriaisModel> listMateriais = new ArrayList<MateriaisModel>();
	Form<MateriaisModel> form3;

	// Atributos para Corte
	private ListView<CorteModel> listViewCorte = null;
	private WebMarkupContainer listContainerCorte = null;
	private LoadableDetachableModel<List<CorteModel>> loadListCorte;
	private List<CorteModel> listCorte = new ArrayList<CorteModel>();
	Form<CorteModel> form5;

	// Atributos para Modelo
	private ListView<ModeloModel> listViewModelo = null;
	private WebMarkupContainer listContainerModelo = null;
	private LoadableDetachableModel<List<ModeloModel>> loadListModelo;
	private List<ModeloModel> listModelo = new ArrayList<ModeloModel>();
	Form<ModeloModel> form7;

	// Atributos para Adionais
	private ListView<AdicionaisModel> listViewAdicionais = null;
	private WebMarkupContainer listContainerAdicionais = null;
	private LoadableDetachableModel<List<AdicionaisModel>> loadListAdicionais;
	private List<AdicionaisModel> listAdicionais = new ArrayList<AdicionaisModel>();
	Form<AdicionaisModel> form6;

	public ProdutoPanel(String id) {
		this(id, new ProdutoModel());

	}

	public ProdutoPanel(String id, final ProdutoModel produtoModel) {
		super(id);
		add(new Label("message", "Ordem de Serviço"));
		// Chamando metodo Pessoa
		pessoa();
		add(listPessoais());
		// Chamando Metodo Cores e Tamanho
		pecasTam();
		add(listCores());
		// Chamando metodo Serviço
		servico();
		add(listTecidos());
		// Chamando Metodo Materiais
		materiais();
		add(listMateriais());
		// Chamando Metodo Corte
		cortesMetodo();
		add(listCortes());
		// Chamando Metodod Modelo
		modelo();
		add(listModelo());
		// Chamando Metodo Adicionais
		adicionar();
		add(listAdd());

		Form<ProdutoModel> form = new Form<ProdutoModel>("form", new CompoundPropertyModel<ProdutoModel>(produtoModel));

		final TextField<String> modelo = new TextField<String>("modelo");
		final TextField<String> largura = new TextField<String>("largura");
		final TextField<String> tipoEnfesto = new TextField<String>("tipoEnfesto");
		final TextField<String> status = new TextField<String>("status");

		modelo.setOutputMarkupId(true);
		largura.setOutputMarkupId(true);
		tipoEnfesto.setOutputMarkupId(true);
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

				executarAoSalvar(target, produtoModel);

				target.add(modelo);
				target.add(largura);
				target.add(tipoEnfesto);
				target.add(status);
			}
		};
		ajaxButton.setOutputMarkupId(true);

		add(form);
		form.add(modelo);
		form.add(largura);
		form.add(tipoEnfesto);
		form.add(status);
		form.add(ajaxButton);

	}

	// Enviando os dados para o HomePage
	public void executarAoSalvar(AjaxRequestTarget target, ProdutoModel produtoModel) {

	}

	// Aqui começa aba pessoa
	// Metodo Pessoa
	private void pessoa() {
		PessoaModel pessoal = new PessoaModel();
		CompoundPropertyModel<PessoaModel> compoundPropertyModel = new CompoundPropertyModel<PessoaModel>(pessoal);
		form0 = new Form<PessoaModel>("form0", compoundPropertyModel);

		final TextField<PessoaModel> pessoa = new TextField<PessoaModel>("pessoa");
		final TextField<PecaModel> sexo = new TextField<PecaModel>("sexo");
		final TextField<PessoaModel> tipo = new TextField<PessoaModel>("tipo");

		pessoa.setOutputMarkupId(true);
		sexo.setOutputMarkupId(true);
		tipo.setOutputMarkupId(true);

		AjaxButton ajaxButton = new AjaxButton("add0") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form0) {
				super.onSubmit(target, form0);
				PessoaModel pessoaAjax = (PessoaModel) form0.getModelObject();
				listPessoa.add(pessoaAjax);
				target.add(listContainerPessoa);
			}
		};
		ajaxButton.setOutputMarkupId(true);

		add(form0);
		form0.add(pessoa);
		form0.add(sexo);
		form0.add(tipo);
		form0.add(ajaxButton);

	}

	// ListView
	private WebMarkupContainer listPessoais() {
		listContainerPessoa = new WebMarkupContainer("theContainerPessoa");
		listContainerPessoa.setOutputMarkupId(true);
		loadListPessoa = new LoadableDetachableModel<List<PessoaModel>>() {

			private static final long serialVersionUID = 1L;

			protected List<PessoaModel> load() {
				return listPessoa;
			}
		};

		// Criando a lista View
		listViewPessoa = new ListView<PessoaModel>("listViewPessoa", loadListPessoa) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<PessoaModel> item) {

				PessoaModel user = item.getModelObject();
				// item.add(new Label("ID", user.getId()));

				item.add(new Label("pessoa", user.getPessoa()));
				item.add(new Label("sexo", user.getSexo()));
				item.add(new Label("tipo", user.getTipo()));
				item.add(removendo(user));
			}

		}.setReuseItems(true);

		listViewPessoa.setOutputMarkupId(true);

		// Aparecer no container
		listContainerPessoa.add(listViewPessoa);

		return listContainerPessoa;
	}

	// Removendo modelo com ajaxLink
	protected Component removendo(PessoaModel user) {
		AjaxLink<PessoaModel> button1 = new AjaxLink<PessoaModel>("delet0") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				PessoaModel user = new PessoaModel();
				if (user.getIddPessoa() == user.getIddPessoa()) {
					listPessoa.remove(user);

				}

				add(listContainerPessoa);
			};
		};
		button1.setOutputMarkupId(true);
		form0.add(button1);
		return button1;
	}

	// Aqui começa aba de peças
	// Metodo Peças
	private void pecasTam() {

		PecaModel cores = new PecaModel();
		CompoundPropertyModel<PecaModel> compoundPropertyModel = new CompoundPropertyModel<PecaModel>(cores);
		form2 = new Form<PecaModel>("form2", compoundPropertyModel);

		final TextField<PecaModel> cor = new TextField<PecaModel>("cor");
		final TextField<PecaModel> tam = new TextField<PecaModel>("tam");
		final NumberTextField<Integer> qtd = new NumberTextField<Integer>("qtd");
		final NumberTextField<Double> qtdTotal = new NumberTextField<Double>("qtdTotal");

		// listCoresTam = (List<CoresModel>) cores;
		// criar uma lista aux para carregar a lista

		cor.setOutputMarkupId(true);
		tam.setOutputMarkupId(true);
		qtd.setOutputMarkupId(true);
		qtdTotal.setOutputMarkupId(true);

		AjaxButton ajaxButton = new AjaxButton("add") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form2) {
				super.onSubmit(target, form2);
				PecaModel coresAjax = (PecaModel) form2.getModelObject();
				listCoresTam.add(coresAjax);
				target.add(qtdTotal);
				target.add(listContainerCoresTam);
			}
		};
		ajaxButton.setOutputMarkupId(true);

		add(form2);
		form2.add(cor);
		form2.add(tam);
		form2.add(qtd);
		form2.add(qtdTotal);
		form2.add(ajaxButton);

	}

	// ListView
	private WebMarkupContainer listCores() {
		listContainerCoresTam = new WebMarkupContainer("theContainerCoresTam");
		listContainerCoresTam.setOutputMarkupId(true);
		loadListCoresTam = new LoadableDetachableModel<List<PecaModel>>() {

			private static final long serialVersionUID = 1L;

			protected List<PecaModel> load() {
				return listCoresTam;
			}
		};

		// Criando a lista View
		listViewCoresTam = new ListView<PecaModel>("listViewCoresTam", loadListCoresTam) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<PecaModel> item) {

				PecaModel user = item.getModelObject();
				// item.add(new Label("ID", user.getId()));

				item.add(new Label("cor", user.getCor()));
				item.add(new Label("tam", user.getTam()));
				item.add(new Label("qtd", user.getQtd()));
				item.add(removendo(user));
			}

		}.setReuseItems(true);

		listViewCoresTam.setOutputMarkupId(true);

		// Aparecer no container
		listContainerCoresTam.add(listViewCoresTam);

		return listContainerCoresTam;
	}

	// Removendo modelo com ajaxLink
	protected Component removendo(final PecaModel user) {
		AjaxLink<PecaModel> button1 = new AjaxLink<PecaModel>("delet") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				PecaModel user2 = new PecaModel();
				
					listCoresTam.remove(user2);

				

				add(listContainerCoresTam);
			};
		};
		button1.setOutputMarkupId(true);
		form2.add(button1);
		return button1;
	}

	// Serviços começam aqui
	// Metodo Serviço
	private void servico() {

		TecidoModel tecidos = new TecidoModel();
		CompoundPropertyModel<TecidoModel> compoundPropertyModel = new CompoundPropertyModel<TecidoModel>(tecidos);
		form4 = new Form<TecidoModel>("form4", compoundPropertyModel);

		final TextField<TecidoModel> tecido = new TextField<TecidoModel>("tecido");
		final TextField<TecidoModel> cor = new TextField<TecidoModel>("cor");
		final TextField<TecidoModel> composicao = new TextField<TecidoModel>("composicao");
		final TextField<TecidoModel> codigo = new TextField<TecidoModel>("codigo");
		final NumberTextField<Double> valor = new NumberTextField<Double>("valor");

		tecido.setOutputMarkupId(true);
		cor.setOutputMarkupId(true);
		composicao.setOutputMarkupId(true);
		codigo.setOutputMarkupId(true);
		valor.setOutputMarkupId(true);

		AjaxButton ajaxButton = new AjaxButton("add4") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form4) {
				super.onSubmit(target, form4);
				TecidoModel tecidoAjax = (TecidoModel) form4.getModelObject();
				listTecido.add(tecidoAjax);
				target.add(listContainerTecido);
			}
		};
		ajaxButton.setOutputMarkupId(true);

		add(form4);
		form4.add(tecido);
		form4.add(cor);
		form4.add(composicao);
		form4.add(codigo);
		form4.add(valor);
		form4.add(ajaxButton);

	}

	// ListView
	private WebMarkupContainer listTecidos() {
		listContainerTecido = new WebMarkupContainer("theContainerTecido");
		listContainerTecido.setOutputMarkupId(true);
		loadListTecido = new LoadableDetachableModel<List<TecidoModel>>() {

			private static final long serialVersionUID = 1L;

			protected List<TecidoModel> load() {
				return listTecido;
			}
		};

		// Criando a lista View
		listViewTecido = new ListView<TecidoModel>("listViewTecido", loadListTecido) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<TecidoModel> item) {

				TecidoModel user = item.getModelObject();
				// item.add(new Label("ID", user.getId()));

				item.add(new Label("tecido", user.getTecido()));
				item.add(new Label("cor", user.getCor()));
				item.add(new Label("composicao", user.getComposicao()));
				item.add(new Label("codigo", user.getCodigo()));
				item.add(new Label("valor", user.getValor()));
				item.add(removendo(user));
			}

		}.setReuseItems(true);

		listViewTecido.setOutputMarkupId(true);

		// Aparecer no container
		listContainerTecido.add(listViewTecido);

		return listContainerTecido;
	}

	// Removendo modelo com ajaxLink
	protected Component removendo(TecidoModel user) {
		AjaxLink<TecidoModel> button1 = new AjaxLink<TecidoModel>("delet4") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				TecidoModel user = new TecidoModel();
				if (user.getIddTecido() == user.getIddTecido()) {
					listTecido.remove(user);

				}

				add(listContainerTecido);
			};
		};
		button1.setOutputMarkupId(true);
		form4.add(button1);
		return button1;
	}

	// Materiais começa aqui
	private void materiais() {

		MateriaisModel cores = new MateriaisModel();
		CompoundPropertyModel<MateriaisModel> compoundPropertyModel = new CompoundPropertyModel<MateriaisModel>(cores);
		form3 = new Form<MateriaisModel>("form3", compoundPropertyModel);

		final TextField<MateriaisModel> nome = new TextField<MateriaisModel>("nome");
		final NumberTextField<Integer> qtd = new NumberTextField<Integer>("qtd");
		final TextField<MateriaisModel> medida = new TextField<MateriaisModel>("medida");

		// listCoresTam = (List<CoresModel>) cores;
		// criar uma lista aux para carregar a lista

		nome.setOutputMarkupId(true);
		qtd.setOutputMarkupId(true);
		medida.setOutputMarkupId(true);

		AjaxButton ajaxButton = new AjaxButton("add2") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form2) {
				super.onSubmit(target, form2);
				MateriaisModel materiaisAjax = (MateriaisModel) form2.getModelObject();
				listMateriais.add(materiaisAjax);
				target.add(listContainerMaterias);
			}
		};
		ajaxButton.setOutputMarkupId(true);

		add(form3);
		form3.add(nome);
		form3.add(qtd);
		form3.add(medida);
		form3.add(ajaxButton);

	}

	// ListView
	private WebMarkupContainer listMateriais() {
		listContainerMaterias = new WebMarkupContainer("theContainerMateriais");
		listContainerMaterias.setOutputMarkupId(true);
		loadListMateriais = new LoadableDetachableModel<List<MateriaisModel>>() {

			private static final long serialVersionUID = 1L;

			protected List<MateriaisModel> load() {
				return listMateriais;
			}
		};

		// Criando a lista View
		listViewMateriais = new ListView<MateriaisModel>("listViewMateriais", loadListMateriais) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<MateriaisModel> item) {

				MateriaisModel user = item.getModelObject();
				// item.add(new Label("ID", user.getId()));

				item.add(new Label("nome", user.getNome()));
				item.add(new Label("qtd", user.getQtd()));
				item.add(new Label("medida", user.getMedida()));
				item.add(removendo(user));
			}

		}.setReuseItems(true);

		listViewMateriais.setOutputMarkupId(true);

		// Aparecer no container
		listContainerMaterias.add(listViewMateriais);

		return listContainerMaterias;
	}

	// Removendo modelo com ajaxLink
	protected Component removendo(MateriaisModel user) {
		AjaxLink<MateriaisModel> button1 = new AjaxLink<MateriaisModel>("delet2") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				MateriaisModel user = new MateriaisModel();
				if (user.getIddMateriais() == user.getIddMateriais()) {
					listMateriais.remove(user);

				}

				add(listContainerMaterias);
			};
		};
		button1.setOutputMarkupId(true);
		form3.add(button1);
		return button1;
	}

	// Aqui começa aba Corte
	// Metodo Corte
	private void cortesMetodo() {

		CorteModel cortes = new CorteModel();
		CompoundPropertyModel<CorteModel> compoundPropertyModel = new CompoundPropertyModel<CorteModel>(cortes);
		form5 = new Form<CorteModel>("form5", compoundPropertyModel);

		final TextField<PecaModel> cor = new TextField<PecaModel>("cor");
		final TextField<PecaModel> tam = new TextField<PecaModel>("tam");
		final NumberTextField<Integer> qtd = new NumberTextField<Integer>("qtd");
		final NumberTextField<Double> qtdTotal = new NumberTextField<Double>("qtdTotal");
		
		cor.setOutputMarkupId(true);
		tam.setOutputMarkupId(true);
		qtd.setOutputMarkupId(true);
		qtdTotal.setOutputMarkupId(true);

		AjaxButton ajaxButton = new AjaxButton("add5") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form5) {
				super.onSubmit(target, form5);
				CorteModel corteAjax = (CorteModel) form5.getModelObject();
				listCorte.add(corteAjax);
				target.add(qtdTotal);
				target.add(listContainerCorte);
			}
		};
		ajaxButton.setOutputMarkupId(true);

		add(form5);
		form5.add(cor);
		form5.add(tam);
		form5.add(qtd);
		form5.add(qtdTotal);
		form5.add(ajaxButton);

	}

	// ListView
	private WebMarkupContainer listCortes() {
		listContainerCorte = new WebMarkupContainer("theContainerCorte");
		listContainerCorte.setOutputMarkupId(true);
		loadListCorte = new LoadableDetachableModel<List<CorteModel>>() {

			private static final long serialVersionUID = 1L;

			protected List<CorteModel> load() {
				return listCorte;
			}
		};

		// Criando a lista View
		listViewCorte = new ListView<CorteModel>("listViewCortes", loadListCorte) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<CorteModel> item) {

				CorteModel user = item.getModelObject();
				// item.add(new Label("ID", user.getId()));

				item.add(new Label("cor", user.getCor()));
				item.add(new Label("tam", user.getTam()));
				item.add(new Label("qtd", user.getQtd()));
				item.add(removendo(user));
			}

		}.setReuseItems(true);

		listViewCorte.setOutputMarkupId(true);

		// Aparecer no container
		listContainerCorte.add(listViewCorte);

		return listContainerCorte;
	}

	// Removendo modelo com ajaxLink
	protected Component removendo(CorteModel user) {
		AjaxLink<CorteModel> button1 = new AjaxLink<CorteModel>("delet5") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				CorteModel user = new CorteModel();
				
					listCorte.remove(user);

				

				add(listContainerCorte);
			};
		};
		button1.setOutputMarkupId(true);
		form5.add(button1);
		return button1;
	}

	// Aqui começa aba Adicionais
	// Metodo Adicionar
	private void adicionar() {

		AdicionaisModel add = new AdicionaisModel();
		CompoundPropertyModel<AdicionaisModel> compoundPropertyModel = new CompoundPropertyModel<AdicionaisModel>(add);
		form6 = new Form<AdicionaisModel>("form6", compoundPropertyModel);

		final TextField<AdicionaisModel> nome = new TextField<AdicionaisModel>("nome");
		final TextArea<AdicionaisModel> descricao = new TextArea<AdicionaisModel>("descricao");

		nome.setOutputMarkupId(true);
		descricao.setOutputMarkupId(true);

		AjaxButton ajaxButton = new AjaxButton("add6") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form6) {
				super.onSubmit(target, form6);
				AdicionaisModel addAjax = (AdicionaisModel) form6.getModelObject();
				listAdicionais.add(addAjax);
				target.add(listContainerAdicionais);
				System.out.println("jfjhgj");
			}
		};
		ajaxButton.setOutputMarkupId(true);

		add(form6);
		form6.add(nome);
		form6.add(descricao);
		form6.add(ajaxButton);

	}

	// ListView
	private WebMarkupContainer listAdd() {
		listContainerAdicionais = new WebMarkupContainer("theContainerAdicionais");
		listContainerAdicionais.setOutputMarkupId(true);
		loadListAdicionais = new LoadableDetachableModel<List<AdicionaisModel>>() {

			private static final long serialVersionUID = 1L;

			protected List<AdicionaisModel> load() {
				return listAdicionais;
			}
		};

		// Criando a lista View
		listViewAdicionais = new ListView<AdicionaisModel>("listViewAdicionais", loadListAdicionais) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<AdicionaisModel> item) {

				AdicionaisModel user = item.getModelObject();
				// item.add(new Label("ID", user.getId()));

				item.add(new Label("nome", user.getNome()));
				item.add(new Label("descricao", user.getDescricao()));
				item.add(removendo(user));
			}

		}.setReuseItems(true);

		listViewAdicionais.setOutputMarkupId(true);

		// Aparecer no container
		listContainerAdicionais.add(listViewAdicionais);

		return listContainerAdicionais;
	}

	// Removendo modelo com ajaxLink
	protected Component removendo(AdicionaisModel user) {
		AjaxLink<AdicionaisModel> button1 = new AjaxLink<AdicionaisModel>("delet6") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				AdicionaisModel user = new AdicionaisModel();
				if (user.getAddId() == user.getAddId()) {
					listAdicionais.remove(user);

				}

				add(listContainerAdicionais);
			};
		};
		button1.setOutputMarkupId(true);
		form6.add(button1);
		return button1;
	}

	// Aqui começa aba Modelo
	// Metodo Modelo
	private void modelo() {

		ModeloModel mod = new ModeloModel();
		CompoundPropertyModel<ModeloModel> compoundPropertyModel = new CompoundPropertyModel<ModeloModel>(mod);
		form7 = new Form<ModeloModel>("form7", compoundPropertyModel);

		final TextField<ModeloModel> prioridade = new TextField<ModeloModel>("prioridade");
		final TextArea<ModeloModel> nome = new TextArea<ModeloModel>("nome");

		nome.setOutputMarkupId(true);
		prioridade.setOutputMarkupId(true);

		AjaxButton ajaxButton = new AjaxButton("add7") {

			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form7) {
				super.onSubmit(target, form7);
				ModeloModel addAjax = (ModeloModel) form7.getModelObject();
				listModelo.add(addAjax);
				target.add(listContainerModelo);
			}
		};
		ajaxButton.setOutputMarkupId(true);

		add(form7);
		form7.add(nome);
		form7.add(prioridade);
		form7.add(ajaxButton);

	}

	// ListView
	private WebMarkupContainer listModelo() {
		listContainerModelo = new WebMarkupContainer("theContainerModelo");
		listContainerModelo.setOutputMarkupId(true);
		loadListModelo = new LoadableDetachableModel<List<ModeloModel>>() {

			private static final long serialVersionUID = 1L;

			protected List<ModeloModel> load() {
				return listModelo;
			}
		};

		// Criando a lista View
		listViewModelo = new ListView<ModeloModel>("listViewModelo", loadListModelo) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<ModeloModel> item) {

				ModeloModel user = item.getModelObject();
				// item.add(new Label("ID", user.getId()));

				item.add(new Label("prioridade", user.getPrioridade()));
				item.add(new Label("nome", user.getNome()));
				item.add(removendo(user));
			}

		}.setReuseItems(true);

		listViewModelo.setOutputMarkupId(true);

		// Aparecer no container
		listContainerModelo.add(listViewModelo);

		return listContainerModelo;
	}

	// Removendo modelo com ajaxLink
	protected Component removendo(final ModeloModel user) {
		AjaxLink<ModeloModel> button1 = new AjaxLink<ModeloModel>("delet7") {

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				ModeloModel user2 = new ModeloModel();
				if (user.getIddObservacao() == user2.getIddObservacao()) {
					listModelo.remove(user);

				}

				add(listContainerModelo);
			};
		};
		button1.setOutputMarkupId(true);
		form7.add(button1);
		return button1;
	}

}
