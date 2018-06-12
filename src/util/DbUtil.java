package util;

import java.sql.Connection; //Connection･･･DBMSへの接続や切断を行う
import java.sql.DriverManager; //DriverManager･･･DBMSへの接続準備を行う

public class DbUtil {

	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver"); //ドライバーの読み込み
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/axizdb_web", "axizuser", "axiz");
		} catch (Exception e) {
			// 本来は専用の例外クラスを作成したほうがよい
			throw new RuntimeException(e);
		}
	}

}