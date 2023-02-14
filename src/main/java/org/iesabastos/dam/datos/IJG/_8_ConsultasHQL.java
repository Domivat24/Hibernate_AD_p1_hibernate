package org.iesabastos.dam.datos.IJG;

import org.hibernate.Query;
import org.hibernate.Session;
import org.iesabastos.dam.datos.IJG.Utils.HibernateUtil;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class _8_ConsultasHQL {
	public static Session session;

	public static void main(String[] args) {
		HibernateUtil.buildSessionFactory();
		HibernateUtil.openSession();
		session = HibernateUtil.getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery("from Departamento");
		Query query2 = session.createQuery("select d.dnombre from Departamento d");
		Query query3 = session.createQuery("select d.dnombre, d.loc from Departamento d");
		infoDepartamentos8_1(query);
		infoDepartamentos8_2(query2);
		infoDepartamentos8_3(query3);
		dadosAltas2016_8_4();
		departamentoInformatica_8_5();
		totalDepartamentos_8_6(query);
		empleadosPorDepartamento_8_7();
		departamentosSinEmpleado_8_8();
		departamentosSinCristina_8_9();
		session.close();
	}

	public static void infoDepartamentos8_1(Query query) {
		List<Departamento> departamentos = (List<Departamento>) query.list();

		for (Departamento d : departamentos
		) {
			System.out.println(d);
		}
	}

	public static void infoDepartamentos8_2(Query query) {
		List<String> departamentos = (List<String>) query.list();

		for (String d : departamentos
		) {
			System.out.println(d);
		}
	}

	public static void infoDepartamentos8_3(Query query) {
		List<Object[]> departamentos = query.list();

		for (Object[] e : departamentos
		) {
			String cadena = "";
			for (int i = 0; i < e.length; i++) {
				cadena += e[i] + "-";
			}
			System.out.println(cadena);
		}
		//Fe de hacerlo en un solo bucle independientemente de la query
		/*if (departamentos.get(0).length == 1 && departamentos.get(0).getClass().getName().equals("java.lang.String")) {
			for (String d : (String[]) departamentos.toString()
			) {

			}
		}
		if (departamentos.get(0).length == 1 && departamentos.get(0).getClass().getName().equals("org.iesabastos.dam.datos.IJG.Departamento")) {

			System.out.println(Arrays.toString(departamentos.get(0)));
			...
		}*/

	}

	public static void dadosAltas2016_8_4() {
		Query query = session.createQuery(" from Empleado as d where substring(d.fecha_alta,1,4) = '2016'");
		List<Empleado> empleados = (List<Empleado>) query.list();
		for (Empleado e : empleados
		) {
			System.out.println(e);
		}
	}

	public static void departamentoInformatica_8_5() {
		Query query = session.createQuery(" from Departamento as d where d.dnombre = 'INFORMATICA'");
		Departamento departamento = (Departamento) query.uniqueResult();
		for (Empleado e : departamento.getEmpleados()
		) {
			System.out.println(e.getNombre());
		}

	}

	public static void totalDepartamentos_8_6(Query query) {
		List<Departamento> departamentos = (List<Departamento>) query.list();

		System.out.println("Total de departamentos en el instituto:" + departamentos.size());
	}

	public static void empleadosPorDepartamento_8_7() {
		Query query = session.createQuery("select d.dnombre, count(d.dnombre) from Departamento as d INNER JOIN d.empleados as e group by d.dnombre");
		List<Object[]> departamentos = query.list();

		for (Object[] e : departamentos
		) {
			System.out.printf("%s tiene %d empleados\n", e[0], e[1]);
		}
	}

	public static void departamentosSinEmpleado_8_8() {
		Query query = session.createQuery("from Departamento d where d.dept_NO not in (select d.dept_NO from Departamento as d INNER JOIN d.empleados as e group by d.dnombre)");
		System.out.println("DEPARTAMENTOS SIN EMPLEADO");
		List<Departamento> departamentos = (List<Departamento>) query.list();
		for (Departamento e : departamentos
		) {
			System.out.println(e);
		}
	}

	public static void departamentosSinCristina_8_9() {
		//																																							  WHERE e.nombre like 'Cristina %'
		Query query = session.createQuery("from Departamento d where d.dept_NO not in (select d.dept_NO from Departamento as d INNER JOIN d.empleados as e WHERE substring(e.nombre,1, LOCATE(' ', e.nombre)-1) = 'Cristina')");
		System.out.println("DEPARTAMENTOS SIN CRISTINA");
		List<Departamento> departamentos = (List<Departamento>) query.list();
		for (Departamento e : departamentos
		) {
			System.out.println(e);
		}
	}

}

