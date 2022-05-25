package com.cap.hotelMangement.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "bookingdetails")
public class BookingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;

	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hotelRoomDetails_id")
	private HotelRoomDetails hotelRoomDetails;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userdetails_id")
	private UserDetails userdetails;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date bookeedtime;
	
	@Column
	private boolean isCancled;
	
	@Column
	private String descrp;

	public String getDescrp() {
		return descrp;
	}

	public void setDescrp(String descrp) {
		this.descrp = descrp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HotelRoomDetails getHotelRoomDetails() {
		return hotelRoomDetails;
	}

	public void setHotelRoomDetails(HotelRoomDetails hotelRoomDetails) {
		this.hotelRoomDetails = hotelRoomDetails;
	}

	public UserDetails getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserDetails userdetails) {
		this.userdetails = userdetails;
	}

	public Date getBookeedtime() {
		return bookeedtime;
	}

	public void setBookeedtime(Date bookeedtime) {
		this.bookeedtime = bookeedtime;
	}

	public boolean isCancled() {
		return isCancled;
	}

	public void setCancled(boolean isCancled) {
		this.isCancled = isCancled;
	}

	
	
}
