import java.sql.*;


public class MySQLDemo {

    private static Connection conn;
    private static Statement stmt;

    static {
        //加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "hazel");
            //创建Statement对象
            stmt = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteOne(int id) throws SQLException {
        String sql = "delete from user where id=" + id;
        int result = stmt.executeUpdate(sql);
        if (result > 0) {
            System.out.println("删除成功");
        }
    }

    public static void updateOne(int age, int id) throws SQLException {
        String sql = "update user set age=" + age + " where id=" + id;
        int result = stmt.executeUpdate(sql);
        if (result > 0) {
            System.out.println("修改成功");
        }
    }

    public static void insertOne(int id, String name, int age) throws SQLException {
        String sql = "insert into user(id,name,age) values(" + id + ", '" + name + "', " + age + ")";
        int result = stmt.executeUpdate(sql);
        if (result > 0) {
            System.out.println("添加成功");
        }
    }


    public static void queryById(int id) throws SQLException {
        String queryAllSql = "select * from user where id=" + id;
        ResultSet rs = stmt.executeQuery(queryAllSql);
        boolean isMatch = false;
        while (rs.next()) {
            isMatch = true;
            System.out.println("id: " + rs.getInt("id")
                    + " name: " + rs.getString("name")
                    + " age: " + rs.getInt("age"));
        }
        if (!isMatch) {
            System.out.println("数据查询为空");
        }
    }

    public static void queryAllUser() throws SQLException {
        String sql = "select * from user";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println("id: " + rs.getInt("id")
                    + " name: " + rs.getString("name")
                    + " age: " + rs.getInt("age"));
        }
    }

    public static void main(String[] args) throws SQLException {
        queryAllUser();
        insertOne(4, "user4", 20);
        queryById(4);
        updateOne(33, 4);
        queryById(4);
        deleteOne(4);
        queryById(4);
    }
}
