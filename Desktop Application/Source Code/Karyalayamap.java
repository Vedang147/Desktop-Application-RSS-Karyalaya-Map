package rss.karyalaya.map;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.event.*;

public class Karyalayamap extends JFrame implements ActionListener {

    private JComboBox<String> locationComboBox;
    private JList<String> locationList;
    private JTextField startLocationField;
    private JTable distanceTable;
    private JButton mapButton;
    private JButton backButton;

    private String[] locations = {"Choose Location", "Nagpur", "Pune", "Chandrapur", "Bhandak", "Akola", "Amravati", "Akot", "Washim"};
    private String[][] distances = {
        {"Nagpur", "Reshimbagh, Nagpur"},
        {"Nagpur", "Dr.Hedgewar Smruti Bhavan,Mahal"},
        {"Pune", "Sudeep RSS Karyalay, Wadgaonsheri Bhag,Pune"},
        {"Pune", "Mamta Housing Society, Sudeep, Lane No. 3, Balajinagar, Mahadev Nagar, Wadgaon Sheri,Pune"},
        {"Chandrapur", "Nearby Vitthal Mandir Ward,Chandrapur"},
        {"Chandrapur", "Nearby Sasaram Mandir,Chandrapur"},
        {"Bhandak", "Nearby Killa Ward Shakha,Bhandak"},  
        {"Bhandak", "Nearby Lokmanaya College,Bhandak"}, 
        {"Akola", "Ram Nagar, Near LIC Office,Akola"},
        {"Amravati", "Nearby Madhokar Peth,Amravati,"},
        {"Akot", "Keshavraj Wetal,Akot"},
        {"Washim", "Nearby Nandipeth,Washim"},
    };
    Karyalayamap() {
        setBounds(400, 200, 850, 550);
        setLayout(null);

        // Location ComboBox
        JLabel locationLabel = new JLabel("Choose Location:");
        locationLabel.setBounds(50, 50, 120, 30);
        add(locationLabel);

        locationComboBox = new JComboBox<>(locations);
        locationComboBox.setBounds(180, 50, 150, 30);
        locationComboBox.addActionListener(this);
        add(locationComboBox);

        // Location List
        JLabel listLabel = new JLabel("List:");
        listLabel.setBounds(50, 100, 50, 30);
        add(listLabel);

        locationList = new JList<>(locations);
        locationList.setBounds(50, 140, 150, 300);
        JScrollPane listScrollPane = new JScrollPane(locationList);
        listScrollPane.setBounds(50, 140, 150, 300);
        add(listScrollPane);

        // Start Location TextField
        JLabel startLocationLabel = new JLabel("Enter Start Location:");
        startLocationLabel.setBounds(350, 50, 150, 30);
        add(startLocationLabel);

        startLocationField = new JTextField();
        startLocationField.setBounds(500, 50, 200, 30);
        add(startLocationField);

        // Distance Table
        JLabel distanceLabel = new JLabel("Destination Location:");
        distanceLabel.setBounds(350, 100, 150, 30);
        add(distanceLabel);

        DefaultTableModel model = new DefaultTableModel(new String[][]{}, new String[]{"Location", "Destination"});
        distanceTable = new JTable(model);
        distanceTable.setBounds(350, 140, 350, 300);
        JScrollPane tableScrollPane = new JScrollPane(distanceTable);
        tableScrollPane.setBounds(350, 140, 350, 300);
        add(tableScrollPane);

        // Map Button
        ImageIcon mapIcon = new ImageIcon("arrow.png");
        mapButton = new JButton(mapIcon);
        mapButton.setBounds(750, 220, 50, 50);
        mapButton.addActionListener(this);
        add(mapButton);
        
        // Back Button
        backButton = new JButton("Back");
        backButton.setBounds(375, 470, 100, 30);
        backButton.addActionListener(this);
        add(backButton);

        setVisible(true);
    }
   
    public static void main(String args[]) {
        new Karyalayamap();
    }

    @Override
public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == locationComboBox) {
        String selectedLocation = (String) locationComboBox.getSelectedItem();
        DefaultTableModel model = (DefaultTableModel) distanceTable.getModel();
        model.setRowCount(0);

        for (String[] distance : distances) {
            if (distance[0].equals(selectedLocation)) {
                model.addRow(distance);
            }
        }
        }
    
    else if (ae.getSource() == mapButton) {
        String startLocation = startLocationField.getText();
        int selectedRowIndex = distanceTable.getSelectedRow();
        
        if (selectedRowIndex != -1) {
            String selectedDestination = (String) distanceTable.getValueAt(selectedRowIndex, 1);
            String url = "https://www.google.com/maps/dir/?api=1&origin=" + startLocation + "&destination=" + selectedDestination;
            
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (IOException | URISyntaxException ex) {
                ex.printStackTrace();
            }
        } else {
            // Display an error message if no destination is selected
            JOptionPane.showMessageDialog(this, "Please select a destination.");
        }
    }
    
    else if (ae.getSource() == backButton) {
            //To handle the back button action    
        setVisible(false);
    }
  }
}