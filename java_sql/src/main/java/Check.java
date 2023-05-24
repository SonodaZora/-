import java.util.Scanner;

class Check{
    int num;
    String sql = "select * from java.book where ";
    public Check() {
        //显示提示
        System.out.println();
        System.out.println("请选择查询方式：");
        System.out.println("1.ISBN查询");
        System.out.println("2.书名查询");
        System.out.println("3.作者查询");
        System.out.println("4.查询全部书本信息");
        System.out.println("5.返回上一级菜单");

        //选择并构建sql语句
        Scanner input = new Scanner(System.in);
        num = input.nextInt();
        if (num==1){
            sql += "isbn = ";
        }
        else if (num==2) {
            sql += "name = ";
        }
        else if (num==3) {
            sql += "author = ";
        }
        else if (num==4) {
            sql = "select * from java.book";
            new Connect(sql, 0);
            return;
        }
        else if (num==5) {
            return;
        }
        System.out.println();
        System.out.println("请输入要查询的信息：");
        sql += "\"" + input.next() + "\"";

        //获取数据库连接并执行
        new Connect(sql, 0);
    }
}
