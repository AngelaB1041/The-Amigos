import rxtxrobot.*;
public class RunEncodedMotor {
	public static void main(String[] args) 
	{ 
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object 
		r.setPort("COM5"); // Set port to COM3 
		r.connect(); 
		r.runEncodedMotor(RXTXRobot.MOTOR1, 255, 100); // Run motor 1 forward (speed of 255) for 100,000 ticks 
		// Program stops until the command above is completed 
		r.runEncodedMotor(RXTXRobot.MOTOR1, -255, 100); // Run motor 1 backward (speed of 255) for 100,000 ticks 
		r.close(); 
	} 
}
