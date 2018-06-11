package com.my.modle;

public class BillPay {

	private String DebitAcc;
	private String BillAcc;
	private double DebitAccBalance;
	private double BillAccBalanace;
	private double DebitAccNewBalance;
	private double BillAccNewBalance;
	private double transferAmount;
	private String transIDBill;
	private String transIDDr;
	public String getDebitAcc() {
		return DebitAcc;
	}
	public void setDebitAcc(String debitAcc) {
		DebitAcc = debitAcc;
	}
	public String getBillAcc() {
		return BillAcc;
	}
	public void setBillAcc(String billAcc) {
		BillAcc = billAcc;
	}
	public double getDebitAccBalance() {
		return DebitAccBalance;
	}
	public void setDebitAccBalance(double debitAccBalance) {
		DebitAccBalance = debitAccBalance;
	}
	public double getBillAccBalanace() {
		return BillAccBalanace;
	}
	public void setBillAccBalanace(double billAccBalanace) {
		BillAccBalanace = billAccBalanace;
	}
	public double getDebitAccNewBalance() {
		return DebitAccNewBalance;
	}
	public void setDebitAccNewBalance(double debitAccNewBalance) {
		DebitAccNewBalance = debitAccNewBalance;
	}
	public double getBillAccNewBalance() {
		return BillAccNewBalance;
	}
	public void setBillAccNewBalance(double billAccNewBalance) {
		BillAccNewBalance = billAccNewBalance;
	}
	public double getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}
	public String getTransIDBill() {
		return transIDBill;
	}
	public void setTransIDBill(String transIDBill) {
		this.transIDBill = transIDBill;
	}
	public String getTransIDDr() {
		return transIDDr;
	}
	public void setTransIDDr(String transIDDr) {
		this.transIDDr = transIDDr;
	}
}//end of the file
