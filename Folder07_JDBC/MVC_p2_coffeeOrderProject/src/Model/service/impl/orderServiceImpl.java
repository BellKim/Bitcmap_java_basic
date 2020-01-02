package Model.service.impl;

import java.util.List;

import Controller.dto.orderList;
import Model.dao.orderDao;
import Model.dao.impl.orderDaoImpl;
import Model.service.orderService;

public class orderServiceImpl implements orderService{
	orderDao ordardao = new orderDaoImpl();
	
	
	@Override
	public List<orderList> getNameToPrice(List<orderList> list) {
		int sizeToInt = 1;
		String coffeeName ="";
		for (int j = 0; j < list.size(); j++) {
			if(list.get(j).getSize().equals("Short")) {
				sizeToInt = 1;
			} else if(list.get(j).getSize().equals("Tall")) {
				sizeToInt = 2;
			} else if(list.get(j).getSize().equals("Grande")) {
				sizeToInt = 3;
			}
			coffeeName = list.get(j).getName();
//			int input = orderDao.receiveCoffeeNo(list);
//			list.get(j).setNameNumber();
			
//			ordardao.getPrice(coffeeName, sizeToInt);
		}
		 
		
		return null;
	}//end getNameToPrice


	@Override
	public void insertOrderList(List<orderList> list, String userInfo) {
		//카페 매뉴명 에 숫자 불러오기. 
		List<orderList> ol =  ordardao.callMenuNumber(list);
		
		System.out.println("insertOrderList \n 리스트 출력 합니다 = " + ol.toString() + " \n ");
		
		ordardao.insertOrderList(ol,userInfo);
		
	}

	

}//end class
