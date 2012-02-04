package org.mybatis;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.dao.factory.SessionFactory;
import org.mybatis.dao.vo.Person;

public class TransactionDemo {

	public static void unitJob() {
		
		Person p1 = new Person();
		p1.setPname("abc");
		p1.setBirthday(new java.util.Date());
		p1.setAge(26);
		
		Person p2 = new Person();
		p2.setAge(21);
		p1.setBirthday(new java.util.Date());
		
		
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		SqlSession sqlSession = SessionFactory.getSqlSession();
		Transaction transaction = transactionFactory.newTransaction(sqlSession.getConnection(), false);
		try {
			sqlSession.insert("PersonMapper.addPerson", p1);
			sqlSession.insert("PersonMapper.addPerson", p2);
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				transaction.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				transaction.close();
				sqlSession.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		unitJob();
	}

}
