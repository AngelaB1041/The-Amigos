import rxtxrobot.*;
public class BumpSensor 
{
	public static RXTXRobot robot;
	public static void main(String[]args) 
	{
		RXTXRobot r = new ArduinoUno();
		r.setPort("COM5");
		r.connect();
		r.refreshDigitalPins();
		int reading = r.getDigitalPin(7).getValue();
		System.out.println("The digital reading on pin 7 was: " + reading);
		r.close(); 
	}
}