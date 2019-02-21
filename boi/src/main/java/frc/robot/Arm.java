package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;


public class Arm {

    private TalonSRX motor;
    private double controlParamter = 0.0;

    public Arm(int index) {
        motor = new TalonSRX(index);
    }

    public void actuate(double velocity, boolean shouldFreeze) {
        if(!shouldFreeze) {
            controlParamter = velocity;
            motor.set(ControlMode.PercentOutput, velocity);
        } else {
            motor.set(ControlMode.PercentOutput, limit(controlParamter + 0.2 * velocity));
        }
    }

    private double limit(double signal) {
        if(signal > 1) return 1;
        if(signal < 1) return -1;
        return signal;
    }
}