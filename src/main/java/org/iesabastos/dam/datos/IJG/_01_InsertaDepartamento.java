package org.iesabastos.dam.datos.IJG;

import org.hibernate.Session;
import org.iesabastos.dam.datos.IJG.Utils.HibernateUtil;

public class _01_InsertaDepartamento {
	public static void main(String[] args) {
		Departamento departamento = new Departamento();
		departamento.setDept_NO((byte) 50);
		departamento.setLoc("DESPA9");
		departamento.setDnombre("FOL2");

		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();

		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		session.save(departamento);
		session.getTransaction().commit();
		session.close();
	}
}
