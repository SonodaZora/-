import java.sql.*;

class Connect {
    int amount;
    public int getAmount() {
        return amount;
    }

    double price;
    public double getPrice() {
        return price;
    }

    public Connect(String sql, int type) {
        Statement statement = null;
        Connection connect = null;
        try {
            //获取连接
            String url = "jdbc:mysql://localhost:3306/java?useSSL=false";
            String user = "root";
            String password = "SonodaZora";
            connect = DriverManager.getConnection(url, user, password);

            //获取操作对象
            statement = connect.createStatement();

            //查询
            if (type!=1){
                //执行操作
                ResultSet resultSet = statement.executeQuery(sql);

                //查询书本
                if (type==0){
                    checkBook(resultSet);
                }

                //查询销售
                else if (type==2) {
                    checkSale(resultSet);
                }

                //查询库存
                else if (type==3) {
                    checkAmount(resultSet);
                }
            }

            //插入、修改、删除
            else {
                statement.execute(sql);
            }

        }
        //捕捉异常
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //断开连接
        finally {
            if (statement != null)
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (connect != null)
                try {
                    connect.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    private void checkBook(ResultSet resultSet) throws SQLException {
        boolean next = resultSet.next();
        System.out.println();
        if (!next){
            System.out.println("未查询到相关数据，请检查输入后重新输入！");
        }
        else {
            System.out.println("查询到的结果为：");
        }
        while (next){
            System.out.print("编号：" + resultSet.getString(1) + ", ");
            System.out.print("ISBN：" + resultSet.getString(2) + ", ");
            System.out.print("书名：" + resultSet.getString(3) + ", ");
            System.out.print("作者：" + resultSet.getString(4) + ", ");
            System.out.print("出版社：" + resultSet.getString(5) + ", ");
            System.out.print("单价：" + resultSet.getString(6) + ", ");
            System.out.print("数量：" + resultSet.getString(7));
            System.out.println();
            next = resultSet.next();
        }
    }

    private void checkSale(ResultSet resultSet) throws SQLException {
        boolean next = resultSet.next();
        System.out.println();
        if (!next){
            System.out.println("未查询到相关数据，请检查输入后重新输入！");
        }
        else {
            System.out.print("总计销售金额为：");
        }
        double total = 0;
        while (next){
            total += resultSet.getDouble(6);
            next = resultSet.next();
        }
        System.out.println(total);
    }

    private void checkAmount(ResultSet resultSet) throws SQLException {
        boolean next = resultSet.next();
        System.out.println();
        if (!next){
            System.out.println("未查询到相关数据，请检查输入后重新输入！");
        }
        else {
            price = Double.parseDouble(resultSet.getString(6));
            amount = Integer.parseInt(resultSet.getString(7));
        }
    }
}