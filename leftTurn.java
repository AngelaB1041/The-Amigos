import rxtxrobot.*;

public class leftTurn {
	public static void main(String[] args) 
	{ 
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object 
		r.setPort("COM5"); // Set port to COM3 
		r.connect(); 
		r.runEncodedMotor(RXTXRobot.MOTOR2, 255, 100); // Run motor 1 forward (speed of 255) for 100,000 ticks 
		// Program stops until the command above is completed 
	
		r.close(); 
	} 
}