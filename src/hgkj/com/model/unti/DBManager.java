package hgkj.com.model.unti;

import java.sql.*;

public class DBManager {
    private static  final String driver="com.mysql.jdbc.Driver";
    private static  final String url="jdbc:mysql://localhost:3306/travlesweb?characterEncoding=utf-8";
    private static  final String user="root";
    private static  final String password="123456";
    public static Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName(driver);
            connection= DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
    public static boolean executeUpdate(String sql,Object[] objects){
        boolean flag=false;
        Connection connection=getConnection();
        PreparedStatement statement=null;
        try {
            statement=connection.prepareStatement(sql);
            for(int i=0;i<objects.length;i++){
                statement.setObject(i+1,objects[i]);
            }
            int rows=statement.executeUpdate();
            if(rows>0){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection,statement);
        }
        return flag;
    }
    /**
     * 执行增删改之后关闭对象
     * @param connection
     * @param statement
     */
    public static void closeAll(Connection connection, Statement statement){
        try {
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 执行查询之后关闭对象
     * @param connection
     * @param statement
     * @param resultSet
     */
    public static void closeAll(Connection connection,Statement statement,ResultSet resultSet){
        try {
            if(resultSet!=null){
                resultSet.close();
            }
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
