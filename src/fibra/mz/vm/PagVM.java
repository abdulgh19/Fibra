package fibra.mz.vm;

import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zhtml.A;
import org.zkoss.zhtml.I;
import org.zkoss.zhtml.Li;
import org.zkoss.zhtml.Ol;
import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;


@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class PagVM extends AbstractCtrl {

	
	private static final long serialVersionUID = 1L;

	@Wire("#breadcrumb")
	private Ol breadcrumb;

	protected List<String> links;

	protected Div target;

	protected Ol ol;

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
	}

	public void drawnBreadcrumb(String icon, String title, List<String> subLinks) {

		if (breadcrumb != null)
			breadcrumb.getChildren().clear();

		Li li = new Li();
		li.setParent(breadcrumb);

		A a = new A();
		a.setDynamicProperty("href", "#");
		a.setParent(li);

		Text txt = new Text();
		txt.setValue(title);
		txt.setParent(a);

		I i = new I();
		i.setSclass(icon);
		i.setParent(a);

		for (String subLink : subLinks) {

			Li l = new Li();
			l.setParent(breadcrumb);

			Text text = new Text();
			text.setValue(subLink);
			text.setParent(l);

			if (subLink.equals(subLinks.get(subLinks.size() - 1))) {
				l.setSclass("active");
			}

		}

	}

	public List<String> getLinks() {
		return links;
	}

	public void setLinks(List<String> links) {
		this.links = links;
	}

}
