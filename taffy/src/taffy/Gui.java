package taffy;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Gui extends JFrame {

	private JPanel contentPane;
	private JTextField input_desknum;
	private JTextField input_playtime;
	static boolean exitcheck = true;

	public Gui() {
		setTitle("\uD0DC\uD53C \uC0C1\uC810 \uC2DC\uBBAC\uB808\uC774\uC158");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel menu = new JPanel();
		menu.setBackground(new Color(224, 255, 255));
		menu.setBounds(0, 0, 434, 262);
		contentPane.add(menu);
		menu.setLayout(null);
		
		JPanel set_menu = new JPanel();
		set_menu.setBackground(new Color(224, 255, 255));
		set_menu.setBounds(0, 0, 434, 262);
		set_menu.setLayout(null);
		
		JLabel meun_title = new JLabel("\uD0DC\uD53C \uC0C1\uC810 \uC2DC\uBBAC\uB808\uC774\uC158");
		meun_title.setFont(new Font("ÇÔÃÊ·Òµ¸¿ò", Font.PLAIN, 40));
		meun_title.setHorizontalAlignment(SwingConstants.CENTER);
		meun_title.setBounds(11, 10, 410, 68);
		menu.add(meun_title);
		
		JButton set = new JButton("\uC2DC\uBBAC\uB808\uC774\uC158 \uC2DC\uC791");
		set.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				contentPane.add(set_menu);
				menu.setVisible(false);
				set_menu.setVisible(true);
			}
		});
		set.setBounds(150, 100, 133, 23);
		menu.add(set);
		
		JButton statis = new JButton("\uD1B5   \uACC4");
		statis.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				double AvrDeltime = 0;
				double AvrSertime = 0; 
				double AvrDeskNum = 0;
				double AvrPlayTime = 0;
				double AvrGuestNum = 0;
				double AvrGetMoney = 0;
				if(Statistics.TotalCount != 0){
					AvrDeskNum = (double)Statistics.TotalDeskNum/Statistics.TotalCount;
					AvrDeltime = (double)Statistics.TotalDelayTime/Statistics.TotalCount;
					AvrSertime = (double)Statistics.TotalGPlayTime/Statistics.TotalCount;
					AvrGuestNum = (double)Statistics.TotalGuestNum/Statistics.TotalCount;
					AvrPlayTime = (double)Statistics.TotalPlayTime/Statistics.TotalCount;
					AvrGetMoney = (double)Statistics.TotalGetMoney/Statistics.TotalCount;
				}
				JPanel totalstatis_menu = new JPanel();
				totalstatis_menu.setBackground(new Color(224, 255, 255));
				totalstatis_menu.setBounds(0, 0, 434, 262);
				totalstatis_menu.setLayout(null);
				
				JLabel totalcount = new JLabel("½Ã¹Ä·¹ÀÌ¼Ç È½¼ö : " + Integer.toString(Statistics.TotalCount));
				JLabel totaldesk = new JLabel("Ã¢±¸ ¼ö : " + Double.toString(AvrDeskNum));
				JLabel totaltime = new JLabel("½Ã¹Ä·¹ÀÌ¼Ç ½Ã°£ : " + Double.toString(AvrPlayTime) + "ºÐ");
				JLabel totalguest = new JLabel("ÃÑ ¼Õ´Ô ¼ö : " + Double.toString(AvrGuestNum) + "¸í");
				JLabel totalgetmoney = new JLabel("Æò±Õ ¼öÀÔ : " + Double.toString(AvrGetMoney) + "¿ø");
				JLabel avrdelaytime = new JLabel("¼Õ´Ô Æò±Õ ´ë±â ½Ã°£ : " + Double.toString(AvrDeltime) + "ºÐ");
				JLabel avrservicestime = new JLabel("¼Õ´Ô Æò±Õ ¼­ºñ½º ½Ã°£ : " + Double.toString(AvrSertime) + "ºÐ");
				totalcount.setBounds(115, 80, 200, 30);
				totaldesk.setBounds(115, 100, 200, 30);
				totaltime.setBounds(115, 120, 200, 30);
				totalguest.setBounds(115, 140, 200, 30);
				totalgetmoney.setBounds(115, 160, 200, 30);
				avrdelaytime.setBounds(115, 180, 200, 30);
				avrservicestime.setBounds(115, 200, 200, 30);
				totalstatis_menu.add(totalcount);
				totalstatis_menu.add(totaldesk);
				totalstatis_menu.add(totaltime);
				totalstatis_menu.add(totalguest);
				totalstatis_menu.add(totalgetmoney);
				totalstatis_menu.add(avrdelaytime);
				totalstatis_menu.add(avrservicestime);
				
				JLabel statis_title = new JLabel("\uD1B5   \uACC4");
				statis_title.setFont(new Font("ÇÔÃÊ·Òµ¸¿ò", Font.PLAIN, 40));
				statis_title.setHorizontalAlignment(SwingConstants.CENTER);
				statis_title.setBounds(11, 10, 410, 68);
				totalstatis_menu.add(statis_title);
				
				JButton statis_back = new JButton("\uB4A4   \uB85C");
				statis_back.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						contentPane.remove(totalstatis_menu);
						set_menu.setVisible(false);
						menu.setVisible(true);
					}
				});
				statis_back.setBounds(325, 229, 97, 23);
				totalstatis_menu.add(statis_back);
				
				contentPane.add(totalstatis_menu);
				
				menu.setVisible(false);
				totalstatis_menu.setVisible(true);
				set_menu.setVisible(false);
			}
		});
		statis.setBounds(150, 150, 133, 23);
		menu.add(statis);
		
		JButton exit = new JButton("\uC885   \uB8CC");
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		exit.setBounds(150, 200, 133, 23);
		menu.add(exit);
		
		JLabel set_title = new JLabel("\uC2DC\uBBAC\uB808\uC774\uC158 \uC124\uC815");
		set_title.setHorizontalAlignment(SwingConstants.CENTER);
		set_title.setFont(new Font("ÇÔÃÊ·Òµ¸¿ò", Font.PLAIN, 40));
		set_title.setBounds(11, 10, 410, 68);
		set_menu.add(set_title);
		
		JButton set_back = new JButton("\uB4A4   \uB85C");
		set_back.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				set_menu.setVisible(false);
				menu.setVisible(true);
			}
		});
		set_back.setBounds(12, 229, 97, 23);
		set_menu.add(set_back);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uC77C", "\uC2DC\uAC04", "\uBD84"}));
		comboBox.setBounds(312, 133, 57, 21);
		set_menu.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"X60", "X600"}));
		comboBox_1.setBounds(224, 162, 57, 21);
		set_menu.add(comboBox_1);
		
		JButton set_start = new JButton("\uC2DC   \uC791");
		set_start.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try{
				int index = comboBox.getSelectedIndex();
				int index2 = comboBox_1.getSelectedIndex();
				Statistics.DelayTime = 0;
				Statistics.GPlayTime = 0;
				Taffy.StartTime = 0;
				Taffy.DeskNum = Integer.parseInt(input_desknum.getText());
				if(index == 0 )
					Taffy.PlayTime = Integer.parseInt(input_playtime.getText())*480;
				else if(index == 1)
					Taffy.PlayTime = Integer.parseInt(input_playtime.getText())*60;
				else
					Taffy.PlayTime = Integer.parseInt(input_playtime.getText());
				if(Taffy.PlayTime < 0)
					throw new NegativeArraySizeException();
				if(index2 == 0)
					Taffy.speed = 1;
				else
					Taffy.speed = 10;
				JPanel play_menu = new JPanel();
				play_menu.setBackground(new Color(224, 255, 255));
				play_menu.setBounds(0, 0, 434, 262);
				play_menu.setLayout(null);
				
				JLabel [] DeskName = new JLabel [Taffy.DeskNum];
				JLabel [] Stime = new JLabel [Taffy.DeskNum];
				JLabel [] Gstand = new JLabel[Taffy.DeskNum];
				JPanel scroll = new JPanel();
				scroll.setLayout(new GridLayout(Taffy.DeskNum, 2));
				for(int i =0; i < Taffy.DeskNum; i++){
					
					DeskName[i] = new JLabel("Ã¢±¸" + Integer.toString(i+1));
					Stime[i] = new JLabel("¼­ºñ½º½Ã°£:0ºÐ");
					Gstand[i] = new JLabel("¼Õ´Ô À¯¹Â:X");
					scroll.add(DeskName[i]);
					scroll.add(Stime[i]);
					scroll.add(Gstand[i]);
				}
				JScrollPane pane = new JScrollPane();
				pane.setBounds(12,36,300,177);
				pane.setViewportView(scroll);
				
				JLabel GuestNum = new JLabel("¼Õ´Ô ¼ö : 0 ");
				GuestNum.setHorizontalAlignment(SwingConstants.CENTER);
				GuestNum.setBounds(320, 50, 100, 15);
				play_menu.add(GuestNum);
				
				JLabel CallGuestNum = new JLabel("ÀüÈ­ ¼Õ´Ô ¼ö : 0");
				CallGuestNum.setHorizontalAlignment(SwingConstants.CENTER);
				CallGuestNum.setBounds(320, 70, 100, 15);
				play_menu.add(CallGuestNum);
				
				JTextPane EndMessage = new JTextPane();
				EndMessage.setText("½Ã¹Ä·¹ÀÌ¼ÇÀÌ     ½ÇÇà Áß ÀÔ´Ï´Ù.");
				EndMessage.setBackground(new Color(224,255,255));
				EndMessage.setFont(new Font("ÇÔÃÊ·Òµ¸¿ò", Font.BOLD, 12));
				EndMessage.setBounds(320, 100, 100, 45);
				play_menu.add(EndMessage);
				
				JLabel desk_label = new JLabel("\uCC3D   \uAD6C");
				desk_label.setHorizontalAlignment(SwingConstants.CENTER);
				desk_label.setBounds(35, 11, 235, 15);
				play_menu.add(desk_label);

				contentPane.add(pane);
				contentPane.add(play_menu);
				
				JButton play_statis = new JButton("Åë   °è");
				play_statis.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						input_desknum.setText("");
						input_playtime.setText("");
						contentPane.remove(play_menu);
						contentPane.remove(pane);
						
						menu.setVisible(true);
						set_menu.setVisible(false);
						play_menu.setVisible(false);
						
						double AvrDeltime = 0;
						double AvrSertime = 0; 
						if(Guest.Count != 0){
							AvrDeltime = (double)Statistics.DelayTime/Guest.Count;
							AvrSertime = (double)Statistics.GPlayTime/Guest.Count;
						}
						JPanel statis_menu = new JPanel();
						statis_menu.setBackground(new Color(224, 255, 255));
						statis_menu.setBounds(0, 0, 434, 262);
						statis_menu.setLayout(null);
						
						JLabel totaldesk = new JLabel("Ã¢±¸ ¼ö : " + Integer.toString(Taffy.DeskNum));
						JLabel totaltime = new JLabel("½Ã¹Ä·¹ÀÌ¼Ç ½Ã°£ : " + Integer.toString(Taffy.PlayTime) +"ºÐ");
						JLabel totalguest = new JLabel("ÃÑ ¼Õ´Ô ¼ö : " + Integer.toString(Guest.Count) +"¸í");
						JLabel getmoney = new JLabel("ÃÑ ¼öÀÔ : " + Integer.toString(Statistics.GetMoney) + "¿ø");
						JLabel avrdelaytime = new JLabel("¼Õ´Ô Æò±Õ ´ë±â ½Ã°£: " + Double.toString(AvrDeltime) + "ºÐ");
						JLabel avrservicestime = new JLabel("¼Õ´Ô Æò±Õ ¼­ºñ½º ½Ã°£ : " + Double.toString(AvrSertime) + "ºÐ");
						totaldesk.setBounds(115, 90, 200, 30);
						totaltime.setBounds(115, 110, 200, 30);
						totalguest.setBounds(115, 130, 200, 30);
						getmoney.setBounds(115, 150, 200, 30);
						avrdelaytime.setBounds(115, 170, 200, 30);
						avrservicestime.setBounds(115, 190, 200, 30);
						statis_menu.add(totaldesk);
						statis_menu.add(totaltime);
						statis_menu.add(totalguest);
						statis_menu.add(getmoney);
						statis_menu.add(avrdelaytime);
						statis_menu.add(avrservicestime);
						
						JLabel statis_title = new JLabel("\uD1B5   \uACC4");
						statis_title.setFont(new Font("ÇÔÃÊ·Òµ¸¿ò", Font.PLAIN, 40));
						statis_title.setHorizontalAlignment(SwingConstants.CENTER);
						statis_title.setBounds(11, 10, 410, 68);
						statis_menu.add(statis_title);
						
						Statistics.TotalPlayTime += Taffy.PlayTime;
						Statistics.TotalDeskNum += Taffy.DeskNum;
						Statistics.TotalGuestNum += Guest.Count;
						Statistics.TotalDelayTime += AvrDeltime;
						Statistics.TotalGPlayTime += AvrSertime;
						Statistics.TotalCount++;
						
						JButton statis_back = new JButton("\uB4A4   \uB85C");
						statis_back.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent e) {					
								Guest.Count = 0;
								contentPane.remove(statis_menu);
								
								set_menu.setVisible(false);
								menu.setVisible(true);
							}
						});
						statis_back.setBounds(325, 229, 97, 23);
						statis_menu.add(statis_back);
						
						contentPane.add(statis_menu);
						
						menu.setVisible(false);
						statis_menu.setVisible(true);
						set_menu.setVisible(false);
					}
				});
				play_statis.setBounds(325, 199, 97, 23);
				play_statis.setVisible(false);
				play_menu.add(play_statis);
				
				Services ser = new Services(GuestNum, Stime, Gstand, EndMessage, play_statis, CallGuestNum);
				Thread startser = new Thread(ser);
				startser.start(); //½Ã¹Ä·¹ÀÌ¼Ç ½ÃÀÛ
				
				JButton play_exit = new JButton("\uC885   \uB8CC");
				play_exit.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						
						new Exitcheck();
						if(exitcheck == true){
							input_desknum.setText("");
							input_playtime.setText("");
							contentPane.remove(play_menu);
							contentPane.remove(pane);
												
							if(Taffy.StartTime != Taffy.PlayTime){
								startser.interrupt();
								Guest.Count = 0;
								Taffy.DeskNum = 0;
								Taffy.PlayTime = 0;
								Taffy.StartTime = 0;
							}
							
							menu.setVisible(true);
							set_menu.setVisible(false);
							play_menu.setVisible(false);
						}
					}
				});
				play_exit.setBounds(325, 229, 97, 23);
				play_menu.add(play_exit);

				menu.setVisible(false);
				set_menu.setVisible(false);
				play_menu.setVisible(true);
				}
				catch(IllegalArgumentException e1){
					new Setcheck();
				}
				catch(NegativeArraySizeException e2){
					new Negativecheck();
				}
			}
		});
		set_start.setBounds(325, 229, 97, 23);
		set_menu.add(set_start);
		
		JLabel set_desknum = new JLabel("\uCC3D\uAD6C \uC218 : ");
		set_desknum.setBounds(115, 108, 57, 15);
		set_menu.add(set_desknum);
		
		JLabel set_time = new JLabel("\uC2DC\uBBAC\uB808\uC774\uC158 \uC2DC\uAC04 : ");
		set_time.setBounds(115, 136, 106, 15);
		set_menu.add(set_time);
		
		input_desknum = new JTextField();
		input_desknum.setBounds(224, 105, 87, 21);
		set_menu.add(input_desknum);
		input_desknum.setColumns(10);
		
		input_playtime = new JTextField();
		input_playtime.setBounds(224, 133, 87, 21);
		set_menu.add(input_playtime);
		input_playtime.setColumns(10);
		
		JLabel set_speed = new JLabel("\uC2DC\uBBAC\uB808\uC774\uC158 \uBC30\uC18D : ");
		set_speed.setBounds(115, 165, 106, 15);
		set_menu.add(set_speed);
	}
}