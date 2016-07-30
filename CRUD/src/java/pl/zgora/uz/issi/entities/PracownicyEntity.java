package pl.zgora.uz.issi.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "pracownicy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PracownicyEntity.findAll", query = "SELECT p FROM PracownicyEntity p"),
    @NamedQuery(name = "PracownicyEntity.findById", query = "SELECT p FROM PracownicyEntity p WHERE p.id = :id"),
    @NamedQuery(name = "PracownicyEntity.findByLogin", query = "SELECT p FROM PracownicyEntity p WHERE p.login = :login"),
    @NamedQuery(name = "PracownicyEntity.findByHaslo", query = "SELECT p FROM PracownicyEntity p WHERE p.haslo = :haslo"),
    @NamedQuery(name = "PracownicyEntity.findByTelefon", query = "SELECT p FROM PracownicyEntity p WHERE p.telefon = :telefon"),
    @NamedQuery(name = "PracownicyEntity.findByMiejscowosc", query = "SELECT p FROM PracownicyEntity p WHERE p.miejscowosc = :miejscowosc"),
    @NamedQuery(name = "PracownicyEntity.findByImie", query = "SELECT p FROM PracownicyEntity p WHERE p.imie = :imie"),
    @NamedQuery(name = "PracownicyEntity.findByNazwisko", query = "SELECT p FROM PracownicyEntity p WHERE p.nazwisko = :nazwisko"),
    @NamedQuery(name = "PracownicyEntity.findByZdjecie", query = "SELECT p FROM PracownicyEntity p WHERE p.zdjecie = :zdjecie")})
public class PracownicyEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Short id;
    @Size(max = 32)
    @Column(name = "login")
    private String login;
    @Size(max = 32)
    @Column(name = "haslo")
    private String haslo;
    @Size(max = 20)
    @Column(name = "telefon")
    private String telefon;
    @Size(max = 100)
    @Column(name = "miejscowosc")
    private String miejscowosc;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "imie")
    private String imie;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "nazwisko")
    private String nazwisko;
    @Basic(optional = false)
    @Column(name = "zdjecie")
    private boolean zdjecie;
    @JoinColumn(name = "departament", referencedColumnName = "id")
    @ManyToOne
    private DepartamentyEntity departament;
    @JoinColumn(name = "stanowisko", referencedColumnName = "id")
    @ManyToOne
    private StanowiskaEntity stanowisko;

    public PracownicyEntity() {
    }

    public PracownicyEntity(Short id) {
        this.id = id;
    }

    public PracownicyEntity(Short id, String imie, String nazwisko, boolean zdjecie) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.zdjecie = zdjecie;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        MessageDigest messageDigest;
        
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(haslo.getBytes(), 0, haslo.length());
            this.haslo = new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            Logger.getLogger(PracownicyEntity.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public boolean getZdjecie() {
        return zdjecie;
    }

    public void setZdjecie(boolean zdjecie) {
        this.zdjecie = zdjecie;
    }

    public DepartamentyEntity getDepartament() {
        return departament;
    }

    public void setDepartament(DepartamentyEntity departament) {
        this.departament = departament;
    }

    public StanowiskaEntity getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(StanowiskaEntity stanowisko) {
        this.stanowisko = stanowisko;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PracownicyEntity)) {
            return false;
        }
        PracownicyEntity other = (PracownicyEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.zgora.uz.issi.entities.PracownicyEntity[ id=" + id + " ]";
    }
    
}
