package common_ref;

import java.sql.*;


import common.BookSequence;
import common.InventorySequence;
import common.IssueId;
import common.Studentid;

public class Table {
	
	public static void main(String[] args) {
		call_me();
		System.out.println("all tables and columns created");
	}
	public static void call_me() {
		Connection connection = null;
		DBConnection db = new DBConnection();
		connection = db.getConnection();
		Statement st = null;

		try {
			st = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		BookSequence obj_Sequence_Book_Id = new BookSequence();
		obj_Sequence_Book_Id.create_table();

		InventorySequence obj_Sequence_inventry_Id = new InventorySequence();
		obj_Sequence_inventry_Id.create_table();

		Studentid obj_Sequence_Student_Id = new Studentid();
		obj_Sequence_Student_Id.create_table();

		try {
			st.execute("create table admin(" + "sl_no int(255) auto_increment," + "user_name varchar(100) not null,"
					+ "password varchar(100) not null," + "primary key(sl_no))");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			st.execute("insert into admin(user_name,password) values('admin','admin@123')");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			st.execute(
					"create table publisher(" + "sl_no int(255) auto_increment," + "publisher_name varchar(300) not null,"
							+ "profile varchar(100)," + "added_on varchar(100)," + "primary key(sl_no))");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			st.execute("create table author(" + "sl_no int(255) auto_increment," + "author_name varchar(300) not null,"
					+ "profile varchar(100)," + "added_on varchar(100)," + "primary key(sl_no))");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			st.execute("create table category(" + "sl_no int(255) auto_increment,"
					+ "category_name varchar(300) not null unique," + "profile varchar(100)," + "added_on varchar(100),"
					+ "primary key(sl_no))");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			st.execute("create table student_table(" + "student_id varchar(300) unique not null,"
					+ "admission_no varchar(300) unique not null," + "student_name varchar(300) not null,"
					+ "profile varchar(300)," + "grade varchar(300)," + "section varchar(300)," + "added_by varchar(300),"
					+ "added_on varchar(300)," + "status int(1) not null," + "primary key(student_id))");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			st.execute("create table book_table(" + "book_sl_no varchar(300) not null,"
					+ "book_title varchar(300) unique not null," + "category_name varchar(300),"
					+ "category_num varchar(10)," + "author_name varchar(300)," + "author_num varchar(10),"
					+ "publisher_name varchar(300)," + "publisher_num varchar(10)," + "edition varchar(100),"
					+ "volume varchar(100)," + "ean_code varchar(300)," + "isbn varchar(300)," + "price varchar(300),"
					+ "purchase_date varchar(300)," + "language varchar(300)," + "total_book_in_library int(255),"
					+ "total_book_available int(255)," + "description varchar(10000)," + "added_on varchar(100),"
					+ "edited_on varchar(100)," + "added_by varchar(100)," + "edited_by varchar(100),"
					+ "primary key(book_sl_no))");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			st.execute("create table inventry_table(" + "sl_no varchar(300) not null," + "book_sl_no varchar(300) not null,"
					+ "book_title varchar(500) not null," + "count int(255) not null," + "added_on varchar(100) not null,"
					+ "added_by varchar(100),"
					+ "primary key(sl_no),FOREIGN KEY (book_sl_no) REFERENCES book_table(book_sl_no))");
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		try {
			st.execute("create table serial_number(" + "sl_no int(255) auto_increment,"
					+ "invertry_sl_no varchar(300) not null," + "book_title varchar(500),"
					+ "book_sl_no varchar(300) not null," + "bar_code varchar(300) unique not null,"
					+ "book_status varchar(300) not null," + "added_on varchar(100) not null,"
					+ "description varchar(3000)," + "shelf varchar(300)," + "rack varchar(300)," + "primary key(sl_no))");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			st.execute("create table last_inventry(" + "sl_no int(255) auto_increment," + "bar_code int(255) not null,"
					+ "book_sl_no varchar(500)," +

					"primary key(sl_no))");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		IssueId obj_Sequence_Issue_Id = new IssueId();
		obj_Sequence_Issue_Id.create_table();

		try {
			st.execute("create table issue_book(" + "issue_sl_no varchar(50) not null unique,"
					+ "student_id varchar(300) not null," + "admission_no varchar(300) not null,"
					+ "student_name varchar(300) not null," + "book_title varchar(500) not null,"
					+ "book_sl_no varchar(100) not null," + "barcode varchar(300) not null,"
					+ "issue_date varchar(300) not null," + "renew_date1 varchar(300)," + "renew_date2 varchar(300),"
					+ "renew_date3 varchar(300)," + "renew_date4 varchar(300)," + "renew_date5 varchar(300),"
					+ "return_date varchar(300)," + "returned_date varchar(300)," + "status varchar(300) not null,"
					+ "description varchar(3000)," +"primary key(issue_sl_no))");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
