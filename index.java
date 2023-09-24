class sun extends Thread //первый поток
{
	@Override
	public void run()
	{
		for(int i = 0; i < 4; i++)
		{
			try{
				sleep(2000);		//Приостанавливает поток на 2 секунды
			}catch(InterruptedException e){}
			
			System.out.println("солнце!");	
		}
	}
}

public class index	//Класс с методом main()
{
	static sun AnotherOpinion;	//Побочный поток
	
	public static void main(String[] args)
	{
		AnotherOpinion = new sun();	//Создание потока
        System.out.println("Какая завтра будет погода?");
		System.out.println("Спор начат...");
		AnotherOpinion.start(); 			//Запуск потока
		
		for(int i = 0; i < 4; i++)
		{
			try{
				Thread.sleep(2000);		//Приостанавливает поток на 2 секунды
			}catch(InterruptedException e){}
			
			System.out.println("дождь!");
		}
		
	
		if(AnotherOpinion.isAlive())	//Если оппонент еще не сказал последнее слово
		{
			try{
				AnotherOpinion.join();	//Подождать пока оппонент закончит высказываться.
			}catch(InterruptedException e){}
			
			System.out.println("Завтра будет солнечно!");
		}
		else	//если оппонент уже закончил высказываться
		{
			System.out.println("Завтра будет дождь!");
		}
		System.out.println("Спор закончен!");	
	}
}