package util;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;
import java.util.Date;


public class JDBCUtilO {

	/**
	 * 连接数据库，获得数据库连接对象
	 * @return
	 */
	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tqt","root","11");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	/**
	 * 关闭数据库连接
	 * @param rs
	 * @param st
	 * @param con
	 */
	public static void shutConnection(ResultSet rs,Statement st,Connection con){
		try {
			if(rs!=null)
				rs.close();
			if(st!=null)
				st.close();
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通用的查询方法
	 * @param sql
	 * @param params
	 * @return
	 */
	public static List<Object[]> queryObjects(String sql,Object...params){
		List<Object[]> list = new ArrayList<Object[]>();
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			if(null!=params&&params.length>0){
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1, params[i]);
				}
			}
			rs = ps.executeQuery();
			int count = rs.getMetaData().getColumnCount();
			Object[] objects = null;
			while(rs.next()){
				objects = new Object[count];
				for(int i=0;i<count;i++){
					objects[i] = rs.getObject(i+1);
				}
				list.add(objects);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			shutConnection(rs,ps,con);
		}
		return list;
	}
	
	/**
	 * 通用的增删改方法
	 * @param sql
	 * @param params
	 * @return
	 */
	public static boolean DMLOperate(String sql,Object...params){
		boolean b = false;
		Connection con = getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			if(null!=params&&params.length>0){
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1, params[i]);
				}
			}
			ps.execute();
			b = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			shutConnection(null,ps,con);
		}
		return b;
	}
	
	/**
	 * 通用的查询方法，查询并返回实体类的 集合
	 * @param c 要查询的实体类的class对象
	 * @param sql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List queryEntities(Class c,String sql,Object...params){
		List list = new ArrayList();
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			if(null!=params&&params.length>0){
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1, params[i]);
				}
			}
			rs = ps.executeQuery();
			//获得字段组成的数组
			Field[] fields = c.getDeclaredFields();
			ResultSetMetaData rsmd = rs.getMetaData();
			//为object赋值
			int count = rsmd.getColumnCount();
			try {
				while(rs.next()){
					Object o = c.newInstance();
					//获取查询出的列的名称,并为对象的 成员变量赋值
					for(int i=1;i<=count;i++){
						Object value = rs.getObject(i);
						String columnName = rsmd.getColumnName(i);
						//判断数据类型
						String typeName = rsmd.getColumnTypeName(i);
						//若为 日期类型，则将java.sql.date转换成java.util.date
						if(typeName.equalsIgnoreCase("date")){
							value = new Date(((java.sql.Date)value).getTime());
						}
						for(Field field:fields){
							if(columnName.equalsIgnoreCase(field.getName())){
								field.setAccessible(true);  //设置私有属性范围 
								field.set(o, value);
							}
						}
					}
					list.add(o);
				}
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			shutConnection(rs,ps,con);
		}
		return list;
	}
	
	/**
	 * 通用的增加方法
	 * @param c
	 * @param o
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean insertEntityOperate(Class c,Object o,String tableName){
		boolean b = false;
		String values = "";
		String columns = "";
		Connection con = getConnection();
		Field[] fields = c.getDeclaredFields();
		List<Object> params = new ArrayList<Object>();
		try {
			//第一位主键不插入数值
			for(int i=1;i<fields.length;i++){
				fields[i].setAccessible(true);
				String fieldName = fields[i].getName();
				if(fields[i].get(o)!=null){
					if(i==fields.length-1){
						columns+=fieldName;
						values+="?";
					}else{
						columns+=fieldName+",";
						values+="?,";
					}
					params.add(fields[i].get(o));
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		String sql = "insert into "+tableName+" ("+columns+")"+" values ("+values+")";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			for(int i=0;i<params.size();i++){
				ps.setObject(i+1, params.get(i));
			}
			ps.execute();
			b = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
}
