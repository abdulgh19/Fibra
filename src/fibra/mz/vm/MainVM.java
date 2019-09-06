package fibra.mz.vm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zhtml.Ol;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import org.zkoss.zul.Image;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class MainVM extends PagVM {

	private static final long serialVersionUID = 1L;

	@Wire("#mainlayout")
	private Div target;

	@Wire("#breadcrumb")
	private Ol ol;

	@Wire
	private Image imgPfl;

	@Wire("#sidebar #imgPflSide")
	private Image imgPflSide;

	// SideBar Menus

	private String initPage;

	private String hoursPage;

	private String recruitPage;

	private String perfomPage;

	private String leavePage;

	private String trainPage;

	private String recPage;

	private String aproovPage;

	private String morePage;

/*	@WireVariable
	private AgenteService agenteService;

	private Ciclo ciclo;
	
	@WireVariable
	private CicloService cicloService;
	
	private Agente agente;*/

	@AfterCompose
	public void initSetup(@ContextParam(ContextType.VIEW) Component view)
			throws IOException {

		final HashMap<String, Object> map = new HashMap<String, Object>();

		Selectors.wireComponents(view, this, false);

		target.getChildren().clear();

		map.put("target", target);
		map.put("breadcrumb", ol);
		//Executions.createComponents("dashboard.zul", target, map);

		links = new ArrayList<String>();
	

		if (target != null) {

			imgPflSide.invalidate();
		}

	}

	@Init
	public void init() {
		menuReset();
		setInitPage("active");
		

	}
	
	@Command
	public void registarCategoria() {
		final HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("target", target);
		map.put("breadcrumb", ol);
		target.getChildren().clear();
		Executions.createComponents(
				"/WEB-INF/views/parametrizacao/registar_Categoria.zul", target, map);

		links = new ArrayList<String>();
		links.add("Inicio");
		drawnBreadcrumb("fa fa-sort", "Mais", links);

		menuReset();
		setMorePage("active");
	}
	

	@Command
	public void registarMaterial() {
		final HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("target", target);
		map.put("breadcrumb", ol);
		target.getChildren().clear();
		Executions.createComponents(
				"/WEB-INF/views/parametrizacao/registar_Material.zul", target, map);

		links = new ArrayList<String>();
		links.add("Inicio");
		drawnBreadcrumb("fa fa-sort", "Mais", links);

		menuReset();
		setMorePage("active");
	}

	@Command
	public void registarVenda() {
		final HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("target", target);
		map.put("breadcrumb", ol);
		target.getChildren().clear();
		Executions.createComponents(
				"/WEB-INF/views/caixa/registar_Venda.zul", target, map);

		links = new ArrayList<String>();
		links.add("Inicio");
		drawnBreadcrumb("fa fa-sort", "Mais", links);

		menuReset();
		setMorePage("active");
	}
	
	@Command
	public void registarCliente() {
		final HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("target", target);
		map.put("breadcrumb", ol);
		target.getChildren().clear();
		Executions.createComponents(
				"/WEB-INF/views/parametrizacao/registar_Cliente.zul", target, map);

		links = new ArrayList<String>();
		links.add("Inicio");
		drawnBreadcrumb("fa fa-sort", "Mais", links);

		menuReset();
		setMorePage("active");
	}
	
	@Command
	public void registarTipoCliente() {
		final HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("target", target);
		map.put("breadcrumb", ol);
		target.getChildren().clear();
		Executions.createComponents(
				"/WEB-INF/views/parametrizacao/registar_TipoCliente.zul", target, map);

		links = new ArrayList<String>();
		links.add("Inicio");
		drawnBreadcrumb("fa fa-sort", "Mais", links);

		menuReset();
		setMorePage("active");
	}
	
	@Command
	public void registarPesquisa() {
		final HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("target", target);
		map.put("breadcrumb", ol);
		target.getChildren().clear();
		Executions.createComponents(
				"/WEB-INF/views/parametrizacao/registar_Pesquisa.zul", target, map);

		links = new ArrayList<String>();
		links.add("Inicio");
		drawnBreadcrumb("fa fa-sort", "Mais", links);

		menuReset();
		setMorePage("active");
	}	
	
	
	@Command
	public void home() {
		final HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("target", target);
		map.put("breadcrumb", ol);
		target.getChildren().clear();
		Executions.createComponents("dashboard.zul", target, map);

		links = new ArrayList<String>();
		links.add("Inicio");
		drawnBreadcrumb("fa fa-sort", "Pagina Inicial", links);

		menuReset();
		setInitPage("active");
		
	}

	@Command
	public void sideBarMore() {
		final HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("target", target);
		map.put("breadcrumb", ol);
		target.getChildren().clear();
		Executions.createComponents("views/more.zul", target, map);

		links = new ArrayList<String>();
		links.add("Inicio");
		drawnBreadcrumb("fa fa-sort", "Mais", links);

		menuReset();
		setMorePage("active");
	}

	private void menuReset() {

		setInitPage("");
		setHoursPage("");
		setRecruitPage("");
		setRecPage("");
		setPerfomPage("");
		setLeavePage("");
		setTrainPage("");
		setAproovPage("");
		setMorePage("");
	}

	public String getInitPage() {
		return initPage;
	}

	public void setInitPage(String initPage) {
		this.initPage = initPage;
	}

	public String getHoursPage() {
		return hoursPage;
	}

	public void setHoursPage(String hoursPage) {
		this.hoursPage = hoursPage;
	}

	public String getRecruitPage() {
		return recruitPage;
	}

	public void setRecruitPage(String recruitPage) {
		this.recruitPage = recruitPage;
	}

	public String getPerfomPage() {
		return perfomPage;
	}

	public void setPerfomPage(String perfomPage) {
		this.perfomPage = perfomPage;
	}

	public String getLeavePage() {
		return leavePage;
	}

	public void setLeavePage(String leavePage) {
		this.leavePage = leavePage;
	}

	public String getTrainPage() {
		return trainPage;
	}

	public void setTrainPage(String trainPage) {
		this.trainPage = trainPage;
	}

	public String getRecPage() {
		return recPage;
	}

	public void setRecPage(String recPage) {
		this.recPage = recPage;
	}

	public String getAproovPage() {
		return aproovPage;
	}

	public void setAproovPage(String aproovPage) {
		this.aproovPage = aproovPage;
	}

	public String getMorePage() {
		return morePage;
	}

	public void setMorePage(String morePage) {
		this.morePage = morePage;
	}
}