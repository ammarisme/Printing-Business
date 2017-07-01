package printare_system;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.CommPortOwnershipListener;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.TooManyListenersException;


public class TestPortTwo {
   
   private Enumeration<CommPortIdentifier> portList;
   private CommPortIdentifier portId;
   private CommPort commPort;
   private SerialPort serialPort;
   private OutputStream tempOutput;
   private InputStream inputStream;
   private OutputStream outputStream;
   private String tempMessage;                  //String to store console output. May be used in SMS process
   
   public TestPortTwo() {
      super();
   }
   
   public void listPorts() {                 //use this method to list all ports connected to your message
      portList = CommPortIdentifier.getPortIdentifiers();
      
      while (portList.hasMoreElements()) {
         portId = portList.nextElement();
         System.out.println("port name: " + portId.getName() + " - " + getPortTypeName(portId.getPortType()));
      }
   }
   
   public String getPortTypeName (int portType) {           //This method is used to find which kind of port we are currently using
      switch (portType) {
         case CommPortIdentifier.PORT_I2C : 
            return "I2C";
         
         case CommPortIdentifier.PORT_PARALLEL :
            return "Parallel";
            
         case CommPortIdentifier.PORT_RAW : 
            return "Raw";
            
         case CommPortIdentifier.PORT_RS485 :
            return "RS485";
            
         case CommPortIdentifier.PORT_SERIAL : 
            return "Serial";
            
         default : 
            return "unknown typr";
      }
   }
   
   public void connect(String portName, String id) throws IOException {          //this method connects to the port that your GMS modem is connected
      try {
         portId = CommPortIdentifier.getPortIdentifier(portName);                //get the COM port you want to connect to
         
         portId.addPortOwnershipListener(new SerialOwnershipHandler(id));        //You need to add this listener, otherwise another port who want's connect to already connected port may need to wait forever.
         
      } catch (NoSuchPortException ex) {                                         //SerialOwnershipHandelr() described below.
         System.out.println("Error: " + ex.getMessage());
         ex.printStackTrace();
      }
      
      if (portId.isCurrentlyOwned()) {
         System.out.println("Error: Port is currently owned");
         
      } else {
         
         try {
            //commPort = portId.open(this.getClass().getName(), 2000);
            serialPort = (SerialPort) portId.open("bms sms", 5000);              //get a serial port instance
            setSerialPortParameters();
            
            outputStream = new PrintStream(serialPort.getOutputStream(), true, "ISO-8859-1");   //this outputStream instance is used to send commands/data to GMS modem
            inputStream = serialPort.getInputStream();                                          //this inputStream instance is used to get the data stream coimg out from GSM modem
            
            setSerialEventHandler(serialPort);                                                  //there're various SerialPortEvent s 
         } catch (PortInUseException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
            
         }
      }
   }
   
   public void setSerialPortParameters() throws IOException {                    //setting SerialParameters is optional. but it make the code safe
      try {
         serialPort.setSerialPortParams(115200,                                  //this is the maximum port speed/baud rate
                                       SerialPort.DATABITS_8, 
                                       SerialPort.STOPBITS_1, 
                                       SerialPort.PARITY_NONE);
         
         serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
         
      } catch (UnsupportedCommOperationException e) {
         throw new IOException("Unsupported serial port parameter");
      }
   }
   
   public InputStream getSerialInputStream() {
      return inputStream;
   }
   
   public OutputStream getSerialOutputStream() {
      return outputStream;
   }
   
   public void send(String message) {                                            
      try {
         tempOutput.write(message.getBytes());
         tempOutput.flush();
         
      } catch (IOException e) {
         System.out.println("Error: " + e.getMessage());
         e.printStackTrace();
      }
   }
   
   public void disconnect() {                                                    //is is a must to release the resources after you used them.
    if (serialPort != null) {                                                    //use this method at the of your message sending process
        try {
            // close the i/o streams.
            outputStream.close();
            inputStream.close();
        } catch (IOException ex) {
            // don't care
        }
        // Close the port.
        serialPort.close();
   }
}

   private class SerialOwnershipHandler implements CommPortOwnershipListener {
      String id;
      
      public SerialOwnershipHandler(String id) {
         this.id = id;
      }
      
