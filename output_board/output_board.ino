//--------------------------------------------------------------------------------------------------
// demo-2-02-001b.ino
//
// Description: Advanced demo to control a 4DBrix 2.02.001 track switch motor.
//
// Author: Lowa
// Created: 25-Nov-2018
// Copyright (C) 2018, 4DBrix LLC.  All rights reserved.
//
// Please feel free to use this example for personal, non-commercial use only, provided you keep the
// copyright message intact.  Have fun !
//--------------------------------------------------------------------------------------------------


//--------------------------------------------------------------------------------------------------
// Included libraries
//--------------------------------------------------------------------------------------------------
#include <Servo.h>
#include <IRLibAll.h>
#include <IRLibProtocols.h>
#include <PowerFunctions.h>
#include <IRLibRecv.h>
#include <IRLibRecvPCI.h>
#include <IRLibFreq.h>
#include <Cmd.h>

class RightSwitch {
  private:
    Servo servo;
    byte servoPin;
  public:
    enum state {RIGHT = 1, TURN = 0} switchState;

    RightSwitch(byte pin) {
      servoPin = pin;
      init();
    }
    void init() {
      pinMode(servoPin, OUTPUT);
      // Always try to avoid duplicate code.
      // Instead of writing digitalWrite(pin, LOW) here,
      // call the function straight() which already does that
      straight();
    }
    void right() {
      servo.attach(servoPin);                   // Activate the servo
      servo.write(25);                          // Move the servo to the 25 degree position
      delay(400);                               // Wait for 400ms so the motor can move to it's position
      servo.write(28);                          // Move the motor 3 degree back to avoid buzzing
      delay(50);                                // Wait for 50ms so the motor can execute the command
      servo.detach();// Deactivate the servo
      switchState = RIGHT;
    }
    void left() {
      // Move the switch to the 'straight' position
      servo.attach(servoPin);                   // Activate the servo
      servo.write(105);                         // Move the servo to the 105 degree position
      delay(400);                               // Wait for 400ms so the motor can move to it's position
      servo.write(102);                         // Move the motor 3 degree back to avoid buzzing
      delay(50);                                // Wait for 50ms so the motor can execute the command
      servo.detach();
      switchState = LEFT;
    }
    void toggle() {
      if (switchState = STRAIGHT) {
        turn();
      }
      else if (switchState = TURN) {
        straight();
      }
    }
}; // don't forget the semicolon at the end of the class
//--------------------------------------------------------------------------------------------------
// Global variables
//--------------------------------------------------------------------------------------------------
// Object to interface with servo 1
int servoPin = 5;// The control pin for servo 1switch

String incomingString;
RightSwitch switch1(5);                              // Digital pin 5 will be used for the servo signal

//--------------------------------------------------------------------------------------------------
// Initialization process
//--------------------------------------------------------------------------------------------------
void setup() {

  // Start the serial communication
  Serial.begin(9600);
  cmdInit(&Serial);// Use the default Arduino baud rate
  cmdAdd('test', test);
  Serial.println("Setting up");
  // Configure the servo motor
  //delay(500);  

  Serial.println("Done.");

}


//--------------------------------------------------------------------------------------------------
// Processing loop
//--------------------------------------------------------------------------------------------------
void loop() {
  Serial.println("loop");
  //handleSerial();
  //Serial.println(readSerialString());

  delay(1000);  
}

void handleSerial() {}

String readSerialString() {}

void test(int arg_cnt, char **args) {
  Serial.println("test");
}
    

//--- End-of-File-----------------------------------------------------------------------------------
