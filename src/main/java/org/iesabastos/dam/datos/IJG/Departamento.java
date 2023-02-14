package org.iesabastos.dam.datos.IJG;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departamentos")
public class Departamento implements Serializable {
	@Id
	private byte dept_NO;

	@Override
	public String toString() {
		return "Departamento{" +
				"dept_NO=" + dept_NO +
				", empleados=" + empleados +
				", dnombre='" + dnombre + '\'' +
				", loc='" + loc + '\'' +
				'}';
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
	private List<Empleado> empleados = new ArrayList<>();

	public byte getDept_NO() {
		return dept_NO;
	}

	public void setDept_NO(byte dept_NO) {
		this.dept_NO = dept_NO;
	}

	public String getDnombre() {
		return dnombre;
	}

	public void setDnombre(String dnombre) {
		this.dnombre = dnombre;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public Departamento() {
	}

	private String dnombre;
	private String loc;
}
