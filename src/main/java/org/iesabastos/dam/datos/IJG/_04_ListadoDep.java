package org.iesabastos.dam.datos.IJG;

import org.hibernate.Session;
import org.iesabastos.dam.datos.IJG.Departamento;
import org.iesabastos.dam.datos.IJG.Empleado;
import org.iesabastos.dam.datos.IJG.Utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class _04_ListadoDep {
	public static void main(String[] args) {

		{
			HibernateUtil.buildSessionFactory();
			HibernateUtil.openSession();

			Session session = HibernateUtil.getCurrentSession();
			session.beginTransaction();
			List<Empleado> empleados;
			Departamento departamento = ((Departamento) session.get(Departamento.class, (byte) 10));
			empleados = departamento.getEmpleados();
			for (Empleado e : empleados
			) {
				System.out.println((e));
			}
			session.close();
		}
	}
}
