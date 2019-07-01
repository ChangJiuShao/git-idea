package Dao;

import entity.Stu;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StuDaoImpl {

	String selectSql="select * from stus where name=? and sex=? ";
	String delSql="delete from stus where id=?  ";
    String findid="select * from stus where id=?  ";
    String selectAll="select * from stus ";
	String insertSql="insert into stus (id,name,age,sex,weight,height) values(?,?,?,?,?,?)";
	String updateSql="update stus set name=?,age=?,sex=?,weight=?,height=? where id=?  ";
	
	public int insert(Stu stu) {
		//更新数据库
				//更新记录数
				int count=0;
        System.out.println(stu);
				java.sql.Connection conn=null;
				PreparedStatement pstmt=null;
				//ResultSet rs=null;
				//第一步，注册驱动
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//第二部，实现连接
				try {
					conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssm?serverTimezone=GMT%2B8&useSSL=false"
							, "root", "5683");
				//第三步，生成执行SQL语句的 PreparedStatement对象
				pstmt=conn.prepareStatement(insertSql);
				//给问号赋值
				pstmt.setInt(1,stu.getId());
				pstmt.setString(2, stu.getName());
				pstmt.setInt(3, stu.getAge());
				pstmt.setString(4,stu.getSex());
				pstmt.setInt(5,stu.getWeight());
				pstmt.setInt(6, stu.getHeight());
				
				//第四步，得到更新记录数
				count=pstmt.executeUpdate();
				//第五步，根据结果进行处理
				if (count!=0){
					//找到该记录
					System.out.println("插入成功！！");
				}
				else{//找不到该记录
					System.out.println("插入失败！！");
				}
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					//第六步，关闭数据库,关闭顺序与创建顺序相反
					try {
						if (pstmt!=null){
							pstmt.close();
						}
						if (conn!=null){
							conn.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
				//返回更新记录数
				return count;
	}
	
	//全查
	public List<Stu> findAll() {
		List<Stu> stulist =null;
		Stu stu=null;
		java.sql.Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//第一步，注册驱动
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//第二部，实现连接
		try {
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssm?serverTimezone=GMT%2B8&useSSL=false"
					, "root", "5683");
		//第三步，生成执行SQL语句的 PreparedStatement对象
		pstmt=conn.prepareStatement(selectAll);
		
		//第四步，得到查询结果rs
             rs = pstmt.executeQuery();
            //第五步，根据结果进行处理
		stulist=new ArrayList<Stu>();
		while (rs.next()){
			//找到该记录
			System.out.println("查找成功！！");

			// rs ---> Book
			stu = new Stu(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getInt(4),
					rs.getInt(5),
					rs.getInt(6)
					);
			stulist.add(stu);
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//第六步，关闭数据库,关闭顺序与创建顺序相反
			try {
				if (rs!=null){
					rs.close();
				}
				if (pstmt!=null){
					pstmt.close();
				}
				if (conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		return stulist;
	}


    public List<Stu> findByID(int id) {
        // TODO Auto-generated method stub
        List<Stu> stulist =null;
        Stu stu=null;
        java.sql.Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        //第一步，注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //第二部，实现连接
        try {
            conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssm?serverTimezone=GMT%2B8&useSSL=false"
                    , "root", "5683");
            //第三步，生成执行SQL语句的 PreparedStatement对象
            pstmt=conn.prepareStatement(findid);
            pstmt.setInt(1, id);

            //第四步，得到查询结果rs
            rs=pstmt.executeQuery();
            //第五步，根据结果进行处理
            stulist=new ArrayList<Stu>();
            while (rs.next()){
                //找到该记录
                System.out.println("查找成功！！");
                // rs ---> Book
                stu = new Stu(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)
                );
                stulist.add(stu);
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //第六步，关闭数据库,关闭顺序与创建顺序相反
            try {
                if (rs!=null){
                    rs.close();
                }
                if (pstmt!=null){
                    pstmt.close();
                }
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }



        return stulist;
    }

	

	public int update( Stu stu) {
		int count=0;
        System.out.println(stu);
		java.sql.Connection conn=null;
		PreparedStatement pstmt=null;
		//ResultSet rs=null;
		//第一步，注册驱动
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//第二部，实现连接
		try {
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssm?serverTimezone=GMT%2B8&useSSL=false"
					, "root", "5683");
            System.out.println(conn);
		//第三步，生成执行SQL语句的 PreparedStatement对象
		pstmt=conn.prepareStatement(updateSql);
		//给问号赋值
            System.out.println(pstmt);
		pstmt.setString(1,stu.getName());
		pstmt.setInt(2, stu.getAge());
		pstmt.setString(3, stu.getSex());
		pstmt.setInt(4,stu.getWeight());
		pstmt.setInt(5,stu.getHeight());
		pstmt.setInt(6, stu.getId());
		
		//第四步，得到更新记录数
		count=pstmt.executeUpdate();
            System.out.println(count);
		//第五步，根据结果进行处理
		if (count!=0){
			//找到该记录
			System.out.println("更新成功！！");
		}
		else{//找不到该记录
			System.out.println("更新失败！！");
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//第六步，关闭数据库,关闭顺序与创建顺序相反
			try {
				if (pstmt!=null){
					pstmt.close();
				}
				if (conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//返回更新记录数
		return count;
}


	public int delete(int  id) {
		//更新数据库
		//更新记录数
		int count=0;
		
		java.sql.Connection conn=null;
		PreparedStatement pstmt=null;
		//ResultSet rs=null;
		//第一步，注册驱动
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//第二部，实现连接
		try {
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssm?serverTimezone=GMT%2B8&useSSL=false"
					, "root", "5683");
		//第三步，生成执行SQL语句的 PreparedStatement对象
		pstmt=conn.prepareStatement(delSql);
		//给问号赋值
		pstmt.setInt(1,id);
		
		//第四步，得到更新记录数
		count=pstmt.executeUpdate();
		//第五步，根据结果进行处理
		if (count!=0){
			//找到该记录
			System.out.println("删除成功！！");
		}
		else{//找不到该记录
			System.out.println("删除失败！！");
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//第六步，关闭数据库,关闭顺序与创建顺序相反
			try {
				if (pstmt!=null){
					pstmt.close();
				}
				if (conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//返回更新记录数
		return count;
	}

	//根据姓名性别查找

	public List<Stu> findByName_Sex(String name, String sex) {
		List<Stu> stulist =null;
		Stu stu=null;
		java.sql.Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//第一步，注册驱动
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//第二部，实现连接
		try {
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssm?serverTimezone=GMT%2B8&useSSL=false"
					, "root", "5683");
		//第三步，生成执行SQL语句的 PreparedStatement对象
		pstmt=conn.prepareStatement(selectSql);
		//给问号赋值
		pstmt.setString(1, name);
		pstmt.setString(2, sex);
		//第四步，得到查询结果rs
		rs=pstmt.executeQuery();
            System.out.println(rs);
		//第五步，根据结果进行处理
		stulist=new ArrayList<Stu>();
		while (rs.next()){
			//找到该记录
			System.out.println("性别");
			// rs ---> Book
			stu = new Stu(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getInt(6)
					);
			stulist.add(stu);
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//第六步，关闭数据库,关闭顺序与创建顺序相反
			try {
				if (rs!=null){
					rs.close();
				}
				if (pstmt!=null){
					pstmt.close();
				}
				if (conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return stulist;
	}



}
	
