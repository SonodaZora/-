import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        int num;
        while (true){
            //显示提示
            System.out.println();
            System.out.println("请输入想要执行的操作所对应的数字序号：");
            System.out.println("1.查询书籍信息");
            System.out.println("2.增加/修改/删除书籍信息");
            System.out.println("3.统计销售情况");
            System.out.println("4.增加书籍销售信息");
            System.out.println("5.退出");
            Scanner input = new Scanner(System.in);
            num = input.nextInt();

            //查询书籍信息
            if (num==1){
                new Check();
            }

            //增加、修改、删除书籍信息
            else if (num==2){
                new Update();
            }

            //统计销售情况
            else if (num==3){
                new Statistics();
            }

            //增加书籍销售信息
            else if (num==4){
                new Sale();
            }

            //退出
            else if (num==5){
                System.out.println("退出成功！");
                break;
            }
        }
    }
}
