package com.moviement.dto;

import java.util.Map;

import lombok.Data;

@Data
public class MovieSeat extends Dto {
	public String seat;
	public String movieTitle;
	public String nickName;
	public boolean enabledSeat;
	public float price;

	public MovieSeat(String seat, String movieTitle, String nickName, boolean enabledSeat,float price) {
		this.seat = seat;
		this.movieTitle = movieTitle;
		this.nickName = nickName;
		this.enabledSeat = enabledSeat;
		this.price = price;
	}

	public MovieSeat(Map<String, Object> row) {
		super(row);
		this.seat = (String) row.get("seat");
		this.movieTitle = (String) row.get("movieTitle");
		this.nickName = (String) row.get("nickName");
		this.enabledSeat = (boolean) row.get("enabledSeat");
		this.price = (float) row.get("price");
	}
}