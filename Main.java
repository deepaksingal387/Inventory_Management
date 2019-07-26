import java.util.*;
import java.io.*;
public class Main {
	
	
	public static void AddItem() throws IOException
	{
		System.out.println("----------------------------");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Item Name : ");
		String name = sc.next();
		System.out.println("Enter Item ID : ");
		int id = sc.nextInt();
		System.out.println("Enter Item Category : ");
		String category = sc.next();
		System.out.println("Enter Item Wholesaler Name : ");
		String wholesaler = sc.next();
		System.out.println("Enter Item Date of Purchase : ");
		String dop = sc.next();
		System.out.println("Enter Item Stock Purchased : ");
		int stock = sc.nextInt();
		System.out.println("Enter Item Purchasing Cost : ");
		float cp = sc.nextFloat();
		System.out.println("Enter Item Expiry Date : ");
		String expiry = sc.next();
		System.out.println("Enter Item Selling Cost : ");
		float sp = sc.nextFloat();
		
		
		
		Item newitem = new Item(name,id,category,sp,expiry,wholesaler,dop,stock,cp);
		
		FileOutputStream fout = new FileOutputStream("Stock.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(newitem);
		oos.close();
		fout.close();
		
		System.out.println("Item Added Successfully....");
		
	}
	
	public static void ViewStock() throws IOException, ClassNotFoundException
	{
		System.out.println("----------------------------");
		try {
		FileInputStream fis = new FileInputStream("Stock.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Item obj = (Item)ois.readObject();
		System.out.println(obj);
		ois.close();
		fis.close();
		}catch(IOException e)
		{
			System.out.println("Stock file does not exist");
			return;
		}
		
	}
	
	
	public static void SearchItem() throws IOException, ClassNotFoundException
	{	System.out.println("----------------------------");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Item ID:");
		int searchid = sc.nextInt();
		try
		{
			FileInputStream fis = new FileInputStream("Stock.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Item obj = (Item)ois.readObject();
		ois.close();
		fis.close();
		if(searchid==obj.getItemId())
		{
			System.out.println(obj);
		}
		else
		{
			System.out.println("Item not found!!!");
		}
		
		}catch(IOException e)
		{
			System.out.println("Stock file does not exist");
			return;
		}
		
	}
	
	
	public static void Admin() throws IOException, ClassNotFoundException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("----------------------------");
		
		int ch;
		
		System.out.println("1: Add Item");
		System.out.println("2: View Stock");
		System.out.println("3: Search Item");
		System.out.println("0: Exit");
		
		choice : while(true){
			System.out.print("Enter Choice : ");
		ch = sc.nextInt();
		switch(ch)
		{
		case 1: AddItem();
		continue choice;
		case 2: ViewStock();
		continue choice;
		case 3: SearchItem();
		continue choice;
		default: System.exit(0);
		}
		}
		
		
	}
	
	
	public static void Login() throws IOException, ClassNotFoundException
	{	
		String username,password;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter UserName:");
		username = sc.next();
		Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }

        char passwordArray[] = console.readPassword("Enter password: ");
        password = new String(passwordArray);
        
		 
		
		try
		{
		FileInputStream fis = new FileInputStream("User.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		User obj = (User)ois.readObject();
		ois.close();
		fis.close();
		if(obj.getUsername().equals(username)&&obj.getPassword().equals(password))
		{
			System.out.println("Login Successful..");
			Admin();
		}
		else 
		{
			System.out.println("Invalid Credentials");
			return;
		}
		}catch(IOException e)
		{
			System.out.println("User file does not exist");
			return;
		}
		
		
	}
	
	
	public static void AddUser() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		String username,password,confirmpassword;
		System.out.println("Enter Username:");
		username = sc.next();
		System.out.println("Enter Password:");
		password = sc.next();
		System.out.println("Confirm Password:");
		confirmpassword = sc.next();
		 
		if(password.equals(confirmpassword))
		{
			User addusr = new User(username,password);
			FileOutputStream fout = new FileOutputStream("User.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(addusr);
			oos.close();
			fout.close();
			System.out.println("User added successfully");
		}
		else 
		{
			System.out.println("Password mismatch");
		}
		return;
		
		
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int ch;
		System.out.println("----------------------------");
		System.out.println("1: Login");
		System.out.println("2: Add User");
		System.out.println("0: Exit");
		
		input : while(true)
		{
		System.out.print("Enter Choice : ");
		ch = sc.nextInt();
		switch(ch)
		{
		case 1: Login();
		continue input;
		case 2: AddUser();
		continue input;
		default: System.exit(0);
		}
		}
		
	 
	}

}
