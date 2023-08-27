package Microsoft;

import java.util.ArrayList;
import java.util.List;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class test2 {

//	public static void main(String[] args) throws FilloException {
	// TODO Auto-generated method stub

	public static List<String> m1() throws FilloException {

		Fillo fillo = new Fillo();

		Connection connection = fillo.getConnection("C:\\Users\\biswa\\eclipse-workspace\\BING30\\kanha30.xlsx");

		String strSelectQuerry = "Select * from Sheet2";

		Recordset recordset = connection.executeQuery(strSelectQuerry);

		String Email = null;
		String Password = null;

		List<String> al = new ArrayList<String>();

		while (recordset.next()) {
			// through getfield() method&nbsp; retrieve the data present in a particular
			// column
			Email = recordset.getField("EMAIL");
			Password = recordset.getField("PASSWORD");
			al.add(Email);
			al.add(Password);
		}

		System.out.println(al.size());
		System.out.println(al);

		recordset.close();
		connection.close();
		return al;
	}

//	}

}
