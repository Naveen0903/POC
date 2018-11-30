import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;


public class Tester {
	public static void main(String[] args) {
		Connection connection = null;
		DBConnection db = new DBConnection();
		connection = db.getConnection();
		
		String user = null;
		String pass = null;
		Scanner sc = new Scanner(System.in);
		PreparedStatement ps = null;
		ResultSet rs = null;
		int n;
		
		System.out.println("1.admin Login");
		System.out.println("2.Librarian Login");
		System.out.println("3.Student Login");
		
		System.out.println("Enter a option:");
		n=sc.nextInt();
		
		boolean exit = false;
		
		
		while(!exit) {
		switch(n) {
			case 1:
				System.out.println("Welcome : Login to access library");
				System.out.println("Enter user ID: ");
				user = sc.next();
		
				System.out.println("Enter password: ");
				pass = sc.next();
		
				try {
					if (user != null && pass != null) {
						String query ="Select * from admin Where user_name='" + user + "' and password='" + pass + "'";
						ps = connection.prepareStatement(query);
						rs = ps.executeQuery(query);
						if (rs.next()) {
							System.out.println("Welcome "+user);
							admin_prop();
							
						} else {
							System.out.println("Username or password is incorrect");
							
				            }
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
		break;
	case 2:
		System.out.println("Welcome : Login to access library");
		System.out.println("Enter user ID: ");
		user = sc.next();

		System.out.println("Enter password: ");
		pass = sc.next();
		
		try {
			if (user != null && pass != null) {
				String query ="Select * from librarian Where user_name='" + user + "' and passwords='" + pass + "'";
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery(query);
				if (rs.next()) {
					System.out.println("------Welcome "+user+ "------");
					lib_prop();
					
				} else {
					System.out.println("Username or password is incorrect");
							
		            }
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		break;
		
	case 3:
		System.out.println("Welcome : Login to access library");
		System.out.println("Enter user ID: ");
		user = sc.next();

		System.out.println("Enter password: ");
		pass = sc.next();

		try {
			if (user != null && pass != null) {
				String query ="Select * from students Where user_name='" + user + "' and passwords='" + pass + "'";
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery(query);
				if (rs.next()) {
					System.out.println("------Welcome "+user+" ------");
					
				} else {
					System.out.println("Username or password is incorrect");
							
		            }
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		
	default:
	
		System.out.println("Please select a valid option");
		}

		}
		sc.close();
	}
	
	
	
	public static void admin_prop() {
		Connection connection = null;
		DBConnection db = new DBConnection();
		connection = db.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);

		System.out.println("1.Add librarian");
		System.out.println("2.Delete librarian");
		System.out.println("3.view librarians");
		System.out.println("4.Add student");
		System.out.println("5.Delete students");
		System.out.println("6.view students");
		System.out.println("7.Add books");
		System.out.println("8.delete books");
		System.out.println("9.view books");
		System.out.println("10.edit profile");
		
		System.out.println("enter an option");
		int n = sc.nextInt();
		
		switch(n) {
		case 1:
			
			try {
				System.out.println("------Enter the libaraian details------");
				System.out.println("Enter the librarian name: ");
				String lname = sc.next();
				System.out.println("enter the user name: ");
				String user=sc.next();
				System.out.println("enter the password: ");
				String pass = sc.next();
				
				
				String stmt = "insert into librarian(lname,user_name,passwords) values('" + lname + "','" + user + "','" + pass +"')";
				ps = connection.prepareStatement(stmt);
				ps.executeUpdate(stmt);
				
				System.out.println("Librarian " + lname + " Added Succesfully");
				break;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 2:
			System.out.println("Enter the librarian slno to delete: ");
			int lno = sc.nextInt();
			
			String query = "Delete from librarian where slno ="+ lno;
			try {
				ps = connection.prepareStatement(query);
				ps.executeUpdate(query);
				System.out.println("librarian with "+lno+" deleted");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 3:
			
			String query1 = "select * from librarian";
			try {
				ps = connection.prepareStatement(query1);
				rs = ps.executeQuery(query1);
				ResultSetMetaData rsmd = rs.getMetaData();
				int columns = rsmd.getColumnCount();
				
				while(rs.next()) {
					for(int i=1;i<columns;i++) {
						System.out.printf(rs.getString(i)+"\t");
					}
					System.out.println();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 4:
			try {
				System.out.println("------Enter the Student details------");
				System.out.println("Enter the student name: ");
				String sname = sc.next();
				System.out.println("enter the student username: ");
				String user=sc.next();
				System.out.println("enter the student password: ");
				String pass = sc.next();
				
				
				String stmt = "insert into students(sname,user_name,passwords) values('" + sname + "','" + user + "','" + pass +"')";
				ps = connection.prepareStatement(stmt);
				ps.executeUpdate(stmt);
				
				System.out.println("student " + sname + " Added Succesfully");
				break;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		case 5:System.out.println("Enter the librarian slno to delete: ");
			int sno = sc.nextInt();
		
			String query2 = "Delete from students where slno ="+sno;
		try {
			ps = connection.prepareStatement(query2);
			rs = ps.executeQuery(query2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
		
			
		case 6:
			String query3 = "select * from students";
			try {
				ps = connection.prepareStatement(query3);
				rs = ps.executeQuery(query3);
				ResultSetMetaData rsmd = rs.getMetaData();
				int columns = rsmd.getColumnCount();
				
				while(rs.next()) {
					for(int i=1;i<columns;i++) {
						System.out.printf(rs.getString(i)+"\t");
					}
					System.out.println();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 7:
			try {
				System.out.println("------Enter the book details------");
				System.out.println("Enter the book serial number: ");
				String bno = sc.next();
				System.out.println("enter the book name: ");
				String bname=sc.next();
				
				
				String stmt = "insert into books(sl_no,bname) values('" + bno + "','" + bname+"')";
				ps = connection.prepareStatement(stmt);
				ps.executeUpdate(stmt);
				
				System.out.println("book " + bname + " Added Succesfully");
				break;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case 8:
			System.out.println("Enter the book slno to delete: ");
			int bno = sc.nextInt();
		
			String query4 = "Delete from books where slno ="+bno;
		try {
			ps = connection.prepareStatement(query4);
			rs = ps.executeQuery(query4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			break;
			
		case 9:
			String query5 = "select * from books";
			try {
				ps = connection.prepareStatement(query5);
				rs = ps.executeQuery(query5);
				ResultSetMetaData rsmd = rs.getMetaData();
				int columns = rsmd.getColumnCount();
				
				while(rs.next()) {
					for(int i=1;i<columns;i++) {
						System.out.printf(rs.getString(i)+"\t");
					}
					System.out.println();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		}
		
	}
	
	public static void lib_prop() {
		Connection connection = null;
		DBConnection db = new DBConnection();
		connection = db.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1.Book Issue");
		System.out.println("2.Book Renewal");
		
		System.out.println("Enter a option:");
		int n=sc.nextInt();
		
		boolean exit = false;
		Integer book_id = null,student_id = null;
		
		while (!exit) {
		switch(n) {
		case 1:
			
			System.out.println("Enter book ID: ");
			book_id = sc.nextInt();
			System.out.println("Enter student ID: ");
			student_id = sc.nextInt();
				
			try {
				if (book_id != null && student_id != null) {
					String query ="insert into issue_renew (sl_no,slno,issue_date,return_date) values ('" 
				+ book_id + "','" 
									+ student_id + "', curdate() , curdate() + interval 15 day)";
					ps = connection.prepareStatement(query);
					rs = ps.executeQuery(query);
					if (rs.next()) {
						System.out.println("Book Issued");
						break;
					}
					else {
						System.out.println("Book not issued");
						break;		
				     }
				}
			} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
			}
			
			exit = true;
	
			break;
			
		case 2: 
			
			System.out.println("Enter book ID: ");
			book_id = sc.nextInt();
			System.out.println("Enter student ID: ");
			student_id = sc.nextInt();
				
			try {
				if (book_id != null && student_id != null) {
					String query ="update issue_renew set extention = 'YES', extended_date = return_date + interval 15 day where sl_no = '" + book_id + "' and slno = '" + student_id + "'";
					ps = connection.prepareStatement(query);
					rs = ps.executeQuery(query);
					if (rs.next()) {
						System.out.println("Book Renewed");
						break;
					}
					else {
						System.out.println("Book not Renewed");
						break;		
				     }
				}
			} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
			}
	
			exit = true;
			
			break;
				
			default:
				System.out.println("Enter a valid option");
		}
		return;
			}
		sc.close();	
	}
	
	
}