import rxtxrobot.*;
public class BothMotors {
	public static void main(String[] args) 
	{ 
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object 
		r.setPort("COM5"); // Set port to COM2 
		r.connect(); 
		r.attachMotor(RXTXRobot.MOTOR1, 5);
		r.attachMotor(RXTXRobot.MOTOR2, 6);
		r.runMotor(RXTXRobot.MOTOR1, 200, RXTXRobot.MOTOR2, -188, 10000); // Run both motors forward indefinitely 
		//r.sleep(5000); // Pause execution for 5 seconds, but the motors keep running. 
		//r.runMotor(RXTXRobot.MOTOR1,0,RXTXRobot.MOTOR2,0,0); // Stop both motors 
		r.close(); 
	} 
}
