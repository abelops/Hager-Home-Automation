#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <WiFiClient.h>
#include <Servo.h>
#define SERVOS 2

const char* ssid = "Android Hotspot";
const char* password = "abelabebe";

String bed = "", fan="", gar="",dor="",liv="", strhttp;
int bedPin = D5, fanPin = D2, garPin = D6, dorPin =D4, livPin = D3, T_read = 1, httpResponseCode;
const char* serverName = "http://192.168.43.81/ard/dyi.php";
unsigned long lastTime = 0;
unsigned long timerDelay = 500;

int servo_pins[SERVOS] = {0,0};
Servo myservo[SERVOS];
int default_pos[SERVOS] = {0,0}; 

void setup() {
  Serial.begin(115200);

  WiFi.begin(ssid, password);
  Serial.println("Connecting");
  while(WiFi.status() != WL_CONNECTED) {
    delay(100);
    Serial.print(".");
  }
  Serial.println("");
  Serial.print("Connected to WiFi network with IP Address: ");
  Serial.println(WiFi.localIP());
 
  Serial.println("Timer set to 5 seconds (timerDelay variable), it will take 5 seconds before publishing the first reading.");
  //pinMode(A0, INPUT);
  pinMode(fanPin, OUTPUT);
  pinMode(bedPin,OUTPUT);
  pinMode(garPin,OUTPUT);
  pinMode(dorPin,OUTPUT);
  pinMode(livPin,OUTPUT);
  for(int i = 0; i < SERVOS; i++) {
    myservo[i].attach(servo_pins[i]);
    myservo[i].write(default_pos[i]);
  }
  delay(15);   
}

void loop() {
  int T_read = analogRead(0);
  //T_read += 5; 
  Serial.println("INSIDE THE LOOP");
    a:if(WiFi.status()== WL_CONNECTED){
      WiFiClient client;
      HTTPClient http;

      String serverPath = String(serverName) + String("?temps=") + String(T_read);
      http.begin(client, serverPath.c_str());
      httpResponseCode = http.GET();
      if (httpResponseCode>0) {
        Serial.print("HTTP Response code: ");
        Serial.println(httpResponseCode);
        String payload = http.getString();
        Serial.println(payload);
      }
      else {
        Serial.print("Error code: ");
        Serial.println(httpResponseCode);
        goto a;
      }
      http.end();
      //temp
      Serial.print("temp: ");
      Serial.println(T_read);
      
      //bed read
      String bedr = String(serverName) + String("?bedr");
      http.begin(client, bedr.c_str());
      httpResponseCode = http.GET();
      strhttp = http.getString();
      Serial.print("Bed: ");
      Serial.println(strhttp);
      if (strhttp != bed) {
        if (bed == "")
        {
          bed = strhttp;
        }
        if (bed == "0"){
          digitalWrite(bedPin, HIGH);
          bed="1";
        }
        else if(bed =="1"){
          digitalWrite(bedPin, LOW);
          bed = "0";
        }
      }
      http.end();
      //fan read
      bedr = String(serverName) + String("?fanr");
      http.begin(client, bedr.c_str());
      httpResponseCode = http.GET();
      strhttp = http.getString();
      Serial.print("Fan: ");
      Serial.println(strhttp);
      if (strhttp!= fan) {
        if (fan == "")
        {
          fan = strhttp;
        }
        if (fan == "0"){
          digitalWrite(fanPin, HIGH);
          fan="1";
        }
        else if(fan =="1"){
          digitalWrite(fanPin, LOW);
          fan = "0";
        }
        }
        http.end();
      //gar read
      bedr = String(serverName) + String("?garr");
      http.begin(client, bedr.c_str());
      httpResponseCode = http.GET();
      strhttp = http.getString();
      Serial.print("Garage: ");
      Serial.println(strhttp);
      if (strhttp!= gar) {
        if (gar == "")
        {
          gar = strhttp;
        }
        if (gar == "0"){
          myservo[0].write(180);
          gar="1";
        }
        else if(gar =="1"){
          myservo[0].write(0);
          gar = "0";
        }
        }
        http.end();
      //dor read
      bedr = String(serverName) + String("?dorr");
      http.begin(client, bedr.c_str());
      httpResponseCode = http.GET();
      strhttp = http.getString();
      Serial.print("Dor: ");
      Serial.println(strhttp);
      if (strhttp!= dor) {
        if (dor == "")
        {
          dor = strhttp;
        }
        if (dor == "0"){
          myservo[1].write(180);
          dor="1";
        }
        else if(dor =="1"){
          myservo[1].write(0);
          dor = "0";
        }
        }
        http.end();
      //liv read
      bedr = String(serverName) + String("?livr");
      http.begin(client, bedr.c_str());
      httpResponseCode = http.GET();
      strhttp = http.getString();
      Serial.print("living: ");
      Serial.println(strhttp);
      if (strhttp!= liv) {
        if (liv == "")
        {
          liv = strhttp;
        }
        if (liv == "0"){
          digitalWrite(livPin, HIGH);
          liv="1";
        }
        else if(liv =="1"){
          digitalWrite(livPin, LOW);
          liv = "0";
        }
      }
      Serial.println(T_read);
        if(T_read<40){
          digitalWrite(fanPin, HIGH);
        }
        else{
          if(fan=="0"){
            digitalWrite(fanPin, LOW);
          }
        }
      http.end();
        
      
    }
 delay(10);
// else{
//  Serial.println("WiFi Disconnected");
// }
//lastTime = millis();
}
