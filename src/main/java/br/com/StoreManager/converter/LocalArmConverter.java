package br.com.StoreManager.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.StoreManager.model.LocalArmazenamento;
import br.com.StoreManager.persistence.LocalArmDAOImp;

@FacesConverter("LocalArmConverter")
public class LocalArmConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String descricao) {
		LocalArmDAOImp dao = new LocalArmDAOImp();
		return dao.buscarLocalArmDescricao(descricao);
	}
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object localArm) {
		return ((LocalArmazenamento) localArm).getDescricao();
	}

}
