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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Michele Milidoni <michelemilidoni@gmail.com>
 */
@Entity
@Table(name = "country_name", 
        schema = "", uniqueConstraints = {
            @UniqueConstraint(columnNames = {"code2l", "language"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CountryName.findAll", query = "SELECT c FROM CountryName c"),
    @NamedQuery(name = "CountryName.findById", query = "SELECT c FROM CountryName c WHERE c.id = :id"),
    @NamedQuery(name = "CountryName.findByCode2l", query = "SELECT c FROM CountryName c WHERE c.code2l = :code2l"),
    @NamedQuery(name = "CountryName.findByLanguage", query = "SELECT c FROM CountryName c WHERE c.language = :language"),
    @NamedQuery(name = "CountryName.findByName", query = "SELECT c FROM CountryName c WHERE c.name = :name"),
    @NamedQuery(name = "CountryName.findByNameOfficial", query = "SELECT c FROM CountryName c WHERE c.nameOfficial = :nameOfficial"),
    @NamedQuery(name = "CountryName.findBySource", query = "SELECT c FROM CountryName c WHERE c.source = :source")})
public class CountryName implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    private String code2l;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    private String language;
    @Size(max = 255)
    private String name;
    @Size(max = 255)
    @Column(name = "name_official")
    private String nameOfficial;
    @Size(max = 255)
    private String source;
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Country countryId;

    public CountryName() {
    }

    public CountryName(Integer id) {
        this.id = id;
    }

    public CountryName(Integer id, String code2l, String language) {
        this.id = id;
        this.code2l = code2l;
        this.language = language;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode2l() {
        return code2l;
    }

    public void setCode2l(String code2l) {
        this.code2l = code2l;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
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
        if (!(object instanceof CountryName)) {
            return false;
        }
        CountryName other = (CountryName) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.milidoni.wespeak_online.entity.CountryName[ id=" + id + " ]";
    }

}
