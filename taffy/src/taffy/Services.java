package taffy;
import java.lang.Runnable;
import javax.swing.*;

public class Services extends JFrame implements Runnable{
	JLabel GuestNum;
	JLabel CallGuestNum;
	JLabel [] Stime;
	JLabel [] Gstand;
	JTextPane EndMessage;
	JButton play_statis; // ��Ȳ�� ���� ������ �ٲٱ� ���� �͵�
	static Guest [] guest; //�մ� ��� �迭 ����
	static Staff [] staff; //������ �迭 ����
	static CallGuest [] callguest; //��ȯ �մ� �迭 ����
	Services(){}
	Services(JLabel GuestNum, JLabel [] Stime, JLabel [] Gstand, JTextPane EndMessage, JButton play_statis, JLabel CallGuestNum){
		this.GuestNum = GuestNum;
		this.Stime = Stime;
		this.Gstand = Gstand;
		this.EndMessage = EndMessage;
		this.play_statis = play_statis;
		this.CallGuestNum = CallGuestNum;
	}
	void GuestCount(){ //�ð������� ���� ��ȭ
		GuestNum.setText("�մ� �� :  " + Integer.toString(Taffy.GuestNum));
		CallGuestNum.setText("��ȭ �մ� �� : " + Integer.toString(Taffy.CallGuestNum)); //�ð������� ���� ��ȭ
	}
	void DeskSet(){ //�ð������� ���� ��ȭ
		for(int i =0; i < Taffy.DeskNum; i++){
			if(staff[i].Working == true){
				Stime[i].setText("���� �ð�:" + Integer.toString(staff[i].ServicesTime) + "��");
				Gstand[i].setText("�մ� ����:O");
			}
			else{
				Stime[i].setText("���� �ð�:0��");
				Gstand[i].setText("�մ� ����:X");
			}
		}
	}

	public void run(){
		guest = new Guest [Taffy.MAXGUEST]; //�ִ� ���մ� ����ŭ ����
		staff = new Staff [Taffy.DeskNum]; //�Է¹��� â�� �� ��ŭ ����
		callguest = new CallGuest [Taffy.MAXGUEST];//�ִ� ���մ� ����ŭ ����
		Check check = new Check(); 
		for(int i = 0; i < Taffy.DeskNum; i++)
			staff[i] = new Staff(); //������ �迭 �ʱ�ȭ
		while(true){
			if(check.EndServices(Taffy.StartTime, Taffy.PlayTime)){ //�ùķ��̼ǽð��� ���� �ð��� ���������� ����
				EndMessage.setText("�ùķ��̼���    ���� �Ͽ����ϴ�.");
				play_statis.setVisible(true);
				Taffy.GuestNum = 0;
				Taffy.CallGuestNum = 0;
				return ;
			}
			check.AddGuest(); //�մ� ���� ���� �߻� �� �մ� ���� 
			check.AddCallGuest();//��ȭ �մ� ���� ���� �߻� �� �մ� ����
			check.ArrvialGuest();//��ȭ �մ� �����Ͽ����� Ȯ�� �� ���մ� �迭�� �߰�
			GuestCount(); //�մ� �� ����
			check.WorkingStaff(); //���� �ִ� �������� �ִ��� Ȯ�� �� �մ� ��ġ
			DeskSet(); //â���� ���� ����
			GuestCount();
			try{
				Thread.sleep(1000/Taffy.speed); //��ӿ� ���� �ӵ� ����
			}
			catch(InterruptedException e){ //�ù����̼� �� ���� ���� �� 
				for(int i = 0; i < Taffy.DeskNum; i++){
					Check.stf[i].interrupt();
				}
				for(int i = 0; i < Taffy.DeskNum; i++){
					Check.cguest[i].interrupt();
				}
				Taffy.GuestNum = 0;
				Taffy.CallGuestNum = 0;
				return;
			}
			Taffy.StartTime++; //����ð��� ��� ���� ��Ŵ
		}
	}
}

