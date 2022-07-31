package application;

public class MasterPasswordConditions { // created a new class for the master password conditions (to check)
	
	
	

	public MasterPasswordConditions(String passwordInput) {
		
		boolean validPassword = true;  // will intially set validPassword as true unless then there's a problem w it
		
		int uppercaseCounter = 0; // to count uppercase letters
		
		int lowercaseCounter = 0; // to count all lowercase letters
		
		int specialChar = 0;  // to count all special characters
	
		
		if (passwordInput.length()<8) {  // make sure the password length is at least 8 
			validPassword = false;
			System.out.println("Your password is not long enough. Your password "
					+ "should have a length of at least 8 characters. You inputted:"+passwordInput.length() 
					+ " characters.");
		}
		
		
		for (char c: passwordInput.toCharArray()) {
			
			if (Character.isUpperCase(c)) {  // to count all uppercase letters
				uppercaseCounter = uppercaseCounter + 1;
			}
			
			if(Character.isLowerCase(c)) {  // to count all lowercase letters
				lowercaseCounter = lowercaseCounter + 1;
			}
			
			if(Character.isLetterOrDigit(c)) { // to count all special characters (not 100% sure if this works)
				specialChar = specialChar + 1;
			}
			
			
		}
		
		
		
		
		
		
		
	}

}
