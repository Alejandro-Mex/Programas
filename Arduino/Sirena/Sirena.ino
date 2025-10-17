int rojo = 13;
int blanco = 12;
int azul = 11;

void setup() {
  pinMode(rojo, OUTPUT);
  pinMode(blanco, OUTPUT);
  pinMode(azul, OUTPUT);
}

void loop() {
  digitalWrite(rojo,HIGH);
  digitalWrite(blanco,HIGH);
  digitalWrite(azul,HIGH);


  delay(2000);

  digitalWrite(rojo,LOW);
  digitalWrite(azul,LOW);
  digitalWrite(blanco,LOW);

  

  for (int i = 0; i<4; i++){
    delay(500);
    digitalWrite(rojo,HIGH);
    digitalWrite(blanco,HIGH);
    digitalWrite(azul,HIGH);
    delay(500);
    digitalWrite(rojo,LOW);
    digitalWrite(blanco,LOW);
    digitalWrite(azul,LOW);

  }
}
 