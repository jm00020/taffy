package taffy;

import java.lang.Runnable;

public class Guest{
	static int Count = 0; //���񽺹��� �մ� ��
	int ServicesTime; //���� �ð�
	int ArrivalTime; //�����ð�
	int Money; // ������ ��
	
	Guest(){
		Count++; //�մ��� ���� �� ������ ����
		ServicesTime = 0;
		ArrivalTime = 0;
		Money = 0;
	}
	
	void SetTime(int stime){ //���� �ð��� ��Ģ�ð� �Է�
		ArrivalTime = Taffy.StartTime; //�����ð� �Է�
		ServicesTime = stime; //���� �ð��Է�
	}
	
	void SetMoney(int money){ //���� �ݾ� �Է�
		Money = money; //���� �ݾ� �Է�
	}
}

class CallGuest extends Guest implements Runnable{
	static int CallCount = 0;
	int CallTime = 0;
	int counttime = 0;
	boolean ArrivalGuest;
	
	CallGuest(){
		CallCount++; //��ȭ �մ� �� ����
		ArrivalGuest = false;
	}
	
	void SetCallTime(int time){ //�������� �ɸ��� �ð� ����
		CallTime = time; //�������� �ɸ��� �ð� ����
	}
	
	public void run() {
		while(true){
			if(counttime == CallTime){ //�����Ͽ����� üũ �� �����Ͽ��ٰ� ��Ÿ��
				ArrivalGuest = true; //������ true�� ��ȯ
				return;
			}
			try{
				Thread.sleep(1000/Taffy.speed);
			}
			catch(InterruptedException e){
				return;
			}
			counttime++;
		}
	}
}
