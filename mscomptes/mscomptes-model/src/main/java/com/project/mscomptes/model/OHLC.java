package com.project.mscomptes.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.project.mscomptes.technical.TechnicalConstants;

public class OHLC {
	
	private String isin;
	
	private Date date;
	
	private Double openPrice;
	
	private Double highPrice;
	
	private Double lowPrice;
	
	private Double closePrice;

	public OHLC(String isin) {
		super();
		this.isin = isin;
	}

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public Date getDate() {
		return date;
	}
	
	public String getFormattedDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
		return dateFormat.format(date);
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setDate(long timestamp) {
		this.date = new Date(timestamp*1000);
	}

	public Double getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(Double openPrice) {
		this.openPrice = openPrice;
	}

	public Double getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(Double highPrice) {
		this.highPrice = highPrice;
	}

	public Double getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(Double lowPrice) {
		this.lowPrice = lowPrice;
	}

	public Double getClosePrice() {
		return closePrice;
	}

	public void setClosePrice(Double closePrice) {
		this.closePrice = closePrice;
	}
	
	@Override
	public String toString() {
		return isin + TechnicalConstants.CSV_SEPARATOR + 
				getFormattedDate() + TechnicalConstants.CSV_SEPARATOR +
				openPrice + TechnicalConstants.CSV_SEPARATOR +
				lowPrice + TechnicalConstants.CSV_SEPARATOR +
				highPrice + TechnicalConstants.CSV_SEPARATOR +
				closePrice + TechnicalConstants.CSV_SEPARATOR;
	}

}
