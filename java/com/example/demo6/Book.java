package com.example.demo6;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Book  implements Serializable{

	private String ISBN;
	private String title;
	private String category;
	private String supplier;
	private int cnt;



	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	private ArrayList<Date> dates;
	private ArrayList<Integer> purchasedAmount;
	
	private ArrayList<Date> purchasedDates; 
	private ArrayList<Integer> quantitiesPurchased;
	private double sellingPrice;
	private double originalPrice;
	private String author;
	private int stock=0;
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public double getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getStock() {
		return stock;
	}
	public void AddStock(int stock) {
		this.stock += stock;
	}
	public void RemoveStock(int stock) {
		this.stock -= stock;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void addDate(Date date) {
		this.dates.add(date);
	}
	public void setDates(ArrayList<Date> dates) {
		this.dates = dates;
	}
	public ArrayList<Date> getDates(){
		return dates;
	}
	public void addPurchasedDate(Date date) {
		this.purchasedDates.add(date);
	}


	Book(String ISBN, String title, String category, String supplier, double originalPrice, double sellingPrice,String author, int stock){
		this.setISBN(ISBN);
		this.setTitle(title);
		this.setCategory(category);
		this.setSupplier(supplier);
		this.setOriginalPrice(originalPrice);
		this.setSellingPrice(sellingPrice);
		this.setAuthor(author);
		this.AddStock(stock);
		dates = new ArrayList<>();
		purchasedDates = new ArrayList<>();
		quantitiesPurchased = new ArrayList<>();
		purchasedAmount = new ArrayList<>();
	}

//	another constructor for the manager


	Book(String ISBN){
		quantitiesPurchased = new ArrayList<>();
		dates = new ArrayList<>();
		purchasedDates = new ArrayList<>();
		purchasedAmount = new ArrayList<>();
		this.setISBN(ISBN);
	}



	public void setStock(int stock) {
		this.stock = stock;
	}
//	Book(String title,int stock){
//		this.setTitle(title);
//		this.setStock(stock);
//	}


	
	public void addQuantity(int quan) {
		this.purchasedAmount.add( quan );
	    
	}
	public void addQuantitiesPurchased(int quan) {
		this.quantitiesPurchased.add(quan);
	}

	


	public String getSoldDatesQuantitiesTotal() {

        String ans = "For \"" + this.title +"\" We have sold:\n";

		if (dates.isEmpty()) {
			return this.getTitle()+" has had no purchases\n";
		}

		Date today = new Date();

		for (int i=0;i<dates.size();i++) {
			ans = ans.concat(purchasedAmount.get(i) +" at "+dates.get(i)+"\n");
		}
		return ans;

	}


	public String getSoldDatesQuantitiesDay(){

		String ans = "For \"" + this.title +"\" We have sold in a day:\n";

		if (dates.isEmpty()) {
			return this.getTitle()+" has had no purchases\n";
		}

		Date today = new Date();

		for (int i=0;i<dates.size();i++) {

			if (dates.get(i).getYear() == today.getYear() && dates.get(i).getMonth() == today.getMonth() && dates.get(i).getDay() == today.getDay()) {
				ans = ans.concat(purchasedAmount.get(i) +" at "+dates.get(i)+"\n");
			}
		}
		return ans;


	}

     public String getSoldDatesQuantitiesMonth(){

		String ans = "For \"" + this.title +"\" We have sold in a month:\n";

		if (dates.isEmpty()) {
			return this.getTitle()+" has had no purchases\n";
		}

		Date today = new Date();

		for (int i=0;i<dates.size();i++) {
			if (dates.get(i).getYear() == today.getYear() && dates.get(i).getMonth() == today.getMonth()) {
				ans = ans.concat(purchasedAmount.get(i) +" at "+dates.get(i)+"\n");
			}
		}
		return ans;
	}


	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", title=" + title + ", category=" + category + ", supplier=" + supplier
				+ ", sellingPrice=" + sellingPrice
				+ ", originalPrice=" + originalPrice + ", author=" + author + ", stock=" + stock + "]";
	}




}
