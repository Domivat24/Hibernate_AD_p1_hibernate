package org.iesabastos.dam.datos.IJG;

import org.hibernate.Session;
import org.iesabastos.dam.datos.IJG.Empleado;
import org.iesabastos.dam.datos.IJG.Utils.HibernateUtil;

public class _07_ModificaEmpleado {
	public static void main(String[] args) {
		short id = 12;
		modificarEmpleado(id);
	}

	public static void modificarEmpleado(short id) {
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();

		Session session = HibernateUtil.getCurrentSession();
		Empleado empleado = (Empleado) session.get(Empleado.class, id);
		empleado.setNombre("Manolo123");
		session.save(empleado);
		session.beginTransaction().commit();
		session.close();
	}
}
