 package src;

import UI.MYUI;

public class StartStop extends Thread {
	private int W_NUM;//车站里沃尔沃的数量
	private static int bus_num=0;//汽车的编号
	private int Y_NUM;//车站里依维柯的数量
	private BusList w_list;//车站里沃尔沃车的列表
	private BusList y_list;//车站里依维柯车的列表
	private BusList list_going;//正在路上的车的列表
	private PassengerList passengerlist;//乘客列表
	private String name;//车站的名字
	
	StartStop(int w,int y,String from)//初始化车站车列表
	{
		name=from;
		passengerlist=new PassengerList(from);//初始化车站排队的旅客
		w_list=new BusList();
		y_list=new BusList();
		list_going=new BusList();
		W_NUM=w;//车站里沃尔沃的数量
		Y_NUM=y;//车站里依维柯的数量
		for(int i=0;i<W_NUM;i++)
		{
			w_list.insert(new Bus(bus_num++,2,3333,0,from,0));//初始化沃尔沃列表	
			MYUI.getjpanel().add(w_list.get_n().get_button());//将车的图标添加到界面上
		}
		for(int i=0;i<Y_NUM;i++)
		{
			y_list.insert(new Bus(bus_num++,1,2333,0,from,0));//初始依维柯沃列表
			MYUI.getjpanel().add(y_list.get_n().get_button());;//将车的图标添加到界面上
		}
		
	}
	public void fache_W()//发沃尔沃
	{
		if(w_list.get_list().size()>0)//车站有车时发车
		{
			String text="";
			//System.out.println("沃尔沃");
			int []num=new int[5];
			list_going.insert(w_list.delete());//将沃尔沃列表中的车放到正在跑的车的队列中
			num=passengerlist.consume(40);//沿途车站下车的人数，将顾客列表中的乘客取出一部分
			int i=0;
			i=num[0]+num[1]+num[2]+num[3]+num[4]+num[5];//上车的人数		
			list_going.get_n().GetOn(i, num);//将取出的乘客放进车里（上车）
			new Thread(list_going.get_n()).start();//启动bus线程
			for(int x=0;x<w_list.get_list().size();x++)//显示车站里的沃尔沃车的信息
			{
				text=text+String.valueOf(w_list.get_list().get(x).get_num())+"号 ";
			}
			if(name.equals("BJ"))
			{
				MYUI.set_jTextPane1(text);
			}
			else
				MYUI.set_jTextPane3(text);
		}
		else
		{
			//System.out.println("没有沃尔沃了");
		}
	}
	public void fache_Y()//发依维柯
	{
		if(y_list.get_list().size()>0)
		{
			String text="";
			//System.out.println("发依维柯");
			int []num=new int[6];
			list_going.insert(y_list.delete());//将依维柯列表中的车放到正在跑的车的队列中
			num=passengerlist.consume(21);//沿途车站下车的人数，将顾客列表中的乘客取出一部分
			int i=0;
			i=num[0]+num[1]+num[2]+num[3]+num[4]+num[5];//上车的人数
			list_going.get_n().GetOn(i, num);//将取出的乘客放进车里（上车）
			new Thread(list_going.get_n()).start();//启动bus线程
			for(int x=0;x<y_list.get_list().size();x++)//显示车站中依维柯的信息
			{
				text=text+String.valueOf(y_list.get_list().get(x).get_num())+"号 ";
			}
			if(name.equals("BJ"))
			{
				MYUI.set_jTextPane2(text);
			}
			else
				MYUI.set_jTextPane4(text);
		}
		else
		{
			//System.out.println("没有依维柯了");
		}
	}
	public PassengerList getPassengerList()
	{
		return passengerlist;
	}
	public BusList get_yBusList()
	{
		return y_list;
	}
	public BusList get_wBusList()
	{
		return w_list;
	}
	public void run()
	{
		int j=0;
		passengerlist.start();//使乘客列表工作,一直产生乘客

		while(Time.getTime()<3600*8)//8点之前不发车
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		while(Time.getTime()<3600*18)//8点开始发车
		{
			fache_Y();//发依维柯
			while(Time.getTime()<3600*(8+j)+1200)//隔20分钟发依维柯
			{
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			fache_Y();//发依维柯
			while(Time.getTime()>=3600*(8+j)+1200&&Time.getTime()<3600*(8+j)+1800)
			{//在第二辆依维柯之后10分钟发沃尔沃
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			fache_W();//发沃尔沃
			while(Time.getTime()<3600*(8+j)+2400&&Time.getTime()>=3600*(8+j)+1800)
			{//再发沃尔沃以后10分钟发依维柯
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			fache_Y();//发依维柯
			while(Time.getTime()>=3600*(8+j)+2400&&Time.getTime()<3600*(8+j)+3600)
			{//再隔20分钟发依维柯
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			j++;
		}
		fache_Y();//发依维柯
	}

}
