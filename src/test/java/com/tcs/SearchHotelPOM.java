package com.tcs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPOM extends LibGlobal{
	public SearchHotelPOM() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "location")
	private WebElement dDnLocation;
	
	@FindBy(id = "hotels")
	private WebElement dDnHotel;
	
	@FindBy(id = "room_type")
	private WebElement dDnRoomType;
	
	@FindBy(id = "room_nos")
	private WebElement dDnRoom;
	
	@FindBy(id = "datepick_in")
	private WebElement txtDateIn;
	
	@FindBy(id = "datepick_out")
	private WebElement txtDateOut;
	
	@FindBy(id = "adult_room")
	private WebElement dDnAdult;
	
	@FindBy(id = "child_room")
	private WebElement dDnChild;
	
	@FindBy(id = "Submit")
	private WebElement btnSubmit;

	public WebElement getdDnLocation() {
		return dDnLocation;
	}

	public WebElement getdDnHotel() {
		return dDnHotel;
	}

	public WebElement getdDnRoomType() {
		return dDnRoomType;
	}

	public WebElement getdDnRoom() {
		return dDnRoom;
	}

	public WebElement getTxtDateIn() {
		return txtDateIn;
	}

	public WebElement getTxtDateOut() {
		return txtDateOut;
	}

	public WebElement getdDnAdult() {
		return dDnAdult;
	}

	public WebElement getdDnChild() {
		return dDnChild;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}
	private void searchHotel(String location, String hotel, String roomType, String roomNo, String dateIn,
			String dateOut, String adult, String child) {
		selectOptionsByText(getdDnLocation(), location);
		selectOptionsByText(getdDnHotel(), hotel);
		selectOptionsByText(getdDnRoomType(), roomType);
		selectOptionsByText(getdDnRoom(), roomNo);
		selectOptionsByText(getTxtDateIn(), dateIn);
		selectOptionsByText(getTxtDateOut(), dateOut);
		selectOptionsByText(getdDnAdult(), adult);
		selectOptionsByText(getdDnChild(), child);
		click(getBtnSubmit());	
	}	
}
