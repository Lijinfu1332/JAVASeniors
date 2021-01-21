 package src;

import java.util.LinkedList;
import java.util.Random;
import UI.MYUI;

public class PassengerList extends Thread{
	public LinkedList<Passenger> passengerlist;
	private String from;//乘客的出发站
	PassengerList(String from)
	{
		this.from=from;
		passengerlist=new LinkedList<Passenger>();
	}
	public void product()//产生乘客
	{
		int i=new Random().nextInt(2);
		for(int j=0;j<i;j++)
		{
			int des=5;
			switch(new Random().nextInt(6))//随即产生一个乘客的目的地
			{
			case 0: des=0;break;
			case 1: des=1;break;
			case 2: des=2;break;
			case 3: des=3;break;
			case 4: des=4;break;
			case 5: des=5;break;
			}
			passengerlist.add(new Passenger(des));//将产生的乘客加入等待队列
		}
		if(from.equals("XA"))
		{
			MYUI.set_jfied1(passengerlist.size());//显示西安站乘客的数量
		}
		else
			MYUI.set_jfied2(passengerlist.size());//显示宝鸡站乘客的数量
	}
	
	public int[] consume(int i)//让i个人上车，若排队的人少于i则全部上车
	{
		int []des=new int[6];//沿途各站下车的人数
		if(passengerlist.size()>=i)//等车的乘客大于出发车的容量
		{
			for(int j=0;j<i;j++)//计算车在每一站下车的人数
			{
				int d=passengerlist.poll().get_destination();
				if(d==0)
				{
					des[0]++;
				}
				else
					if(d==1)
					{
						des[1]++;
					}
					else 
						if(d==2)
						{
							des[2]++;
						}
						else 
							if(d==3)
							{
								des[3]++;								
							}
							else
								if(d==4)
								{
									des[4]++;
								}
								else
									if(d==5)
									{
										des[5]++;
									}
			}
		}
		else
			if(passengerlist.size()<i&&passengerlist.size()>0)
			{
				int a=passengerlist.size();
				for(int j=0;j<a;j++)
				{
					int d=passengerlist.poll().get_destination();
					if(d==0)
					{
						des[0]++;
					}
					else
						if(d==1)
						{
							des[1]++;
						}
						else 
							if(d==2)
							{
								des[2]++;
							}
							else 
								if(d==3)
								{
									des[3]++;								
								}
								else
									if(d==4)
									{
										des[4]++;
									}
									else
										if(d==5)
										{
											des[5]++;
										}
				}
			}
			else
				if(passengerlist.size()==0)
				{
	
				}
		if(from.equals("XA"))//显示车站的乘客数量
		{
			MYUI.set_jfied1(passengerlist.size());
		}
		else
			MYUI.set_jfied2(passengerlist.size());
		return des;
	}
	public void run()
	{
		while(Time.getTime()<3600*18)//在下午6点之前一直产生乘客
		{
			product();//产生乘客		
			try {
				Thread.sleep(300);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
