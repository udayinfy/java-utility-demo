package com.hibernate.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.domain.IdCard;
import com.hibernate.domain.Person;
import com.hibernate.util.HibernateUtil;

public class One2OneTest {
	public static void main(String[] args) {
//		add();
		query(1);
	}


	/**
	 * 查询一对一关联的两个对象
	 * @param id
	 * @return
	 */
	static Person query(int id) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			Person person = (Person) session.get(Person.class, id);
			// System.out.print(p.getIdCard());
			// IdCard idCard = (IdCard) s.get(IdCard.class, id);
			// System.out.println(idCard.getPerson());
			return person;
		} finally {
			if (session != null)
				session.close();
		}
	}

	/**
	 * 增加一对一映射的两个对象
	 * @return
	 */
	public static Person add() {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSession();
			IdCard idCard = new IdCard();
			idCard.setUsefulLife(new Date());

			Person person = new Person();
			person.setName("p1");
			person.setIdCard(idCard);

			idCard.setPerson(person);

			tx = session.beginTransaction();
			session.save(person);
			session.save(idCard);
			tx.commit();
			return person;
		} finally {
			if (session != null)
				session.close();
		}
	}
}
