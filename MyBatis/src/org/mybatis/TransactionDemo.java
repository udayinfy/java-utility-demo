package org.mybatis;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.dao.factory.SessionFactory;

public class TransactionDemo {

	public static void unitJob() {
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		SqlSession session = SessionFactory.getSqlSession();
		Transaction newTransaction = transactionFactory.newTransaction(session.getConnection(), false);
		try {
			session.delete("");
			session.update("");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				newTransaction.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				newTransaction.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		unitJob();
	}

}
