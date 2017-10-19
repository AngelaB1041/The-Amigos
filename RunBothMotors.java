import rxtxrobot.*; 
public class RunBothMotors {
	public static void main(String[] args) 
	{ 
		RXTXRobot r = new ArduinoUno(); // Create RXTXRobot object 
		r.setPort("COM5"); // Set port to COM2 
		r.connect(); 
		r.attachMotor(RXTXRobot.MOTOR1, 5);
		r.attachMotor(RXTXRobot.MOTOR2, 6);
		r.refreshDigitalPins();
		int reading = r.getDigitalPin(7).getValue();
		while(reading==0) {
		if (reading == 0 ) {
					r.runMotor(RXTXRobot.MOTOR1, 200, RXTXRobot.MOTOR2, -188, 0); // Run both motors forward indefinitely 
		} else {
			r.runMotor(RXTXRobot.MOTOR1,0,RXTXRobot.MOTOR2,0,0); // stops both motors	
		}
		}
	
		r.close(); 
	} 
}
