

public class Test {
	
	public static void main (String []args ) {

		try {
              //command to java recognize the derby driver
			//driver is the mechanism to implement the data
			
			Class.forName("org.apache.derby.jdbc.ClientDriver");

			ConnectionDB.buildDb();
			System.out.println("DataBase connection  succeed"
					+ "************************************");
///////////////to insert data in in DB/////


		try {
              //command to java recognize the derby driver
			//driver is the mechanism to implement the data
			
			Class.forName("org.apache.derby.jdbc.ClientDriver");

			ConnectionDB.buildDb();
			System.out.println("DataBase connection  succeed"
					+ "************************************");
///////////////to insert data in in DB/////
			ConnectionDB.insert("Pen", 2.5);
			ConnectionDB.insert("Pencil", 1.2);
			ConnectionDB.insert("Notebook", 3);
			ConnectionDB.insert("Book", 88);
			ConnectionDB.insert("books", 20.0);
			//System.out.println("Insert action succeed");
			
//////////////to update data in DB ////////////////	
			ConnectionDB.update(1, "Green Pen", 2.7);
			//System.out.println("Update succeed");
			
///////////////to delete from DB ///////////////////
			ConnectionDB.delete(5);
			ConnectionDB.delete(700);
			//System.out.println("Delete succeed");

			ConnectionDB.readAll();
			
			
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
          System.out.print("Action succeed:  The data was added");
          {
}
            ConnectionDB.insert("Pen", 2.5);
            ConnectionDB.insert("Pencil", 1.2);
            ConnectionDB.insert("Notebook", 3);
            ConnectionDB.insert("Book", 88);
            ConnectionDB.insert("books", 20.0);
			//System.out.println("Insert action succeed");
			
//////////////to update data in DB ////////////////	
            ConnectionDB.update(1, "Green Pen", 2.7);
			//System.out.println("Update succeed");
			
///////////////to delete from DB ///////////////////
            ConnectionDB.delete(5);
            ConnectionDB.delete(700);
			//System.out.println("Delete succeed");

            ConnectionDB.readAll();
			
			
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
          System.out.print("Action succeed:  The data was added");
	}
}

	
