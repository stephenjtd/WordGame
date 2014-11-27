package com.stephendoyle.ocja.wordgame;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Button;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class WordGameApp extends JFrame {

	private JPanel contentPane;
	ArrayList<Character> letters = new ArrayList<Character>();
	
	private String word;
	private String wordlabel;
	private int score = 0;
	private JTextField textField;
	JLabel lblWord = new JLabel();
	JLabel lblSetscore = new JLabel("0");
	JLabel lblAlphabet = new JLabel("alphabet");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WordGameApp frame = new WordGameApp();
					frame.setVisible(true);
					//word = JOptionPane.showInputDialog("Enter a secret word or phrase: ");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//main
	
	public void list(){
		ArrayList<Character> cl = new ArrayList<Character>();
		//fill arraylist;
		for (char c = 'A'; c < '['; ++c){
			cl.add(new Character(c));
			
		}
		this.letters=cl;
		lblAlphabet.setText(letters+"");
	}//list
	
	public void word(){
		String wordlabel = "";
		for(int i = 0; i < word.length(); i++){
			if (word.charAt(i)==' ')
				wordlabel += " ";
			else
				wordlabel += "-";
		}

		this.wordlabel = wordlabel;
		lblWord.setText(wordlabel);
	}//word
	
	public void guessLetter(String s){
		//String wordlabel="";
		//wordlabel = this.wordlabel;
		String wordlabel2="";
		boolean guessed = false;
		
		int count = 0;
		//while(b){

		char letter = s.charAt(0);
		//char letterU = (s.toUpperCase()).charAt(0);
		Character letterU = new Character((s.toUpperCase()).charAt(0));
		
		if(letters.contains(letterU)){
			letters.remove(letterU);
			lblAlphabet.setText(letters+"");

		}
		else{
			JOptionPane.showMessageDialog(null, "That letter has already been entered.");
			guessed = true;
		}
		
			for(int i = 0; i < word.length(); i++){
			//if guess is correct
				if((letter == word.charAt(i))&&(guessed==false)){
					wordlabel2 += letter;
					score+=1;
					lblSetscore.setText(score+"");
				}
				else if((wordlabel.charAt(i) != '-')||(wordlabel.charAt(i) != ' '))
					wordlabel2 += wordlabel.charAt(i);
				else if(wordlabel.charAt(i) == '-')
					wordlabel2 += '-';
				else if(wordlabel.charAt(i) == ' ')
					wordlabel2 += ' ';

				//lblWord.setText(letter+"");
				//count++;
			
			}
		//if (count==s.length())
			//break;
		//}//while
		lblWord.setText(wordlabel2);
		this.wordlabel = wordlabel2;
		
		if (score==word.length())
			JOptionPane.showMessageDialog(null, "Congratulations!  You win!");

	}//game

	/**
	 * Create the frame.
	 */
	public WordGameApp() {
		list();
		lblWord.setText(wordlabel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGuessALetter = new JLabel("Guess a letter: ");
		lblGuessALetter.setBounds(10, 75, 102, 14);
		contentPane.add(lblGuessALetter);
		
		textField = new JTextField();
		textField.setBounds(211, 72, 45, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnOk_1 = new JButton("OK");
		btnOk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = textField.getText();
				guessLetter(s);
				textField.setText("");
			}
		});
		btnOk_1.setBounds(313, 73, 89, 23);
		contentPane.add(btnOk_1);
		
		lblWord.setBounds(10, 114, 191, 14);
		contentPane.add(lblWord);
		
		JLabel lblScore = new JLabel("Score");
		lblScore.setBounds(211, 114, 46, 14);
		contentPane.add(lblScore);
		
		lblSetscore.setBounds(313, 114, 46, 14);
		contentPane.add(lblSetscore);
		
		JButton btnReset = new JButton("Start/Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//reset so new game can be played
				word = JOptionPane.showInputDialog("Enter a secret word or phrase: ");
				score = 0;
				lblSetscore.setText(score+"");
				word();
				list();
			}
		});
		btnReset.setBounds(10, 11, 102, 23);
		contentPane.add(btnReset);
		
		lblAlphabet.setBounds(10, 237, 392, 14);
		contentPane.add(lblAlphabet);
	}
}
