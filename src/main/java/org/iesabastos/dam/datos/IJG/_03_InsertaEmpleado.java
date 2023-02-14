package org.iesabastos.dam.datos.IJG;

import org.hibernate.Session;
import org.iesabastos.dam.datos.IJG.Departamento;
import org.iesabastos.dam.datos.IJG.Empleado;
import org.iesabastos.dam.datos.IJG.Utils.HibernateUtil;

public class _03_InsertaEmpleado {
	public static void main(String[] args) {

		{
			Empleado empleado = new Empleado();
			empleado.setEmp_no((short) 13);
			empleado.setNombre("Manolo");


			HibernateUtil.buildSessionFactory();
			HibernateUtil.openSession();

			Session session = HibernateUtil.getCurrentSession();
			session.beginTransaction();
			empleado.setDepartamento((Departamento) session.get(Departamento.class, (byte) 50));
			session.save(empleado);
			session.getTransaction().commit();
			session.close();
		}
	}
}
