package org.parking;

import java.time.LocalDateTime;

import org.parking.model.Fine;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Document(collection = "fines")
@EqualsAndHashCode
@Getter
@ToString
public class FineDoc {

	long ownerID;
	String ownerName;
	long carID;
	String parkingPlace;
	LocalDateTime dateTime;
	float amountOfFine;
	String status;
	
	private FineDoc(long ownerID, String ownerName, long carID, String parkingPlace, LocalDateTime dateTime,
			float amountOfFine, String status) {
		this.ownerID = ownerID;
		this.ownerName = ownerName;
		this.carID = carID;
		this.parkingPlace = parkingPlace;
		this.dateTime = dateTime;
		this.amountOfFine = amountOfFine;
		this.status = status;
	}
	
	public static FineDoc of(Fine fine) {
		return new FineDoc(fine.ownerID, fine.ownerName, fine.carID, fine.parkingPlace,
				fine.dateTime, fine.amountOfFine, fine.status.name());
	}
	
	
}
