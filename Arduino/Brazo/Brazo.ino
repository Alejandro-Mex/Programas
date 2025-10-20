#include <Servo.h>
int servoBase = 8;
int servoIzq = 11;
int servoMano = 12;
int servoDer = 9;
int servoPos = 300;
Servo myservoBase, myservoIzq, myservoMano, myservoDer;


void setup() {
  myservoBase.attach(servoBase);
  myservoIzq.attach(servoIzq);
  myservoMano.attach(servoMano);
  myservoDer.attach(servoDer);
  Serial.begin(9600);

}

void loop() {

  myservoBase.write(0);
  myservoIzq.write(0);
  myservoMano.write(0);
  myservoDer.write(0);

}
