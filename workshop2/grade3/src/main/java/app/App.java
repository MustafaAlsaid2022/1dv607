package app;


import model.Register;
import view.View;

public class App {

	public static void main(String[] args) throws Exception {
		new View().start();
		Register r=new Register();
		
		
		System.out.println(r.getMemberList());
	}
}
