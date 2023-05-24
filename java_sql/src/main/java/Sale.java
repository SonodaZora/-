import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Sale {

    Scanner input = new Scanner(System.in);

    public Sale() throws SQLException {
        System.out.println();
        System.out.println("请按照顺序依次输入ISBN和购买数量：");

        //读取输入并构建sql语句
        String isbn = input.next();
        int amount = input.nextInt();
        String sql = "select * from java.book where isbn = \"" + isbn + "\"";

        //创建数据库连接的对象，取得该书本的库存数量以及单价
        Connect connect = new Connect(sql, 3);
        double price = connect.getPrice();

        //如果库存不够则发出提示
        if (connect.getAmount() < amount){
            System.out.println("书本库存数量不够！请检查后重新输入");
            return;
        }

        //获取当前日期
        Date date_date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        String date = formatter.format(date_date);

        //增加一条销售记录
        sql = "insert into java.sale(date, isbn, amount, price, total) values(";
        sql += "\"" + date + "\", ";
        sql += "\"" + isbn + "\", ";
        sql += amount + ", ";
        sql += price + ", ";
        sql += (amount * price) + ")";
        new Connect(sql, 1);

        //减少书本库存
        sql = "update java.book set ";
        sql += "amount = " + (connect.getAmount() - amount) + " ";
        sql += "where isbn = \"" + isbn + "\"";
        new Connect(sql, 1);

        //发出提示
        String msg = "日期：" + date + ", ";
        msg += "ISBN：" + isbn + ", ";
        msg += "数量；：" + amount + ", ";
        msg += "单价：" + price + ", ";
        msg += "总价：" + amount * price;
        System.out.println(msg);
        System.out.println();
        System.out.println("执行成功！");
    }
}