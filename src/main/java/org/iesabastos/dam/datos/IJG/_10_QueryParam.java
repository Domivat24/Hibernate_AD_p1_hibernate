package org.iesabastos.dam.datos.IJG;

import org.hibernate.Query;
import org.hibernate.Session;
import org.iesabastos.dam.datos.IJG.Utils.HibernateUtil;

import java.util.List;

public class _10_QueryParam {
	public static void main(String[] args) {
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Empleado e WHERE e.salario >= :salario");
		query.setParameter("salario", 800F);
		List<Empleado> Empleados = (List<Empleado>) query.list();

		for (Empleado d : Empleados
		) {
			System.out.println(d);
		}
		session.close();
	}

}
