import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
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
	private JTextField nameTextField;
	private JLabel playerLabel;
	private JLabel weaponLabel;
	private JLabel youLabel;
	private JLabel oppLabel;
	private JButton brawlerButton;
	private JTextField jText;
	
	
	//Weapon related

	private String weaponName;
	private JLabel weaponInfo;
	private JTextField weaponDamage;
	private JButton weaponButton;

	//Panels
	private JPanel gamePanel;
	private JPanel gamePanel2;
	private JPanel winPanel;
	private JPanel lossPanel;
	private JPanel attackLog;
	
	//Attack Buttons
	private JButton atk1 = new JButton("Attack 1");
	private JButton atk2 = new JButton("Attack 2");
	private JButton reset = new JButton("Reset");
	
	//Attack Log
	private JLabel j1;
	private JLabel j2;
	
	private JLabel winCountLabel;
		
	//File related
	private int winCount;
	private JButton saveButton = new JButton("Save");
	private JButton loadSaveButton = new JButton("Load Save");


	public GameView()
	{
		gamePanel = new JPanel();
		gamePanel2 = new JPanel();
		winPanel = new JPanel();
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
		
		nameTextField = new JTextField("Enter Name");
		nameTextField.setForeground(Color.blue);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weighty = 0;
		c.gridx = 2;
		c.gridy = 2;
		gamePanel.add(nameTextField, c);

		weaponInfo = new JLabel("Choose Your Character");
		weaponInfo.setFont(new Font("Dialog", Font.PLAIN, 20));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 2;
		c.gridy = 3;
		gamePanel.add(weaponInfo, c);
		
		brawlerButton = new JButton("Brawler");
		brawlerButton.setFont(new Font("Dialog", Font.PLAIN, 20));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weighty = 0;
		c.gridx = 2;
		c.gridy = 4;
		gamePanel.add(brawlerButton, c);
		
		JLabel orLabel = new JLabel("Or Enter Previous Save File");
		orLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 2;
		c.gridy = 6;
		gamePanel.add(orLabel, c);
		
		jText = new JTextField("Enter Your Save File Here");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 2;
		c.gridy = 7;
		gamePanel.add(jText, c);
		
		clickToPlayButtonLabel = new JLabel("Press The Play Button To Continue");
		clickToPlayButtonLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 2;
		c.gridy = 10;
		gamePanel.add(clickToPlayButtonLabel, c);
		
		loadSaveButton.setFont(new Font("Dialog", Font.PLAIN, 20));
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 2;
		c.gridy = 9;
		gamePanel.add(loadSaveButton, c);
		
		playButton = new JButton("PLAY");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 2;
		c.gridy = 11;
		gamePanel.add(playButton, c);
	}
	
	private void createPanelTwo()
	{	
		GridBagConstraints gbc = new GridBagConstraints();
		gamePanel2.setLayout(new GridBagLayout());
		gamePanel2.setBackground(Color.black);
		
		titleLabel = new JLabel("            FIGHT!");
		titleLabel.setFont(new Font("Dialog", 3, 50));
		titleLabel.setBorder(BorderFactory.createMatteBorder(5,5,5,5, Color.cyan));
		titleLabel.setForeground(Color.white);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.0001;
		gbc.weighty = 0.001;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gamePanel2.add(titleLabel, gbc);
		
		youLabel = new JLabel("YOU: ");
		youLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		youLabel.setBorder(BorderFactory.createLineBorder(Color.green));
		youLabel.setForeground(Color.white);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gamePanel2.add(youLabel, gbc);
		
		playerLabel = new JLabel(getName());
		playerLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		playerLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		playerLabel.setForeground(Color.white);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gamePanel2.add(playerLabel, gbc);
		
		weaponLabel = new JLabel("Weapon: " + weaponName);
		weaponLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		weaponLabel.setBorder(BorderFactory.createLineBorder(Color.orange));
		weaponLabel.setForeground(Color.white);
		gbc.weighty = 0.001;
		gbc.gridx = 0;
		gbc.gridy = 3;
		gamePanel2.add(weaponLabel, gbc);
		
		oppLabel = new JLabel("Opponent");
		oppLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		oppLabel.setBorder(BorderFactory.createLineBorder(Color.red));
		oppLabel.setForeground(Color.white);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gamePanel2.add(oppLabel, gbc);
		
		JLabel oppCharacter = new JLabel("Karen");
		oppCharacter.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		oppCharacter.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		oppCharacter.setForeground(Color.white);
		gbc.gridx = 2;
		gbc.gridy = 2;
		gamePanel2.add(oppCharacter, gbc);
		
		JLabel oppWeaponLabel = new JLabel("Weapon: Aura of Entitlement");
		oppWeaponLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		oppWeaponLabel.setBorder(BorderFactory.createLineBorder(Color.orange));
		oppWeaponLabel.setForeground(Color.white);
		gbc.weighty = 0;
		gbc.gridx = 2;
		gbc.gridy = 3;
		gamePanel2.add(oppWeaponLabel, gbc);
		
		
		atk1.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.BLUE));
		atk1.setBackground(Color.cyan);
		atk1.setOpaque(true);
		gbc.weighty = 0.01;
		gbc.gridx = 0;
		gbc.gridy = 4;
		gamePanel2.add(atk1, gbc);
		
	
		atk2.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.red));
		atk2.setBackground(Color.magenta);
		atk2.setOpaque(true);
		gbc.weighty = 0.01;
		gbc.gridx = 0;
		gbc.gridy = 5;
		gamePanel2.add(atk2, gbc);

		
		reset.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.WHITE));
		reset.setBackground(Color.WHITE);
		reset.setOpaque(true);
		reset.setVisible(false);
		gbc.weighty = 0.01;
		gbc.gridx = 2;
		gbc.gridy = 4;
		gamePanel2.add(reset, gbc);
		
		winCountLabel = new JLabel("Wins: " + winCount);
		winCountLabel.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.WHITE));
		winCountLabel.setBackground(Color.WHITE);
		winCountLabel.setOpaque(true);
		gbc.weighty = 0.01;
		gbc.gridx = 2;
		gbc.gridy = 5;
		gamePanel2.add(winCountLabel, gbc);
		
		
		saveButton.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.GRAY));
		saveButton.setBackground(Color.WHITE);
		saveButton.setOpaque(true);
		gbc.weighty = 0.01;
		gbc.gridx = 2;
		gbc.gridy = 6;
		gamePanel2.add(saveButton, gbc);
		
		
		attackLog = new JPanel();
		GridBagConstraints gbc2 = new GridBagConstraints();
		attackLog.setLayout(new GridBagLayout());
		attackLog.setBackground(Color.LIGHT_GRAY);
		attackLog.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.WHITE));
		gbc.gridy = 2;
		gbc.gridx = 1;
		gbc.ipady = 10;
		gamePanel2.add(attackLog, gbc);
		
		j1 = new JLabel("Attack!");
		j1.setFont(new Font(Font.MONOSPACED, Font.BOLD | Font.ITALIC, 20));
		gbc2.ipady = 30;
		gbc2.gridy = 2;
		attackLog.add(j1, gbc2);
	
			
		j2 = new JLabel("    ");
		attackLog.add(j2);

		
	}
	
	public void setWinnerBackground()
	{
		gamePanel2.setBackground(Color.green);
		reset.setVisible(true);
		
	}
	
	public void updateWinCount()
	{
		winCountLabel.setText("Wins: " + winCount);
	}
	

	
	public void resetGame()
	{
		gamePanel2.setBackground(Color.black);
		winCount++;
		winCountLabel.setText("Wins: " + winCount);
		reset.setVisible(false);
		
	}
	

	public void gamePanelSetNotVisible()
	{
		add(gamePanel2);
		createPanelTwo();
		gamePanel.setVisible(false);
		gamePanel2.setVisible(true);
	}
	
	
	public void setWeaponName(String name)
	{
		
		weaponName = name;
		
	}
	
	public void addToAttackLog(String text) 
	{
				
		j1.setText(text);
	
	}
	

	public String getName()
	{
		return nameTextField.getText();
	}

	public void addATK1Listener(ActionListener listenATK1)
	{
		atk1.addActionListener(listenATK1);
	}
	
	public void addBrawlerButton(ActionListener brawlButton)
	{
		brawlerButton.addActionListener(brawlButton);
	}
	
	public void addATK2Listener(ActionListener listenATK2) 
	{
		atk2.addActionListener(listenATK2);
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
	
	public void addResetGameButton(ActionListener resetButtonListener)
	{
		reset.addActionListener(resetButtonListener);
	}
	
	public void addSaveGameButton(ActionListener saveButtonListener)
	{
		saveButton.addActionListener(saveButtonListener);
	}
	
	public void errorMessage(String eMessage)
	{
		JOptionPane.showMessageDialog(this, eMessage);
	}
	
	public JTextField getNameField()
	{
		return nameTextField;
	}
	
	public JTextField getWeaponDamageField()
	{
		return weaponDamage;
	}
	


	public void showCharacterHealth(double player1Health, double player2Health)
	{
		youLabel.setText("YOU: " + player1Health);
		oppLabel.setText("OPPONENT: " + player2Health);
		
		
	}

	public void setGamePanel2(Color color)
	{
		gamePanel2.setBackground(color);
	}

	public int getWinCount()
	{
		
		return winCount;
	}

	public Component getGamePanel2()
	{
		// TODO Auto-generated method stub
		return gamePanel2;
	}

	public void setWinCount(int num)
	{
		winCount = num;
		
	}
	
	public String getLoadSaveField()
	{
		return jText.getText();
	}
	

	
}
