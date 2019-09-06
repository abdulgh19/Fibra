package fibra.mz.controller;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.spring.SpringUtil;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

import fibra.mz.entity.Categoria;
import fibra.mz.service.CategoriaService;

public class CategoriaCtrl extends GenericForwardComposer {

	private Textbox txt_designacao;
	private Button btn_cancelar, btn_gravar, btn_actualizar;
	private Listbox lbx_categoria;
		
	@WireVariable
	private CategoriaService _categoriaService;
	
	private Categoria categoria;
	
	private List<Categoria> listaCategoria = new ArrayList<Categoria>();
	
	
    @SuppressWarnings("unchecked")
   	@Override
   	public void doBeforeComposeChildren(Component comp) throws Exception {
   		super.doBeforeComposeChildren(comp);
   		
   		_categoriaService = (CategoriaService) SpringUtil.getBean("categoriaService");
  
   	}

   	@SuppressWarnings("unchecked")
   	@Override
   	public void doAfterCompose(Component comp) throws Exception {
   		// TODO Auto-generated method stub
   		super.doAfterCompose(comp);

   		listar();
   	}

	private void listar() {
		// TODO Auto-generated method stub
   		listaCategoria = _categoriaService.getAll();
   		lbx_categoria.setModel(new ListModelList<Categoria>(listaCategoria));
	}
	
	public void onClick$btn_cancelar(Event e) throws InterruptedException{

		limparCampos();
	
	}
	
	private void limparCampos() {
		txt_designacao.setRawValue(null);
		
		btn_gravar.setVisible(true);
		btn_actualizar.setVisible(false);
		listar();
	}
	
   	public void onClick$btn_gravar(Event e) throws InterruptedException{

   		Categoria _ctg = new Categoria();
   	    
   		_ctg.setDesignacao(txt_designacao.getValue());  		           	    

   		_categoriaService.create(_ctg);
   		showNotifications("Categoria registada com sucesso!", "info");
   		limparCampos();
   	}
   	
   	
   	public void showNotifications(String message, String type) {
   		Clients.showNotification(message, type, txt_designacao,"before_center", 4000, true);
   	}
	
}
