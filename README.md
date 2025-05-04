# 🔥 Smart Fire Detection System (Java + IoT)

This project implements a real-time fire detection system using an Arduino-based sensor module and a Java application. The system reads smoke and temperature data and sends SMS alerts when thresholds are exceeded.

---

## 📦 Project Structure

```
SmartFireDetectionSystem/
├── arduino/
│   └── fire_detection.ino        # Arduino code to read smoke and temperature sensors
├── java/
│   ├── FireDetectionSystem.java  # Java application to receive serial data and send SMS
│   └── pom.xml                   # Maven file with dependencies
└── README.md                     # Project documentation
```

---

## 🧰 Requirements

### Hardware
- Arduino Uno (or compatible board)
- Smoke sensor (e.g., MQ2 or MQ135)
- Temperature sensor (e.g., LM35)
- USB cable for Arduino connection

### Software
- [Arduino IDE](https://www.arduino.cc/en/software)
- [Java JDK 8+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Apache Maven](https://maven.apache.org/)
- [Twilio account](https://www.twilio.com/)

---

## ⚙️ Setup Instructions

### 1. **Upload Arduino Code**
- Navigate to `arduino/fire_detection.ino`
- Open it in the Arduino IDE
- Upload it to the board
- Ensure sensors are connected:
  - Smoke sensor to A0
  - Temperature sensor to A1

### 2. **Configure Java Backend**
- Go to `java/FireDetectionSystem.java`
- Replace placeholders:
  ```java
  public static final String ACCOUNT_SID = "YOUR_TWILIO_SID";
  public static final String AUTH_TOKEN = "YOUR_TWILIO_AUTH_TOKEN";
  ...
  new com.twilio.type.PhoneNumber("+91xxxxxxxxxx"),  // Recipient
  new com.twilio.type.PhoneNumber("+1xxxxxxxxxx"),   // Your Twilio number
  ```
- Update the correct COM port for your Arduino in:
  ```java
  SerialPort port = SerialPort.getCommPort("COM3"); // Adjust this!
  ```

### 3. **Run the Java App**
```bash
cd java
mvn compile exec:java -Dexec.mainClass=FireDetectionSystem
```

---

## 🚨 Alert Triggering

Alerts are triggered when:
- Smoke sensor value > `300`
- Temperature > `50.0 °C`

The Java app continuously monitors sensor data from the Arduino and sends an SMS alert using the Twilio API if either condition is met.

---

## 📞 SMS Integration via Twilio

This project uses the [Twilio Java SDK](https://www.twilio.com/docs/libraries/java) for sending SMS. You must:
- Create a Twilio account
- Generate your **SID**, **Auth Token**, and **Trial Phone Number**
- Verify recipient phone numbers if using a trial account

---

## 🔐 Note on Security

Never expose your Twilio credentials in public repositories. Use environment variables or external config files in production.

---

## 📸 Demo (Optional)
_Add screenshots, logs, or a video demo here if you have one._

---

## 📃 License

This project is for educational and demonstration purposes.
