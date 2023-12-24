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
