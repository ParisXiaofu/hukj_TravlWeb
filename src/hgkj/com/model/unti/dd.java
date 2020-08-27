package hgkj.com.model.unti;

public class dd {
    public static void main(String[] args) {
        String sql="insert into customer values(?,?,?,?,?,?,?,?)";
        Object[] objects={2,"123456","基豪","123456","男","422422","110",1};
        boolean result=DBManager.executeUpdate(sql,objects);
        if(result){
            System.out.println("操作成功！");
        }else {
            System.out.println("操作失败");
        }
    }
    }

