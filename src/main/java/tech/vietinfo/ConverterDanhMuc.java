package tech.vietinfo;

import tech.vietinfo.models.DanhMuc;
import tech.vietinfo.services.DanhMucService;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@FacesConverter(value = "converterDanhMuc", managed = true)
public class ConverterDanhMuc implements Converter<DanhMuc> {

    @Inject
    private DanhMucService danhMucService;


    @Override
    public DanhMuc getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                return danhMucService.getDanhMucsAsMap().get(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid country."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, DanhMuc value) {
        return null;
    }
}
