import com.demo.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;


import java.io.Reader;

public class test {

    private static Reader reader;
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            reader = Resources.getResourceAsReader("classpath:Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch (Exception e){

        }
    }
//    public static void main(String[] args){
//        SqlSession session = sqlSessionFactory.openSession();
//        User user=(User) session.selectOne("com.demo.model.UserMapper.selectUserByID",1);
//
//        System.out.println(user.getName());
//
//    }
}
