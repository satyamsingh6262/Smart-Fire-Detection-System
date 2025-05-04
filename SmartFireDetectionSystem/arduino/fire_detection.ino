int smokeSensor = A0;
int tempSensor = A1;

void setup() {
  Serial.begin(9600);
}

void loop() {
  int smoke = analogRead(smokeSensor);
  int tempRaw = analogRead(tempSensor);
  float voltage = tempRaw * (5.0 / 1023.0);
  float temperatureC = (voltage - 0.5) * 100; // For LM35

  Serial.print("SMOKE:");
  Serial.print(smoke);
  Serial.print(",TEMP:");
  Serial.println(temperatureC);

  delay(1000);
}
