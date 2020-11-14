package com.wuhanbus.control;

import java.util.ArrayList;
import java.util.List;

import com.wuhanbus.dao.BaseDao;
import com.wuhanbus.dao.CommonCardDao;
import com.wuhanbus.dao.OldCardDao;
import com.wuhanbus.entity.Card;

public class CardManager {
	public static List<BaseDao> daos=new ArrayList<BaseDao>();
	public static List<Card> cards=new ArrayList<Card>();
	
	public static void Init(){
		daos.add(new CommonCardDao());
		daos.add(new OldCardDao());
		for(BaseDao dao:daos){
			List<Card> tempCards=dao.getAllCards();
			for(Card tempCard:tempCards){
				cards.add(tempCard);
			}
		}
	}
}
