import com.fazecast.jSerialComm.SerialPort;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class FireDetectionSystem {
    public static final String ACCOUNT_SID = "YOUR_TWILIO_SID";
    public static final String AUTH_TOKEN = "YOUR_TWILIO_AUTH_TOKEN";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        SerialPort port = SerialPort.getCommPort("COM3"); // Replace with your port
        port.setBaudRate(9600);

        if (port.openPort()) {
            System.out.println("Port opened successfully.");
        } else {
            System.out.println("Failed to open port.");
            return;
        }

        byte[] buffer = new byte[1024];

        while (true) {
            if (port.bytesAvailable() > 0) {
                int len = port.readBytes(buffer, buffer.length);
                String data = new String(buffer, 0, len).trim();

                System.out.println("Received: " + data);

                if (data.contains("SMOKE:") && data.contains("TEMP:")) {
                    String[] parts = data.split(",");
                    int smokeValue = Integer.parseInt(parts[0].split(":")[1]);
                    double tempValue = Double.parseDouble(parts[1].split(":")[1]);

                    if (smokeValue > 300 || tempValue > 50.0) {
                        sendAlert(smokeValue, tempValue);
                    }
                }
            }
        }
    }

    public static void sendAlert(int smoke, double temp) {
        String alertMsg = "🔥 Fire Alert!\nSmoke: " + smoke + "\nTemp: " + temp + "°C";

        Message.creator(
            new com.twilio.type.PhoneNumber("+91xxxxxxxxxx"),
            new com.twilio.type.PhoneNumber("+1xxxxxxxxxx"),
            alertMsg
        ).create();

        System.out.println("⚠️ Alert Sent!");
    }
}
