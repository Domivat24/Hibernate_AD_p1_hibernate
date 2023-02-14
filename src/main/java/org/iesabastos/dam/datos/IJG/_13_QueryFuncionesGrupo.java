package org.iesabastos.dam.datos.IJG;

import org.hibernate.Query;
import org.hibernate.Session;
import org.iesabastos.dam.datos.IJG.Utils.HibernateUtil;


public class _13_QueryFuncionesGrupo {
	public static void main(String[] args) {
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("select avg(e.salario), count(id) from Empleado e");
		Object[] valores = (Object[]) query.uniqueResult();

		System.out.printf("El salario medio de los %d empleados es de %.2f\n", valores[1], valores[0]);

		session.close();
	}
}
