import rxtxrobot.*; 
public class MoveServo {
	public static void main(String[] args) 
	{ 
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object 
		r.setPort("COM5"); // Set the port to COM3 
		r.setVerbose(true); // Turn on debugging messages 
		r.connect(); 
		r.attachServo(RXTXRobot.SERVO1, 11); //Connect the servos to the Arduino 
		r.moveServo(RXTXRobot.SERVO1, 160 ); // Move Servo 1 to location 30 
		r.sleep(5000);
		r.close(); 
	}
}
