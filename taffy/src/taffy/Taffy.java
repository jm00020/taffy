package taffy;

import java.awt.EventQueue;

public class Taffy  {
	static int PlayTime = 0; //�ùķ��̼� �ð�
	static int DeskNum = 0; //â�� ��
	static int StartTime = 0; //ù ���ۺ��� �ð� ī����
	static int GuestNum = 0; //���մ� ��
	static int CallGuestNum = 0; //��ȭ�մ� ��
	static int speed = 1; //�ù����̼� ���
	static final int MAXGUEST = 100; //���մ� �ִ��
	
	Taffy(){
	}

	public static void main(String [] args){ //GUI����
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}