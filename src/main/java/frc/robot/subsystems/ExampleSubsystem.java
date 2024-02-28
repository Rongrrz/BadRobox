// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  SerialPort a;
  double loopcount;
  double colorCycle;
  public ExampleSubsystem() {
    a = new SerialPort(115200, SerialPort.Port.kUSB, 8);
    //System.out.println(a.writeString("11\n"));
    //a.flush();
    loopcount = 0;
    colorCycle = 0;
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // System.out.println("!!!!!!!!!!!!!!");

    //a.close();

    loopcount += 1;
    if (loopcount % 250 == 0 && colorCycle % 2 == 0) {
      colorCycle += 1;
      System.out.println(a.writeString("1\r\n"));
      a.flush();
    } else if (loopcount % 250 == 0 && colorCycle % 2 != 0) {
      colorCycle += 1;
      System.out.println(a.writeString("2\r\n"));
      a.flush();
    }

    //a.writeString("111\r\n");
    // a.flush();
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
