package pl.zgora.uz.issi.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "stanowiska")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StanowiskaEntity.findAll", query = "SELECT s FROM StanowiskaEntity s"),
    @NamedQuery(name = "StanowiskaEntity.findById", query = "SELECT s FROM StanowiskaEntity s WHERE s.id = :id"),
    @NamedQuery(name = "StanowiskaEntity.findByNazwa", query = "SELECT s FROM StanowiskaEntity s WHERE s.nazwa = :nazwa")})
public class StanowiskaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Short id;
    @Size(max = 100)
    @Column(name = "nazwa")
    private String nazwa;
    @OneToMany(mappedBy = "stanowisko")
    private Collection<PracownicyEntity> pracownicyEntityCollection;

    public StanowiskaEntity() {
    }

    public StanowiskaEntity(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @XmlTransient
    public Collection<PracownicyEntity> getPracownicyEntityCollection() {
        return pracownicyEntityCollection;
    }

    public void setPracownicyEntityCollection(Collection<PracownicyEntity> pracownicyEntityCollection) {
        this.pracownicyEntityCollection = pracownicyEntityCollection;
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
        if (!(object instanceof StanowiskaEntity)) {
            return false;
        }
        StanowiskaEntity other = (StanowiskaEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.zgora.uz.issi.entities.StanowiskaEntity[ id=" + id + " ]";
    }
    
}
