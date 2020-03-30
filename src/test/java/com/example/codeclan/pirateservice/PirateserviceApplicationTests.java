package com.example.codeclan.pirateservice;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.models.Ship;
import com.example.codeclan.pirateservice.repositories.PirateRepository;
import com.example.codeclan.pirateservice.repositories.RaidRepository;
import com.example.codeclan.pirateservice.repositories.ShipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PirateserviceApplicationTests {

	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createPirateAndShip(){
		Ship ship = new Ship("The Flying Dutchman");
		Pirate jack = new Pirate("Jack", "Sparrow", 32, ship);
		Raid raid = new Raid("Glasgow", 50);
		shipRepository.save(ship);
		pirateRepository.save(jack);
		raidRepository.save(raid);

		jack.addRaidToPirate(raid);
		raid.addPirateToRaid(jack);

		pirateRepository.save(jack);
		raidRepository.save(raid);
	}



}
