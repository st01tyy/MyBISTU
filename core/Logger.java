package core;

import function.DataFunction;

public class Logger implements Runnable
{
	private String id;
	private String pw;
	
	public Logger(String id, String pw)
	{
		this.id = id;
		this.pw = pw;
	}
	@Override
	public void run() 
	{
		DataFunction.login(id, pw);
	}

}
