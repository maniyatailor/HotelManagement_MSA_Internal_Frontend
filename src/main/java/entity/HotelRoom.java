/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "hotel_room")
@NamedQueries({
    @NamedQuery(name = "HotelRoom.findAll", query = "SELECT h FROM HotelRoom h"),
    @NamedQuery(name = "HotelRoom.findByHrid", query = "SELECT h FROM HotelRoom h WHERE h.hrid = :hrid")})
public class HotelRoom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hrid")
    private Integer hrid;
    @JoinColumn(name = "hotelid", referencedColumnName = "hotelid")
    @ManyToOne(optional = false)
    private Hotelmaster hotelid;
    @JoinColumn(name = "roomtypeid", referencedColumnName = "roomtypeid")
    @ManyToOne(optional = false)
    private Roomtype roomtypeid;

    public HotelRoom() {
    }

    public HotelRoom(Integer hrid) {
        this.hrid = hrid;
    }

    public Integer getHrid() {
        return hrid;
    }

    public void setHrid(Integer hrid) {
        this.hrid = hrid;
    }

    public Hotelmaster getHotelid() {
        return hotelid;
    }

    public void setHotelid(Hotelmaster hotelid) {
        this.hotelid = hotelid;
    }

    public Roomtype getRoomtypeid() {
        return roomtypeid;
    }

    public void setRoomtypeid(Roomtype roomtypeid) {
        this.roomtypeid = roomtypeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hrid != null ? hrid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HotelRoom)) {
            return false;
        }
        HotelRoom other = (HotelRoom) object;
        if ((this.hrid == null && other.hrid != null) || (this.hrid != null && !this.hrid.equals(other.hrid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.HotelRoom[ hrid=" + hrid + " ]";
    }
    
}
