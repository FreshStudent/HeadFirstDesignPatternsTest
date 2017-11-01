package bookCode.ch4.part3;

import bookCode.ch4.part3.factorys.BeiJingPizzaFactory;
import bookCode.ch4.part3.factorys.GuangZhouPizzaFactory;
import bookCode.ch4.part3.factorys.ShenZhenPizzaFactory;
import bookCode.ch4.part3.stores.BeiJingPizzaStore;
import bookCode.ch4.part3.stores.GuangZhouPizzaStore;
import bookCode.ch4.part3.stores.ShenZhenPizzaStore;

public class PizzaMainRun {

	public static void main(String[] args) {
		
		//工厂
		GuangZhouPizzaFactory gzFactory = new GuangZhouPizzaFactory();
		ShenZhenPizzaFactory szFactory = new ShenZhenPizzaFactory();
		BeiJingPizzaFactory bjFactory = new BeiJingPizzaFactory();
		
		//销售Pizza的商店
		GuangZhouPizzaStore gzStore = new GuangZhouPizzaStore(gzFactory);
		ShenZhenPizzaStore szStore = new ShenZhenPizzaStore(szFactory);
		BeiJingPizzaStore bjStore = new BeiJingPizzaStore(bjFactory);
		
		//售卖芝士的Pizza
		gzStore.orderPizza("cheese");
		szStore.orderPizza("cheese");
		bjStore.orderPizza("cheese");
		
     }
}
