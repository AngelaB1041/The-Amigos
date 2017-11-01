import rxtxrobot.*;

public class pingStraightaway {
	public static void main(String[] args)
	{
		RXTXRobot r = new ArduinoNano();
		for (int x=0; x < 100; ++x) 
		{ 
			double dist = r.getPing(PING_PIN2);
		}  
		r.runMotor(RXTXRobot.MOTOR1, 500, RXTXRobot.MOTOR2, 500, 0);
		if(PING_PIN2 > 15 ) {
			r.runMotor(RXTXRobot.MOTOR1,0,RXTXRobot.MOTOR2,0,0);
			r.leftTurn();
		} else {
			r.runMotor(RXTXRobot.MOTOR1, 500, RXTXRobot.MOTOR2, 500, 0);// Stop both motors 
		}
	}
}
