import java.util.Objects;
import java.util.Scanner;

class Update{
    int num;
    String sql = "select * from java.book ";
    Scanner input = new Scanner(System.in);
    public Update() {
        //显示提示
        System.out.println();
        System.out.println("请选择想要执行的操作：");
        System.out.println("1.增加书本信息");
        System.out.println("2.修改书本信息");
        System.out.println("3.删除书本信息");
        System.out.println("4.返回上一级菜单");
        num = input.nextInt();

        //增加书本信息
        if (num==1){
            insert();
        }

        //修改书本信息
        else if (num==2) {
            new Connect(sql, 0);
            update();

        }

        //删除书本信息
        else if (num==3) {
            new Connect(sql, 0);
            delete();
        }

        //返回上一级菜单
        else if (num==4) {
            return;
        }
    }

    //插入
    private void insert(){
        //构建sql语句
        System.out.println();
        System.out.println("请按照 ISBN 书名 作者 出版社 单价 数量 的顺序依次输入：");
        sql = "insert into java.book(ISBN, name, author, press, price, amount) values(";
        sql += "\"" + input.next() + "\", ";
        sql += "\"" + input.next() + "\", ";
        sql += "\"" + input.next() + "\", ";
        sql += "\"" + input.next() + "\", ";
        sql += input.nextDouble() + ", ";
        sql += input.nextInt();
        sql += ")";

        //执行并发出提示
        new Connect(sql, 1);
        System.out.println();
        System.out.println("执行成功！");
    }

    //修改
    private void update(){
        //获取需要更改的书本id
        System.out.println();
        System.out.println("请输入需要修改的书本id：");
        int id = input.nextInt();

        //构建sql语句
        sql = "update java.book set ";

        //选择修改项目
        System.out.println();
        System.out.println("请输入需要修改的项目：");
        System.out.println("1.ISBN");
        System.out.println("2.书名");
        System.out.println("3.作者");
        System.out.println("4.出版社");
        System.out.println("5.单价");
        System.out.println("6.数量");
        System.out.println("7.全部修改");
        int type = input.nextInt();

        //修改并完善sql语句
        System.out.println();
        System.out.println("请输入修改后的数值：");

        if (type == 1) {
            sql += "isbn = \"" + input.next() + "\" ";
        }
        else if (type == 2) {
            sql += "name = \"" + input.next() + "\" ";
        }
        else if (type == 3) {
            sql += "author = \"" + input.next() + "\" ";
        }
        else if (type == 4) {
            sql += "press = \"" + input.next() + "\" ";
        }
        else if (type == 5) {
            sql += "price = " + input.nextDouble() + " ";
        }
        else if (type == 6) {
            sql += "amount = " + input.nextInt() + " ";
        }
        else if (type == 7) {
            System.out.println("(按照 ISBN 书名 作者 出版社 单价 数量 的顺序依次输入)");
            sql += "isbn = \"" + input.next() + "\", ";
            sql += "name = \"" + input.next() + "\", ";
            sql += "author = \"" + input.next() + "\", ";
            sql += "press = \"" + input.next() + "\", ";
            sql += "price = " + input.nextDouble() + ", ";
            sql += "amount = " + input.nextInt() + " ";
        }
        sql += "where id = " + id;

        //执行
        new Connect(sql, 1);
    }

    //删除
    private void delete(){
        System.out.println();
        System.out.println("请输入需要删除的书本编号：");
        sql = "delete from java.book where id = " + input.nextInt();

        //二次确认
        System.out.println();
        System.out.println("请输入1确认删除操作！输入其他则不执行删除：");
        if (Objects.equals(input.next(), "1")){
            new Connect(sql, 1);
        }
        else {
            System.out.println();
            System.out.println("删除操作未执行，已返回主菜单。");
        }
    }

}