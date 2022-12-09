import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.PrintStream;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.GridBagLayout;

public class GameView extends JFrame
{

	private JLabel titleLabel;
	private JLabel clickToPlayButtonLabel;
	private JButton playButton;
	
	//Character related information
	private JLabel nameSelect;
	private JTextField playerInfo;
	
	//Weapon related
	private JLabel weaponSelect;
	private JTextField weaponName;
	private JLabel weaponInfo;
	private JTextField weaponDamage;
	private JButton weaponButton;
	private JButton attack1Button;
	
	private JFrame frame;
	private JPanel gamePanel;
	private JPanel gamePanel2;


	private JButton attack2Button;
	private JLabel playerLabel;
	private JLabel weaponLabel;
	
	private JButton atk1;
	private JButton atk2;

//	private String name;
//	private String wName;
//	private double damage;
//	
	public void gamePanelSetNotVisible()
	{
		add(gamePanel2);
		createPanelTwo();
		gamePanel.setVisible(false);
		gamePanel2.setVisible(true);
	}
	

	public GameView()
	{
		gamePanel = new JPanel();
		gamePanel2 = new JPanel();
		setSize(1000, 750);
		createPanelOne();
		add(gamePanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamePanel.setVisible(true);
	}
	
	private void createPanelOne()
	{	
		gamePanel.setBackground(Color.cyan);
		gamePanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//Title stuffs
		titleLabel = new JLabel("FIGHTIN' FIGHTERS ");
		titleLabel.setBorder(BorderFactory.createMatteBorder(5,5,5,5, Color.black));
		titleLabel.setFont(new Font("Dialog", Font.ITALIC|Font.BOLD, 50));
		titleLabel.setForeground(Color.black);
		c.fill = GridBagConstraints.PAGE_START;
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 2;
		c.gridy = 0;
		c.anchor = GridBagConstraints.NORTH;
		c.ipady = 20;
		gamePanel.add(titleLabel, c);
		
		nameSelect = new JLabel("Enter Your Name, then Click Confirm!");
		nameSelect.setFont(new Font("Dialog", Font.PLAIN, 20));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weighty = 0;
		c.gridx = 2;
		c.gridy = 1;
		gamePanel.add(nameSelect, c);
		
		playerInfo = new JTextField("Enter Name");
		playerInfo.setForeground(Color.blue);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weighty = 0;
		c.gridx = 2;
		c.gridy = 2;
		gamePanel.add(playerInfo, c);

		//Weapons stuffs
		weaponSelect = new JLabel("Enter Your Weapon Name");
		weaponSelect.setFont(new Font("Dialog", Font.PLAIN, 20));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weighty = 0;
		c.gridx = 2;
		c.gridy = 3;
		gamePanel.add(weaponSelect, c);
		
		weaponName = new JTextField("Enter Weapon Name");
		weaponName.setForeground(Color.red);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weighty = 0;
		c.gridx = 2;
		c.gridy = 4;
		gamePanel.add(weaponName, c);
		
		weaponInfo = new JLabel("Enter Your Weapon Damage < 25");
		weaponInfo.setFont(new Font("Dialog", Font.PLAIN, 20));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 3;
		c.gridy = 3;
		gamePanel.add(weaponInfo, c);
		
		weaponDamage  = new JTextField("Enter Weapon Damage");
		weaponDamage.setForeground(Color.green);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 3;
		c.gridy = 4;
		gamePanel.add(weaponDamage, c);
		
		weaponButton = new JButton("Confirm");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 4;
		c.gridy = 4;
		gamePanel.add(weaponButton, c);
		
		clickToPlayButtonLabel = new JLabel("Press The Play Button To Continue");
		clickToPlayButtonLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 2;
		c.gridy = 5;
		gamePanel.add(clickToPlayButtonLabel, c);
		
		
		playButton = new JButton("PLAY");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 2;
		c.gridy = 6;
		gamePanel.add(playButton, c);
	}
	
	private void createPanelTwo()
	{	
		GridBagConstraints gbc = new GridBagConstraints();
		gamePanel2.setLayout(new GridBagLayout());
		gamePanel2.setBackground(Color.gray);
		
		titleLabel = new JLabel("FIGHT! FIGHT! FIGHT!");
		titleLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 50));
		titleLabel.setBorder(BorderFactory.createMatteBorder(5,5,5,5, Color.cyan));
		titleLabel.setForeground(Color.white);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.0001;
		gbc.weighty = 0.001;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gamePanel2.add(titleLabel, gbc);
		
