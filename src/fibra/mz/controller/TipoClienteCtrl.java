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

import fibra.mz.entity.TipoCliente;
import fibra.mz.service.TipoClienteService;

public class TipoClienteCtrl extends GenericForwardComposer{
	

	private Textbox txb_designacao;
	private Button btn_cancelar, btn_gravar, btn_actualizar;
	private Listbox lbx_tipoCliente;
		
	@WireVariable
	private TipoClienteService _tipoClienteService;
	

	private List<TipoCliente> listaTipoCliente = new ArrayList<TipoCliente>();

	
	
    @SuppressWarnings("unchecked")
   	@Override
   	public void doBeforeComposeChildren(Component comp) throws Exception {
   		super.doBeforeComposeChildren(comp);
   		
   		_tipoClienteService = (TipoClienteService) SpringUtil.getBean("tipoClienteService");
  
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
		listaTipoCliente = _tipoClienteService.getAll();
		lbx_tipoCliente.setModel(new ListModelList<TipoCliente>(listaTipoCliente));
	}
	
	public void onClick$btn_cancelar(Event e) throws InterruptedException{

		limparCampos();
	
	}
	
	private void limparCampos() {
		txb_designacao.setRawValue(null);
		
		btn_gravar.setVisible(true);
		btn_actualizar.setVisible(false);
		listar();
	}
	
   	public void onClick$btn_gravar(Event e) throws InterruptedException{

   		TipoCliente tipoCliente = new TipoCliente();
   	    
   		tipoCliente.setDesignacao(txb_designacao.getValue());  		           	    
   		_tipoClienteService.create(tipoCliente);
   		showNotifications("Tipo de Cliente registado com sucesso!", "info");
   		limparCampos();
   	}
   	
   	
   	public void showNotifications(String message, String type) {
   		Clients.showNotification(message, type, txb_designacao,"before_center", 4000, true);
   	}

}
