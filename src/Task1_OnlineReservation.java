// import javax.swing.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.HashMap;
// import java.util.Map;
//
// class ReservationSystem {
//     private Map<String, String> userCredentials; // Store user credentials (ID, Password)
//     private Map<String, ReservationDetails> reservations; // Store reservations (PNR, ReservationDetails)
//
//     public ReservationSystem() {
//         userCredentials = new HashMap<>();
//         userCredentials.put("user1", "password1"); // Example user credentials
//
//         reservations = new HashMap<>();
//     }
//
//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             LoginForm loginForm = new LoginForm(new ReservationSystem());
//             loginForm.setVisible(true);
//         });
//     }
//
//     static class LoginForm extends JFrame {
//         private JTextField userIdField;
//         private JPasswordField passwordField;
//
//         public LoginForm(ReservationSystem reservationSystem) {
//             setTitle("Login Form");
//             setSize(300, 150);
//             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//             setLocationRelativeTo(null);
//
//             JPanel panel = new JPanel();
//             add(panel);
//             placeComponents(panel, reservationSystem);
//
//             pack();
//         }
//
//         private void placeComponents(JPanel panel, ReservationSystem reservationSystem) {
//             panel.setLayout(null);
//
//             JLabel userLabel = new JLabel("User ID:");
//             userLabel.setBounds(10, 20, 80, 25);
//             panel.add(userLabel);
//
//             userIdField = new JTextField(20);
//             userIdField.setBounds(100, 20, 160, 25);
//             panel.add(userIdField);
//
//             JLabel passwordLabel = new JLabel("Password:");
//             passwordLabel.setBounds(10, 50, 80, 25);
//             panel.add(passwordLabel);
//
//             passwordField = new JPasswordField(20);
//             passwordField.setBounds(100, 50, 160, 25);
//             panel.add(passwordField);
//
//             JButton loginButton = new JButton("Login");
//             loginButton.setBounds(10, 80, 80, 25);
//             panel.add(loginButton);
//
//             loginButton.addActionListener(new ActionListener() {
//                 @Override
//                 public void actionPerformed(ActionEvent e) {
//                     String userId = userIdField.getText();
//                     String password = new String(passwordField.getPassword());
//
//                     if (reservationSystem.authenticateUser(userId, password)) {
//                         // Open reservation form
//                         dispose();
//                         ReservationForm reservationForm = new ReservationForm(reservationSystem);
//                         reservationForm.setVisible(true);
//                     } else {
//                         JOptionPane.showMessageDialog(null, "Invalid credentials. Try again.");
//                     }
//                 }
//             });
//         }
//     }
//
//     static class ReservationDetails {
//         String trainNumber;
//         String trainName;
//         String classType;
//         String dateOfJourney;
//         String from;
//         String to;
//
//         public ReservationDetails(String trainNumber, String trainName, String classType, String dateOfJourney, String from, String to) {
//             this.trainNumber = trainNumber;
//             this.trainName = trainName;
//             this.classType = classType;
//             this.dateOfJourney = dateOfJourney;
//             this.from = from;
//             this.to = to;
//         }
//     }
//
//     static class ReservationForm extends JFrame {
//         private JTextField trainNumberField;
//         private JTextField trainNameField;
//         private JTextField classTypeField;
//         private JTextField dateOfJourneyField;
//         private JTextField fromField;
//         private JTextField toField;
//
//         public ReservationForm(ReservationSystem reservationSystem) {
//             setTitle("Reservation Form");
//             setSize(400, 300);
//             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//             setLocationRelativeTo(null);
//
//             JPanel panel = new JPanel();
//             add(panel);
//             placeComponents(panel, reservationSystem);
//
//             pack();
//         }
//
//         private void placeComponents(JPanel panel, ReservationSystem reservationSystem) {
//             panel.setLayout(null);
//
//             JLabel trainNumberLabel = new JLabel("Train Number:");
//             trainNumberLabel.setBounds(10, 20, 80, 25);
//             panel.add(trainNumberLabel);
//
//             trainNumberField = new JTextField(20);
//             trainNumberField.setBounds(150, 20, 200, 25);
//             panel.add(trainNumberField);
//
//             JLabel trainNameLabel = new JLabel("Train Name:");
//             trainNameLabel.setBounds(10, 50, 80, 25);
//             panel.add(trainNameLabel);
//
//             trainNameField = new JTextField(20);
//             trainNameField.setBounds(150, 50, 200, 25);
//             panel.add(trainNameField);
//
//             JLabel classTypeLabel = new JLabel("Class Type:");
//             classTypeLabel.setBounds(10, 80, 80, 25);
//             panel.add(classTypeLabel);
//
//             classTypeField = new JTextField(20);
//             classTypeField.setBounds(150, 80, 200, 25);
//             panel.add(classTypeField);
//
//             JLabel dateOfJourneyLabel = new JLabel("Date of Journey:");
//             dateOfJourneyLabel.setBounds(10, 110, 120, 25);
//             panel.add(dateOfJourneyLabel);
//
//             dateOfJourneyField = new JTextField(20);
//             dateOfJourneyField.setBounds(150, 110, 200, 25);
//             panel.add(dateOfJourneyField);
//
//             JLabel fromLabel = new JLabel("From:");
//             fromLabel.setBounds(10, 140, 80, 25);
//             panel.add(fromLabel);
//
//             fromField = new JTextField(20);
//             fromField.setBounds(150, 140, 200, 25);
//             panel.add(fromField);
//
//             JLabel toLabel = new JLabel("To:");
//             toLabel.setBounds(10, 170, 80, 25);
//             panel.add(toLabel);
//
//             toField = new JTextField(20);
//             toField.setBounds(150, 170, 200, 25);
//             panel.add(toField);
//
//             JButton insertButton = new JButton("Insert");
//             insertButton.setBounds(10, 200, 80, 25);
//             panel.add(insertButton);
//
//             insertButton.addActionListener(new ActionListener() {
//                 @Override
//                 public void actionPerformed(ActionEvent e) {
//                     // Get input values
//                     String trainNumber = trainNumberField.getText();
//                     String trainName = trainNameField.getText();
//                     String classType = classTypeField.getText();
//                     String dateOfJourney = dateOfJourneyField.getText();
//                     String from = fromField.getText();
//                     String to = toField.getText();
//
//                     // Create ReservationDetails object
//                     ReservationDetails reservationDetails = new ReservationDetails(trainNumber, trainName, classType, dateOfJourney, from, to);
//
//                     // Add reservation
//                     String pnr = reservationSystem.addReservation(reservationDetails);
//
//                     JOptionPane.showMessageDialog(null, "Reservation successful! PNR: " + pnr);
//                 }
//             });
//         }
//     }
//
//     private boolean authenticateUser(String userId, String password) {
//         return userCredentials.containsKey(userId) && userCredentials.get(userId).equals(password);
//     }
//
//     private String addReservation(ReservationDetails reservationDetails) {
//         String pnr = generatePNR();
//         reservations.put(pnr, reservationDetails);
//         return pnr;
//     }
//
//     private String generatePNR() {
//         // This is a simple example. In a real system, you would need a more sophisticated approach to generate PNR.
//         return String.valueOf(System.currentTimeMillis() % 1000000);
//     }
// }

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Task1_OnlineReservation {
    private Map<String, String> userCredentials;
    private JFrame mainFrame;

    public Task1_OnlineReservation() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1"); // Example user credentials

        mainFrame = new JFrame("Online Reservation System");
        mainFrame.setSize(400, 300);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);

        showLoginForm();
    }

    private void showLoginForm() {
        mainFrame.getContentPane().removeAll();

        JPanel panel = new JPanel();
        mainFrame.add(panel);
        placeLoginComponents(panel);

        mainFrame.setVisible(true);
    }

    private void placeLoginComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("User ID:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userIdField = new JTextField(20);
        userIdField.setBounds(100, 20, 200, 25);
        panel.add(userIdField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 50, 200, 25);
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = userIdField.getText();
                String password = new String(passwordField.getPassword());

                if (authenticateUser(userId, password)) {
                    showReservationForm();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials. Try again.");
                }
            }
        });
    }

    private boolean authenticateUser(String userId, String password) {
        return userCredentials.containsKey(userId) && userCredentials.get(userId).equals(password);
    }

    private void showReservationForm() {
        mainFrame.getContentPane().removeAll();

        JPanel panel = new JPanel();
        mainFrame.add(panel);
        placeReservationComponents(panel);

        mainFrame.setVisible(true);
    }

    private void placeReservationComponents(JPanel panel) {
        panel.setLayout(null);

        // Assuming train details are hardcoded for simplicity
        String[] trainNumbers = {"123", "456", "789"};
        JComboBox<String> trainNumberComboBox = new JComboBox<>(trainNumbers);
        trainNumberComboBox.setBounds(10, 20, 150, 25);
        panel.add(trainNumberComboBox);

        JTextField trainNameField = new JTextField("Sample Train");
        trainNameField.setBounds(170, 20, 200, 25);
        trainNameField.setEditable(false);
        panel.add(trainNameField);

        JTextField classTypeField = new JTextField();
        classTypeField.setBounds(10, 50, 150, 25);
        panel.add(classTypeField);

        JTextField dateOfJourneyField = new JTextField();
        dateOfJourneyField.setBounds(170, 50, 200, 25);
        panel.add(dateOfJourneyField);

        JTextField fromField = new JTextField();
        fromField.setBounds(10, 80, 150, 25);
        panel.add(fromField);

        JTextField toField = new JTextField();
        toField.setBounds(170, 80, 200, 25);
        panel.add(toField);

        JButton insertButton = new JButton("Insert");
        insertButton.setBounds(10, 110, 80, 25);
        panel.add(insertButton);

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle reservation logic here
                // You can retrieve values from the fields and perform necessary actions
                JOptionPane.showMessageDialog(null, "Reservation successful!");
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(100, 110, 80, 25);
        panel.add(cancelButton);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLoginForm();
            }
        });

        JButton cancelReservationButton = new JButton("Cancel Reservation");
        cancelReservationButton.setBounds(190, 110, 180, 25);
        panel.add(cancelReservationButton);

        cancelReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCancellationForm();
            }
        });
    }

    private void showCancellationForm() {
        mainFrame.getContentPane().removeAll();

        JPanel panel = new JPanel();
        mainFrame.add(panel);
        placeCancellationComponents(panel);

        mainFrame.setVisible(true);
    }

    private void placeCancellationComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel pnrLabel = new JLabel("PNR Number:");
        pnrLabel.setBounds(10, 20, 80, 25);
        panel.add(pnrLabel);

        JTextField pnrField = new JTextField();
        pnrField.setBounds(100, 20, 200, 25);
        panel.add(pnrField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(10, 50, 80, 25);
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve reservation details based on PNR and display
                String pnr = pnrField.getText();
                // Call a method to fetch and display reservation details based on PNR
                displayReservationDetails(pnr);
            }
        });

        JButton okButton = new JButton("OK");
        okButton.setBounds(100, 50, 80, 25);
        panel.add(okButton);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle cancellation logic here
                // You can retrieve the PNR and perform necessary cancellation actions
                JOptionPane.showMessageDialog(null, "Cancellation confirmed!");
                showLoginForm();
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setBounds(190, 50, 80, 25);
        panel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showReservationForm();
            }
        });
    }

    private void displayReservationDetails(String pnr) {
        // Implement logic to fetch and display reservation details based on PNR
        // For simplicity, displaying a message here
        JOptionPane.showMessageDialog(null, "Reservation Details for PNR: " + pnr);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Task1_OnlineReservation();
        });
    }
}
