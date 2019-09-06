package fibra.mz.vm;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.util.GenericForwardComposer;

@SuppressWarnings("rawtypes")
public class AbstractCtrl extends GenericForwardComposer {

	private static final long serialVersionUID = 1L;




	private Locale pt = new Locale("pt", "pt");

	SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd", pt);

	@SuppressWarnings("unchecked")
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		Selectors.wireComponents(comp, this, false);

	}

	@SuppressWarnings("unchecked")
	public void doBeforeComposeChildren(Component comp) throws Exception {
		super.doBeforeComposeChildren(comp);
		
	

	}

}
