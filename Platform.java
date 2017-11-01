import rxtxrobot.*;

public class Platform {
	public static void main(String[] args) 
	{ 
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object 
		r.setPort("COM5"); // Set the port to COM3 
		r.setVerbose(true); // Turn on debugging messages 
		r.connect(); 
		r.attachServo(RXTXRobot.SERVO1, 11); //Connect the servos to the Arduino 
		r.moveServo(RXTXRobot.SERVO1, ??? ); // Move Servo 1 to location 30 
		//r.sleep(5000);
		
		
		
		int thermistorReading = getThermistorReading(r);
		
		double temp = (thermistorReading - 722.6367802)/ -4.927753169;
		
		//Print the results
		System.out.println("The probe reads the value: " + thermistorReading);
		System.out.println("In volts: " + (thermistorReading * (5.0/1023.0)));
		System.out.println("Temperature = " + temp);
		
	}
	
	public static int getThermistorReading(RXTXRobot robot) {
		
		int sum = 0;
		int readingCount = 10;
		
		//Read the analog pin values ten times, adding to sum each time
		for (int i = 0; i < readingCount; i++) {
			
			//Refresh the analog pins so we get new readings
			robot.refreshAnalogPins();
			int reading = robot.getAnalogPin(0).getValue();
			sum += reading;
		}
		
		//Return the average reading
		return sum / readingCount;
		
	}
	
	r.moveServo(RXTXRobot.SERVO1, ???);

}
