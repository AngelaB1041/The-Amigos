import rxtxrobot.*;
public class RunBothEncodedMotors {
	public static void main(String[] args) 
	{ 
		RXTXRobot r = new ArduinoUno(); // Create RXTXRobot object 
		r.setPort("COM5"); // Set port to COM2 
		r.connect(); 
		//We don't have to attach anything because these motors are 
		//attached by default 
		r.runEncodedMotor(RXTXRobot.MOTOR1, 255, 100, RXTXRobot.MOTOR2, 255, 100); // Run both motors forward, one for 100,000 ticks and one for 50,000 ticks. 
		r.close(); 
	} 
}
