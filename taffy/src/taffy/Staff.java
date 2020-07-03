package taffy;

import java.lang.Runnable;

public class Staff implements Runnable {
	boolean Working; //���ϴ� ������ ����
	int ServicesTime; //���� �ð�
	int StaffStartTime; //���� ���� �ð�(�ð��� ������ ���� ����)

	Staff(){
		Working = false;
		ServicesTime = 0;
		StaffStartTime = 0;
	}
	void SetStaff(int time){ //���ϴ� ���̶�� ����, �մԿ��� ���� �ð��� �޾ƿ�
		this.Working = true; //���ϴ� ���̸� true
		this.ServicesTime = time; //�մԿ��� ���񽺽ð��� �޾� �Է�
	}
	void StopStaff(){ //���� ���� �ʱ�ȭ
		this.Working = false; //���� �� false
		this.StaffStartTime = 0; //�� �ð� 0���� �ʱ�ȭ
		this.ServicesTime = 0;
	}
	public void run(){
		while(true){
			if(StaffStartTime == ServicesTime){ //���񽺽ð��� ���� ����ð��� ������ �ʱ�ȭ
				StopStaff();
				return;
			}
			try{
				Thread.sleep(1000/Taffy.speed);
			}
			catch(InterruptedException e){
				StopStaff();
				return;
			}
			StaffStartTime++;
		}
	}
}

