import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
	
	private static String connectionString = "jdbc:derby://localhost:3301/JBDB;create=true";

	public static void main(String[] args) {
		
	}
			
	public static void buildDb() {
				try {
					Connection connection = DriverManager.getConnection(connectionString);
					
					String sql = "create table Products ("
							+ "id integer not null primary key generated always as identity(start with 1, increment by 1), "
							+ "name varchar(50) not null, " + "price double not null)";
					
					Statement statement = connection.createStatement();
					
					statement.executeUpdate(sql);
					
					System.out.println("Product table has been created.");
				}catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		public static void insert(String name, double price) throws SQLException {

				// Create a connection:
				Connection connection = DriverManager.getConnection(connectionString);

				// Create sql statement:
				String sql = String.format("insert into Products(name, price) values('%s', %.2f)", name, price);

				// Create object which can execute the above sql and return the new id:
				PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

				// Execute (the insert command):
				preparedStatement.executeUpdate();

				// Retrieves any auto-generated keys created as a result of executing this
				// Statement object (returns ResultSet)
				ResultSet resultSet = preparedStatement.getGeneratedKeys();

				resultSet.next();

				int id = resultSet.getInt(1);

				System.out.println("Insert succeeded. New create id: " + id);
			}

			// -------------------------call details from db-----------------------------
		public static void readAll() throws SQLException {

				// Create a connection:
				Connection connection = DriverManager.getConnection(connectionString);
				System.out.println("Connection Succeed");
				
				// Create a statement object which can read data:
				Statement statement = connection.createStatement();
				System.out.println("Object statement created to read data");

				// Create sql statement for reading data:
				String sql = "select * from Products";
				//System.out.println("the sql object was created successfully to read data");

				// Execute the query and return an object which contains the data (the table):
				ResultSet resultSet = statement.executeQuery(sql);
				//System.out.println("The object to return data was created successfully");

				// loop over the rows in the ResultSet
				// next() - Moves the cursor forward one row from its current position - returns
				// true if the new current row is valid; false if there are no more rows
				while (resultSet.next()) {

					int id = resultSet.getInt("id");
					String name = resultSet.getString("name");
					double price = resultSet.getDouble("price");

					System.out.println("id: " + id + ", name: " + name + ", price: " + price);
				}
			
			}
		    public void print (){
		    	 try {
					readAll();
					System.out.println("Read all data succeed");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		     }
			// -------------------------update details from db----------------------------
			public static void update(int id, String name, double price) throws SQLException {

				// Create a connection:
				Connection connection = DriverManager.getConnection(connectionString);

				// Create an update sql statement:
				String sql = String.format("update Products set name='%s', price=%.2f where id=%d", name, price, id);

				// Create an object for executing the above sql:
				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				preparedStatement.executeUpdate();

				System.out.println("Update succeeded.");
			}
	
			// -------------------------delete details from db-----------------------------
			public static void delete(int id) throws SQLException {

				// Create a connection:
				Connection connection = DriverManager.getConnection(connectionString);

				// Create sql command for delete one record:
				String sql = String.format("delete from Products where id=%d", id);

				// Create an object for executing the above command:
				PreparedStatement preparedStatement = connection.prepareStatement(sql);

				// Execute:
				preparedStatement.executeUpdate();

				System.out.println("Delete succeeded.");
			}
         }
  	



