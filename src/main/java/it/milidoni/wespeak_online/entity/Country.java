/*
 * Copyright 2017 Michele Milidoni <michelemilidoni@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.milidoni.wespeak_online.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Michele Milidoni <michelemilidoni@gmail.com>
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"}),
    @UniqueConstraint(columnNames = {"code2l"}),
    @UniqueConstraint(columnNames = {"code3l"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c"),
    @NamedQuery(name = "Country.findById", query = "SELECT c FROM Country c WHERE c.id = :id"),
    @NamedQuery(name = "Country.findByEnabled", query = "SELECT c FROM Country c WHERE c.enabled = :enabled"),
    @NamedQuery(name = "Country.findByCode3l", query = "SELECT c FROM Country c WHERE c.code3l = :code3l"),
    @NamedQuery(name = "Country.findByCode2l", query = "SELECT c FROM Country c WHERE c.code2l = :code2l"),
    @NamedQuery(name = "Country.findByName", query = "SELECT c FROM Country c WHERE c.name = :name"),
    @NamedQuery(name = "Country.findByNameOfficial", query = "SELECT c FROM Country c WHERE c.nameOfficial = :nameOfficial"),
    @NamedQuery(name = "Country.findByFlag32", query = "SELECT c FROM Country c WHERE c.flag32 = :flag32"),
    @NamedQuery(name = "Country.findByFlag128", query = "SELECT c FROM Country c WHERE c.flag128 = :flag128"),
    @NamedQuery(name = "Country.findByLatitude", query = "SELECT c FROM Country c WHERE c.latitude = :latitude"),
    @NamedQuery(name = "Country.findByLongitude", query = "SELECT c FROM Country c WHERE c.longitude = :longitude"),
    @NamedQuery(name = "Country.findByZoom", query = "SELECT c FROM Country c WHERE c.zoom = :zoom")})
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean enabled;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(nullable = false, length = 3)
    private String code3l;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(nullable = false, length = 2)
    private String code2l;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(nullable = false, length = 64)
    private String name;
    @Size(max = 128)
    @Column(name = "name_official", length = 128)
    private String nameOfficial;
    @Size(max = 255)
    @Column(name = "flag_32", length = 255)
    private String flag32;
    @Size(max = 255)
    @Column(name = "flag_128", length = 255)
    private String flag128;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 10, scale = 8)
    private BigDecimal latitude;
    @Column(precision = 11, scale = 8)
    private BigDecimal longitude;
    private Boolean zoom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryId")
    private List<CountryName> countryNameList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryId")
    private List<CountryRegion> countryRegionList;

    public Country() {
    }

    public Country(Integer id) {
        this.id = id;
    }

    public Country(Integer id, boolean enabled, String code3l, String code2l, String name) {
        this.id = id;
        this.enabled = enabled;
        this.code3l = code3l;
        this.code2l = code2l;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getCode3l() {
        return code3l;
    }

    public void setCode3l(String code3l) {
        this.code3l = code3l;
    }

    public String getCode2l() {
        return code2l;
    }

    public void setCode2l(String code2l) {
        this.code2l = code2l;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameOfficial() {
        return nameOfficial;
    }

    public void setNameOfficial(String nameOfficial) {
        this.nameOfficial = nameOfficial;
    }

    public String getFlag32() {
        return flag32;
    }

    public void setFlag32(String flag32) {
        this.flag32 = flag32;
    }

    public String getFlag128() {
        return flag128;
    }

    public void setFlag128(String flag128) {
        this.flag128 = flag128;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Boolean getZoom() {
        return zoom;
    }

    public void setZoom(Boolean zoom) {
        this.zoom = zoom;
    }

    @XmlTransient
    public List<CountryName> getCountryNameList() {
        return countryNameList;
    }

    public void setCountryNameList(List<CountryName> countryNameList) {
        this.countryNameList = countryNameList;
    }

    @XmlTransient
    public List<CountryRegion> getCountryRegionList() {
        return countryRegionList;
    }

    public void setCountryRegionList(List<CountryRegion> countryRegionList) {
        this.countryRegionList = countryRegionList;
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
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.milidoni.wespeak_online.entity.Country[ id=" + id + " ]";
    }
    
}
