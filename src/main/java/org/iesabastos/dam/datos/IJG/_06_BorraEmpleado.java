package org.iesabastos.dam.datos.IJG;

import org.hibernate.Session;
import org.iesabastos.dam.datos.IJG.Departamento;
import org.iesabastos.dam.datos.IJG.Empleado;
import org.iesabastos.dam.datos.IJG.Utils.HibernateUtil;

public class _06_BorraEmpleado {
	public static void main(String[] args) throws InterruptedException {
		{

			HibernateUtil.buildSessionFactory();
			HibernateUtil.openSession();

			Session session = HibernateUtil.getCurrentSession();
			session.beginTransaction();
			session.delete(session.get(Empleado.class, (short) 13));
			session.getTransaction().commit();
			session.beginTransaction().rollback();
			session.close();
		}
	}
}
