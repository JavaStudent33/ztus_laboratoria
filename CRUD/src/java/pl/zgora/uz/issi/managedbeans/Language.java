package pl.zgora.uz.issi.managedbeans;

import java.io.Serializable;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class Language implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Locale lang;
    
    public Language() {
        lang = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
    }

    public Locale getLang() {
        return lang;
    }

    public void setLang(Locale lang) {
        this.lang = lang;
    }
    
    public void setLanguage(String language) {
        setLang(new Locale(language));
    }
}