		JLabel youLabel = new JLabel("YOU:");
		youLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		youLabel.setBorder(BorderFactory.createLineBorder(Color.green));
		youLabel.setForeground(Color.white);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gamePanel2.add(youLabel, gbc);
		
		JLabel oppLabel = new JLabel("Opponent");
		oppLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		oppLabel.setBorder(BorderFactory.createLineBorder(Color.red));
		oppLabel.setForeground(Color.white);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gamePanel2.add(oppLabel, gbc);
		
		playerLabel = new JLabel(getName());
		playerLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		playerLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		playerLabel.setForeground(Color.white);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gamePanel2.add(playerLabel, gbc);
		
		weaponLabel = new JLabel("Weapon: " + getWeaponName());
		weaponLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		weaponLabel.setBorder(BorderFactory.createLineBorder(Color.orange));
		weaponLabel.setForeground(Color.white);
		gbc.weighty = 0.001;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gamePanel2.add(weaponLabel, gbc);
		
		JLabel oppCharacter = new JLabel("Queen Elizabeth");
		oppCharacter.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		oppCharacter.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		oppCharacter.setForeground(Color.white);
		gbc.gridx = 2;
		gbc.gridy = 2;
		gamePanel2.add(oppCharacter, gbc);
		
		JLabel oppWeaponLabel = new JLabel("Weapon: " + "The Royal Crown");
		oppWeaponLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		oppWeaponLabel.setBorder(BorderFactory.createLineBorder(Color.orange));
		oppWeaponLabel.setForeground(Color.white);
		gbc.weighty = 0;
		gbc.gridx = 2;
		gbc.gridy = 3;
		gamePanel2.add(oppWeaponLabel, gbc);
		
		JButton atk1 = new JButton("Attack 1");
		gbc.weighty = 0.01;
		gbc.gridx = 0;
		gbc.gridy = 4;
		gamePanel2.add(atk1, gbc);
		
		JButton atk2 = new JButton("Attack 2");
		gbc.weighty = 0.01;
		gbc.gridx = 0;
		gbc.gridy = 5;
		gamePanel2.add(atk2, gbc);

	
		JPanel attackLog = new JPanel();
		GridBagConstraints gbc2 = new GridBagConstraints();
		attackLog.setLayout(new GridBagLayout());
		attackLog.setBackground(Color.white);
		attackLog.setBorder(BorderFactory.createLineBorder(Color.black));
		gbc.gridy = 2;
		gbc.gridx = 1;
		gbc.ipady = 10;
		gamePanel2.add(attackLog, gbc);
		

		
		
		
		
		JLog attackLogInput = new JLog();
		attackLogInput.setForeground(Color.blue);
		int[] array = new int[15];
		for(int i = 1; i < array.length; i++)
		{
			attackLogInput = new JLog();
			//set the text to be the current attack
			//declare an empty String variable
			//set the attack buttons to have an event handler
			//Have the event handler update the String to show
			//YOU: Did 15 Damage
			//Queen Elizabeth: Loses 15 Health;
			attackLogInput.setText(getName());
			gbc2.gridy = i;
			attackLog.add(attackLogInput, gbc2);
		}
	
		
	
	}
	
	class JLog extends JLabel
	{
		JLog()
		{
			super();
			setOpaque(true);
		}
		
		protected void paintComponent(Graphics gr)
		{
			super.paintComponent(gr);
		}
	}
	
	
	
	public String printMessage()
	{
		return "Hello my name is Buddy";
	}
		
	public String getName()
	{
		return playerInfo.getText();
	}
	
	public String getWeaponName()
	{
		return weaponName.getText();
	}
	
	public double getWeaponDamage()
	{
		return Double.parseDouble(weaponDamage.getText());
	}
	
	public void setFightingSequenceLabel()
	{
		//
	}

	public void addATK1Listener(ActionListener listenATK1)
	{
		atk1.addActionListener(listenATK1);
	}
	
	public void addTextListener(ActionListener listenTextName)
	{
		weaponButton.addActionListener(listenTextName);
	}
	
	public void addWeaponDamageListener(ActionListener listenWeaponDamage)
	{
		weaponButton.addActionListener(listenWeaponDamage);
	}
	
	
	public void addPlayListener(ActionListener listenPlay)
	{
		playButton.addActionListener(listenPlay);
		
	}
	
	public void errorMessage(String eMessage)
	{
		JOptionPane.showMessageDialog(this, eMessage);
	}
	
	public JTextField getNameField()
	{
		return playerInfo;
	}
	
	public JTextField getWeaponNameField()
	{
		return weaponName;
	}
	
	public JTextField getWeaponDamageField()
	{
		return weaponDamage;
	}
	

	
}
