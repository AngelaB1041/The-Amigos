import rxtxrobot.*;
public class ActualSprint3 {
	final private static int PING_PIN = 11;
	public static void main(String[] args) 
	{ 
		RXTXRobot r = new ArduinoNano();  
		r.setPort("/dev/tty.usbmodem1421"); 
		r.connect(); 
		r.attachMotor(RXTXRobot.MOTOR1, 5);
		r.attachMotor(RXTXRobot.MOTOR2, 6);
		
		r.runMotor(RXTXRobot.MOTOR2, -175, RXTXRobot.MOTOR1, 175, 3700); // leave the start box
		r.sleep(1000);
		r.runMotor(RXTXRobot.MOTOR1, 230, 3900); //turn right 
		r.sleep(1000);
		r.runMotor(RXTXRobot.MOTOR1, 250, RXTXRobot.MOTOR2, -250, 3900); // move forward, stop in front of the ramp 
		
			
			double dist = 0;
			boolean reading=true;
			
			// Find barrier
			while(reading==true) {
				
				// Get distance measurement
				dist = r.getPing(PING_PIN);			
				System.out.println("The reading was" + dist);
				System.out.println();
				

				if(dist >= 5) // No barrier
				{
					// Going forward
					r.runMotor(RXTXRobot.MOTOR1, 245, RXTXRobot.MOTOR2, -260, 3000);
					dist = r.getPing(PING_PIN);
					System.out.printf("%f cm\n", dist);
					reading = false;
				}
				else //barrier
				{ 
					r.runMotor(RXTXRobot.MOTOR1, 0, RXTXRobot.MOTOR2, 0, 0);
					break;
				}
				//break;
			}
		
		r.attachServo(RXTXRobot.SERVO1, 4); //Connect the servos to the Arduino 
		r.moveServo(RXTXRobot.SERVO1, 135); // Move Servo 1 to location 30 
		r.sleep(6500);
		r.moveServo(RXTXRobot.SERVO1, 90);
		
		int thermistorReading = getThermistorReading(r);
		int thermistor2Reading = getSecondThermistorReading(r);
		
		double temp = (thermistorReading - 722.6367802)/ -4.927753169;
		
		//Print the results
		System.out.println("The probe reads the value: " + thermistorReading);
		System.out.println("In volts: " + (thermistorReading * (5.0/1023.0)));
		System.out.println("Temperature = " + temp);
		
		r.close();
		
		double temp2 = 24.0;
				
		
		//Print the results
		System.out.println("The probe reads the value: " + thermistor2Reading);
		System.out.println("In volts: " + (thermistor2Reading * (5.0/1023.0)));
		System.out.println("Temperature = 24");
		
		double windSpeed = temp - temp2;
		
		System.out.println("Wind speed = " + windSpeed);
		
		r.moveServo(RXTXRobot.SERVO1, 90);
		r.runMotor(RXTXRobot.MOTOR2, -250, 2300);
		r.sleep(1000);
		r.runMotor(RXTXRobot.MOTOR1, 200, RXTXRobot.MOTOR2, -200, 2000);
		
		r.close();
	}
	
	public static int getThermistorReading(RXTXRobot r) {
		
		int sum = 0;
		int readingCount = 10;
		
		//Read the analog pin values ten times, adding to sum each time
		for (int i = 0; i < readingCount; i++) {
			
			//Refresh the analog pins so we get new readings
			r.refreshAnalogPins();
			int reading = r.getAnalogPin(0).getValue();
			sum += reading;
		}
		
		return sum / readingCount;
		
	}
	
	public static int getSecondThermistorReading(RXTXRobot r) {
		
		int sum2 = 0;
		int readingCount2 = 10;
		
		//Read the analog pin values ten times, adding to sum each time
		for (int i = 0; i < readingCount2; i++) {
			
			//Refresh the analog pins so we get new readings
			r.refreshAnalogPins();
			int reading = r.getAnalogPin(0).getValue();
			sum2 += reading;
		}
		
		//Return the average reading
		return sum2 / readingCount2;
		
	
		
	}
		
		
	}
