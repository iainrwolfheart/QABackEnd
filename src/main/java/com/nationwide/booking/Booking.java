package com.nationwide.booking;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "bookings")
public class Booking {

    @Id
    private String id;
    private String firstName;
    private String lastName;
	private String email;
    private String showingId;
	private String[] seatIds;
    private double totalPrice;
    private boolean paid;
    private boolean cancelled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getShowingId() {
        return showingId;
    }

    public void setShowingId(String showingId) {
        this.showingId = showingId;
    }

    public String[] getSeatIds() {
        return seatIds;
    }

    public void setSeatIds(String[] seatIds) {
        this.seatIds = seatIds;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
	}
	
	public Booking() {}

    public Booking(String firstName, String lastName, String email, String showingId, String[] seatIds, double totalPrice,
            boolean paid, boolean cancelled) {
        this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
        this.showingId = showingId;
        this.seatIds = seatIds;
        this.totalPrice = totalPrice;
		this.paid = paid;
		this.cancelled = cancelled;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}
}