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

import org.springframework.format.annotation.DateTimeFormat;

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
	@JoinColumn(name = "email")
	private UserDetails userdetails;

	@Temporal(TemporalType.TIMESTAMP)
	private Date bookeedtime;

	@Column
	private boolean cancled;

	@Column
	private String descrp;
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fromDate;

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date toDate;
	@Column
	private String Updateby;

	public String getUpdateby() {
		return Updateby;
	}

	public void setUpdateby(String updateby) {
		Updateby = updateby;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

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

	public boolean getCancled() {
		return cancled;
	}

	public void setCancled(boolean cancled) {
		this.cancled = cancled;
	}

}
