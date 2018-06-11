package com.my.modle;

public class FundTransfer {

	private String DebitAcc;
	private String CreditAcc;
	private double DebitAccBalance;
	private double CreditAccBalanace;
	private double DebitAccNewBalance;
	private double CreditAccNewBalance;
	private double transferAmount;
	private String transIDcr;
	private String transIDDr;

	
	public String getDebitAcc() {
		return DebitAcc;
	}
	public void setDebitAcc(String debitAcc) {
		DebitAcc = debitAcc;
	}
	public String getCreditAcc() {
		return CreditAcc;
	}
	public void setCreditAcc(String creditAcc) {
		CreditAcc = creditAcc;
	}
	public double getDebitAccBalance() {
		return DebitAccBalance;
	}
	public void setDebitAccBalance(double debitAccBalance) {
		DebitAccBalance = debitAccBalance;
	}
	public double getCreditAccBalanace() {
		return CreditAccBalanace;
	}
	public void setCreditAccBalanace(double creditAccBalanace) {
		CreditAccBalanace = creditAccBalanace;
	}
	public double getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}
	public double getDebitAccNewBalance() {
		return DebitAccNewBalance;
	}
	public void setDebitAccNewBalance(double debitAccNewBalance) {
		DebitAccNewBalance = debitAccNewBalance;
	}
	public double getCreditAccNewBalance() {
		return CreditAccNewBalance;
	}
	public void setCreditAccNewBalance(double creditAccNewBalance) {
		CreditAccNewBalance = creditAccNewBalance;
	}
	public String getTransIDcr() {
		return transIDcr;
	}
	public void setTransIDcr(String transID) {
		this.transIDcr = transID;
	}
	public String getTransIDDr() {
		return transIDDr;
	}
	public void setTransIDDr(String transIDDr) {
		this.transIDDr = transIDDr;
	}
	
	
	
}

