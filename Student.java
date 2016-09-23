import java.util.*;


class Student1{

	int regno;
	String name;
	GregorianCalendar date;
	int sem;
	int gpa;
	int cgpa;
	static int count=0;

	Student1(){}
	
	
	Student1(String name,int sem,int gpa,int cgpa,int year,int month,int date1)
	{
		this.name=name;
		count++;
		date=new GregorianCalendar(year,month,date1);
		this.sem=sem;
		this.gpa=gpa;
		this.cgpa=cgpa;
		int x=date.get(Calendar.YEAR);
		x=x%100;
		regno=x*100 + count; 
	}
	
	
	void display()
	{
		System.out.println("Name : " + name + "  Reg. No. : " + regno + "  DOJ : " + date.get(Calendar.YEAR));
		System.out.println("Sem : " + sem +"  GPA : " + gpa + "  CGPA : " + cgpa);
	}
	
	void sortBySem(Student1 s1[])
	{
		int large,j,i;
		Student1 temp;
		for(i=0;i<s1.length;i++)
		{	
			for(j=0;j<i;j++)
			{	
				if(s1[j].sem>s1[j+1].sem)
				{
					temp=s1[j];
					s1[j]=s1[j+1];
					s1[j+1]=temp;
				
				}
			}
		}
		
		for(i=0;i<s1.length;i++)
		{	
			for(j=0;j<i;j++)
			{
				
					if(s1[j].sem==s1[j+1].sem && s1[j].cgpa>s1[j+1].cgpa)
					{
					temp=s1[j];
					s1[j]=s1[j+1];
					s1[j+1]=temp;
				
					}
				
			}
		}
		
		
		for(i=0;i<s1.length;i++)
			s1[i].display();
	}
	
	void sortByName(Student1 s1[])
	{
		int result,j,i;
		
		Student1 temp;
		
		for(i=0;i<s1.length;i++)
		{	
			for(j=0;j<i;j++)
			{	
				result=(s1[j].name).compareTo(s1[j+1].name);
				System.out.println(result);
				if(result>0)
				{
					temp=s1[j];
					s1[j]=s1[j+1];
					s1[j+1]=temp;
				}
				
			}
		}
		
		
		for(i=0;i<s1.length;i++)
			s1[i].display();
	}


void startCharacter(Student1 s1[])
	{
		int large,j,i;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter charater");
		String s=sc.nextLine();

		for(i=0;i<s1.length;i++)
		{
			if (s1[i].name.equals(s)) {
			s1[i].display();	
			}
			
		}
	}	

void subString(Student1 s1[])
	{
		int j,i,result=-1;
		System.out.println("Enter substring");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		for(i=0;i<s1.length;i++)
		{	
			result=(s1[i].name).indexOf(s);
				if (result!=-1) {
			s1[i].display();	
			}
			
		}		
	}

void convert(Student1 s1[])
	{
		int j,i,x;
		String s="";
		String k="";
		String p=" ";

		for(i=0;i<s1.length;i++)
		{	
			s="";

			k=s1[i].name;
			x=k.lastIndexOf(" ");
			s=s + k.charAt(0);
			for(j=0;j<x;j++)
			{
				if (k.charAt(j)==' ') {
					s = s + "." + k.charAt(j+1);
				}
			}
			s=s+".";

			for(j=x;j<k.length();j++)
			{
				s=s + k.charAt(j);
			}

			s1[i].name=s;
			
		}	

		for(i=0;i<s1.length;i++)
			s1[i].display();	
	}

}



	

class Student{

	public static void main(String[] args)
	{

		int i,date,month,year,sem,gpa,cgpa;
		
		Student1 s1[]=new Student1[3];
		
		Scanner sc=new Scanner(System.in);
		
		for(i=0;i<3;i++)
		{	

			System.out.print("Enter date, month, year : ");
			date=sc.nextInt();
			month=sc.nextInt();
			year=sc.nextInt();		
			System.out.print("Enter sem, gpa and cgpa : ");
			sem=sc.nextInt();
			gpa=sc.nextInt();
			cgpa=sc.nextInt();
			sc.nextLine();
			
			
			System.out.print("Enter Name : ");
			String name=sc.nextLine();
			s1[i]=new Student1(name,sem,gpa,sem,year,month,date);
		}
		
		/*for(i=0;i<s1.length;i++)
			s1[i].display();*/
		s1[0].convert(s1);

	}
}
