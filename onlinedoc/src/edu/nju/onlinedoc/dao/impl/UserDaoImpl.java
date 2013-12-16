package edu.nju.onlinedoc.dao.impl;

//import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import edu.nju.onlinedoc.dao.UserDao;
import edu.nju.onlinedoc.model.*;



public class UserDaoImpl implements UserDao
{
	//protected Logger log = Logger.getLogger(this.getClass());
	//private static UserDaoImpl userDao=new UserDaoImpl();
//	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	
	private UserDaoImpl()
	{
		
	}
	
/*	public static UserDaoImpl getInstance()
	{
		return userDao;
	}*/
	
	/*
	 * ����ݿ��в���һ��user��¼
	 */
	public void save(User user)
	{
		/*Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		try 
		{
			stmt=con.prepareStatement("insert into users(id,userid,password,name,birthday,phone,email,bankid,account) values(?,?,?,?,?,?,?,?,?)");
			//stmt=con.prepareStatement("insert into user(id,name) values(?,?)");
			stmt.setLong(1,user.getId());
			stmt.setString(2,user.getUserid());
			stmt.setString(3,user.getPasswordOne());
			stmt.setString(4,user.getName());
			stmt.setDate(5,user.getBirthday());
			stmt.setString(6,user.getPhone());
			stmt.setString(7,user.getEmail());
			stmt.setString(8,user.getBankid());
			stmt.setDouble(9,user.getAccount());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}*/
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(user);
			tx.commit();
			session.close();
			sessionFactory.close();
			//this.getHibernateTemplate().save(user);
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * ��ݲ��������������ϵ�ֵ����user����,����ҵ��򷵻��������,���򷵻�null
	 * column ����
	 * value ��ֵ
	 */
	public User find(String column,String value)
	{
		/*Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		try 
		{
			stmt=con.prepareStatement("select * from users where "+column+"=?");
			stmt.setString(1,value);
			result=stmt.executeQuery();
			if(result.next())
			{
				User user=new User();
				user.setId(result.getLong(1));
				user.setUserid(result.getString(2));
				user.setPasswordOne(result.getString(3));
				user.setName(result.getString(4));
				user.setBirthday(result.getDate(5));
				user.setPhone(result.getString(6));
				user.setEmail(result.getString(7));
				user.setBankid(result.getString(8));
				user.setAccount(result.getDouble(9));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}
		return null;*/
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from edu.nju.onlinedoc.model.User as us where us."
					+ column + "='" + value + "'";
			Query query = session.createQuery(hql);
			List list = query.list();

			// List list=
			// this.getHibernateTemplate().find("from User u where u." + column
			// + "='"+ value+"'");
			if ((list.size()) == 0)
				return null;
			else
				return (User) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * ���id����user���һ����¼
	 */
	public void updateByUserid(User user)
	{
		/*Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		try 
		{
			stmt=con.prepareStatement("update users set name=?,birthday=?," +
						"phone=?,email=?,bankid=?,account=?,password=? where userid=?");
			stmt.setString(1,user.getName());
			stmt.setDate(2,user.getBirthday());
			stmt.setString(3,user.getPhone());
			stmt.setString(4,user.getEmail());
			stmt.setString(5,user.getBankid());
			stmt.setDouble(6,user.getAccount());
			stmt.setString(7,user.getPasswordOne());
			stmt.setString(8,user.getUserid());

			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}*/		
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.update(user);
			tx.commit();
			session.close();
			sessionFactory.close();
			//this.getHibernateTemplate().update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
