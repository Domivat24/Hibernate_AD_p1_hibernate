package org.iesabastos.dam.datos.IJG;

import org.hibernate.Query;
import org.hibernate.Session;
import org.iesabastos.dam.datos.IJG.Utils.HibernateUtil;

import java.util.List;

public class _11_MasAntiguo {
	public static void main(String[] args) {
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Empleado e order by e.fecha_alta");

		List<Empleado> empleados = (List<Empleado>) query.list();
		Empleado empleado = empleados.get(0);

		Query query2 = session.createQuery("from Departamento e WHERE e.dept_NO = :dep");
		query2.setParameter("dep", empleado.getDepartamento().getDept_NO());
		Departamento departamento = (Departamento) query2.uniqueResult();
		for (Empleado d : departamento.getEmpleados()
		) {
			System.out.println(d);
		}
		session.close();
	}
}
