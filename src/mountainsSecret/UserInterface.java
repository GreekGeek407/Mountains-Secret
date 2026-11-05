package mountainsSecret;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface {
	private JFrame window;
	private JTextArea roomDescArea;
    private JTextArea outputArea;
    private JTextField inputField;
    private JLabel roomLabel;
    
    private Color backgroundColor = new Color(28, 160, 101);
    private Color panelColor = new Color(47, 41, 99);
    private Color labelColor = new Color(255, 255, 255);
    
    public UserInterface() {
        createUI();
        updateGameText("You begin in the " + Game.getCurrentRoom().getName() + ".");
    }

    private void createUI() {
        // 1. Setup the Main Window Frame
        window = new JFrame("Swipe Dad's Car");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(backgroundColor);
        ((JComponent) window.getContentPane()).setBorder(BorderFactory.createLineBorder(panelColor, 6));
        window.setLayout(null); // Absolute positioning for precise layouts
        window.setResizable(false);

        // 2. Setup the Top Status/Stats Panel
        JPanel statsPanel = new JPanel();
        statsPanel.setBounds(50, 20, 700, 40);
        statsPanel.setBackground(backgroundColor);
        statsPanel.setLayout(new GridLayout(1, 2));

        roomLabel = new JLabel("Current Room: " + Game.getCurrentRoom().getName(), JLabel.LEFT);
        roomLabel.setForeground(labelColor);
        roomLabel.setFont(new Font("Serif", Font.BOLD, 24));
        statsPanel.add(roomLabel);
        
        window.add(statsPanel);
        
        inputField = new JTextField();
        inputField.setBounds(50, 500, 700, 40);
        inputField.setFont(new Font("Serif", Font.PLAIN, 15));
        inputField.setBorder(BorderFactory.createLineBorder(panelColor, 4));
        inputField.setToolTipText(
            "Enter an action, such as 'look', 'north', or 'take key'"
        );
        inputField.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String command = inputField.getText();
        		if (!command.trim().isEmpty()) {
        			Game.runGame(command);
        			inputField.setText("");
        		}
        		
        	}
        });
        
        window.add(inputField);

        // 3. Setup the Narrative Output Display Area
        JPanel outputPanel = new JPanel();
        outputPanel.setBounds(50, 80, 700, 400);
        outputPanel.setLayout(new GridLayout(2, 1));
        roomDescArea = new JTextArea();
        roomDescArea.setBounds(50, 80, 700, 200);
        roomDescArea.setBackground(backgroundColor.darker());
        roomDescArea.setForeground(Color.WHITE);
        roomDescArea.setBorder(BorderFactory.createLineBorder(panelColor, 3));
        roomDescArea.setFont(new Font("Serif", Font.PLAIN, 18));
        roomDescArea.setLineWrap(true);
        roomDescArea.setWrapStyleWord(true);
        roomDescArea.setEditable(false);
        outputPanel.add(roomDescArea);
        
        outputArea = new JTextArea();
        outputArea.setBounds(50, 310, 700, 200);
        outputArea.setBackground(backgroundColor.darker());
        outputArea.setForeground(Color.WHITE);
        outputArea.setBorder(BorderFactory.createLineBorder(panelColor, 3));
        outputArea.setFont(new Font("Serif", Font.PLAIN, 18));
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(outputArea);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        outputPanel.add(scroll);
        window.add(outputPanel);

        // Make window visible
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    // Helper methods to modify the displayed text dynamically
    public void updateGameText(String text) {
    	roomLabel.setText("Current Room: " + Game.getCurrentRoom().getName());
    	roomDescArea.setText(Game.getCurrentRoom().getDescription());
        outputArea.append("\n" + text);
    }



}
