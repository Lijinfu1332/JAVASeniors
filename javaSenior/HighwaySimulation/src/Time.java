 package src;

import UI.MYUI;

public class Time extends Thread{
	private  static int second=3600*8-1800;
	
	private static int XA=0;
	private static int BJ=0;
	private static int b_num;
	
	public Time()
	{
	}
	public void run()//时间线程要做的工作
	{
		
		StartStop XA_StartStop=new StartStop(5,12,"XA");//创建西安车站
		StartStop BJ_StartStop=new StartStop(4,15,"BJ");//创建宝鸡车站
		XA_StartStop.start();
		BJ_StartStop.start();
		
		while(second<=3600*20)
		{
			String text="";
			if(XA==1)//有一辆依维柯到达西安车站
			{
				XA_StartStop.get_yBusList().insert(new Bus(b_num,1,2333,0,"XA",0));
				MYUI.getjpanel().add(XA_StartStop.get_yBusList().get_n().get_button());
				XA=0;
				for(int x=0;x<XA_StartStop.get_yBusList().get_list().size();x++)
				{
					text=text+String.valueOf(XA_StartStop.get_yBusList().get_list().get(x).get_num())+"号 ";
				}
				MYUI.set_jTextPane4(text);
			}
			else 
				if(XA==2)//有一辆沃尔沃到达西安车站
				{
					XA_StartStop.get_wBusList().insert(new Bus(b_num,2,3333,0,"XA",0));
					MYUI.getjpanel().add(XA_StartStop.get_wBusList().get_n().get_button());
					XA=0;
					for(int x=0;x<XA_StartStop.get_wBusList().get_list().size();x++)
					{
						text=text+String.valueOf(XA_StartStop.get_wBusList().get_list().get(x).get_num())+"号 ";
					}
					MYUI.set_jTextPane3(text);
				}
			if(BJ==1)//有一辆依维柯到达宝鸡车站
			{
				BJ_StartStop.get_yBusList().insert(new Bus(b_num,1,2333,0,"BJ",0));
				MYUI.getjpanel().add(BJ_StartStop.get_yBusList().get_n().get_button());
				BJ=0;
				for(int x=0;x<BJ_StartStop.get_yBusList().get_list().size();x++)
				{
					text=text+String.valueOf(BJ_StartStop.get_yBusList().get_list().get(x).get_num())+"号 ";
				}
				MYUI.set_jTextPane2(text);
			}
			else
				if(BJ==2)//有一辆沃尔沃到达宝鸡车站
				{
					BJ_StartStop.get_wBusList().insert(new Bus(b_num,2,3333,0,"BJ",0));
					MYUI.getjpanel().add(BJ_StartStop.get_wBusList().get_n().get_button());
					BJ=0;
					for(int x=0;x<BJ_StartStop.get_wBusList().get_list().size();x++)
					{
						text=text+String.valueOf(BJ_StartStop.get_wBusList().get_list().get(x).get_num())+"号 ";
					}
					MYUI.set_jTextPane1(text);
				}
				
			try
			{
				second++;
				Thread.sleep(10);
				//System.out.println(second);
				MYUI.setJTextField(second);	//在界面上显示时间		
			} catch (InterruptedException e) {  
            e.printStackTrace();  
			}	
		}
	}
	
	public static void set_XA(int i,int b)//车到XA站的标志
	{
		XA=i;
		b_num=b;
	}
	public static void set_BJ(int i,int b)//车到宝鸡站的标志
	{
		BJ=i;
		b_num=b;
	}
	
	public static int getTime()
	{
		return second;
	}
}