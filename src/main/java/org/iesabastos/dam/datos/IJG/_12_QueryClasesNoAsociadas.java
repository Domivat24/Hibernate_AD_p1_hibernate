package org.iesabastos.dam.datos.IJG;

import org.hibernate.Query;
import org.hibernate.Session;
import org.iesabastos.dam.datos.IJG.Utils.HibernateUtil;

import java.util.Iterator;

public class _12_QueryClasesNoAsociadas {
	//. Crea una nueva clase _12_QueryClasesNoAsociadas para obtener el código y nombre de los
	//departamentos junto con los empleados ordenados por los nombres de los empleados con
	//iterate()
	public static void main(String[] args) {
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Departamento");
		Query query2;
		Iterator iter = query.iterate();
		Iterator iter2;
		while (iter.hasNext()) {
			Departamento d = (Departamento) iter.next();
			query2 = session.createQuery("from Empleado e WHERE e.departamento.dept_NO = :dep ORDER BY e.nombre");
			query2.setParameter("dep", d.getDept_NO());
			iter2 = query2.iterate();
			System.out.println("DEPARTAMENTO: " + d.getDnombre());
			while (iter2.hasNext()) {
				Empleado e = (Empleado) iter2.next();
				System.out.println(e.getNombre());
			}
		}
		session.close();
	}
}
