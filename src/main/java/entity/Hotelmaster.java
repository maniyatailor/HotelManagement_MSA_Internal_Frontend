/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "hotelmaster")
@NamedQueries({
    @NamedQuery(name = "Hotelmaster.findAll", query = "SELECT h FROM Hotelmaster h"),
    @NamedQuery(name = "Hotelmaster.findByHotelid", query = "SELECT h FROM Hotelmaster h WHERE h.hotelid = :hotelid"),
    @NamedQuery(name = "Hotelmaster.findByHotelname", query = "SELECT h FROM Hotelmaster h WHERE h.hotelname = :hotelname"),
    @NamedQuery(name = "Hotelmaster.findByHoteltype", query = "SELECT h FROM Hotelmaster h WHERE h.hoteltype = :hoteltype"),
    @NamedQuery(name = "Hotelmaster.findByAddress", query = "SELECT h FROM Hotelmaster h WHERE h.address = :address"),
    @NamedQuery(name = "Hotelmaster.findByCity", query = "SELECT h FROM Hotelmaster h WHERE h.city = :city"),
    @NamedQuery(name = "Hotelmaster.findByTotalrooms", query = "SELECT h FROM Hotelmaster h WHERE h.totalrooms = :totalrooms"),
    @NamedQuery(name = "Hotelmaster.findByContactno", query = "SELECT h FROM Hotelmaster h WHERE h.contactno = :contactno")})
public class Hotelmaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hotelid")
    private Integer hotelid;
    @Basic(optional = false)
    @Column(name = "hotelname")
    private String hotelname;
    @Basic(optional = false)
    @Column(name = "hoteltype")
    private String hoteltype;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @Column(name = "totalrooms")
    private int totalrooms;
    @Basic(optional = false)
    @Column(name = "contactno")
    private int contactno;
    @JsonbTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotelid")
    private Collection<HotelRoom> hotelRoomCollection;

    public Hotelmaster() {
    }

    public Hotelmaster(Integer hotelid) {
        this.hotelid = hotelid;
    }

    public Hotelmaster(Integer hotelid, String hotelname, String hoteltype, String address, String city, int totalrooms, int contactno) {
        this.hotelid = hotelid;
        this.hotelname = hotelname;
        this.hoteltype = hoteltype;
        this.address = address;
        this.city = city;
        this.totalrooms = totalrooms;
        this.contactno = contactno;
    }

    public Integer getHotelid() {
        return hotelid;
    }

    public void setHotelid(Integer hotelid) {
        this.hotelid = hotelid;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getHoteltype() {
        return hoteltype;
    }

    public void setHoteltype(String hoteltype) {
        this.hoteltype = hoteltype;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTotalrooms() {
        return totalrooms;
    }

    public void setTotalrooms(int totalrooms) {
        this.totalrooms = totalrooms;
    }

    public int getContactno() {
        return contactno;
    }

    public void setContactno(int contactno) {
        this.contactno = contactno;
    }

    public Collection<HotelRoom> getHotelRoomCollection() {
        return hotelRoomCollection;
    }

    public void setHotelRoomCollection(Collection<HotelRoom> hotelRoomCollection) {
        this.hotelRoomCollection = hotelRoomCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hotelid != null ? hotelid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hotelmaster)) {
            return false;
        }
        Hotelmaster other = (Hotelmaster) object;
        if ((this.hotelid == null && other.hotelid != null) || (this.hotelid != null && !this.hotelid.equals(other.hotelid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Hotelmaster[ hotelid=" + hotelid + " ]";
    }
    
}
