package org.iesabastos.dam.datos.IJG;

import org.hibernate.Query;
import org.hibernate.Session;
import org.iesabastos.dam.datos.IJG.Utils.HibernateUtil;

import java.util.Iterator;
import java.util.List;

public class _09_QueryDep {
	public static void main(String[] args) {
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery("from Departamento");
		List<Departamento> departamentos = (List<Departamento>) query.list();

		System.out.println("query.list():");
		for (Departamento d : departamentos
		) {
			System.out.println(d);
		}
		Iterator iter = query.iterate();
		System.out.println("Lista con iterate");
		while (iter.hasNext()) {
			Departamento d = (Departamento) iter.next();
			System.out.println(d);
		}
		session.close();
	}
}
