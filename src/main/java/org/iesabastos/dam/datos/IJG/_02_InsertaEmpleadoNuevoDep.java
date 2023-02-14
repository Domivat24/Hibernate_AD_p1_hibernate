package org.iesabastos.dam.datos.IJG;

import org.hibernate.Session;
import org.iesabastos.dam.datos.IJG.Utils.HibernateUtil;

public class _02_InsertaEmpleadoNuevoDep {
	public static void main(String[] args) {
		Departamento departamento = new Departamento();
		departamento.setDept_NO((byte) 60);
		departamento.setLoc("DESPA10");
		departamento.setDnombre("FOL2");
		Empleado empleado = new Empleado();
		empleado.setEmp_no((short) 12);
		empleado.setNombre("Manolo");
		empleado.setDepartamento(departamento);


		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();

		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		session.save(departamento);
		session.save(empleado);
		session.getTransaction().commit();
		session.close();
	}
}
