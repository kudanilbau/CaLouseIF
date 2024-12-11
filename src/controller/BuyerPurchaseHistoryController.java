package controller;

import javafx.collections.ObservableMap;
import model.Item;
import model.Transaction;
import model.User;
import session.UserSession;

public class BuyerPurchaseHistoryController {
	
	public ObservableMap<Transaction, Item> getPurchaseHistory(){
		User user = UserSession.getInstance().getUser();
		
		return Transaction.ViewHistory(user.getUser_id());
	}

}
