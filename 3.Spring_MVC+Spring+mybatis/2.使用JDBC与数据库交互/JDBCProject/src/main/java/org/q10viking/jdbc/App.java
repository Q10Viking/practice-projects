package org.q10viking.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			//1.加载数据驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.通过驱动管理类获取数据库连接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			//3.定义sql语句？表示占位符
			String sql = "SELECT * from mybatis where username=?";
			//4.获得预处理statement
			preparedStatement = connection.prepareStatement(sql);
			
			//5.设置参数，第一个参数为sql语句中参数的序号(从1开始)，第二个参数为设置的参数值
			preparedStatement.setString(1, "张三");
			//6.向数据库发出sql执行查询，查询出结果集
			resultSet=preparedStatement.executeQuery();
			//7.遍历结果集
			while(resultSet.next()) {
				System.out.println(resultSet.getString("id")+" "
									+ resultSet.getString("username")+" "
									+ resultSet.getString("birthday")+" "
									+ resultSet.getString("sex")+" "
									+ resultSet.getString("address"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			//释放资源
			if(resultSet!=null) {
				try {
					resultSet.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				resultSet=null;
			}
			
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				preparedStatement=null;
			}
			
			if(connection!=null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				connection=null;
			}
			
		}
	}
}
/*
10 张三 2014-07-10 1 北京市
*/