      public void ownershipChange(int type) {
         
         switch (type) {
            case CommPortOwnershipListener.PORT_OWNED :
               System.out.println(id + " : We got the port");
               break;
               
            case CommPortOwnershipListener.PORT_UNOWNED :
               System.out.println(id + " : We've just lost our port ownership");
               break;
               
            case CommPortOwnershipListener.PORT_OWNERSHIP_REQUESTED : 
               System.out.println(id + " : Someone is asking our port's ownership");
               break;
         }
      }
   }
   
   private byte[] readBuffer = new byte[1024];           //buffer to store bytes read from input stream
   
   private void readSerial() {                           //this method prints the respones that you recieve from your device immediatly after you send command to your device
      try {
         int availableBytes = inputStream.available();
         
         if (availableBytes > 0) {
            inputStream.read(readBuffer, 0, availableBytes);
            tempMessage = new String(readBuffer, 0, availableBytes);
            System.out.println(new String(readBuffer, 0, availableBytes));
         }
         
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   public String getTempOutput() {
      return tempMessage;
   }
   
   private void checkCTS() {
      System.out.println("CTS changed");
      
      if (serialPort.isCTS()) {
         System.out.println("CTS asserted");
         
      } else {
         System.out.println("CTS de-asserted");
      }
   }
   
   private class SerialEventHandler implements SerialPortEventListener {
      
      public void serialEvent(SerialPortEvent event) {
         switch (event.getEventType()) {
            case SerialPortEvent.CTS :                //you'll need RTS/CTS notification as well. Otherwise, we will flood the modem with data, since most PCs are faster than modem
               checkCTS();
               break;
            
            case SerialPortEvent.DATA_AVAILABLE :     //this event is called when data is available in inputstream
               readSerial();                          //this method is used to print data in the input stream
               break;
         }
      }
   }
   
   private void setSerialEventHandler(SerialPort serialPort) {
       try {
           serialPort.addEventListener(new SerialEventHandler());
       serialPort.notifyOnDataAvailable(true);
       serialPort.notifyOnCTS(true);
       } catch (TooManyListenersException ex) {
           Logger.getLogger(TestPortTwo.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   public void checkAT() {
      String message = "AT\r\n";
      try {
         outputStream.write(message.getBytes());
         
      } catch (IOException e) {
         System.out.println("Error at checkAT: " + e.getMessage());
         e.printStackTrace();
      }
   }
   
   public void checkATI() {
      String message = "ATI\r\n";
      try {
         outputStream.write(message.getBytes());
      } catch (IOException e) {
         System.out.println("Error at checkAT: " + e.getMessage());
         e.printStackTrace();
      }
   }
   
   public void changeCMGF() {
      String message = "AT+CMGF=1\r\n";
      try {
         outputStream.write(message.getBytes());
      } catch (IOException e) {
         System.out.println("Error at checkAT: " + e.getMessage());
         e.printStackTrace();
      }
   }
   
   public void listAllMsgs() {
      String message = "AT+CMGL=\"ALL\"\r\n";
      
      try {
         outputStream.write(message.getBytes());
      } catch (IOException e) {
         System.out.println("Error at checkAT: " + e.getMessage());
         e.printStackTrace();
      }
   }
   
   public void deleteAll() {
      String message = "AT+CMGD=1,4\r\n";
      
      try {
         outputStream.write(message.getBytes());
      } catch (IOException e) {
         System.out.println("Error at deleteAll: " + e.getMessage());
         e.printStackTrace();
      }
   }
   
   public void setMessageStorage() {
      String message = "AT+CPMS=\"SM\"\r\n";
      
      try {
         outputStream.write(message.getBytes());
      } catch (IOException e) {
         System.out.println("Error at setMessageStorage: " + e.getMessage());
         e.printStackTrace();
      }
   }
   
   public void sendMessage(String text) {
      String message = "AT+CMGS=\"+94777123030\"\r";
      
      try {
         outputStream.write(message.getBytes());
         outputStream.write(text.getBytes());
         outputStream.write(26);
      } catch (IOException e) {
         System.out.println("Error at setMessageStorage: " + e.getMessage());
         e.printStackTrace();
      }
   }
}
