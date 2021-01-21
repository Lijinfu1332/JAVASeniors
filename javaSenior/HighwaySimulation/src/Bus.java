  package src;

import java.awt.Color;
import java.awt.Rectangle;
import UI.MYUI;
import javax.swing.JButton;

public class Bus implements Runnable{
	private int num;//���ı��
	private int type;//1��ʾ��ά�£�2��ʾ�ֶ���
	private int speed;//����(����/��)
	private String from="";//ʼ��վ
	private int length;//����ʻ�ľ��� ����
	private int passengerNum;//���ϳ˿���
	private int destination[];//����;��վ�³�������
	private int map[];//����;��վ�ľ���  ����
	private JButton jbutton;//ͼ�ν��棬����ͳ�
	Bus(int n,int t,int s,int p,String f,int l)
	{
		jbutton=new JButton();
		num=n;
		type=t;
		speed=s;
		passengerNum=p;
		from=f;
		length=l;
		jbutton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {//���С����ʾС������Ϣ	
				MYUI.setjTextPane(String.valueOf(num)+"�ų�"+"��ʣ"+String.valueOf(passengerNum)+"��");
			}
		});
		if(f.equals("XA"))//�����������ĸ�վ·��
		{
			map=new int [6];
			map[0]=2200000;
			map[1]=4600000;
			map[2]=6700000;
			map[3]=12900000;
			map[4]=15000000;
			map[5]=17400000;
		}
		else//������������վ��·��
		{
			map=new int [6];
			map[5]=17400000;
			map[4]=15200000;
			map[3]=12800000;
			map[2]=10700000;
			map[1]=4500000;
			map[0]=2400000;
		}	
	}
	public void run()
	{
		int i=0;//��¼���˼�վ
		while(length<17400000)//һֱ����֪����ʻ���볬��������������·��
		{
			if(from.equals("BJ"))//�ڽ�������ʾ�����ĳ�������̬��ʾ����λ��
			{
				if(type==1)//�ڽ�������ʾ��ά�£���ɫ����
				{
					jbutton.setBounds(new Rectangle(length/25000+20, 140, 20, 10));	
					jbutton.setBackground(Color.blue);
				}
				else
					if(type==2)//�ڽ�������ʾ�ֶ��֣���ɫ����
					{
						jbutton.setBounds(new Rectangle(length/25000+20, 120, 20, 10));
					}
			}
			else
				if(from.equals("XA"))
				{
					if(type==1)//�ڽ�������ʾ��ά�£���ɫ����
					{
						jbutton.setBounds(new Rectangle(726-length/25000, 220, 20, 10));
						jbutton.setBackground(Color.blue);
					}
					else
						if(type==2)//�ڽ�������ʾ�ֶ��֣���ɫ����
						{
							jbutton.setBounds(new Rectangle(726-length/25000, 240, 20, 10));
						}
				}

			length=length+speed;//����ʻ��·��
			if((length-map[i])>=0&&(length-map[i])<=speed)//��վ
			{
				//���м�վ
				if(destination[i]!=0&&i!=5)//����Ҫ����;վ�³�
				{
					passengerNum=passengerNum-destination[i];//�˿��³�
					try {
						Thread.sleep(1200);//ͣ������
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//else
					if(i==5)
					{
						jbutton.setVisible(false);//�ó���ʧ
						//�����յ�վ
						if(from.equals("XA"))//֪ͨ������վ�г�����
						{
							if(type==1)
							{
								Time.set_BJ(1,num);
							}
							else
								if(type==2)
								{
									Time.set_BJ(2,num);
								}
							
						}
						else
							if(from.equals("BJ"))//֪ͨ������վ�г�����
							{
								if(type==1)
								{
									Time.set_XA(1,num);
								}
								else
									if(type==2)
									{
										Time.set_XA(2,num);
									}
							}
						passengerNum=0;//�˿�ȫ���³�
					}
				i++;
			}
			else
			{
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public JButton get_button()
	{
		return jbutton;
	}
	public void GetOn(int Num,int des[])//�ϳ�
	{
		passengerNum=Num;//���ϳ˿͵�����
		destination=des;//��;��վ�³�������
	}
	public void GetDown(int i)//�³�
	{
		passengerNum=passengerNum-destination[i];//���ϳ˿͵�����
	}
	public int get_num()
	{
		return num;
	}
	public int get_type()
	{
		return type;
	}
	public double get_speed()
	{
		return speed;
	}
	public String get_from()
	{
		return from;
	}
	public double get_length()
	{
		return length;
	}
	public int get_passengerNum()
	{
		return passengerNum;
	}
	public int[] get_destination()
	{
		return destination;
	}
	public int[] get_map()
	{
		return map;
	}
}
