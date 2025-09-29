package com.jsp.onlineUtilityBillPayment.DTO;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bills")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long billId;
	private double amount;
	private LocalDate duedate;
	
	@Enumerated(EnumType.STRING)
	private UtilityType utilitytype;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentstatus;
	
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToOne(mappedBy = "bill",cascade = CascadeType.ALL)//means when we do payment it will also reflect to bill
	private Payment payment;
	
	
	public long getBillId() {
		return billId;
	}

	public void setBillId(long billId) {
		this.billId = billId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDuedate() {
		return duedate;
	}

	public void setDuedate(LocalDate duedate) {
		this.duedate = duedate;
	}

	public UtilityType getUtilitytype() {
		return utilitytype;
	}

	public void setUtilitytype(UtilityType utilitytype) {
		this.utilitytype = utilitytype;
	}

	public PaymentStatus getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(PaymentStatus paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
	
	
	
}
