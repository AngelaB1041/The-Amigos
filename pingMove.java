import rxtxrobot.*;

public class pingMove {
	public static void main(String[] args) {
		
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object 
		r.setPort("COM5"); // Set port to COM3 
		r.connect(); 
		r.runEncodedMotor(RXTXRobot.MOTOR1, 255, 100); // Run motor 1 forward (speed of 255) for 100,000 ticks 
		// Program stops until the command above is completed 
		r.runEncodedMotor(RXTXRobot.MOTOR2, -255, 100); // Run motor 1 backward (speed of 255) for 100,000 ticks 
		r.close(); 
		
		for (int x=0; x < 100; ++x) 
		{ 
			double dist = r.getPing(PING_PIN1);
		}  
		
		if(PING_PIN1 > 15 ) {
			r.runMotor(RXTXRobot.MOTOR1, 500, RXTXRobot.MOTOR2, 500, 0);
		} else {
			r.runMotor(RXTXRobot.MOTOR1,0,RXTXRobot.MOTOR2,0,0);
			r.leftTurn();// Stop both motors 
		}
		
		for (int x=0; x < 100; ++x) 
		{ 
			double dist = r.getPing(PING_PIN3);
		}  
		
		if(PING_PIN3 > 15 ) {
			r.runMotor(RXTXRobot.MOTOR1, 500, RXTXRobot.MOTOR2, 500, 0);
		} else {
			r.runMotor(RXTXRobot.MOTOR1,0,RXTXRobot.MOTOR2,0,0);
			r.rightTurn();// Stop both motors 
		}
	}

}
