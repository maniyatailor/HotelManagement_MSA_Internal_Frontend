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
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "roomtype")
@NamedQueries({
    @NamedQuery(name = "Roomtype.findAll", query = "SELECT r FROM Roomtype r"),
    @NamedQuery(name = "Roomtype.findByRoomtypeid", query = "SELECT r FROM Roomtype r WHERE r.roomtypeid = :roomtypeid"),
    @NamedQuery(name = "Roomtype.findByRtname", query = "SELECT r FROM Roomtype r WHERE r.rtname = :rtname"),
    @NamedQuery(name = "Roomtype.findByCharge", query = "SELECT r FROM Roomtype r WHERE r.charge = :charge"),
    @NamedQuery(name = "Roomtype.findByAvailableRoom", query = "SELECT r FROM Roomtype r WHERE r.availableRoom = :availableRoom")})
public class Roomtype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "roomtypeid")
    private Integer roomtypeid;
    @Basic(optional = false)
    @Column(name = "rtname")
    private String rtname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "charge")
    private BigDecimal charge;
    @Basic(optional = false)
    @Column(name = "available_room")
    private int availableRoom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomtypeid")
    @JsonbTransient
    private Collection<HotelRoom> hotelRoomCollection;

    public Roomtype() {
    }

    public Roomtype(Integer roomtypeid) {
        this.roomtypeid = roomtypeid;
    }

    public Roomtype(Integer roomtypeid, String rtname, BigDecimal charge, int availableRoom) {
        this.roomtypeid = roomtypeid;
        this.rtname = rtname;
        this.charge = charge;
        this.availableRoom = availableRoom;
    }

    public Integer getRoomtypeid() {
        return roomtypeid;
    }

    public void setRoomtypeid(Integer roomtypeid) {
        this.roomtypeid = roomtypeid;
    }

    public String getRtname() {
        return rtname;
    }

    public void setRtname(String rtname) {
        this.rtname = rtname;
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    public int getAvailableRoom() {
        return availableRoom;
    }

    public void setAvailableRoom(int availableRoom) {
        this.availableRoom = availableRoom;
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
        hash += (roomtypeid != null ? roomtypeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roomtype)) {
            return false;
        }
        Roomtype other = (Roomtype) object;
        if ((this.roomtypeid == null && other.roomtypeid != null) || (this.roomtypeid != null && !this.roomtypeid.equals(other.roomtypeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Roomtype[ roomtypeid=" + roomtypeid + " ]";
    }
    
}
