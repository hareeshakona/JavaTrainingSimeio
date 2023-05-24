package com.simeio.fun;

public class AnonyClass {

	public static void main(String[] args) {

		IGames blockgames = new IGames() {

			@Override
			public void createApps() {
				System.out.println("Block games");
				
			}
			
			
		};
		
		blockgames.createApps();
		
		IGames boardgames = new IGames() {
			
			@Override
			public void createApps() {
				System.out.println("Board games");
				
			}
		};
		
		boardgames.createApps();
		
	}

}
