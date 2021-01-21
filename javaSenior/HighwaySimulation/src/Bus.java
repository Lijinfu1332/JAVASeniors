  package src;

import java.awt.Color;
import java.awt.Rectangle;
import UI.MYUI;
import javax.swing.JButton;

public class Bus implements Runnable{
	private int num;//车的编号
	private int type;//1表示依维柯，2表示沃尔沃
	private int speed;//车速(厘米/秒)
	private String from="";//始发站
	private int length;//车行驶的距离 厘米
	private int passengerNum;//车上乘客数
	private int destination[];//到沿途各站下车的人数
	private int map[];//到沿途各站的距离  厘米
	private JButton jbutton;//图形界面，代表客车
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
			public void mouseClicked(java.awt.event.MouseEvent e) {//点击小车显示小车的信息	
				MYUI.setjTextPane(String.valueOf(num)+"号车"+"还剩"+String.valueOf(passengerNum)+"人");
			}
		});
		if(f.equals("XA"))//西安到宝鸡的各站路程
		{
			map=new int [6];
			map[0]=2200000;
			map[1]=4600000;
			map[2]=6700000;
			map[3]=12900000;
			map[4]=15000000;
			map[5]=17400000;
		}
		else//宝鸡到西安各站的路程
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
		int i=0;//记录到了几站
		while(length<17400000)//一直运行知道行驶距离超过西安到宝鸡总路程
		{
			if(from.equals("BJ"))//在界面上显示出发的车，并动态显示车的位置
			{
				if(type==1)//在界面上显示依维柯，蓝色矩形
				{
					jbutton.setBounds(new Rectangle(length/25000+20, 140, 20, 10));	
					jbutton.setBackground(Color.blue);
				}
				else
					if(type==2)//在界面上显示沃尔沃，白色矩形
					{
						jbutton.setBounds(new Rectangle(length/25000+20, 120, 20, 10));
					}
			}
			else
				if(from.equals("XA"))
				{
					if(type==1)//在界面上显示依维柯，蓝色矩形
					{
						jbutton.setBounds(new Rectangle(726-length/25000, 220, 20, 10));
						jbutton.setBackground(Color.blue);
					}
					else
						if(type==2)//在界面上显示沃尔沃，白色矩形
						{
							jbutton.setBounds(new Rectangle(726-length/25000, 240, 20, 10));
						}
				}

			length=length+speed;//车行驶的路程
			if((length-map[i])>=0&&(length-map[i])<=speed)//到站
			{
				//到中间站
				if(destination[i]!=0&&i!=5)//有人要在中途站下车
				{
					passengerNum=passengerNum-destination[i];//乘客下车
					try {
						Thread.sleep(1200);//停车两秒
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//else
					if(i==5)
					{
						jbutton.setVisible(false);//让车消失
						//到达终点站
						if(from.equals("XA"))//通知宝鸡车站有车到了
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
							if(from.equals("BJ"))//通知西安车站有车到了
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
						passengerNum=0;//乘客全部下车
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
	public void GetOn(int Num,int des[])//上车
	{
		passengerNum=Num;//车上乘客的数量
		destination=des;//沿途各站下车的人数
	}
	public void GetDown(int i)//下车
	{
		passengerNum=passengerNum-destination[i];//车上乘客的数量
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
