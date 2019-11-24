package day10.View;

import java.util.ArrayList;
import java.util.Scanner;

import day10.AirplaneController.AirplaneController;
import day10.AirplaneController.CityController;
import day10.AirplaneController.MemberController;
import day10.AirplaneController.ResvController;
import day10.AirplaneDTO.AirplaneDTO;
import day10.AirplaneDTO.CityDTO;

public class TravelMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ResvController resvController=new ResvController();
		AirplaneController airplaneController = new AirplaneController();
		CityController cityController = new CityController();
		MemberController memberController = new MemberController();
		
		for(AirplaneDTO a : airplaneController.selectAll()) {
			CityDTO c = cityController.selectOne(a.getStartCityId());
			CityDTO c2 = cityController.selectOne(a.getEndCityId());
			System.out.println(a.getId() + " "+c.getCityName() + " " +
					c2.getCityName()+ " "+a.getDepartTime());
		}
		
		
				
		
		
		
		scan.close();
	}


}