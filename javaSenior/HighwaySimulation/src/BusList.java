 package src;

import java.util.LinkedList;
 
public class BusList  {
	private LinkedList<Bus> buslist;
	BusList()
	{
		buslist=new LinkedList<Bus>();
	}
	public void insert(Bus b)//插入一辆车
	{
		buslist.add(b);
	}
	public Bus delete()//删掉一辆车
	{
		return buslist.poll();
	}
	public Bus getfirst()//得到队列中的第一辆车
	{
		return buslist.getFirst();
	}
	public Bus get_n() //得到队列中的最后一辆车
	{
		return buslist.getLast() ;
	}
	public LinkedList<Bus> get_list() //得到车队列
	{
		return buslist;
	}
}
