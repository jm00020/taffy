package taffy;

public class Check {
	int TNum; //���� �ð� ����
	int money; //���� �ݾ� ����
	static Thread [] stf = new Thread[Taffy.DeskNum]; //������ ���񽺽����� ���� ������
	static Thread [] cguest  = new Thread[Taffy.MAXGUEST]; //��ȭ �մ� ������ ���� ������
	Check(){
		TNum = 0;
		money = 0;
	}
	boolean SetGuest(){ //�մ� ���� ���� �߻�
		int Guestcheck;
		Guestcheck = (int)(Math.random()*4+1); //1~4�� ���� �߻�
		if(Guestcheck == 4) //4�̸� �մ� ����
			return true;
		else
			return false;
	}
	boolean SetCallGuest(){ //��ȭ �մ� ���� ���� �߻�
		int CallGuestcheck;
		CallGuestcheck = (int)(Math.random()*10+1); //1~10�� ���� �߻�
		if(CallGuestcheck == 10) //10�̸� ��ȭ �մ� ����
			return true;
		else 
			return false;
	}
	void AddGuest(){ //�մ��� ���մԹ迭�� ����
		if(SetGuest()){
			if(Taffy.GuestNum == Taffy.MAXGUEST) //�ִ� �մ� ���� �ʰ��Ͽ����� Ȯ�� �� �ʰ��� ��� ����
				return;
			Services.guest[Taffy.GuestNum] = new Guest(); //�ֱ�ȭ
			Services.guest[Taffy.GuestNum].SetTime(SetTime()); //���� �ð� ���� �߻�
			Services.guest[Taffy.GuestNum].SetMoney(SetMoney()); //���� �ݾ� ���� �߻�
			Taffy.GuestNum++; //���մ� �� ����
		}
	}
	void AddCallGuest(){ //��ȭ �մ��� ������ �����ϰ� ������ ����
		if(SetCallGuest()){
			if(Taffy.CallGuestNum == Taffy.MAXGUEST) //�ִ� �մ� ���� �ʰ��Ͽ����� Ȯ�� �� �ʰ��� ��� ����
				return;
			Services.callguest[Taffy.CallGuestNum] = new CallGuest(); //�ʱ�ȭ
			Services.callguest[Taffy.CallGuestNum].SetCallTime(SetTime()); //����ð� �ʱ�ȭ
			Services.callguest[Taffy.CallGuestNum].SetTime(SetTime()); //���� �ð� �ʱ�ȭ
			Services.callguest[Taffy.CallGuestNum].SetMoney(SetMoney()); //���� �ݾ� �ʱ�ȭ
			cguest[Taffy.CallGuestNum] = new Thread(Services.callguest[Taffy.CallGuestNum]);
			cguest[Taffy.CallGuestNum].start(); //����ð����� ������ ����
			Taffy.CallGuestNum++; //��ȭ�մԼ� ����
		}
	}
	void ArrvialGuest(){ //��ȭ �մ� ������ ���� ���մԹ迭�� �߰�
		for(int i = 0; i < Taffy.CallGuestNum; i ++){
			if(Services.callguest[i].ArrivalGuest == true){ //��ȭ �մ��� �����Ͽ����� Ȯ��
				if(Taffy.GuestNum >= Taffy.MAXGUEST-1) //��⿭�� �� á���� ����
					return;
				for(int j = Taffy.GuestNum; j > 0; j--){ //�տ��� ���� �� ĭ�� �ڷ� �̵�
					Services.guest[j] = Services.guest[j-1];
				} 
				Services.guest[0] = new Guest(); //�ʱ�ȭ
				Services.guest[0].ArrivalTime = Services.callguest[i].ArrivalTime + Services.callguest[i].CallTime; //�����ð� �Է�
				Services.guest[0].Money = Services.callguest[i].Money; //���� �ݾ� �Է�
				Services.guest[0].ServicesTime = Services.callguest[i].ServicesTime; //���� �ð� �Է�
				Taffy.GuestNum++; //���մ� �� ����
				Taffy.CallGuestNum--; //��ȭ �մ� �� ����
			}
		}
	}
	void WorkingStaff(){ //�������� ���� �ϰ� �ִ��� üũ�ϰ� �մ� ��ġ
		if(Taffy.GuestNum > 0 )
			for(int i = 0; i < Taffy.DeskNum; i++){
				if(Services.staff[i].Working == false){ //�������� ���� �ϰ� �ִ��� üũ
					Services.staff[i].SetStaff(Services.guest[0].ServicesTime); // ���񽺽ð� �Է�, ���ϴ� ������ ����
					stf[i] = new Thread(Services.staff[i]);
					stf[i].start(); //������ �� ����
					Statistics.DelayTime = Taffy.PlayTime-Services.guest[0].ArrivalTime; //���ð� �Է�
					Statistics.GPlayTime += Services.guest[0].ServicesTime; //���� �ð� �Է�
					Statistics.GetMoney += Services.guest[0].Money; //���� �ݾ� �Է�
					for(int j = 0; j < Taffy.GuestNum-1; j++) //������ ��ĭ�� ����
						Services.guest[j] = Services.guest[j+1];
					Taffy.GuestNum--; //�մԼ� ����
					if(Taffy.GuestNum == 0) //��� �մ��� ������ Ż��
						break;
				}
			}
			
	}
	int SetTime(){ //���� �ð� ���� �߻�
		TNum = (int)(Math.random()*10+1); //1~10���� �߻�
		return TNum;
	}
	int SetMoney(){ //���� �ݾ� ���� �߻�
		money = (int)(Math.random()*10+1)*1000; //1~10�� ������ �߻��� 1000�� ����
		return money;
	}
	boolean EndServices(int endtime, int cometime){ //�� �ð��� ���� �� ��
		if(endtime == cometime)
			return true;
		else
			return false;
	}
}
