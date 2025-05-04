# Smart Fire Detection System (Java + IoT)

## Overview
This project detects fire using sensors and triggers real-time SMS alerts using Java and Twilio.

## Structure
- `arduino/`: Arduino sketch to read sensor data.
- `java/`: Java app for device integration and alerting (Maven project).

## Setup
1. Upload the Arduino sketch to your board.
2. Update the Java file with your Twilio SID, token, and phone numbers.
3. Use `mvn compile exec:java` to run the backend.

## Dependencies
- jSerialComm
- Twilio Java SDK
