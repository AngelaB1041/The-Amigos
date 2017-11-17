import rxtxrobot.*;
public class Sprint4Right {
	final private static int PING_PIN1 = 11;
	final private static int PING_PIN2 = 10;
	
	public static void main(String[] args) 
	{ 
		RXTXRobot r = new ArduinoUno();  
		r.setPort("/dev/tty.usbmodem179"); 
		r.connect(); 
		r.attachMotor(RXTXRobot.MOTOR1, 7);// left motor changed from 5 to 7 bc not working
		r.attachMotor(RXTXRobot.MOTOR2, 6);
		
		r.runMotor(RXTXRobot.MOTOR2, -250, RXTXRobot.MOTOR1, 250, 1200); // leave the start box
		r.sleep(1000);
		r.runMotor(RXTXRobot.MOTOR2, -260, RXTXRobot.MOTOR1, -245, 2800); //turn left 
		r.sleep(1000);
		
		r.refreshDigitalPins();
		double dist = 0;
		boolean reading = true;
		
		//find barrier
		while(reading == true) 
		{
			//get distance measurement
			dist = r.getPing(PING_PIN1);
			System.out.println("The reading was " + dist);
			System.out.println();
			
			if (dist >= 40)
			{
				//going forward
				r.runMotor(RXTXRobot.MOTOR1, 225, RXTXRobot.MOTOR2, -260, 2500);
				dist = r.getPing(PING_PIN1);
				System.out.printf("%f cm/n", dist);
				reading = true;
			}
			else //barrier
			{
				r.runMotor(RXTXRobot.MOTOR1, 0, RXTXRobot.MOTOR2, 0, 0);
				reading = false;
			}
			
		}
		
		r.refreshDigitalPins();
		double dist2 = 0;
		boolean reading2 = true;
		
		//go over ramp
		while(reading2 == true) 
		{
			//get distance measurement
				dist2 = r.getPing(PING_PIN1);
				System.out.println("The reading was " + dist2);
				System.out.println();
				
				if (dist2 <= 40)
				{
					//going forward
					r.runMotor(RXTXRobot.MOTOR1, 0, RXTXRobot.MOTOR2, 0, 0);
					dist2 = r.getPing(PING_PIN1);
					System.out.printf("%f cm/n", dist2);
					reading2 = true;
				}
				else 
				{
					r.runMotor(RXTXRobot.MOTOR1, 400, RXTXRobot.MOTOR2, -400, 2300);
					reading2 = false;
				}
					
		}
		
		r.attachServo(RXTXRobot.SERVO1, 4); //Connect the servos to the Arduino 
		r.moveServo(RXTXRobot.SERVO1, 135); // Move Servo 1 to location 30 
		r.sleep(6500);
		
		double thermistorReading = getThermistorReading(r);
		double thermistor2Reading = getSecondThermistorReading(r);
		
		double temp = ((thermistorReading - 597.3885438)/-4.893029676);
		
		//Print the results
		System.out.println("The shielded probe reads the value: " + thermistorReading);
		System.out.println("In volts: " + (thermistorReading * (5.0/1023.0)));
		System.out.println("Temperature = " + temp);
		
		double temp2 = thermistor2Reading;
		System.out.println("The unshielded probe reads the value: " + thermistor2Reading);
			
		double difference = thermistorReading - thermistor2Reading; 
		double windSpeed = (40.134 + difference)/ -10.341;
		System.out.println("Wind speed = " + windSpeed );
		
		
		r.moveServo(RXTXRobot.SERVO1, 90);
		
		r.runMotor(RXTXRobot.MOTOR1, 225, RXTXRobot.MOTOR2, 260, 1300);
		r.sleep(1000);
		r.runMotor(RXTXRobot.MOTOR1, 200, RXTXRobot.MOTOR2, -240, 1900);
		
		double dist3 = 0;
		boolean reading3 = true;
		
		//find gap
		while(reading3 == true) 
		{
			//get distance measurement
			dist3 = r.getPing(PING_PIN2);
			System.out.println("The reading was " + dist3);
			System.out.println();
			
			if (dist3 <= 110)
			{
				//going forward
				r.runMotor(RXTXRobot.MOTOR1, 245, RXTXRobot.MOTOR2, -260, 900);
				dist3 = r.getPing(PING_PIN2);
				System.out.printf("%f cm/n", dist3);
				reading3 = true;
			}
			else
			{
				r.runMotor(RXTXRobot.MOTOR1, 330, RXTXRobot.MOTOR2, 330, 1100);
				reading3 = false;
			}
			
		}
		
		//r.runMotor(RXTXRobot.MOTOR1, 245, RXTXRobot.MOTOR2, -260, 1200);
		//r.runMotor(RXTXRobot.MOTOR1, 330, RXTXRobot.MOTOR2, 330, 1100);
		
		double dist4 = 0;
		boolean reading4 = true;
		
		//find wall after gap
		while(reading4 == true) 
		{
			//get distance measurement
			dist4 = r.getPing(PING_PIN1);
			System.out.println("The reading was " + dist4);
			System.out.println();
			
			if (dist4 >= 70)
			{
				//going forward
				r.runMotor(RXTXRobot.MOTOR1, 245, RXTXRobot.MOTOR2, -260, 1500);
				dist4 = r.getPing(PING_PIN1);
				System.out.printf("%f cm/n", dist4);
				reading4 = true;
			}
			else
			{
				r.runMotor(RXTXRobot.MOTOR1, 330, RXTXRobot.MOTOR2, 330, 1100);
				reading4 = false;
			}
			
		}
		
		double dist5 = 0;
		boolean reading5 = true;
		
		//find second wall
		while(reading5 == true) 
		{
			//get distance measurement
			dist5 = r.getPing(PING_PIN1);
			System.out.println("The reading was " + dist5);
			System.out.println();
			
			if (dist5 >= 60)
			{
				//going forward
				r.runMotor(RXTXRobot.MOTOR1, 245, RXTXRobot.MOTOR2, -260, 1500);
				dist5 = r.getPing(PING_PIN1);
				System.out.printf("%f cm/n", dist5);
				reading5 = true;
			}
			else
			{
				r.runMotor(RXTXRobot.MOTOR2, -260, RXTXRobot.MOTOR1, -245, 3000); //turn left 
				reading5 = false;
			}
			
		}
		
		double dist6 = 0;
		boolean reading6 = true;
		
		//find third wall
		while(reading6 == true) 
		{
			//get distance measurement
			dist6 = r.getPing(PING_PIN1);
			System.out.println("The reading was " + dist6);
			System.out.println();
			
			if (dist6 >= 60)
			{
				//going forward
				r.runMotor(RXTXRobot.MOTOR1, 245, RXTXRobot.MOTOR2, -260, 1500);
				dist5 = r.getPing(PING_PIN1);
				System.out.printf("%f cm/n", dist5);
				reading6 = true;
			}
			else
			{
				r.runMotor(RXTXRobot.MOTOR2, -260, RXTXRobot.MOTOR1, -245, 2800); //turn left 
				reading6 = false;
			}
			
		}
		
		//code to go over bridge
		r.runMotor(RXTXRobot.MOTOR1, 250, RXTXRobot.MOTOR2, -250, 5000);
		
		
		
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
			
			//Return the average reading
			return sum / readingCount;
			
		}

		
		public static int getSecondThermistorReading(RXTXRobot r) {
			
			int sum2 = 0;
			int readingCount2 = 10;
			
			//Read the analog pin values ten times, adding to sum each time
			for (int i = 0; i < readingCount2; i++) {
				
				//Refresh the analog pins so we get new readings
				r.refreshAnalogPins();
				int reading = r.getAnalogPin(1).getValue();
				sum2 += reading;
				}
			return sum2 / readingCount2;
		}
		
	}

