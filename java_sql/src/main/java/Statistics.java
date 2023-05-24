import java.util.Scanner;

class Statistics {
    int num;
    String sql = "select * from java.sale where ";
    Scanner input = new Scanner(System.in);
    public Statistics() {
        //显示提示
        System.out.println();
        System.out.println("请选择查询方式：");
        System.out.println("1.ISBN查询");
        System.out.println("2.日期查询");
        System.out.println("3.返回上一级菜单");

        //选择
        num = input.nextInt();

        //ISBN查询
        if (num==1){
            System.out.println();
            System.out.println("请输入需要查询的ISBN：");
            sql += "isbn = \"" + input.next() + "\"";
            new Connect(sql,2);
        }

        //日期查询
        else if (num==2) {
            System.out.println();
            System.out.println("请输入需要查询的日期：");
            System.out.println("（格式为 年.月.日，例如：2023.05.02）");
            sql += "date = \"" + input.next() + "\"";
            new Connect(sql,2);
        }

        //返回上一级菜单
        else if (num==3) {
            return;
        }
    }
}
