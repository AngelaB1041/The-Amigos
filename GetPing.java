import rxtxrobot.*;
public class GetPing {
	public static RXTXRobot robot; 
	final public static int PING_PIN = 13; 
	 
	public static void main(String[] args) 
	{ 
		RXTXRobot r = new ArduinoUno(); // Create RXTXRobot object 
		r.setPort("COM5"); // Set the port to COM3 
		r.connect(); 
		for (int x=0; x < 100; ++x) 
		{ 
			//Read the ping sensor value, which is connected to pin 12 
			System.out.println("Response: " + r.getPing(PING_PIN) + " cm"); 
			r.sleep(300); 
		} 
		r.close(); 
	} 
}
