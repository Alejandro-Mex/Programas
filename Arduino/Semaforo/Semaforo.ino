int rojo = 13;
int amarillo = 12;
int verde = 11;

void setup() {
  pinMode(rojo, OUTPUT);
  pinMode(amarillo, OUTPUT);
  pinMode(verde, OUTPUT);

}

void loop() {
  // put your main code here, to run repeatedly:
  digitalWrite(verde, LOW);
  digitalWrite(rojo, HIGH);
  delay(1000);
  digitalWrite(rojo, LOW);
  digitalWrite(amarillo, HIGH);
  delay(1000);
  digitalWrite(amarillo, LOW);
  digitalWrite(verde, HIGH);
  delay(1000);
 
  
}