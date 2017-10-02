package workshop2.grade2;

import workshop2.grade2.model.Register;
import workshop2.grade2.view.View;

public class App {

	public static void main(String[] args) throws Exception {
		new View().start();
		Register r=new Register();
		
		
		System.out.println(r.getMemberList());
	}
}
